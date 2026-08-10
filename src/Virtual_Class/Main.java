package Virtual_Class;

public class Main {
    public static void main(String[] args) {
        // 입출금 계좌 객체 생성
        CheckingAccount myChecking = new CheckingAccount("123-4567890", 1000000);
        myChecking.displayAccountInfo();
        myChecking.withdraw(10000);
        myChecking.deposit(15000);
    }
}
