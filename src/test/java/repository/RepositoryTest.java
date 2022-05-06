package repository;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    void shouldRemoveById() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "stihi", 200, "esenin");
        Smartphone smartphone1 = new Smartphone(2, "iphone11", 80000, "apple");

        repo.save(book1);
        repo.save(smartphone1);
        repo.removeById(2);

        Product[] expected = {book1};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByWrongId() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "stihi", 200, "esenin");
        Smartphone smartphone1 = new Smartphone(2, "iphone11", 80000, "apple");

        repo.save(book1);
        repo.save(smartphone1);
        repo.removeById(3);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdIfExistItemsWithIdenticalId() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "stihi", 200, "esenin");
        Smartphone smartphone1 = new Smartphone(2, "iphone11", 80000, "apple");
        Book book2 = new Book(1, "java", 500, "pankov");
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.removeById(1);

        Product[] expected = {smartphone1};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void souldSaveAnyProducts() {
        Repository repo = new Repository();
        Book book1 = new Book();
        Smartphone smartphone1 = new Smartphone();

        repo.save(book1);
        repo.save(smartphone1);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void souldSaveFirstProduct() {
        Repository repo = new Repository();
        Book book1 = new Book();

        repo.save(book1);

        Product[] expected = {book1};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }
}