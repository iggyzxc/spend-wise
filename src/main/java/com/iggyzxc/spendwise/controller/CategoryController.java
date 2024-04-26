package com.iggyzxc.spendwise.controller;

import com.iggyzxc.spendwise.dto.CategoryDTO;
import com.iggyzxc.spendwise.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Category CRUD Operations",
        description = "This controller provides CRUD operations for managing category resources. " +
                "You can create, read, update, and delete categories using the respective endpoints. " +
                "These APIs allow you to efficiently manage category data within your application."
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    // SpringDocs
    @Operation(
            summary = "Create Category",
            description = "Create a new category and save it in the database."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid request body."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    // Create a category
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
            return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    // SpringDocs
    @Operation(
            summary = "Get Category by ID",
            description = "Retrieve a category from the database by its ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category found.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDTO.class))),
            @ApiResponse(responseCode = "404", description = "Category not found."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    // View a category by id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Long id) {
            return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    // SpringDocs
    @Operation(
            summary = "Get All Categories",
            description = "Retrieve all categories from the database."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categories found."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    // View all categories
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> allCategories = categoryService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }

    // SpringDocs
    @Operation(
            summary = "Update Category",
            description = "Update an existing category in the database."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category updated successfully."),
            @ApiResponse(responseCode = "404", description = "Category not found."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    // Update category
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id,
                                                      @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO updatedCategory = categoryService.updateCategory(id, categoryDTO);
            if (updatedCategory != null) {
                return ResponseEntity.ok(updatedCategory);
            } else {
                return ResponseEntity.notFound().build();
            }
    }

    // SpringDocs
    @Operation(
            summary = "Delete Category",
            description = "Delete an existing category from the database."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Category deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Category not found."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    // Delete category
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully.");
    }
}
