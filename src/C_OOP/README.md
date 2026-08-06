# 클래스 정리

## 객체 생성
### 1. new 키워드를 사용한 객체 생성과 참조

<img width="641" height="192" alt="image" src="https://github.com/user-attachments/assets/a0175757-6227-462d-a1a3-d8a425377c7f" />


- **메서드 영역(Method Area):**
  - 프로그램이 시작될 때 클래스 관련 정보가 저장되는 공간.
  - 클래스명, 부모 클래스, 클래스 변수, 필드 정보, 메서드 정보, 메서드 코드 저장됨
  - 프로그램 시작 시 로드 -> 프로그램 종료까지 유지, 메서드 영역 저장된 정보 클래스의 모든 객체에 공유됨

- **힙(Heap):**
  - 프로그램이 실행되며 동적으로 생성된 객체와 배열 저장되는 공간.
  - 객체와 함께 인스턴스 변수들도 저장됨.
  - new 키워드 생성 -> 힙 영역에 저장
    
- **스택(Stack):**
  - 메서드 실행과 관련된 정보들이 저장됨.
  - 지역 변수, 메서드 결과 반환 주소.
  - 메서드 실행 시 자동 메모리 할당, 종료 시 해제


객체 == 힙 
참조 변수 == 스택 
**-> 참조 변수 객체 메모리 주소 저장, 저장된 주소 참조 -> 객체 접근**

**new 키워드로 객체 생성하는 과정**


<img alt="자바new객체생성" src="https://github.com/user-attachments/assets/457ce96a-1048-44da-99c3-8c3dbb29099b" width="70%"/>


1. new 키워드 사용 -> 객체 힙 영역에 생성
2. 객체 생성 -> 객체 주소가 new 키워드 사용한 곳으로 반환
3. 클래스로 참조 변수 선언
4. 반환된 주소를 참조 변수에 저장
5. 저장된 주소로 해당 객체를 참조

### 2. 문자열 리터럴과 new 키워드 차이

1. **문자열 상수 풀(String Constanat Pool)**

- JAVA **힘(Heap)** 메모리 영역 안에 특별히 존재
- JAVA 문자열 객체 매우 자주 사용 -> 동일한 문자열 값 여러 번 사용 시 메모리 재사용

2. **두 가지 생성 방식과 메모리 차이**

```
// 1. 문자열 리터럴 방식
String str1 = "Hello";
String str2 = "Hello";

// 2. new 키워드 생성 방식
String str3 = new String("Hello");
String str4 = new String("Hello");
```
  
  1. **문자열 리터럴 방식("Hello")**

     - "Hello"와 같이 큰따옴표(리터럴)로 문자열 생성 -> JAVA 문자열 상수 풀 확인
     - 상수 풀 동일한 내용 문자열 x: 새로운 String 객체 생성 및 주소값 반환
     - 상수 풀 동일한 내용 문자열 o: 기존 상수 풀 객체 주소값 **재사용**

  2. **new 키워드 생성 방식(new String("Hello"))**

     - new 키워드 사용 -> **힙 메모리**의 별도 공간에 항상 **새로운 객체 생성**
     - str3와 str4 내부 문자열 값 같지만, 메모리 주소값 다름
    

## 클래스 심화

### static

```
public static void main(String[] args) {
}
// static이 무엇일까?
```

**런타임 데이터 영역** 속 **메서드 영역**

- 메서드 영역: 클래스 변수, 클래스 메서드 저장
  - 프로그램 시작 시 할당, 종료 시 반환
  - 클래스 변수/클래스 메서드 앞에 static 붙음

### 접근 제한자

**접근 제한자**: 
- 클래스, 변수, 메서드, 생성자 등의 접근 범위를 제한하여 외부로부터 데이터를 보호(캡슐화)
- 불필요한 노출을 막기 위해 사용하는 키워드

**public**: 접근 제한x
**protected**: 같은 패키지와 상속받은 클래스
**default**: 같은 패키지
**private**: 같은 클래스

예시)
```
package sample;

public class Car {
    // 1. public: 누구나 접근 가능
    public String modelName;

    // 2. protected: 같은 패키지 또는 상속받은 자식 클래스에서 접근 가능
    protected int speed;

    // 3. default (키워드를 쓰지 않음): 같은 패키지에서만 접근 가능
    int fuel;

    // 4. private: 오직 Car 클래스 내부에서만 접근 가능
    private String serialNumber;

    public Car(String modelName, String serialNumber) {
        this.modelName = modelName;
        this.serialNumber = serialNumber; // 클래스 내부이므로 private 접근 가능
    }

    // private 변수는 보통 getter/setter 메서드를 통해 안전하게 접근합니다.
    public String getSerialNumber() {
        return this.serialNumber;
    }
}
```
메인 클래스
```
package sample; // Car와 같은 패키지

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("소나타", "12345-ABC");

        System.out.println(myCar.modelName);    // OK (public)
        System.out.println(myCar.speed);        // OK (protected - 같은 패키지)
        System.out.println(myCar.fuel);         // OK (default - 같은 패키지)
        
        // System.out.println(myCar.serialNumber); // 에러! (private은 외부에서 접근 불가)
        System.out.println(myCar.getSerialNumber()); // OK (public 메서드를 거쳐 접근)
    }
}
```
