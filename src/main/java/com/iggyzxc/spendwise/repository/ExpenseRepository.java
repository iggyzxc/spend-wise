package com.iggyzxc.spendwise.repository;

import com.iggyzxc.spendwise.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
