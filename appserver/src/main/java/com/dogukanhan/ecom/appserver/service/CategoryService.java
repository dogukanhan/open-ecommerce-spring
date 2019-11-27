package com.dogukanhan.ecom.appserver.service;

import com.dogukanhan.ecom.appserver.admin.category.CategoryCreateDTO;
import com.dogukanhan.ecom.appserver.admin.category.CategoryUpdateDTO;
import com.dogukanhan.ecom.appserver.admin.dto.CategorySelectDTO;
import com.dogukanhan.ecom.appserver.entity.Category;
import com.dogukanhan.ecom.appserver.exception.ResourceNotFoundException;
import com.dogukanhan.ecom.appserver.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private static final byte PAGINATION_SIZE = 10;

    private final CategoryRepository categoryRepository;

    public Category findOneById(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Category> findAllByParentOrderByName(Category category, int page) {
        return categoryRepository.findAllByParentOrderByName(category, PageRequest.of(page, PAGINATION_SIZE));
    }
    public List<Category> findAllByParentOrderByName(Category category) {
        return categoryRepository.findAllByParentOrderByName(category);
    }

    public long countByParent(Category parent) {
        return categoryRepository.countByParent(parent);
    }

    public long paginationSizeByParent(Category parent) {
        return categoryRepository.countByParent(parent) / PAGINATION_SIZE;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    public void deleteById(Long id) {

        categoryRepository.deleteById(id);

    }

    public void update(CategoryUpdateDTO categoryUpdateDTO) {

        Category category = findOneById(categoryUpdateDTO.getId());
        category.setName(categoryUpdateDTO.getName());

        categoryRepository.save(category);
    }

    public void create(CategoryCreateDTO categoryCreateDTO) {


        Category category = new Category();
        category.setName(categoryCreateDTO.getName());

        category.setParent(categoryCreateDTO.getParentId() != -1 ?
                findOneById(categoryCreateDTO.getParentId()) : null
        );

        categoryRepository.save(category);

    }

    public List<CategorySelectDTO> findAllOnlyNameAndId() {
        return categoryRepository.findAllOnlyNameAndId();
    }
}
