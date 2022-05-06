package domain;

import repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    Repository repo = new Repository();

    @org.junit.jupiter.api.Test
    void shouldSearchByIfNotExistText() {
        repo.save(new Book(1, "stihi", 200, "barto"));
        repo.save(new Smartphone(2, "sumsung", 12000, "company"));
        repo.save(new Book(3, "animals", 150, "bianki"));
        //ProductManager manager = new ProductManager();

        String text = "pushkin";

        ProductManager manager = new ProductManager(repo);

        Product[] expected = {};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test
    void shouldSearchByIfExistTextInOneItem() {
        repo.save(new Book(1, "stihi", 200, "barto"));
        repo.save(new Smartphone(2, "sumsung", 12000, "company"));
        repo.save(new Book(3, "animals", 150, "bianki"));
        //ProductManager manager = new ProductManager();
        String text = "barto";
        ProductManager manager = new ProductManager(repo);

        Product[] expected = {new Book(1, "stihi", 200, "barto")};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldSearchByIfExistTextInMoreThenOneItem() {
        repo.save(new Book(1, "stihi", 200, "barto"));
        repo.save(new Smartphone(2, "sumsung", 12000, "company"));
        repo.save(new Book(3, "animals", 150, "bianki"));
        repo.save(new Smartphone(4, "sumsung-galaxy", 15000, "company"));
        String text = "company";
        ProductManager manager = new ProductManager(repo);

        Product[] expected = {
                new Smartphone(2, "sumsung", 12000, "company"),
                new Smartphone(4, "sumsung-galaxy", 15000, "company")
        };
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldSearchByIfExistTextInMoreThenOneItemInDifferentParts() {
        repo.save(new Book(1, "stihi", 200, "petrov"));
        repo.save(new Smartphone(2, "sumsung", 12000, "company"));
        repo.save(new Book(3, "animals", 150, "bianki"));
        repo.save(new Smartphone(4, "sumsung-galaxy", 15000, "company"));
        repo.save(new Book(5, "petrov and sokolov", 200, "ivanov"));
        String text = "petrov";
        ProductManager manager = new ProductManager(repo);

        Product[] expected = {
                new Book(1, "stihi", 200, "petrov"),
                new Book(5, "petrov and sokolov", 200, "ivanov")
        };
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouldSearchByIfExistTextPartially() {
        repo.save(new Book(1, "stihi", 200, "petrov"));
        repo.save(new Smartphone(2, "sumsung", 12000, "company"));
        repo.save(new Book(3, "animals", 150, "bianki"));
        repo.save(new Smartphone(4, "sumsung-galaxy", 15000, "company"));
        repo.save(new Book(5, "petrov and sokolov", 200, "ivanov"));
        String text = "sumsung";
        ProductManager manager = new ProductManager(repo);

        Product[] expected = {
                new Smartphone(2, "sumsung", 12000, "company"),
                new Smartphone(4, "sumsung-galaxy", 15000, "company")
        };
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }
}