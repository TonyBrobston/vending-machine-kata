package domain;

import java.util.Arrays;
import java.util.List;

public class Coin {
    private Integer value = 0;

    public boolean isValid() {
        List<Integer> validCoins = Arrays.asList(5, 10, 25);
        return validCoins.contains(this.value);
    }

    public Integer getValue() {
        return value;
    }

    public Coin setValue(Integer value) {
        this.value = value;
        return this;
    }
}
