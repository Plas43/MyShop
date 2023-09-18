import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Store {
    private Map<Integer, Product> productsMap;
    private int counter;

    public Store() {
        productsMap = new HashMap<>();
        counter = 1;
    }

    public void addProducts(Product... products) {
        for (Product product : products) {
            productsMap.put(counter, product);
            counter++;
        }
    }

    public void printProducts() {
        int i = 1;
        for (Product product : productsMap.values()) {
            System.out.println(i + ". " + product.getName());
            i++;
        }
    }

    public Product getProductById(int id) {
        return productsMap.get(id);
    }

//    public void removeProduct(Product product) {
//        productsSet.remove(product);
//    }



}
