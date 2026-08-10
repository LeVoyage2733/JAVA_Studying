package Polymorphism;

public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog(); // 강아지 객체 생성
        Cat myCat = new Cat(); // 고양이 객체 생성

        myDog.breed = "진돗개";
        myDog.name = "바둑이";
        myDog.age = 3;
        myDog.roll();
        myDog.eat();

        myCat.name = "나비";
        myCat.age = 4;
        myCat.rub();
        myCat.eat();
        System.out.print("\n");

        Animal myAnimal1 = new Dog();
        myAnimal1.name = "장군";
        myAnimal1.eat();
        myAnimal1 = new Cat();
        myAnimal1.name = "꽁치";
        myAnimal1.eat();
    }
}
