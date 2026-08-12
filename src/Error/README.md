# 오류와 에외

## 오류(Error)
- def. **프로그램 코드로 복구할 수 없는 문제**. JVM 자체의 문제나 시스템 자원 부족 등 **프로그램 외부 시스템 수준에서 발생**하는 문제
- **수습 불가능**, try-catch로 잡아내서 정상으로 복구 불가
- ex) 메모리 가득 찬 경우(OutOfMemoryError), 재귀 호출이 끝없이 이어져 스택 메모리가 넘친 경우(StackOverflowError)
- 대처 방법: 코드로 해결x, 서버 메모리 증설, 비효율적인 로직 수정

1. **컴파일 타임 오류(Compile Time Error)**
   - def. 컴파일 과정에서 컴파일러가 이해할 수 없는 코드 있을 때 발생하는 오류.
   - **문법 오류(Syntax Error)**: 오타나 세미콜론 누락 등 문법에 맞은 코드 작성 시 발생
   - **타입 오류(Type Error)**:  잘못된 자료형 사용할 때 발생
   - **참조 오류(Reference Error)**: 선언하지 않은 변수나 메서드 사용할 때 발생

2. **런타임 오류(Runtime Error)**
   - def. 프로그램이 실행 중(runtime) 발생하는 오류. 프로그램이 실행되는 중에 처리할 수 없는 연산을 만나 비정상적으로 종료되는 경우
     1) **시스템 오류(Error)**
        - 메모리 부족, JVM 내부 결함 등 **시스템/환경적인 문제**로 발생
        - 프로그램 외부의 문제이므로 코드로 복구 불가. **프로그램 즉시 강제 종료**
        - ex) OutOfMemoryError: Heap 메모리 부족, StackOverflowError: 무한 재귀 호출 등으로 Stack 메모리 넘칠 때
      2) **예외(Exception)**
         - 개발자의 **코드 작성 실수**, **외부 환경(사용자 입력, 파일/네트워크 이상)**으로 발생
         - try-catch로 복구 가능
         - ex) NullPointerException: null 객체 참조하려 할 때(개발자 실수), ArrayIndexOutOfBoundsException: 배열 범위 벗어난 인덱스 접근(개발자 실수), FileNotFoundException: 지정한 경로에 파일 존재x (외부 환경 문제)

3. **논리 오류(Logical Error)**
   - def. 컴파일, 실행 정상 작동, 결과가 의도한 대로 안 나와 발생하는 오류. 정상 종료된 후 발생함.
   - 결과가 양수로 나와야 하는데 음수로 나오거나, 변수 a의 값이 아니라 a+b의 값이 나오는 경우
   - 문법적 오류x 컴파일러가 오류 못 잡음. -> 개발자가 직접 오류 찾아서 고쳐야 함.

4. **링커 오류(Linker Error)**
   - def. 살행에 필요한 외부 함수, 클래스, 모듈 찾을 수 없을 때 발생하는 오류.
   - 컴파일 직후, 분리된 소스 코드 파일들이나 라이브러리를 하나로 연결(Linkeng)하는 과정에서 발생.
   - 필요한 .class파일이나 JAR 라이브러리 패스(Classpath)가 누락될 때 발생
   - ex) NoClassDefFoundError, ClassNotFoundException
  
## 예외(Exception)
- def. **프로그램 실행 중 발생**하는 **복구 가능**한 **문제 상황**
- try-catch해 두면 프로그램 계속 작동

```
              java.lang.Throwable
                        │
               java.lang.Exception
                        │
    ┌───────────────────┴───────────────────┐
    ▼                                       ▼
Checked Exception                      RuntimeException 
(외부 환경/사용자 입력 문제)            (개발자의 코드 작성 실수)
(Exception 직속 하위 클래스들)           (Unchecked Exception)
    │                                       │
    ├── IOException                         ├── NullPointerException
    ├── SQLException                        ├── ArrayIndexOutOfBoundsException
    └── FileNotFoundException               └── ArithmeticException
```

1. **확인 예외(Checked Exception)**
   - def. **컴파일 시점**에 **컴파일러가 예외 처리 여부를 적극적으로 확인**하는 예외
   - try-catch로 예외 잡거나, throws로 외부에 던진다고 명시하지 않으면 컴파일 오류 발생하여 프로그램 빌드 안 됨
   - 파일 입출력, 네트워크 통신, DB 연동 등 프로그램 외부 환경과 상호작용 과정에서 발생. 개발자가 아무리 코드를 잘 짜도 외부 환경에 의해 터질 수 있음. 자바가 강제 처리함.
   - ex) IOException (입출력 예외), FileNotFoundException (파일 찾을 수 없음), SQLException (데이터베이스 작업 오류)

2. **미확인 예외(Unchecked Exception)**
   - def. **컴파일러**가 **예외 처리 여부 검사하지 않는** 예외.
   - 예외 처리 안 해도 컴파일 정상 진행. 실행 중 조건 안 맞으면 프로그램 터짐.
   - 개발자의 논리적 오류, 코드 작성 실수로 발생, RuntimeException 클래스와 하위 클래스
   - if문 조건 검사, 코드 수정하여 예외 발생 방지
   - ex) NullPointerException (null 객체 참조), ArrayIndexOutOfBoundsException (배열 인덱스 범위 초과), ArithmeticException (0으로 나누기), IllegalArgumentException (잘못된 인자 전달)


# 예외 처리하기

```
try {
   // 예외가 발생할 수 있는 코드
} catch (예외_클래스 변수) {
   // 해당 예외가 발생했을 때 수행할 동작
) finally {
   // 예외와 상관없이 항상 수행할 동작
}
```

**예시 코드**

```
import java.util.Scanner;

public class TryCatchExample {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.print("첫 번째 정수를 입력하세요.--> ");
      int a = scan.nextInt();
      System.out.print("두 번째 정수를 입력하세요.--> ");
      int b - scan.nextInt();
      try {
         int result = a / b;
         System.out.println("결과: " + result);
      } catch (ArithmeticExeption e) {
         System.out.println(e);
      } finally {
         System.out.println("프로그램을 종료합니다.");
      }
   }
}
```

### throw로 예외 발생시키기

코드에 의도적으로 예외 발생시킬 수 있다. throw 키워드는 RuntimeException 예외 처리할 때 사용함.

```
throw new 예외_클래스([예외_메세지]);
```

**예시 코드**
```
import java.util.Scanner;

public class TryCatchExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("첫 번째 정수를 입력하세요.-->");
        int a = scan.nextInt();
        System.out.print("두 번째 정수를 입력하세요.-->");
        int b = scan.nextInt();
        try {
            if (b == 3) {
                throw new ArithmeticException("3으로 나눌 수 없습니다.");
            }
            int result = a / b;
            System.out.println("결과: " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("프로그램을 종료합니다.");
        }
    }
}

```















