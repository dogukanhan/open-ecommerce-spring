package com.dogukanhan.ecom.appserver.repository;

import com.dogukanhan.ecom.appserver.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

}
