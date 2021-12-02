package com.chathra.fernanPharmacyBackend.services;

import com.chathra.fernanPharmacyBackend.entity.Brand;
import com.chathra.fernanPharmacyBackend.entity.Category;
import com.chathra.fernanPharmacyBackend.entity.Product;
import com.chathra.fernanPharmacyBackend.exceptions.BadRequestException;
import com.chathra.fernanPharmacyBackend.payload.request.ProductRequest;
import com.chathra.fernanPharmacyBackend.payload.response.ProductResponse;
import com.chathra.fernanPharmacyBackend.repositories.BrandRepository;
import com.chathra.fernanPharmacyBackend.repositories.CategoryRepository;
import com.chathra.fernanPharmacyBackend.repositories.ProductRepository;
import lombok.SneakyThrows;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static com.chathra.fernanPharmacyBackend.config.ComPath.UPLOAD_URL;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 29/11/2021
 * Time: 5:36 pm
 */
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BrandRepository brandRepository;


    @SneakyThrows
    public ProductResponse saveProduct(ProductRequest productRequest){

        Category category = categoryRepository.findById(productRequest.getCategory())
                .orElseThrow(() -> new BadRequestException(HttpStatus.BAD_REQUEST, "Invalid Category"));


        Brand brand = brandRepository.findById(productRequest.getBrand())
                .orElseThrow(() -> new BadRequestException(HttpStatus.BAD_REQUEST, "Invalid Brand"));

        String productImage = new Date().getTime() + "_" + UUID.randomUUID().toString().concat(".").concat(FilenameUtils.getExtension(productRequest.getImg().getOriginalFilename()));

        Path profileImagePath = Paths.get(UPLOAD_URL + "images\\product_images\\", productImage);

        try {
            Files.write(profileImagePath, productRequest.getImg().getBytes());
            System.out.println("image saved --- ");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "Image upload fail");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Product product = Product.builder()
                .name(productRequest.getName())
                .qty(productRequest.getQty())
                .discount(0.0)
                .description(productRequest.getDesc())
                .buyingPrice(productRequest.getPrice())
                .sellingPrice(productRequest.getPrice())
                .mfd(dateFormat.parse(productRequest.getMfd()))
                .exp(dateFormat.parse(productRequest.getExp()))
                .createdDate(new Date())
                .category(category)
                .status(1)
                .brand(brand)
                .build();

        Product save = productRepository.save(product);


        ProductResponse productResponse = ProductResponse.builder()
                .id(save.getId())
                .name(product.getName())
                .qty(Long.valueOf(product.getQty()))
                .desc(product.getDescription())
                .price(product.getBuyingPrice())
                .mfd(productRequest.getMfd())
                .exp(productRequest.getExp())
                .category(category.getCategory())
                .brand(brand.getBrand())
                .build();


        return productResponse;

    }

}
