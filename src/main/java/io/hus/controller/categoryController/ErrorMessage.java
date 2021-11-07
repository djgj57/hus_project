package io.hus.controller.categoryController;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class ErrorMessage {
    private String code ;
    private List<Map<String, String >> messages ;
}