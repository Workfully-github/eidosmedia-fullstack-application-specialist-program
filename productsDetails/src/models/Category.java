package models;

public class Category {
    private String name;
    public static final String ENDPOINT = "/categories";

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
