package com.iggyzxc.spendwise.mapper;

import com.iggyzxc.spendwise.dto.CategoryDTO;
import com.iggyzxc.spendwise.dto.ExpenseDTO;
import com.iggyzxc.spendwise.entity.Category;
import com.iggyzxc.spendwise.entity.Expense;

public class ExpenseMapper {
    public static Expense toEntity(ExpenseDTO expenseDTO) {
        return new Expense(
                expenseDTO.id(),
                expenseDTO.amount(),
                expenseDTO.expenseDate(),
                new Category(
                        expenseDTO.categoryDTO().id()
                )
        );
    }

    public static ExpenseDTO fromEntity(Expense expense) {
        return new ExpenseDTO(
                expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDTO(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                )
        );
    }
}
