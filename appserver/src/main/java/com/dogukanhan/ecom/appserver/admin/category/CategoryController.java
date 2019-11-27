package com.dogukanhan.ecom.appserver.admin.category;

import com.dogukanhan.ecom.appserver.entity.Category;
import com.dogukanhan.ecom.appserver.exception.ResourceNotFoundException;
import com.dogukanhan.ecom.appserver.service.CategoryService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin/category")
@RequiredArgsConstructor
class CategoryController {

    private final CategoryService categoryService;

    @GetMapping(value = {"/", "/{page}"})
    String listCategories(Model model,
                          @PathVariable(value = "page", required = false) Integer page
    ) {

        if (page == null)
            page = 0;


        var categories = categoryService.findAllByParentOrderByName(null, page);

        var paginationSize = categoryService.paginationSizeByParent(null);

        model.addAttribute("categories", categories);
        model.addAttribute("paginationSize", paginationSize);
        model.addAttribute("page", page);

        return "admin/category/index";
    }


    @GetMapping("/{categoryId}/{page}/")
    String listChildCategories(Model model,
                               @PathVariable(value = "page") Integer page,
                               @PathVariable(value = "categoryId") Long categoryId
    ) {

        var category = categoryService.findOneById(categoryId);

        var categoryUpdateDTO = new CategoryUpdateDTO(category.getId(), category.getName());

        model.addAttribute("parentCategory", categoryUpdateDTO);

        var categories = categoryService.findAllByParentOrderByName(category, page);

        var paginationSize = categoryService.paginationSizeByParent(category);

        model.addAttribute("categories", categories);
        model.addAttribute("paginationSize", paginationSize);
        model.addAttribute("page", page);

        return "admin/category/child";
    }

    @GetMapping("/delete/{categoryId}/")
    String listChildCategories(Model model,
                               @PathVariable(value = "categoryId") Long categoryId
    ) {

        var category = categoryService.findOneById(categoryId);

        model.addAttribute("category", category);

        return "admin/category/delete";
    }

    @PostMapping("/delete")
    String deleteCategory(@RequestParam("categoryId") Long id) {

        categoryService.deleteById(id);

        return "redirect:/admin/category/?delete=true";
    }

    @PostMapping("/update")
    String updateCategory(CategoryUpdateDTO categoryUpdateDTO) {

        categoryService.update(categoryUpdateDTO);

        return "redirect:/admin/category/" + categoryUpdateDTO.getId() + "/0/";
    }


    @GetMapping("/create/")
    String createCategory(Model model) {

        var categories = categoryService.findAllOnlyNameAndId();

        model.addAttribute("categories", categories);
        model.addAttribute("category", new CategoryCreateDTO());

        return "admin/category/create";
    }


    @PostMapping("/create/")
    String createNewCategory(CategoryCreateDTO categoryCreateDTO) {

        categoryService.create(categoryCreateDTO);

        return "redirect:/admin/category/?create=true";
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "admin/category/404";
    }


}
