package Polymorphism;

public class Dog extends Animal{
    // 필드
    String breed; // 견종

    // 메서드
    public void roll() {
        System.out.println(name + "가 바닥을 구릅니다.");
    }

    // 메서드 오버로딩
    public void roll(int times) {
        System.out.println(name + "가 바닥을 " + times + "번 구릅니다.");
    }
}
