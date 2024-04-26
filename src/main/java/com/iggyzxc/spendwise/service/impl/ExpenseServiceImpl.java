package com.iggyzxc.spendwise.service.impl;

import com.iggyzxc.spendwise.dto.ExpenseDTO;
import com.iggyzxc.spendwise.entity.Expense;
import com.iggyzxc.spendwise.mapper.ExpenseMapper;
import com.iggyzxc.spendwise.repository.ExpenseRepository;
import com.iggyzxc.spendwise.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
