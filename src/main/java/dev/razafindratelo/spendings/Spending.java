package dev.razafindratelo.spendings;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Spending {
    private String description;
    private double amount;
    private Category category;
    private LocalDate date;
}
