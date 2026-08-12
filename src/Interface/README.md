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
      - 개념: 선언부만 존재, 구현부({})가 없는 메서드
      - 특징: 인터페이스를 상속(구현)받는 클래스가 반드시 오버라이딩하여 실제 로직 작성해야 함
      - 표현: 별도 작성 안 해도 모든 추상 메서드는 public abstract 키워드 자동으로 붙음
   ```
   public interface Animal {
      void sound(); // public abstract void sound(); 와 동일
   }
   ```
   2) **디폴트 메서드(Default Method)**
      - 개념: 자바 8부터 도입. 인터페이스 내에서 실제 구현부({})를 가질 수 있는 메서드
      - 특징: 기존 인터페이스에 새로운 기능 추가할 때, 이를 구현한 기존 클래스들 수정 안 해도 공통 기능 제공 가능. 구현 클래스에서 필요에 따라 오버라이딩이나 그대로 사용 가능.
      - 표현: 메서드 선언 앞에 default 키워드 붙음
   ```
   public interface Animal {
      default void sleep() {
         System.out.println("잠을 잡니다.");
      }
   }
   ```
   3) **정적 메서드(Static Method)**
      - 개념: 자바 8부터 도입. 구현부({})를 갖는 클래스 유틸리티 형태의 메서드
      - 특징: 인터페이스 구현한 객체 생성x, "인터페이스명.메서드명()"으로 직접 호출. 구현 클래스에서 오버라이딩x
      - 표현: 메서드 선언 앞에 static 붙음
   ```
   public interface Calculator {
      static int add(int a, int b) {
         return a + b;
      }
   } // 사용: int result = Calculator.add(5, 3);
   ```
3. **상수(Constant)**
   - 개념: 값을 변경할 수 없는 고정된 변수
   - 특징: 인터페이스는 상태(인스턴스 필드)를 가질 수 없음. 인터페이스에 선언되는 모든 변수는 상수로 처리됨. 변수를 선언할 때 별도로 명시하지 않아도 "public static final"이 자동으로 붙음. 선언과 동시에 반드시 초기값을 할당해야 함.
   ```
   public interface Config {
      int MAX_LIMIT = 100; // public static final int MAX_LIMIT = 100;
   }
   ```
4. **접근 제한자(Access Modifier)**
   - 개념: 인터페이스 자체 및 내부 멤버들의 접근 범위 제어.
   - 특징:
     - 인터페이스 자체: public 또는 package-private(기본값, 키워드 생략)만 사용 가능
     - 멤버(상수, 추상/디폴트/정적 메서드): 외부에서 접근하여 사용할 수 있도록 기본적으로 모두 public이다.
     - private 메서드(자바 9+): 자바 9부터 인터페이스 내부의 디폴트 메서드나 정적 메서드 간의 코드 중복을 줄이기 위해 private 메서드를 정의할 수 있다.(외부나 구현 클래스에는 노출되지 않음)
    
**디폴트 메서드 vs 정적 메서드**

**디폴트 메서드:** 기존 코드와 호환성 유지하며 기능 확장. 자바 8 만들면서 Collection 인터페이스에 stream()이나 forEach()같은 새로운 기능 추가함. 이때 기존 방식대로 추상 메서드로 추가하면, 전세계 수많은 라이브러리와 구현 클래스들이 전부 컴파일 에러가 뜸. 디폴트 메서드를 통해 기존 클래스 수정하지 않고 인터페이스의 기능을 안전하게 오버라이딩할 수 있게 됨.

```
// 객체의 상태나 동작과 관련이 있는 기본 제공 메서드
public interface List<E> {
    // 기본 동작을 제공하지만, 필요하면 ArrayList 등에서 성능 optimized 버전으로 오버라이딩 가능
    default void sort(Comparator<? super E> c) {
        // 기본 정렬 로직...
    }
}
```

**정적 메서드:** 특정 객체의 상태와 상관없이, 인터페이스와 관련된 독립적이고 공통적인 유틸리티 기능(한 번 만들어두고 쓰는 메서드 영역에 저장하는 로직, add()..) 제공. 인터페이스 내부에 관련 유틸리티 메서드 직접 제공할 수 있음. 관련 기능을 한 곳에 모으고 객체 생성 없이 간단히 사용 가능. 유틸리티 기능은 일종의 고정된 표준 계산식/생성기 역할을 해야 하므로, 하위 클래스가 마음대로 로직 변형(오버라이딩)하지 못해야 함.

```
public interface Path {
    // 객체 없이 Path.of(...) 형태로 도우미 기능을 바로 사용
    // 하위 구현체가 이 유틸리티의 핵심 동작 방식을 바꿀 수 없음
    static Path of(String first, String... more) {
        return FileSystems.getDefault().getPath(first, more);
    }
}
```

**인터페이스 형식**
```
[접근_제한자] interface 인터페이스명 {
   자료형 변수명 = 값; // 상수, public static final 생략됨
   반환형 메서드명(매개변수1, 매개변수2, ...) {}; // 추상 메서드
   default 반환형 메서드명(매개변수1, 매개변수2, ...) {}; // 디폴트 메서
   static 반환형 메서드명(매개변수1, 매개변수2, ...) {}; // 정적 메서드
```

**구현 클래스로 전달**
- 인터페이스는 직접 객체 생성x.
- 구현 클래스에서 객체 생성, 객체에서 인터페이스를 자료형으로 선언 가능
- implements 키워드로 구현할 인터페이스 명시
```
// 기본 구조
class 클래스명 implements 인터페이스명 {}
// 부모_클래스 상속받음, 인터페이스는 다중 구현 가능
class 자식_클래스명 extends 부모_클래스명 implements 인터페이스1, 인터페이스2... {}
```
