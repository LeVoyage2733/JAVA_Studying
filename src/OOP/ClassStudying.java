/*
자바는 객체지향 프로그래밍 언어 -> 모든 것이 객체

객체지향 프로그래밍(OOP, Object-Oriented Programming)
-> 데이터, 데이터 조자하는 동작을 "객체" 단위로 묶어 프로그램 구성

====== <객체지향 언어의 특징> =========

1. 캡슐화(Encapsulation): 데이터와 동작 등 프로그램에 필요한 모든 자원을 객체로 묶어 감추는 것
|-- 1.1. 데이터와 기능 하나로 묶기: 관련 있는 변수와 함수 하나의 클래스 안에 묶기
|-- 1.2. 정보 은닉: 내부 구현 상세나 중요한 데이터는 바깥에서 직접 만지지 못하게 숨기고,
                  외부에는 허용된 통로(인터페이스/메서드)만 열어두는 것입니다.
                  접근 제어자(private, protected, public)

2. 상속(Inheritance): 한 클래스의 데이터와 기능을 다른 클래스가 이어받는 것

3. 다형성(Polymorphism): 동작이나 다른 기능을 하나의 이름으로 사용할 수 있게 하는 것
                        -> 상속, 오버로딩, 오버라이딩, 부모 타입 참조

4. 추상화(Abstraction): 공통되는 특성이나 속성 따위를 추출해 파악.
                       -> 객체마다 데이터와 동작을 구체적으로 정의 x -> 객체 공통 데이터와 동작만 추출해 선언

 */

// 클래스(Class)/객체(Object)
// 자동차 설계도 -> 클래스 (클래스를 바탕으로 여러 객체 생성 가능)
// 자동차 -> 객체

/*
자바 클래스 --- public (파일명) 클래스 1개          <- 다른 패키지/클래스 접근 가능한 클래스를 의미
          |-- 클래스 (public 없음) 다수로 구성

======= < 자바 클래스 내부에 public 클래스가 하나인 이유 > =========
-> JVM(자바 가상 머신)/자바 컴파일러의 파일 찾는 구조

1.1. 컴파일 전
자바 컴파일러가 다른 파일에서 Person 클래스 참조 시
-> Person.java 즉시 찾아서 컴파일

만약 Mathutils.java 안에 public class Car, public class Person이 있으면
컴파일러 Car/Person 클래스 찾기 위해 .java 파일 내부 다 봐야 함
-> 속도 저하
따라서 "외부에 공개되는(public) 핵심 클래스 명칭 = 소스 파일명"으로 규격을 강제하여 1:1 매핑

1.2. 컴파일 후
컴파일 후 파일 내 클래스마다 .class 파일 생성됨
[Main.java] (소스 파일 하나)
 ├── public class Main  ───(컴파일)───> Main.class
 └── class Dog          ───(컴파일)───> Dog.class

2. 자바 동작 과정
[소스 코드 (.java)] ──(컴파일러: javac, 컴파일 타임)──> [바이트코드 (.class)] ──(JVM 런타임)──> [실행]

2.1. 컴파일 타임
컴파일러: 기초적인 코드 문법 검사, 타입 체크만 함
         각 클래스 .class(바이트 코드)로 변환

2.2. 런타임
JVM(프로그램 실행 중): 프로그램 시작 시 main 클래스 먼저 메모리에 올림.
                    그 후 클래스가 필요할 때마다 파일 시스템에서 클래스명.class 참조해서 메모리에 올림(동적 로딩, Dynamic Loading)
                    JVM이 그 클래스가 실제로 필요한 순간(객체 생성, 메서드 호출 등)이 되면
                    비로소 해당 .class 파일을 메모리에 들고 와서(동적 로딩) 참조 및 실행

3. C++ vs JAVA

C++
소스 코드들 -[컴파일러]-> 기계어 코드 컴파일(.o/.obj) -[링커(Linker)]-> 하나의 .exe 파일로 정적 결합(Link)
컴파일 시 오래 걸림 -> 컴파일 완료 시 매우 빠름(.exe 파일 내 기계어 바로 실행)

JAVA
[소스 코드 (.java)] ──(컴파일러: javac, 컴파일 타임)──> [바이트코드 (.class)] ──(JVM 런타임)──> [실행]
JVM의 런타임 시 클래스 로드, 가비지 컬렉터 작동(메모리 동적 관리)

*/

/*
====== < 클래스 멤버 > ======
클래스 구성 요소 ───── 필드(Field)
                ├── 생성자(Constructor)
                └── 메서드(Method)

1.1. 필드
필드: 클래스에 선언하는 변수 == 멤버 변수

1.1.1 인스턴스 변수
    클래스 객체 생성할 때마다 새로 생성되는 변수
1.1.2. 클래스 변수
    클래스로 생성한 모든 객체에서 공유하는 변수
1.1.3. 지역 변수
    메서드에 선언하는 변수

1.2. 메서드
메서드: 클래스 안에 정의한 함수

[접근 제한자] 반환형 메서드/함수명(매개변수1, 매개변수2,...) {
    메서드 본문
    }

1.3. 생성자
객체를 생성하고 초기화하는 특별한 메서드
클래스 이름과 같고, 반환형 명시 x, 초기화하는 본문 들어감
생성자 정의x -> 생성자 자동 생성(매개변수x) == 기본 생성자
 */
package OOP;

public class ClassStudying {
    public static void main(String[] args) {
        // 객체 생성
        // 클래스명 변수명 = new 클래스명();
        //
        Car myCar = new Car();
    }
}

class Car {
    // 클래스 변수
    static int countOfCars = 0;
    String brand;
    int year;
    String color;

    // 기본 생성자
    public Car() {
        System.out.println("새로운 자동차 객체가 생성됐습니다.");
        this.carInfo(); // 인스턴스 메서드 호출
    }

    // 매개변수 2개가 있는 생성자
    public Car(String brand, int year) {
        System.out.println("새로운 자동차 객체가 생성됐습니다.");
        this.brand = brand;
        this.year = year;
        this.color = "white";
        this.carInfo(); // 인스턴스 매서드 호출
    }
    // 인스턴스 메서드
    public void carInfo() {
        System.out.println("--- 자동차 정보 ---");
        System.out.println("브랜드: " + brand);
        System.out.println("연식: " + year);
        System.out.println("색: " + color);
    }
    // 클래스 메서드
    public static void countOfCarsInfo() {
        System.out.println("자동차 수량: " + countOfCars);
    }


}

/* this는 객체 자신, 즉 생성자를 호출해서 생성한 객체를 가리키는 특별한 변수.
1. 객체 내 인스턴스 변수와 매개변수 이름 같을 때 구별해줌
ex)
public class Person {
    private String name; // 인스턴스 변수
    private int age;     // 인스턴스 변수

    // 생성자
    public Person(String name, int age) {
        // this.name -> 이 객체의 필드(인스턴스 변수)
        // name      -> 매개변수로 받아온 값
        this.name = name;
        this.age = age;
    }
2. 객체의 메서드 호출할 때 사용
멤버 참조 연산자"."
}

 */

