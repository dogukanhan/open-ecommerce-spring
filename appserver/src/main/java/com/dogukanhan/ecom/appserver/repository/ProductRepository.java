package com.dogukanhan.ecom.appserver.repository;

import com.dogukanhan.ecom.appserver.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product AS p LEFT JOIN p.productImages WHERE p.id = :productId")
    Optional<Product> findProductWithProductImageById(Long productId);

    List<Product> findAllByCategoryOrderById(Long categoryId, Pageable pageable);

    long countByCategory(Long categoryId);
}
