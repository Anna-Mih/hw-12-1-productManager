package domain;

import repository.Repository;

public class ProductManager {
    private Repository repo;

    public ProductManager(Repository repo) {
        this.repo = repo;
    }

    public void addProduct(Product item) {
        repo.save(item);
    }

    public Product[] searchBy(String text) {
//        int index = 0;
//        int length = 0;
//
//        for (Product item: repo.findAll()) {
//            if (matches(item, text)) {
//                length++;
//            }
//        }
//        Product[] result = new Product[length];
//
//        for (Product item: repo.findAll()) {
//            if (matches(item, text)) {
//                result[index] = item;
//                index++;
//            }
//        }
//        return result;

        Product[] result = new Product[0];
        for (Product item : repo.findAll()) {
            if (matches(item, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product item, String search) {
        if (item instanceof Book) {
            Book book = (Book) item;
            if (book.getAuthor().contains(search)) {
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (item instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) item;
            if (smartphone.getManufacturer().contains(search)) {
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return false;
        }
        return false;
    }

}
