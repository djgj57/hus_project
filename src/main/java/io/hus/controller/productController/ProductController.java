package io.hus.controller.productController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.hus.controller.categoryController.ErrorMessage;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@SecurityRequirement(name = "javainuseapi")
public class ProductController {

    private final ProductService productService;
    private final ImageService imageService;
    private final CategoryService categoryService;
    private final CityService cityService;

    @GetMapping(value = "status")
    public String checkStatus() {
        return "ok";
    }

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

    @Operation(summary = "Eight products in random order")
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

    @Operation(summary = "Get 8 products by page")
    @GetMapping(value = "/open/products/page/{page}")
    public ResponseEntity<List<Product>> getProductByPages(@PathVariable("page") Integer page){
        if(page < 1){return ResponseEntity.badRequest().build();}
        Integer pageTemp = (page-1)*8;
        List<Product> products = new ArrayList<>();
        products = productService.getProductByPages (pageTemp);
        if (products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Update a product")
    @PutMapping(value = "/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,
                                             @RequestBody Product product
    ){

        Optional<Product> productDB =  productService.getProduct(id);
        if (productDB.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Product updateProduct = product;
        updateProduct.setId(id);
        updateProduct = productService.updateProduct(updateProduct);
        return ResponseEntity.ok(updateProduct);
    }

    @Operation(summary = "Create a new product")
    @PostMapping(value = "/product/save")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product,
                                             BindingResult result) {
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        product.setId(null);
        Product productCreate =  productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productCreate);
    }

    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

}
