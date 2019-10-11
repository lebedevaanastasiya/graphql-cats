package ql.graph.cats;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
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

    Food createFood(String title, int points, int minutes) {
        return foodRepository.create(title, points, minutes);
    }
}
