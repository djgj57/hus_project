package io.hus.controller.productController;

import io.hus.entity.categoryEntity.Category;
import io.hus.entity.imageEntity.Image;
import io.hus.entity.productEntity.Product;
import io.hus.service.categoryService.CategoryService;
import io.hus.service.cityService.CityService;
import io.hus.service.imageService.ImageService;
import io.hus.service.productService.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@SecurityRequirement(name = "javainuseapi")
public class ProductController {

    private final ProductService productService;
    private final ImageService imageService;
    private final CategoryService categoryService;
    private final CityService cityService;

    @Operation(summary = "List all products")
    @GetMapping(value = "/open/products")
    public ResponseEntity<List<Product>> listProducts(){
        List<Product> products = new ArrayList<>();
        products = productService.getProducts();
        if (products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "All products in random order")
    @GetMapping(value = "/open/products/random")
    public ResponseEntity<List<Product>> listProductsRandom(){
        List<Product> products = new ArrayList<>();
        products = productService.getProductsRandom();
        if (products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }



    @Operation(summary = "Delete a product")
    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id){
        Optional<Product> product = productService.getProduct(id);
        if (product.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        productService.deleteProduct(id);

        // Delete all images of this product
        product.get().getImages().forEach(image -> imageService.deleteImage(image.getId()));

        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get a product")
    @GetMapping(value = "/open/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        Optional<Product> product = productService.getProduct(id);
        if (product.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product.get());
    }

    @Operation(summary = "Get products by city")
    @GetMapping(value = "/open/products/city/{city}")
    public ResponseEntity<List<Product>> getProductByCity(@PathVariable("city") String city){
        List<Product> products = new ArrayList<>();
        products = productService.getProductByCity(cityService.getCityByName(city));

        if (products.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Get products by category")
    @GetMapping(value = "/open/products/category/{category}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("category") String category){
        List<Product> products = new ArrayList<>();
        products = productService.getProductByCategory(categoryService.findByTitle(category));
        if (products.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }

}
