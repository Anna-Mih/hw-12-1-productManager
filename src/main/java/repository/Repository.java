package repository;

import domain.Product;

public class Repository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public void removeById(int id) {

        int findId = 0;  // проверяю, что введен существующий id
        for (Product item : items) {
            if (item.getId() == id) {
                findId++;
            }
        }

//        if (findId == 0) {
//            return;
//        }
//
//        if (findId > 1) {
//            return;
//        }

        int length = items.length - findId;
        Product[] tmp = new Product[length];
        int index = 0;


        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index = index + 1;
            }
        }
        items = tmp;
    }
}
