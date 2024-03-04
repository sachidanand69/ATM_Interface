import java.util.Scanner;

public class App {
    static User user;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you have a Account !");
        System.out.println("Type Yes or NO");
        String suggest = scanner.next();
        while (true) {
            if (suggest.equalsIgnoreCase("Yes")) {
                Account account=new Account();
                boolean exitUser=true;
                while (exitUser) {
                    exitUser=account.loginAccount(user);
                }                 
                break;
            } else {
                Account account=new Account();
                user=account.createAccount();
                suggest="Yes";
            }
        }

    }
}
