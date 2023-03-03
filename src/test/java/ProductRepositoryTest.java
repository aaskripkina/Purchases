
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {

    @Test
    public void shouldAdd(){
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Piece of Cake", 154, "Robinson");
        assertEquals("Robinson", book1.getAuthor());

        manager.add(book1);

        Product[] expected = {book1};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchBy(){
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Piece of Cake", 154, "Robinson");
        Book book2 = new Book(2, "One piece", 210, "Oda");
        Book book3 = new Book(3, "Master and Margarita", 500, "Bulgakov");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("Piece");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById(){
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Piece of Cake", 154, "Robinson");
        Book book2 = new Book(2, "One piece", 210, "Oda");
        Book book3 = new Book(3, "Master and Margarita", 500, "Bulgakov");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        manager.removeById(1);

        Product[] expected = {book2, book3};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatches(){
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Piece of Cake", 154, "Robinson");
        Book book2 = new Book(2, "One piece", 210, "Oda");
        Book book3 = new Book(3, "Master and Margarita", 500, "Bulgakov");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        boolean expected = true;
        boolean actual = manager.matches(book3, "a" );

        assertArrayEquals(new boolean[]{expected}, new boolean[] {actual});
    }

    @Test
    public void shouldNotMatchesBook(){
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Piece of Cake", 154, "Robinson");
        Book book2 = new Book(2, "One piece", 210, "Oda");
        Book book3 = new Book(3, "Master and Margarita", 500, "Bulgakov");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        boolean expected = false;
        boolean actual = manager.matches(book1, "r" );

        assertArrayEquals(new boolean[]{expected}, new boolean[] {actual});
    }

    @Test
    public void shouldAddSmartphone(){
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);

        Smartphone smartphone1 = new Smartphone(1, "IPhone", 500, "Apple");
        assertEquals("Apple", smartphone1.getManufacturer());
        assertEquals(500, smartphone1.getPrice());

        smartphone1.setManufacturer("Samsung");
        assertEquals("Samsung", smartphone1.getManufacturer());

        manager.add(smartphone1);

        Product[] expected = {smartphone1};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchBySmartphone(){
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);

        Smartphone smartphone1 = new Smartphone(1, "IPhone", 500, "USA");
        Smartphone smartphone2 = new Smartphone(2, "Samsung", 300, "Korea");
        Smartphone smartphone3 = new Smartphone(3, "Oppo", 400, "China");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Phone");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdSmartphone(){
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);

        Smartphone smartphone1 = new Smartphone(1, "IPhone", 500, "USA");
        Smartphone smartphone2 = new Smartphone(2, "Samsung", 300, "Korea");
        Smartphone smartphone3 = new Smartphone(3, "Oppo", 400, "China");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.removeById(2);

        Product[] expected = {smartphone1, smartphone3};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchesSmartphone(){
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);

        Smartphone smartphone1 = new Smartphone(1, "IPhone", 500, "USA");
        Smartphone smartphone2 = new Smartphone(2, "Samsung", 300, "Korea");
        Smartphone smartphone3 = new Smartphone(3, "Oppo", 400, "China");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        boolean expected = true;
        boolean actual = manager.matches(smartphone1, "I" );

        assertArrayEquals(new boolean[]{expected}, new boolean[] {actual});
    }

    @Test
    public void shouldNotMatches(){
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);

        Smartphone smartphone1 = new Smartphone(1, "IPhone", 500, "USA");
        Smartphone smartphone2 = new Smartphone(2, "Samsung", 300, "Korea");
        Smartphone smartphone3 = new Smartphone(3, "Oppo", 400, "China");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone1);

        boolean expected = false;
        boolean actual = manager.matches(smartphone2, "p" );

        assertArrayEquals(new boolean[]{expected}, new boolean[] {actual});
    }

    @Test
    public void shouldDeleteById() {
        Repository repository = new Repository();

        Book book1 = new Book(1, "Piece of Cake", 154, "Robinson");
        Book book2 = new Book(2, "One piece", 210, "Oda");
        Book book3 = new Book(3, "Master and Margarita", 500, "Bulgakov");

        repository.addItem(book1);
        repository.addItem(book2);
        repository.addItem(book3);

        repository.removeById(1);

        Product[] expected = {book2, book3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void noProductExists() {
        Repository repository = new Repository();

        Book book1 = new Book(1, "Piece of Cake", 154, "Robinson");
        Book book2 = new Book(2, "One piece", 210, "Oda");
        Book book3 = new Book(3, "Master and Margarita", 500, "Bulgakov");

        repository.addItem(book1);
        repository.addItem(book2);
        repository.addItem(book3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(8);
        });
    }

}
