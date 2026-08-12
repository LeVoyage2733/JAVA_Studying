# 인터페이스(Interface)

## 인터페이스(Interface)란

<img style="width: 50%" alt="자바_다중상속_문제점" src="https://github.com/user-attachments/assets/fc7b676d-d044-4223-86ad-75fce59d9883" />

- 가장 밑의 자식 클래스는 어떤 money() 메서드 사용해야 되는지 혼란 발생
- 자바는 **다중 상속(multiple inheritance)** 허용x

**인터페이스(Interface)**:
**클래스에서 구현할 메서드들이 선언된 집합**
- 인터페이스에서 선언된 메서드의 동작 구현은 각 클래스가 담담
- C++의 **순수 가상 함수**과 기능과 역할이 같다

**특징**
1. 앞에 **interface** 키워드 붙여 선언
2. **메서드**
   1) **추상 메서드(Abstract Method)**
      - 정의: 선언부만 존재, 구현부({})가 없는 메서드
      - 특징: 인터페이스를 상속(구현)받는 클래스가 반드시 오버라이딩하여 실제 로직 작성해야 함
      - 표현: 별도 작성 안 해도 모든 추상 메서드는 public abstract 키워드 자동으로 붙음
   
