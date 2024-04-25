package com.iggyzxc.spendwise.mapper;

import com.iggyzxc.spendwise.dto.CategoryDTO;
import com.iggyzxc.spendwise.entity.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryDTO categoryDTO) {
        return new Category(
                categoryDTO.id(),
                categoryDTO.name()
        );
    }

    public static CategoryDTO fromEntity(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getName()
        );
    }
}
