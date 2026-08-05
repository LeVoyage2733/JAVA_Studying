package C_OOP;

public class ClassStatic {
    // 클래스 변수
    static int countOfCars = 0;
    // 인스턴스 변수
    String brand; // 브랜드
    int year; // 연식
    String color; // 색

    // 기본 생성자
    public ClassStatic() {
        System.out.println("새로운 자동차 객체가 생성됐습니다.");
        this.CarInfo();
        countOfCars++; // 객체가 생성될 때마다 자동차 수 1 증가
        countOfCarsInfo(); // 자동차 수량 확인 메서드 호출
    }

    // 매개변수 3개 생성자
    public ClassStatic(String brand, int year, String color) {
        System.out.println("새로운 자동차 객체가 생성됐습니다.");
        this.brand = brand;
        this.year = year;
        this.color = color;
        countOfCars++;
        countOfCarsInfo();
    }

    // 클래스 메서드
    public static void countOfCarsInfo() {
        System.out.println("자동차 수량: " + countOfCars);
    }
    // 인스턴스 메서드
    public void CarInfo() {
        System.out.println(" --- 자동차 정보 --- ");
        System.out.println("브랜드: " + brand);
        System.out.println("연식: " + year);
        System.out.println("색: " + color);
    }

    // 클래스 메서드
    public static void main(String[] args) {
        System.out.println("자동차 수량: " + countOfCars);
        ClassStatic car1 = new ClassStatic("현대", 3, "white");
        ClassStatic car2 = new ClassStatic("벤츠", 2, "black");
        car1.CarInfo();
        car2.CarInfo();
        ClassStatic.countOfCarsInfo();
    }
}