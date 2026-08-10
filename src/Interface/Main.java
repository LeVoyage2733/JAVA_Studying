package Interface;

public class Main {
    public static void main(String[] args) {
        CheckingAccount myChecking = new CheckingAccount("123-4567890", 100000, 0.02);
        myChecking.displayAccountInfo();
    }
}
