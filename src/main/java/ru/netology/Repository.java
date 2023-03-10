package ru.netology;

public class Repository {

    Product[] items = new Product[0];
    public Product[] findAll() {
        return items;
    }

    public Repository() {

    }

    public void addItem(Product item) {
        int length = items.length + 1;
        Product[] newProducts = new Product[length];
        for (int i = 0; i < items.length; i++) {
            newProducts[i] = items[i];
        }
        newProducts[newProducts.length - 1] = item;
        items = newProducts;

    }

    public void deleteItem(int id) {
        int length = items.length - 1;
        Product[] newProducts = new Product[length];
        int index = 0;
        for (int i = 0; i < items.length; i++) {
            Product currentProduct = items[i];
            if (currentProduct.getId() != id) {
                newProducts[index] = currentProduct;
                index++;
            }
        }

        items = newProducts;

    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(id);
        }
        deleteItem(id);
    }

}
