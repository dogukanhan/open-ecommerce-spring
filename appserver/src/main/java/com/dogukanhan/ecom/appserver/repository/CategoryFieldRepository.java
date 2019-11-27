package com.dogukanhan.ecom.appserver.repository;

import com.dogukanhan.ecom.appserver.entity.CategoryField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryFieldRepository extends JpaRepository<CategoryField, Long> {

}
