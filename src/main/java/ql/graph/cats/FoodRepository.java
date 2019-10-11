package ql.graph.cats;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FoodRepository {
    private List<Food> foods = new ArrayList<>();

    public List<Food> findAll() {
        return foods;
    }

    public Food create(String title, int points, int minutes) {
        var food = new Food(UUID.randomUUID().toString(), title, points, minutes);
        foods.add(food);
        return food;
    }
}
