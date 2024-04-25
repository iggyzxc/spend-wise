package com.iggyzxc.spendwise.service;

import com.iggyzxc.spendwise.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO getCategoryById(Long id);
    List<CategoryDTO> getAllCategories();
}
