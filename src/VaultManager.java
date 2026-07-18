import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VaultManager extends Credentials{

    private FileWriter writer;

    public VaultManager() throws Exception {
        FileWriter writer = new FileWriter("Vault.md", true);
    }

    public void writeToFile(String userName, String passWord, String site) {
    
        try {
            writer.write(userName);
            writer.write(passWord);
            writer.write(site);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void loadVault() throws Exception {

        Scanner scanner = new Scanner(new File("Vault.md"));

        try {
            while (scanner.hasNextLine()) {

            String name = scanner.nextLine();
            userName.add(name);

            String pass = scanner.nextLine();
            passWord.add(pass);

            String _site = scanner.nextLine();
            site.add(_site);

            if (!scanner.hasNextLine()) break;
        }

        scanner.close();
            
        } catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
        }
    }
}