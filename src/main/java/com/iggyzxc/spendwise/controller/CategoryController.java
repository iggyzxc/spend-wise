package com.iggyzxc.spendwise.controller;

import com.iggyzxc.spendwise.dto.CategoryDTO;
import com.iggyzxc.spendwise.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    // Create a category
    @PostMapping("/")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        try {
            return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // View a category by id
    @GetMapping("/{id}/")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(categoryService.getCategoryById(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        try {
            List<CategoryDTO> allCategories = categoryService.getAllCategories();
            return ResponseEntity.ok(allCategories);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
