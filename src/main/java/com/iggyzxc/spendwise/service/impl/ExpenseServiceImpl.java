package com.iggyzxc.spendwise.service.impl;

import com.iggyzxc.spendwise.dto.ExpenseDTO;
import com.iggyzxc.spendwise.entity.Expense;
import com.iggyzxc.spendwise.mapper.ExpenseMapper;
import com.iggyzxc.spendwise.repository.ExpenseRepository;
import com.iggyzxc.spendwise.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    @Override
    public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
        Expense expense = ExpenseMapper.toEntity(expenseDTO);
        Expense savedExpense = expenseRepository.save(expense);
        return ExpenseMapper.fromEntity(savedExpense);
    }

    @Override
    public ExpenseDTO getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
        return ExpenseMapper.fromEntity(expense);
    }


    @Override
    public List<ExpenseDTO> getAllExpenses() {
        return List.of();
    }

    @Override
    public ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO) {
        return null;
    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = expenseRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
        expenseRepository.delete(expense);
    }


}
