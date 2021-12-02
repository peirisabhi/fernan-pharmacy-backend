package com.chathra.fernanPharmacyBackend.services;

import com.chathra.fernanPharmacyBackend.comparators.UserComparators;
import com.chathra.fernanPharmacyBackend.entity.User;
import com.chathra.fernanPharmacyBackend.entity.UserRole;
import com.chathra.fernanPharmacyBackend.exceptions.BadRequestException;
import com.chathra.fernanPharmacyBackend.payload.request.*;
import com.chathra.fernanPharmacyBackend.payload.response.DataTableResponse;
import com.chathra.fernanPharmacyBackend.payload.response.SaveUserResponse;
import com.chathra.fernanPharmacyBackend.repositories.UserRepository;
import com.chathra.fernanPharmacyBackend.repositories.UserRoleRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.chathra.fernanPharmacyBackend.config.ComPath.UPLOAD_URL;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 07/11/2021
 * Time: 8:29 am
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

//    public List<User> getUsersByEmail(String email){
//       return userRepository.getUserByEmail(email);
//    }

    private static final Comparator<User> EMPTY_COMPARATOR = (e1, e2) -> 0;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public SaveUserResponse saveUser(SaveUserRequest saveUserRequest) {

        User userByEmail = userRepository.findUserByEmail(saveUserRequest.getEmail());

        UserRole userRole = userRoleRepository.findById(saveUserRequest.getUserRole())
                .orElseThrow(() -> new BadRequestException(HttpStatus.BAD_REQUEST, "Invalid User Role"));

        if (userByEmail != null) {
            System.out.println("This email already exists");
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "This email already exists");
        }

        String profileImage = new Date().getTime() + "_" + UUID.randomUUID().toString().concat(".").concat(FilenameUtils.getExtension(saveUserRequest.getImg().getOriginalFilename()));

        Path profileImagePath = Paths.get(UPLOAD_URL + "images\\user_images\\", profileImage);

        try {
            Files.write(profileImagePath, saveUserRequest.getImg().getBytes());
            System.out.println("image saved --- ");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "Image upload fail");
        }

        User user = new User();
        user.setFname(saveUserRequest.getFname());
        user.setLname(saveUserRequest.getLname());
        user.setMobile(saveUserRequest.getMobile());
        user.setEmail(saveUserRequest.getEmail());
        user.setGender(saveUserRequest.getGender());
        user.setDob(saveUserRequest.getDob());
        user.setAddress(saveUserRequest.getAddress());
        user.setPassword(saveUserRequest.getPassword());
        user.setRegisteredDate(new Date());
        user.setUserRole(userRole);
        user.setActiveStatus(true);
        user.setBlockStatus(false);
        user.setImg(profileImage);

        User savedUser = userRepository.save(user);

        SaveUserResponse saveUserResponse = new SaveUserResponse();
        saveUserResponse.setId(savedUser.getId());
        saveUserResponse.setFname(savedUser.getFname());
        saveUserResponse.setLname(savedUser.getLname());
        saveUserResponse.setMobile(savedUser.getMobile());
        saveUserResponse.setEmail(savedUser.getEmail());
        saveUserResponse.setGender(savedUser.getGender());
        saveUserResponse.setAddress(savedUser.getAddress());
        saveUserResponse.setUserRole(savedUser.getUserRole().getRole());
        saveUserResponse.setImgUrl(profileImagePath.toString());


        return saveUserResponse;
    }


    public DataTableResponse getAllUsers() {

        DataTableResponse<User> userDataTableResponse = new DataTableResponse<>();

        List<User> userList = userRepository.getUsersForDataTable("sds");
        userDataTableResponse.setData(userList);
        userDataTableResponse.setDraw(1);
        userDataTableResponse.setRecordsTotal(userList.size());
        userDataTableResponse.setRecordsFiltered(userList.size());

        return userDataTableResponse;
    }


    public Page<User> getUsers(DataTableRequest dataTableRequest) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
//            List<User> users = objectMapper.readValue(getClass().getClassLoader()
//                            .getResourceAsStream("employees.json"),
//                    new TypeReference<List<User>>() {
//                    });

            List<User> users = userRepository.findAll();

            return getPage(users, dataTableRequest);

        } catch (Exception e) {
//            log.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return new Page<>();
    }

    private Page<User> getPage(List<User> users, DataTableRequest dataTableRequest) {
        List<User> filtered = users.stream()
                .sorted(sortEmployees(dataTableRequest))
                .filter(filterEmployees(dataTableRequest))
                .skip(dataTableRequest.getStart())
                .limit(dataTableRequest.getLength())
                .collect(Collectors.toList());

        long count = users.stream()
                .filter(filterEmployees(dataTableRequest))
                .count();

        Page<User> page = new Page<>(filtered);
        page.setRecordsFiltered((int) count);
        page.setRecordsTotal((int) count);
        page.setDraw(dataTableRequest.getDraw());

        return page;
    }


    private Predicate<User> filterEmployees(DataTableRequest dataTableRequest) {
        if (dataTableRequest.getSearch() == null || StringUtils.isEmpty(dataTableRequest.getSearch()
                .getValue())) {
            return employee -> true;
        }

        String value = dataTableRequest.getSearch()
                .getValue();

        return user -> user.getFname()
                .toLowerCase()
                .contains(value)
                || user.getLname()
                .toLowerCase()
                .contains(value)
                || user.getEmail()
                .toLowerCase()
                .contains(value);
    }

    private Comparator<User> sortEmployees(DataTableRequest dataTableRequest) {
        if (dataTableRequest.getOrder() == null) {
            return EMPTY_COMPARATOR;
        }

        try {
            Order order = dataTableRequest.getOrder()
                    .get(0);

            int columnIndex = order.getColumn();
            Column column = dataTableRequest.getColumns()
                    .get(columnIndex);

            Comparator<User> comparator = UserComparators.getComparator(column.getData(), order.getDir());
            if (comparator == null) {
                return EMPTY_COMPARATOR;
            }

            return comparator;

        } catch (Exception e) {
//            log.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return EMPTY_COMPARATOR;
    }


    public DataTableResponse<User> getUsersForDataTable(DataTableRequest dataTableRequest){


        DataTableResponse<User> userDataTableResponse = new DataTableResponse<>();

        List<User> userList = userRepository.getUsersForDataTable(dataTableRequest.getSearch().getValue());
        userDataTableResponse.setData(userList);
        userDataTableResponse.setDraw(dataTableRequest.getDraw());
        userDataTableResponse.setRecordsTotal(userList.size());
        userDataTableResponse.setRecordsFiltered(userList.size());

        return userDataTableResponse;

    }

}
