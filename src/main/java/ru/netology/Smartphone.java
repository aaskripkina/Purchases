package ru.netology;

public class Smartphone extends Product{
    private String manufacturer;

    public Smartphone(int id, String name, int price, String manufacturer) {
        super();
        setId(id);
        setName(name);
        setPrice(price);
        this.manufacturer = manufacturer;
    }

    public void setManufacturer (String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
