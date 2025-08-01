package org.example.basic.parkminji.uniteight.interfaceuse;

class CreditCardPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("신용카드로 " + amount + "원 결제되었습니다.");
    }
}
