package ql.graph.cats;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import exceptions.CatNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppMutations implements GraphQLMutationResolver {
    @Autowired
    private CatRepository catRepository;

    @Autowired
    private FoodRepository foodRepository;

    Cat createCat(String name) {
        return catRepository.create(name);
    }

    Cat updateCat(String id, String name) throws CatNotFoundException { return catRepository.edit(id, name); }

    Integer deleteCat(String id) { return catRepository.delete(id); }

    Food createFood(String title, int points, int minutes) {
        return foodRepository.create(title, points, minutes);
    }

    Food updateFood(String id, String title, int points, int minutes) { return foodRepository.update(id, title, points, minutes); }

    Integer deleteFood(String id) { return foodRepository.delete(id); }
}
