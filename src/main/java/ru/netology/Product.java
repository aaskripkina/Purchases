package ru.netology;

public class Product {
    private int id;
    private String name;
    private int price;


    public Product() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;

    }
    public void setName(String name) {
        this.name = name;
    }


    public void setPrice (int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
