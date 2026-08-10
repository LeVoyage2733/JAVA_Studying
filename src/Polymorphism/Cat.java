package Polymorphism;

public class Cat extends Animal {
    public void rub() {
        System.out.println(name + "가 몸을 비빕니다.");
    }
    @Override
    public void eat() { // 메서드 오버라이딩
        System.out.println(name + "가 닭고기를 먹습니다.");
    }
}
