// import java.util.Scanner;

// public class WoodyVault extends Object{
//     public static void main(String[] args) {

//         Login login = new Login();
//         Scanner input = new Scanner(System.in);
//         String pass = input.next();

//         input.nextLine();

//         if (!(login.appLogin(pass))) {
//             System.exit(0);
//         }
//         System.out.println("Login SuccessFull");
        
//         Credentials credentials = new Credentials();
//         credentials.addCredentials("google.com", "ROOTx", "1234");

//         credentials.getAllCredentials();

//         Password password = new Password();
//         System.out.println(password.passGenerate());

//         while (true) {
//             pass = input.next();
//             input.nextLine();
//             System.out.println(password.passStrengthAnalyzer(pass));
//         }
//     }
// }