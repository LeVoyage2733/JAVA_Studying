# 다형성(Polymorphism)

## 1. 메서드 오버라이딩(Method Overriding)

**메서드 오버라이딩**: 

- 클래스 상속 시 자식 클래스에서 다른 동작을 수행하도록 메서드를 변형해서 사용
- 메서드 재정의

### 애너테이션:
**@Override** 애너테이션 추가해 오버라이딩 명시적 표기 가능


public class Cat extends Animal {
    public void rub() {
        System.out.println(name + "가 몸을 비빕니다.");
    }
    @Override
    public void eat() { // 메서드 오버라이딩
        System.out.println(name + "가 닭고기를 먹습니다.");
    }
}
