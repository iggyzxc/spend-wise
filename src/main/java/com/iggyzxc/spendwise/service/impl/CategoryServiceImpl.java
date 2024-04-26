package com.iggyzxc.spendwise.service.impl;

import com.iggyzxc.spendwise.dto.CategoryDTO;
import com.iggyzxc.spendwise.entity.Category;
import com.iggyzxc.spendwise.mapper.CategoryMapper;
import com.iggyzxc.spendwise.repository.CategoryRepository;
import com.iggyzxc.spendwise.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toEntity(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.fromEntity(savedCategory);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Category with id %s not found", id)
                ));
        return CategoryMapper.fromEntity(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories
                .stream()
                .map(CategoryMapper::fromEntity)
                .collect(Collectors.toList()
                );
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Category with id %s not found", id)
                ));
        category.setName(categoryDTO.name());
        Category updatedCategory = categoryRepository.save(category);
        return CategoryMapper.fromEntity(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository
                .findById(id)
                        .orElseThrow(() -> new RuntimeException(
                                String.format("Category with id %s not found", id)
                        ));
        categoryRepository.delete(category);
    }

}
