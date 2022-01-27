package service;

import model.Product;

import java.util.ArrayList;

public class ProductService {
    private final static ArrayList<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Iphone12", 28990000, 18, "blue"));
        products.add(new Product(2, "AppleWatch6", 12600000, 26, "black"));
        products.add(new Product(3, "AirPod2", 3290000, 12, "white"));
        products.add(new Product(4, "MacbookAir", 33500000, 7, "red"));
    }

    public Product getProduct(int id) {
        for (Product c :
                products) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void editProduct(int id, Product product) {
        products.set(id, product);
    }

    public ArrayList<Product> displayPro() {
        return products;
    }

    public ArrayList<Product> displayCart() {
        return products;
    }

    public void deleteCart(Product product) {
        products.remove(product);
    }

    public void deleteAll() {
        products.removeAll(products);
    }

    public void createCart(int index, Product product) {
        products.add(product);
    }

    public ArrayList<Product> sortProductUp() {
        products.sort((o1, o2) -> {
            if (o1.getPrice() > o2.getPrice()) return 1;
            else if (o1.getPrice() < o2.getPrice()) return -1;
            else return 0;
        });
        return products;
    }

    public ArrayList<Product> sortProductDown() {
        products.sort((o1, o2) -> {
            if (o1.getPrice() > o2.getPrice()) return -1;
            else if (o1.getPrice() < o2.getPrice()) return 1;
            else return 0;
        });
        return products;
    }
}
