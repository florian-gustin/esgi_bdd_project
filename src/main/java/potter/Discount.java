package potter;

import java.util.HashMap;
import java.util.Map;

public class Discount {

    private final Map<Integer, Double> catalogue = new HashMap<>();

    public Discount() {
        catalogue.put(0, 0.0);
        catalogue.put(1, 0.0);
        catalogue.put(2, 0.05);
        catalogue.put(3, 0.1);
        catalogue.put(4, 0.15);
        catalogue.put(5, 0.2);
    }

    public double get(int size) {
        return 1 - catalogue.get(size);
    }

}
