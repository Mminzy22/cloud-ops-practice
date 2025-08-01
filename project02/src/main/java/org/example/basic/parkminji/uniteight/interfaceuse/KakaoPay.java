package org.example.basic.parkminji.uniteight.interfaceuse;

class KakaoPay implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("카카오페이로 " + amount + "원 결제되었습니다.");
    }
}
