package io.hus.controller.categoryController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.hus.entity.categoryEntity.Category;
import io.hus.service.categoryService.CategoryService;
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
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@SecurityRequirement(name = "javainuseapi")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "List all categories")
    @GetMapping(value = "/open/categories")
    public ResponseEntity<List<Category>> listCategory(){
        List<Category> categories = new ArrayList<>();
        categories = categoryService.listAllCategory();
        if (categories.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }

    // TODO: Pasar la validacion de status a la query
    @Operation(summary = "Find the specified category")
    @GetMapping(value = "/open/category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long id) {
        Category category =  categoryService.getCategory(id);
        if (null==category || Objects.equals(category.getStatus(), "DELETED")){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(category);
    }

    @Operation(summary = "Create a new category")
    @PostMapping(value = "/category/save")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category,
                                           BindingResult result){
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        category.setCreateAt(new Date());
        category.setId(null);
        Category categoryCreate =  categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryCreate);
    }

    @Operation(summary = "Update a category")
    @PutMapping(value = "/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id,
                                           @RequestBody Category category){
        category.setId(id);
        Category categoryDB =  categoryService.updateCategory(category);
        if (categoryDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryDB);
    }

    @Operation(summary = "Delete a category")
    @DeleteMapping(value = "/category/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") Long id){
        Category categoryDelete = categoryService.deleteCategory(id);
        if (categoryDelete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryDelete);
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
