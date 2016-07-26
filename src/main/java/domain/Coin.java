package domain;

public class Coin {
    private Integer value = 0;

    public Integer getValue() {
        return value;
    }

    public Coin setValue(Integer value) {
        this.value = value;
        return this;
    }
}
