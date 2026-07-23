package WoodyAPP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Login {

    public static String masterPassword;
    
    Password password = new Password();

    public boolean appLogin(String mPass) {
        readMasterPass();
        return masterPassword.equals(mPass);
    }

    public String changeMasterPassword(String masterPassword, String newPass, String confirmPass) {

        if (Login.masterPassword == null) {
            return "No Master Password Set";
        }

        if (Login.masterPassword.equals(masterPassword)) {
            if (newPass.equals(confirmPass)) {
                Login.masterPassword = newPass;
                writeToFile(newPass);
                return "Password Changed Successfully";
            }
            return "New Pass & ConfirmPass Should Be Same";
        }
        return "Wrong Master Password";
    }

    public void readMasterPass() {

        try (Scanner scanner = new Scanner(new File("MasterPass.txt"))) {
            
            if (scanner.hasNextLine()) {
                String mPass = scanner.nextLine();
                masterPassword = password.decryptedText(mPass, 3);
            }
        } catch (Exception e) {
            System.out.println("Error: IDK");
            masterPassword = "1";
        }
    }

    public void writeToFile(String masterPassword) {
        try (FileWriter writer = new FileWriter("MasterPass.txt")) {
            
            masterPassword = password.encryptedText(masterPassword, 3);
            writer.write(masterPassword);
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }

}