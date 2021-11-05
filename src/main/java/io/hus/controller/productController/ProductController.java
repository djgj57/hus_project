package io.hus.controller.productController;

import io.hus.entity.categoryEntity.Category;
import io.hus.entity.imageEntity.Image;
import io.hus.entity.productEntity.Product;
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

    @Operation(summary = "List all products")
    @GetMapping(value = "/open/products")
    public ResponseEntity<List<Product>> listCategory(){
        List<Product> products = new ArrayList<>();
        products = productService.getProducts();
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

}
