package com.dogukanhan.ecom.appserver.service;

import com.dogukanhan.ecom.appserver.entity.Product;
import com.dogukanhan.ecom.appserver.entity.ProductImage;
import com.dogukanhan.ecom.appserver.repository.ProductImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductImageService {

    private final ProductImageRepository productImageRepository;
    private final ProductService productService;

    public void create(Long productId, String link) {
        ProductImage productImage = new ProductImage();
        productImage.setLink(link);

        Product product = new Product();
        product.setId(productId);
        productImage.setProduct(product);

        productImageRepository.save(productImage);

        product = productService.findProductWithProductImageById(productId);
        product.getProductImages().add(productImage);

        productService.update(product);

    }

}
