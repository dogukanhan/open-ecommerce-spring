package com.dogukanhan.ecom.appserver.service;

import com.dogukanhan.ecom.appserver.admin.product.ProductCreateDTO;
import com.dogukanhan.ecom.appserver.entity.Product;
import com.dogukanhan.ecom.appserver.exception.ResourceNotFoundException;
import com.dogukanhan.ecom.appserver.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private static final byte PAGINATION_SIZE = 10;

    private final CategoryService categoryService;

    private final ProductRepository productRepository;

    public Product findOneById(long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Product findProductWithProductImageById(long id) {
        return productRepository.findProductWithProductImageById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Iterable<Product> findAllOrderById(Integer page) {
        return productRepository.findAll(PageRequest.of(page, PAGINATION_SIZE, Sort.by("id")));
    }

    public List<Product> findAllByCategoryOrderById(Long categoryId, Integer page) {
        return productRepository.findAllByCategoryIdOrderById(categoryId, PageRequest.of(page, PAGINATION_SIZE));
    }

    public Long create(ProductCreateDTO productCreateDTO) {

        Product product = new Product();
        product.setName(productCreateDTO.getName());
        product.setDetail(productCreateDTO.getDetail());
        product.setPiece(productCreateDTO.getPiece());
        product.setPrice(productCreateDTO.getPrice());

        product.setCategory(productCreateDTO.getCategoryId() != -1 ?
                categoryService.findOneById(productCreateDTO.getCategoryId()) : null
        );

        return productRepository.save(product).getId();
    }

    public void update(Product product) {
        productRepository.save(product);
    }

    public long paginationSizeByCategory(Long categoryId) {
       return productRepository.countByCategory(categoryId);
    }
}
