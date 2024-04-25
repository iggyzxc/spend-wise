package com.iggyzxc.spendwise.service.impl;

import com.iggyzxc.spendwise.dto.CategoryDTO;
import com.iggyzxc.spendwise.entity.Category;
import com.iggyzxc.spendwise.mapper.CategoryMapper;
import com.iggyzxc.spendwise.repository.CategoryRepository;
import com.iggyzxc.spendwise.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toEntity(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.fromEntity(savedCategory);
    }
}
