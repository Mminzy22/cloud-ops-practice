package org.example.basic.parkminji.uniteighteen;

public enum CoffeeType {
    AMERICANO(3000),
    LATTE(3500),
    CAPPUCCINO(4000);

    private final int price;

    CoffeeType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String lower = name().toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1); // Latte
    }
}
