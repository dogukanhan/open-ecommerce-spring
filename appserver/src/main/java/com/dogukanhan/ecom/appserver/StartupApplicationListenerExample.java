package com.dogukanhan.ecom.appserver;

import com.dogukanhan.ecom.appserver.entity.*;
import com.dogukanhan.ecom.appserver.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@Component
public class StartupApplicationListenerExample implements
        ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryFieldRepository categoryFieldRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private MProductRepository mProductRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        categoryRepository.save(new Category("Books"));
        categoryRepository.save(new Category("Movies"));
        categoryRepository.save(new Category("Electronics"));
        var comp = new Category("Computers");
        categoryRepository.save(comp);
        var laptop = new Category(comp, "Laptop");
        categoryRepository.save(laptop);
        comp.setChildren(List.of(laptop));
        categoryRepository.save(comp);

        categoryRepository.save(new Category("Mobile"));
        categoryRepository.save(new Category("Clothes"));

        Category category = new Category("Shoes");
        categoryRepository.save(category);

        CategoryField color = new CategoryField();
        color.setName("Color");
        color.setFieldValues(List.of("Red", "Black", "Blue", "Yellow"));
        categoryFieldRepository.save(color);

        category.setFields(List.of(color));
        categoryRepository.save(category);

        for (int i = 0; i < 20; i++) {

            Product product = new Product();
            product.setName("Product " + i);
            product.setPrice(BigDecimal.valueOf(10 * i));
            product.setPiece(i * 5);
            product.setDetail("Product " + i);
            product.setCategory(category);
            product.setThumbnail("c2cb153f-7adb-4a2b-8d22-19f3e06cb41b.png");
            productRepository.save(product);
            if (mProductRepository.findOne(product.getId()).isEmpty()) {
                MProduct mProduct = new MProduct(product, Map.of(color, "Red"));
                mProductRepository.save(mProduct);
            }

            ProductImage productImage = new ProductImage();
            productImage.setLink("c2cb153f-7adb-4a2b-8d22-19f3e06cb41b.png");
            productImage.setProduct(product);
            productImageRepository.save(productImage);

            product.setProductImages(List.of(productImage));
            productRepository.save(product);
        }

    }
}