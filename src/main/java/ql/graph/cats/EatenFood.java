package ql.graph.cats;

import java.time.Instant;

public class EatenFood {
    private String catId;

    private Food food;

    private Instant activeUntil;

    public String getCatId() {
        return catId;
    }

    void setCatId(String catId) {
        this.catId = catId;
    }

    public Food getFood() {
        return food;
    }

    void setFood(Food food) {
        this.food = food;
    }

    public Instant getActiveUntil() {
        return activeUntil;
    }

    void setActiveUntil(Instant activeUntil) {
        this.activeUntil = activeUntil;
    }
}
