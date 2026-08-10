# 다형성(Polymorphism)

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

###자바 **애너테이션(Annotation)**:

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

