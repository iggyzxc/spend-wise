package com.iggyzxc.spendwise.service.impl;

import com.iggyzxc.spendwise.dto.ExpenseDTO;
import com.iggyzxc.spendwise.entity.Category;
import com.iggyzxc.spendwise.entity.Expense;
import com.iggyzxc.spendwise.mapper.ExpenseMapper;
import com.iggyzxc.spendwise.repository.CategoryRepository;
import com.iggyzxc.spendwise.repository.ExpenseRepository;
import com.iggyzxc.spendwise.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final CategoryRepository categoryRepository;
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
        List<Expense> expenseDTO = expenseRepository.findAll();
        return expenseDTO
                .stream()
                .map(ExpenseMapper::fromEntity)
                .collect(Collectors.toList()
                );
    }

    @Override
    public ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO) {
        Expense expense = expenseRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Expense not found with id: " + id)
                );

        expense.setAmount(expenseDTO.amount());

        expense.setExpenseDate(expenseDTO.expenseDate());

        if (expenseDTO.categoryDTO() != null) {
            Category expenseCategory = categoryRepository
                    .findById(expenseDTO.categoryDTO().id())
                    .orElseThrow(
                            () -> new RuntimeException(
                                    "Category not found with id: " + expenseDTO.categoryDTO().id()
                            )
                    );
            expense.setCategory(expenseCategory);
        }
        Expense updatedExpense = expenseRepository.save(expense);
        return ExpenseMapper.fromEntity(updatedExpense);
    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = expenseRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
        expenseRepository.delete(expense);
    }
}
