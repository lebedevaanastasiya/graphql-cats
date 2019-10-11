package ql.graph.cats;

import java.time.Instant;

public class Food {
    private String id;

    private String title;

    private int points;

    private int minutes;

    public Food(String id, String title, int points, int minutes) {
        this.id = id;
        this.title = title;
        this.points = points;
        this.minutes = minutes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
