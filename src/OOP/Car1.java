package OOP;

public class Car1 {
    // 클래스 변수
    static int countOfCars = 0;
    // 인스턴스 변수
    String brand; // 브랜드
    int year; // 연식
    String color; // 색

    // 기본 생성자
    public Car1() {
        System.out.println("새로운 자동차 객체가 생성됐습니다.");
        this.CarInfo();
    }

    // 매개변수 3개 생성자
    public Car1(String brand, int year, String color) {
        System.out.println("새로운 자동차 객체가 생성됐습니다.");
        this.brand = brand;
        this.year = year;
        this.color = color;
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
        Car1 car1 = new Car1("현대", 3, "white");
        car1.CarInfo();
    }
}
