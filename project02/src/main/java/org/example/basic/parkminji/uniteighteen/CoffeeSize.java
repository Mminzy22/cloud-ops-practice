package org.example.basic.parkminji.uniteighteen;

public enum CoffeeSize {
    SMALL(250),
    MEDIUM(350),
    LARGE(450);

    private final int volume;

    CoffeeSize(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        String lower = name().toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }
}
