package ru.netology;

public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        setId(id);
        setName(name);
        setPrice(price);
        setAuthor(author);
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
