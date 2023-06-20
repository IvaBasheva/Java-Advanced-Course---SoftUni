package DefiningClassesLab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String input = scanner.nextLine();
        Map <Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!input.equals("End")) {
            String [] data = input.split("\\s+");
            String command =  data[0];

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.put(bankAccount.getId(), bankAccount);
                    System.out.println("Account ID" + bankAccount.getId() + " created");
                    break;

                case "Deposit":
                    int id = Integer.parseInt(data[1]);
                    double amount =  Double.parseDouble(data[2]);

                    BankAccount currentAccount = bankAccounts.get(id);
                    if (currentAccount == null) {
                        System.out.println("Account does not exist");
                    } else {
                        currentAccount.deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    }
                    break;

                case "SetInterest":
                    double setInterestRate = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(setInterestRate);
                    break;

                case "GetInterest":
                    int searchingId = Integer.parseInt(data[1]);
                    int years = Integer.parseInt(data[2]);
                    BankAccount searchingAccount = bankAccounts.get(searchingId);
                    if (searchingAccount == null) {
                        System.out.println("Account does not exist");
                    } else {
                        double gettingInterest =  searchingAccount.getInterest(years);
                        System.out.printf("%.2f%n", gettingInterest);

                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
