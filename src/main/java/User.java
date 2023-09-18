import java.util.HashMap;

public class User implements Shopper, Buyer {

    private HashMap<Product, Integer> cart;
    private int cartSum;
    private int money;

    public User(int money) {
        cart = new HashMap<>();
        this.money = money;
    }

    public void addToCart(Product product, int amount) {        // todo negative values
        if (!cart.containsKey(product)) {
            cart.put(product, amount);      // TODO
        } else {
            cart.put(product, cart.get(product) + amount);
        }
        cartSum += amount * product.getPrice();
    }


    public boolean removeFromCart(Product product, int amountToDelete) {
        if (cart.containsKey(product)) {
            if (cart.get(product) > amountToDelete) {
                cart.put(product, cart.get(product) - amountToDelete);
                cartSum -= amountToDelete * product.getPrice();
            } else {
                cartSum -= cart.get(product) * product.getPrice();
                cart.remove(product);
            }

            return true;
        }

        return false;
    }

    public boolean kupil() {
        int total = 0;
        for (Product product : cart.keySet()) {
            total += product.getPrice() * cart.get(product);       // TODO product.equals7
        }

        if (money >= total) {
            money -= total;     // TODO if not enough money
            System.out.println();
            System.out.println("Вы приобрели товары на сумму " + total + " рублей");
            System.out.println("Ваш баланс: " + money);
            return true;
        }

        System.out.println();
        System.out.println("У вас недостаточно денег чтобы совершить эту покупку");
        System.out.println("Удалите некоторые продукты из вашей корзины");
        System.out.println();

        return false;

    }

    public int getCartSum() { return cartSum; }

    public int getMoney() {
        return money;
    }
}