package com.dogukanhan.ecom.appserver.repository;

import com.dogukanhan.ecom.appserver.admin.dto.CategorySelectDTO;
import com.dogukanhan.ecom.appserver.entity.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

    List<Category> findAllByParentOrderByName(Category parent, Pageable pageable);

    long countByParent(Category parent);

    List<Category> findAll();

    @Query("SELECT NEW com.dogukanhan.ecom.appserver.admin.dto.CategorySelectDTO(id,name) FROM Category")
    List<CategorySelectDTO> findAllOnlyNameAndId();

    @Query(nativeQuery = true, value = "SELECT * FROM category_selection")
    List<CategorySelectDTO> findAllWithView();


    List<Category> findAllByParentOrderByName(Category category);
}
