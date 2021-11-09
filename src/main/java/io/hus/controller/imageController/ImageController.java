package io.hus.controller.imageController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.hus.controller.categoryController.ErrorMessage;
import io.hus.entity.categoryEntity.Category;
import io.hus.entity.imageEntity.Image;
import io.hus.service.imageService.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@SecurityRequirement(name = "javainuseapi")
public class ImageController {

    private final ImageService imageService;

    @Operation(summary = "Create a new image")
    @PostMapping(value = "/image/save")
    public ResponseEntity<Image> createImage(@Valid @RequestBody Image image,
                                             BindingResult result) {

        if( image.getTitle()==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        image.setCreateAt(new Date());
        image.setId(null);
        Image imageCreate =  imageService.createImage(image);
        return ResponseEntity.status(HttpStatus.CREATED).body(imageCreate);
    }

    @Operation(summary = "Update an image")
    @PutMapping(value = "/image/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable("id") Long id,
                                                   @RequestBody Image image
    ){
        if( image.getTitle()==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Image imageDB =  imageService.getImage(id);
        if (imageDB == null){
            return ResponseEntity.notFound().build();
        }
        Image updateImage = image;
        updateImage.setId(id);
        updateImage.setCreateAt(imageDB.getCreateAt());
        updateImage = imageService.updateImage(updateImage);
        return ResponseEntity.ok(updateImage);
    }

    @Operation(summary = "Delete an image")
    @DeleteMapping(value = "/image/{id}")
    public ResponseEntity<Category> deleteImage(@PathVariable("id") Long id){
        Image image = imageService.getImage(id);
        if (image == null){
            return ResponseEntity.notFound().build();
        }
        imageService.deleteImage(id);
        return ResponseEntity.ok().build();
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
