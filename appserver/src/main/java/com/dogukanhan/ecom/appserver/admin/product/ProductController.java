package com.dogukanhan.ecom.appserver.admin.product;


import com.dogukanhan.ecom.appserver.service.CategoryService;
import com.dogukanhan.ecom.appserver.service.ProductImageFileService;
import com.dogukanhan.ecom.appserver.service.ProductImageService;
import com.dogukanhan.ecom.appserver.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/product")
@RequiredArgsConstructor
class ProductController {

    private final ProductService productService;

    private final CategoryService categoryService;

    private final ProductImageService productImageService;

    private final ProductImageFileService productImageFileService;

    @GetMapping(value = {"/", "/{page}"})
    public String list(Model model,
                       @PathVariable(value = "page", required = false) Integer page) {

        if (page == null)
            page = 0;

        var categories = categoryService.findAllOnlyNameAndId();
        model.addAttribute("categories", categories);

        var products = productService.findAllOrderById(page);
        model.addAttribute("products", products);

        var paginationSize = productService.paginationSizeByCategory(null);
        model.addAttribute("paginationSize", paginationSize);

        return "admin/product/index";
    }

    @GetMapping("/{categoryId}/{page}/")
    public String list(Model model,
                       @PathVariable(value = "categoryId", required = false) Long categoryId,
                       @PathVariable(value = "page", required = false) Integer page) {

        if (page == null)
            page = 0;

        var products = productService.findAllByCategoryOrderById(categoryId, page);

        model.addAttribute("products", products);

        return "admin/product/category";
    }

    @GetMapping("/create/")
    String createCategory(Model model) {

        var categories = categoryService.findAllOnlyNameAndId();

        model.addAttribute("categories", categories);
        model.addAttribute("product", new ProductCreateDTO());

        return "admin/product/create";
    }

    @PostMapping("/create/")
    String createNewCategory(ProductCreateDTO productCreateDTO) {

        var id = productService.create(productCreateDTO);

        return "redirect:/admin/product/" + id + "/update/image/";
    }


    @GetMapping("{productId}/update/image/")
    String updateImage(Model model,
                       @PathVariable(value = "productId") Long productId) {

        var product = productService.findProductWithProductImageById(productId);

        model.addAttribute("product", product);

        return "admin/product/update-image";
    }

    @PostMapping("{productId}/update/image/upload/")
    String uploadImage(Model model,
                       @RequestParam("file") MultipartFile file,
                       @PathVariable(value = "productId") Long productId) {
        String link = null;
        try {
            link = productImageFileService.upload(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (link != null) productImageService.create(productId, link);

        var categories = categoryService.findAllOnlyNameAndId();

        model.addAttribute("categories", categories);
        model.addAttribute("product", new ProductCreateDTO());

        return "redirect:/admin/product/" + productId + "/update/image/";
    }
}
