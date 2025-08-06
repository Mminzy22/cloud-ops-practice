package org.example.basic.parkminji.uniteighteen;

public class CoffeeOrder {
    private final CoffeeType type;
    private final CoffeeSize size;

    public CoffeeOrder(CoffeeType type, CoffeeSize size) {
        this.type = type;
        this.size = size;
    }

    public int getPrice() {
        return type.getPrice();
    }

    @Override
    public String toString() {
        return String.format(
                "\n주문 내역\n- 커피 종류: %s\n- 사이즈: %s (%dml)\n- 가격: %,d원",
                type, size, size.getVolume(), type.getPrice()
        );
    }
}
