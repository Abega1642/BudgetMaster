package dev.razafindratelo.user;

import dev.razafindratelo.spendings.Spending;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private String firstName;
    private String lastName;
    private double monthlyBudget;
    private List<Spending> spendingsList;
}
