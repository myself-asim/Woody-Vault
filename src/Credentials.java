import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Credentials {

    protected  ArrayList<String> vault;

    public Credentials() {
        vault = new ArrayList<>();
    }

    public String addCredentials(String userName, String passWord, String site) {

        if (userName.isEmpty() && passWord.isEmpty() && site.isEmpty()) {
            return  "Dispose";
        }

        if (userName.isEmpty() || passWord.isEmpty() || site.isEmpty()) {
            return  "   Fill All Fields";
        }

        writeToFile(userName, passWord, site);

        this.vault.add(userName);
        this.vault.add(passWord);
        this.vault.add(site);
        return "    Credentials has been Added Successfully";
    }

    // public void getAllCredentials() {
        
    // }

    // public int findByUserName(String userName) {

    //     int index = 0;
    //     for (String name: this.vault) {
    //         if (name.equalsIgnoreCase(userName)) {
    //             return index;
    //         } else {
    //             index++;
    //         }
    //     }
    //     return -1;
    // }

    public void deleteCredentials(int index) {

        // try { Delete From Vault Method Below
        //     ///
        //     }
        // } catch (Exception e) {
        //     System.err.println("Index Out of Range");
        // }
    }

    public void updateCredentials(String userName, String passWord, String site, int index) {
        loadVault();
        
        try {
            this.vault.set(index, userName);
            this.vault.set(index, passWord);
            this.vault.set(index, site);
        } catch (Exception e) {
            System.err.println("Index Out of Range");
        }
    }

    public int credentialsCounter() {
        return (vault.size() / 3);
    }

    // File Handling
    public void writeToFile(String userName, String passWord, String site) {
        try (FileWriter writer = new FileWriter("Vault.txt", true)) {
            writer.write(userName + '\n');
            writer.write(passWord + '\n');
            writer.write(site + '\n');

            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void loadVault() {
    vault.clear();

    try (Scanner scanner = new Scanner(new File("Vault.txt"))) {

        while (scanner.hasNextLine()) {

                String username = scanner.nextLine();
                if (!scanner.hasNextLine()) break;

                String password = scanner.nextLine();
                if (!scanner.hasNextLine()) break;

                String platform = scanner.nextLine();

                vault.add(username);
                vault.add(password);
                vault.add(platform);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void deleteFromVault(int num) {

    loadVault();

    int totalCredentials = vault.size() / 3;

    if (num < 1 || num > totalCredentials) {
        System.out.println("Invalid credential number.");
        return;
    }

    int index = (num - 1) * 3;

    vault.remove(index);
    vault.remove(index);
    vault.remove(index);

    try (FileWriter writer = new FileWriter("Vault.txt")) {

        for (String line : vault) {
            writer.write(line + "\n");
        }

    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}
}