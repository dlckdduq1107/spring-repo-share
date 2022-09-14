package hello.core.Singleton;

public class StatefulService {
    private int price;

    public void order(String id, int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
