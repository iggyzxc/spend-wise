package com.iggyzxc.spendwise.repository;

import com.iggyzxc.spendwise.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
