package DefiningClassesLab;

public class BankAccount {

    private static int id;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount (){
        BankAccount.id++;
    }

    public int getId () {
        return id;
    }

    public static void setInterestRate (double interestRate){
        BankAccount.interestRate = interestRate;
    }
    public double getInterest (int years) {
        return balance * years * interestRate;
    }
    public void deposit (double amount) {
        balance += amount;
    }
}
