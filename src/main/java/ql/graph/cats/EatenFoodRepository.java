package ql.graph.cats;

import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EatenFoodRepository {
    private Map<String, List<EatenFood>> eatenFoodMap = new HashMap<>();

    public EatenFood feedCat(Cat cat, Food food) {
        if (!eatenFoodMap.containsKey(cat.getId())) {
            eatenFoodMap.put(cat.getId(), new ArrayList<>());
        }
        var eatenFood = new EatenFood();
        eatenFood.setCatId(cat.getId());
        eatenFood.setFood(food);
        eatenFood.setActiveUntil(Instant.now().plus(food.getMinutes(), ChronoUnit.MINUTES));
        eatenFoodMap.get(cat.getId()).add(eatenFood);
        return eatenFood;
    }
}
