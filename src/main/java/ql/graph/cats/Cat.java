package ql.graph.cats;

import java.util.ArrayList;
import java.util.List;

public class Cat {
    private String id;

    private String name;

    private List<Food> foodItems = new ArrayList<>();

    public Cat() {
    }

    public Cat(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<Food> foodItems) {
        this.foodItems = foodItems;
    }
}
