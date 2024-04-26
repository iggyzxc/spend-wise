package com.iggyzxc.spendwise.controller;

import com.iggyzxc.spendwise.dto.ExpenseDTO;
import com.iggyzxc.spendwise.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Expense CRUD Operations",
        description = "This controller provides CRUD operations for managing expense resources. " +
                "You can create, read, update, and delete expenses using the respective endpoints. " +
                "These APIs allow you to efficiently manage expense data within your application."
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private ExpenseService expenseService;

    // SpringDocs
    @Operation(
            summary = "Create Expense",
            description = "Create a new expense and save it in the database."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Expense created successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid request body."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    @PostMapping
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expenseDTO) {
        ExpenseDTO savedExpense = expenseService.createExpense(expenseDTO);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    // SpringDocs
    @Operation(
            summary = "Get Expense by ID",
            description = "Retrieve an expense from the database by its ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expense found."),
            @ApiResponse(responseCode = "404", description = "Expense not found."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }

    // SpringDocs
    @Operation(
            summary = "Get All Expenses",
            description = "Retrieve all expenses from the database."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expenses found."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    // SpringDocs
    @Operation(
            summary = "Update Expense",
            description = "Update an existing expense in the database."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expense updated successfully."),
            @ApiResponse(responseCode = "404", description = "Expense not found."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDTO> updateExpense(@PathVariable Long id,
                                                    @RequestBody ExpenseDTO expenseDTO) {
        return ResponseEntity.ok(expenseService.updateExpense(id, expenseDTO));
    }

    // SpringDocs
    @Operation(
            summary = "Delete Expense",
            description = "Delete an existing expense from the database."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Expense deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Expense not found."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully.");
    }
}
