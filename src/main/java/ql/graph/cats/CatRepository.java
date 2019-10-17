package ql.graph.cats;

import exceptions.CatNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class CatRepository {
    private List<Cat> cats = new ArrayList<>();

    Cat create(String name) {
        var cat = new Cat(UUID.randomUUID().toString(), name);
        cats.add(cat);
        return cat;
    }

    List<Cat> findAll() {
        return this.cats;
    }

    Cat edit(String id, String name) throws CatNotFoundException {
        var c = cats.stream().filter(q -> q.getId().equals(id)).findFirst().orElseThrow(() -> new CatNotFoundException("Cat not found", id));
        c.setName(name);
        return c;
    }

    Integer delete(String id) {
        cats.removeIf(c -> c.getId().equals(id));
        return 0;
    }
}
