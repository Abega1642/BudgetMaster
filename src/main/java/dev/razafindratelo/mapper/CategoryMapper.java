package dev.razafindratelo.mapper;

import dev.razafindratelo.spendings.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryMapper {
    private Category category;
    private double amount;
}
