# 상속(Inheritance)

## 1. 상속
한 클래스가 다른 클래스의 필드와 메서드를 이어받아 사용하고 기능을 확장

**부모 클래스(parent class)** -[상속]-> **자식 클래스(child class)**
  (상속하는 클래스)                        (상속받는 클래스)

### 형식
```
class 자식_클래스명 extends 부모_클래스명 {
  // 클래스 본문
}
```
ex)
```
class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}
```

