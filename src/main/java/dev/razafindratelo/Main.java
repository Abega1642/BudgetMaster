package dev.razafindratelo;

import dev.razafindratelo.spendings.Category;
import dev.razafindratelo.spendings.Expense;
import dev.razafindratelo.user.User;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User user = new User("Abegà", "Razafindratelo", 500_000);

        user.addExpense(
                "Foods",
                100_000d,
                Category.FOODS_AND_RESTAURANTS,
                LocalDate.now()
        );

        user.addExpense(
                "Foods",
                20_000d,
                Category.FOODS_AND_RESTAURANTS,
                LocalDate.now()
        );

        user.addExpense(
                "Transport",
                200_000d,
                Category.TRANSPORTS,
                LocalDate.now()
        );
        user.addExpense(
                "Transport",
                50_000d,
                Category.OTHERS,
                LocalDate.now()
        );

        System.out.println(user.getRemainingBudget());

        System.out.println(user.getExpenseByCategory(Category.FOODS_AND_RESTAURANTS));
        System.out.println(user.getExpenseByCategory(Category.TRANSPORTS));

        System.out.println(user.getMonthlyBudget());
        user.reportingOverflowOfSpending();

        System.out.println("Top categories");
        for (Category topCategory : user.getTopCategories()) {
            System.out.println(topCategory);
        }

        System.out.println(user.calculateAverageSpendingPerCategory());

    }
}