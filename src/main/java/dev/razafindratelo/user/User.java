package dev.razafindratelo.user;

import dev.razafindratelo.exception.NotAuthorizedAmountException;
import dev.razafindratelo.mapper.CategoryMapper;
import dev.razafindratelo.spendings.Category;
import dev.razafindratelo.spendings.Expense;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@Data
public class User {
    private String firstName;
    private String lastName;
    private double monthlyBudget;
    private List<Expense> spendingsList;

    public User(String firstName, String lastName, double monthlyBudget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlyBudget = monthlyBudget;
        this.spendingsList = new ArrayList<>();
    }

    public void addExpense(
            String description,
            double amount,
            Category category,
            LocalDate date
    ) {
        if (amount <= 0) {
            throw new NotAuthorizedAmountException("Please, check the amount. Negative amount is not allowed");
        }
        Expense newExpense = new Expense(description, amount, category, date);
        this.spendingsList.add(newExpense);
    }

    public void showAllSpendingByDateSorted() {
        List<Expense> sortedExpenseList = new ArrayList<>(this.spendingsList);
        sortedExpenseList.sort(Comparator.comparing(Expense::getDate));
        for (Expense expense : sortedExpenseList) {
            System.out.println(expense);
        }
    }

    public List<Expense> getExpenseByCategory(Category category) {
        return spendingsList
                .stream()
                .filter(expense -> expense.getCategory() == category)
                .toList();
    }

    public double getTotalSpentThisMonth() {
        return spendingsList
                .stream()
                .filter(expense -> expense.getDate().getMonthValue() == LocalDate.now().getMonthValue())
                .map(Expense::getAmount)
                .reduce(0.0, Double::sum);
    }

    public double getRemainingBudget() {
        return monthlyBudget - getTotalSpentThisMonth();
    }

    public void reportingOverflowOfSpending() {
        if (getRemainingBudget() <= 0) {
            System.out.println("--- Reporting : Your budget is now greater than your monthly budget");
        }
    }

    public List<Category> getTopCategories() {
        List<CategoryMapper> categories = new ArrayList<>();
        for (Category category : Category.values()) {
            categories.add(new CategoryMapper(category, getTotalSpentByCategory(category));
        }
        categories.sort(Comparator.comparing(CategoryMapper::getAmount));
        return List.of(
                categories.get(0).getCategory(),
                categories.get(1).getCategory(),
                categories.get(2).getCategory());
    }

    public double getTotalSpentByCategory(Category category) {
        return getExpenseByCategory(category)
                .stream()
                .map(Expense::getAmount)
                .reduce(0.0, Double::sum);
    }
}
