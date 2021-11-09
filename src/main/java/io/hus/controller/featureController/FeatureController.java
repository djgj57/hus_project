package io.hus.controller.featureController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.hus.controller.categoryController.ErrorMessage;
import io.hus.entity.categoryEntity.Category;
import io.hus.entity.featureEntity.Feature;
import io.hus.service.featureService.FeatureService;
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
public class FeatureController {


    private final FeatureService featureService;

    @Operation(summary = "Create a new feature")
    @PostMapping(value = "/feature/save")
    public ResponseEntity<Feature> createFeature(@Valid @RequestBody Feature feature,
                                             BindingResult result) {

        if( feature.getName()==null || feature.getIcon()==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        feature.setCreateAt(new Date());
        feature.setId(null);
        Feature featureCreate =  featureService.createFeature(feature);
        return ResponseEntity.status(HttpStatus.CREATED).body(featureCreate);
    }

    @Operation(summary = "Update a feature")
    @PutMapping(value = "/feature/{id}")
    public ResponseEntity<Feature> updateFeature(@PathVariable("id") Long id,
                                             @RequestBody Feature feature
    ){
        if( feature.getName()==null || feature.getIcon()==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Feature featureDB =  featureService.getFeature(id);
        if (featureDB == null){
            return ResponseEntity.notFound().build();
        }
        Feature updateFeature = feature;
        updateFeature.setId(id);
        updateFeature.setCreateAt(featureDB.getCreateAt());
        updateFeature = featureService.updateFeature(updateFeature);
        return ResponseEntity.ok(updateFeature);
    }

    @Operation(summary = "Delete a feature")
    @DeleteMapping(value = "/feature/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") Long id){
        Feature feature = featureService.getFeature(id);
        if (feature == null){
            return ResponseEntity.notFound().build();
        }
        featureService.deleteFeature(id);
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
