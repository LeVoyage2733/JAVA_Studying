# 다형성(Polymorphism)

## 0. 다형성(Polymorphism)

**다형성**: **하나**의 **객체**나 **메서드**가 **다양한 형태(타입)로 동작**할 수 있는 성질

1. **오버라이딩(Overriding, 런타임 다형성)**
   - 상위 클래스가 정의한 메서드를 하위 클래스에서 재정의
   - 부모 타입의 참조 변수로 자식 객체를 가리킬 때, 호출되는 메서드는 실제 참조 중인 객체의 재정의된 메서드가 실행됨(동적 바인딩)
2. **오버로딩(Overloading, 컴파일 타임 다형성)**
   - 같은 이름의 메서드라도 매개변수의 타입이나 개수를 다르게 하여 여러 개 정의하는 것

## 1. 메서드 오버라이딩(Method Overriding)

**메서드 오버라이딩**: 

- 클래스 상속 시 자식 클래스에서 다른 동작을 수행하도록 메서드를 변형해서 사용
- 메서드 재정의

### 애너테이션:
**@Override** 애너테이션 추가해 오버라이딩 명시적 표기 가능

```
// 부모 클래스 Animal
public class Animal {
    // 필드
    String name;
    int age;
    // 메서드
    public void eat() {
        System.out.println(name + "이(가) 밥을 먹습니다.");
    }
}
```

```
// Animal의 자식 클래스 Cat
public class Cat extends Animal {
    public void rub() {
        System.out.println(name + "가 몸을 비빕니다.");
    }
    @Override
    public void eat() { // 메서드 오버라이딩
        System.out.println(name + "가 닭고기를 먹습니다.");
    }
}
```

### 자바 **애너테이션(Annotation)**:

**Annotation**: 주석, 코드에 대한 설명이나 문법을 컴파일러가 확인하도록 정보 제공
- **표준 애너테이션**: 자바 표준 이브러리에 포함(@Override, @Deprecated)
- **메타 애너테이션**: 애너테이션을 위한 애너테이션, 다른 애너테이션 정의할 때 사용(@Retention, @Target)
- **커스텀 애너테이션**: 사용자 정의 애너테이션

## 2. 메서드 오버로딩
**오바라이딩(Overriding)**: 
- 매서드명, 반환형, 매개변수의 개수와 순서 모두 같음
- 동작만 다른 메서드를 자식 클래스에 정의

**메서드 오버로딩(Method Overloading)**:
- 메서드명 같음
- 매개변수의 개수와 순서, 자료형이 다른 메서드를 같은 클래스 안에 여러 개 정의함

```
// 오버라이딩

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
```

## 3. 형변환

### 업캐스팅
**업캐스팅(Upcasting)**: 자식 클래스 객체를 부모 클래스형으로 변환. 명시적x, 자동.

자식 클래스 객체 생성
```
Dog myDog = new Dog(); // Dog 클래스의 참조 변수에 할당
Cat myCat = new Cat(); // Cat 클래스의 참조 변수에 할당
```
상속 관계 자식 클래스 객체 생성
```
Animal myAnimal1 = new Dog(); // Dog 클래스 객체를 Animal 클래스형의 참조 변수에 할당
Animal myAnimal2 = new Cat(); // Cat 클래스 객체를 Animal 클래스형의 참조 변수에 할당
```
**컴파일러**에 의해 **자식 클래스 객체** -> **부모 클래스형** 자동 변환
- **업캐스팅**된 **참조 변수** -> **부모 클래스 선언 필드, 메서드"만"** 접근 가능
- **자식 클래스** 정의 필드, 메서드 **접근x**
  - 자식 클래스에 **오버라이딩 메서드** 존재 -> 해당 메서드 접근 가능
 
**업캐스팅 하는 이유**:
부모 클래스형(Animal) 하나로 여러 자식 클래스의 객체 다룰 수 있음

### 다운캐스팅
**다운캐스팅(Downcasting)**: 부모 클래스형 객체 -> 자식 클래스형 형변환

```
public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Dog();
        myAnimal.name = "바둑이";
        myAnimal.eat(); // Animal 클래스의 eat() 메서드 호출
        Dog myDog = (Dog)myAnimal;
        myDog.roll();
        myAnimal = new Cat();
        myAnimal.name = "나비";
        myAnimal.eat(); // Cat 클래스의 eat() 메서드 호출
        Cat myCat = (Cat)myAnimal;
        myCat.rub();
    }
}
```
