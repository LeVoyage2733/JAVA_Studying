package Virtual_Class;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }
    // 오버라이딩해서 추상 메서드 구현(출금 메서드)
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(amount + "원이 출금됐습니다.");
        }
        else {
            System.out.println("잔액이 부족해 출금할 수 없습니다.");
        }
    }
    // 오버라이딩해서 추상 메서드 구현(입금 메서드)
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "원이 입금되었습니다.");
            System.out.println("잔액: " + balance + "원");
        }
        else {
            System.out.println("입금액이 0보다 커야 합니다.");
        }
    }
}
