package com.estudo.resource;

import com.estudo.domain.Category;
import com.estudo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("category")
@RestController
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCategory(@RequestBody Optional<Category> category) throws Exception {

        if(category.isPresent()) {
            return ResponseEntity.ok(service.saveCategory(category.get()));
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllCategory() {
        return ResponseEntity.ok(service.getAllCategory());
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteById(@RequestParam Integer categoryId) {
        return ResponseEntity.ok(service.deleteCategoryById(categoryId));
    }
}
