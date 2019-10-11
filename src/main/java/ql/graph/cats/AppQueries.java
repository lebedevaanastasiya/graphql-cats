package ql.graph.cats;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppQueries implements GraphQLQueryResolver {
    @Autowired
    private CatRepository catRepository;

    @Autowired
    private FoodRepository foodRepository;

    public List<Cat> cats() {
        return catRepository.findAll();
    }

    public List<Food> foods() {
        return foodRepository.findAll();
    }
}
