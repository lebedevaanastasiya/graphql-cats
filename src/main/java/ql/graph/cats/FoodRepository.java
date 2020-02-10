package ql.graph.cats;

import ql.graph.cats.exceptions.FoodNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
class FoodRepository {
    private List<Food> foods = new ArrayList<>();

    List<Food> findAll() {
        return foods;
    }

    Food create(String title, int points, int minutes) {
        var food = new Food(UUID.randomUUID().toString(), title, points, minutes);
        foods.add(food);
        return food;
    }

    Food update(String id, String title, int points, int minutes) throws FoodNotFoundException {
        var food = foods.stream().filter(f -> f.getId().equals(id)).findFirst().orElseThrow(() -> new FoodNotFoundException("Food not found", id));
        food.setTitle(title);
        food.setPoints(points);
        food.setMinutes(minutes);
        return food;
    }

    Integer delete(String id) {
        foods.removeIf(f -> f.getId().equals(id));
        return 0;
    }
}
