package Virtual_Class;

public abstract class BankAccount {
    String accountNumber;
    double balance;
    // 생성자
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    // 추사 메서드(입출금 메서드)
    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);
    // 계좌 정보 출력 메서드
    public void displayAccountInfo() {
        System.out.println("계좌 번호: " + accountNumber);
        System.out.println("잔액: " + balance + "원");
    }
}
