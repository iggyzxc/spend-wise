package com.iggyzxc.spendwise.service;

import com.iggyzxc.spendwise.dto.ExpenseDTO;

import java.util.List;

public interface ExpenseService {

    ExpenseDTO createExpense(ExpenseDTO expenseDTO);

    ExpenseDTO getExpenseById(Long id);

    List<ExpenseDTO> getAllExpenses();

    ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO);

    void deleteExpense(Long id);
}
