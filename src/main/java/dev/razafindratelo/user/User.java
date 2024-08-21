package dev.razafindratelo.user;

import dev.razafindratelo.spendings.Category;
import dev.razafindratelo.spendings.Spending;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
public class User {
    private String firstName;
    private String lastName;
    private double monthlyBudget;
    private List<Spending> spendingsList;

    public User(String firstName, String lastName, double monthlyBudget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlyBudget = monthlyBudget;
        this.spendingsList = new ArrayList<>();
    }

    public void addSpending(
            String description,
            double amount,
            Category category,
            LocalDate date
    ) {
        Spending newSpending = new Spending(description, amount, category, date);
        this.spendingsList.add(newSpending);
    }

    public void showAllSpendingByDateSorted() {
        List<Spending> sortedSpendingList = new ArrayList<>(this.spendingsList);
        sortedSpendingList.sort(Comparator.comparing(Spending::getDate));
        for (Spending spending : sortedSpendingList) {
            System.out.println(spending);
        }
    }

    public void showAllSpendingByCategories() {
        List<Spending> foodsCategories = new ArrayList<>();


    }
}
