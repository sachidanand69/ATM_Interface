import java.util.Scanner;

import javax.security.auth.login.AccountException;

public class Account {
    Scanner scanner = new Scanner(System.in);
    User user;

    public boolean start(User accounte) {
        System.out.println("-----------------------------------");
        System.out.println("Choose the Option");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Cash");
        System.out.println("3. Withdraw Cash");
        System.out.println("4. Exit ATM");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                System.out.println("-----------------------------------");
                System.out.println("Your Current Balance is : " + checkBalance(accounte));
                return true;
            }
            case 2: {
                System.out.println("-----------------------------------");
                System.out.println("Enter the amount you want to deposit");
                double amount = scanner.nextDouble();
                double amount1 = depositCash(amount, accounte);
                System.out.println("Your amount " + amount + " is deposited successfuly");
                System.out.println("Now your Current Balance is " + amount1);
                return true;
            }
            case 3: {
                System.out.println("-----------------------------------");
                System.out.println("Enter the amount you want to withdraw");
                double amount = scanner.nextDouble();
                if (accounte.getAmount() >= amount) {
                    double amount1 = withdrawCash(amount, accounte);
                    System.out.println("Your amount " + amount + " is debited successfuly");
                    System.out.println("Now your Current Balance is " + amount1);
                } else {
                    System.out.println("Insufficient Balance!");
                }

                return true;
            }
            case 4: {
                System.out.println("-----------------------------------");
                System.out.println("Exit Atm Successfully");
                return false;
            }
            default: {
                System.out.println("Invalid choice. Please choose again.");
                return true;
            }

        }
    }

    public User createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create a Account");
        System.out.println("Enter First Name");
        String FirstName = scanner.next();

        System.out.println("-----------------------------------");
        System.out.println("Enter Last Name");
        String LastName = scanner.next();

        System.out.println("-----------------------------------");
        System.out.println("Enter Age");
        int age = scanner.nextInt();

        System.out.println("-----------------------------------");
        System.out.println("Enter Address");
        String address = scanner.next();

        System.out.println("-----------------------------------");
        System.out.println("Enter Email Id");
        String email = scanner.next();

        System.out.println("-----------------------------------");
        System.out.println("Enter Gender");
        String gender = scanner.next();

        System.out.println("-----------------------------------");
        System.out.println("Enter the Account No");
        long account = scanner.nextLong();

        System.out.println("-----------------------------------");
        System.out.println("Enter the Amount");
        double amount = scanner.nextDouble();

        boolean checkpin = true;
        int pin = 0;
        while (checkpin) {
            System.out.println("Enter the four digit Pin");
            pin = scanner.nextInt();
            int count = 0;
            for (int i = pin; i > 0; i = i / 10) {
                count++;
            }
            if (count == 4) {
                break;
            } else {
                System.out.println("This pin " + pin + " not a four digit !");
                System.out.println("Please enter four digit pin !");
            }
        }

        if (FirstName == null || LastName == null || gender == null || account == 0.0
                || address == null || email == null) {
            System.out.println("Account is not created");
        } else {
            user = new User(FirstName, LastName, age, address, email, gender, account, pin, amount);
            System.out.println("Your Account is created");
        }
        return user;
    }

    public boolean loginAccount(User user) {
        System.out.println("-----------------------------------");
        System.out.println("Please Enter your Login Credential !");
        System.out.println("Enter your account no");
        long account = scanner.nextLong();
        System.out.println("-----------------------------------");
        System.out.println("Enter your pin");
        int pin = scanner.nextInt();
        User account2 = user;
        if (account == account2.getAccountNo() && pin == account2.getPin()) {
            boolean exit = true;
            while (exit) {
                exit = start(account2);
                System.out.println("-----------------------------------");
                System.out.println("Do you want to do operations again");
                System.out.println("Type Yes or No");
                String suggest1 = scanner.next();
                if (suggest1.equalsIgnoreCase("Yes")) {
                    exit = true;
                } else {
                    System.out.println("-----------------------------------");
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = false;
                }
            }
           return false;
        } else if (account != account2.getAccountNo()) {
            System.out.println("Invalid Account No !");
        } else if (pin != account2.getPin()) {
            System.out.println("Invalid Pin !");
        }
        return true;
    }


    public double checkBalance(User accounte) {
        User account = accounte;
        return account.getAmount();
    }

    public double depositCash(double amount, User accounte) {
        User account = accounte;
        account.setAmount(amount + account.getAmount());
        return account.getAmount();
    }

    public double withdrawCash(double amount, User accounte) {
        User account = accounte;
        if (amount <= account.getAmount()) {
            account.setAmount(account.getAmount() - amount);
            return account.getAmount();
        } else {
            return account.getAmount();
        }
    }

}
