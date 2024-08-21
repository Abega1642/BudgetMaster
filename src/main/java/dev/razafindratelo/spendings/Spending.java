package dev.razafindratelo.spendings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@ToString
public class Spending {
    private String description;
    private double amount;
    private Category category;
    private LocalDate date;
}
