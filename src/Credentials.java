import java.util.ArrayList;

public class Credentials {

    protected  ArrayList<String> userName;
    protected  ArrayList<String> passWord;
    protected  ArrayList<String> site;

    public Credentials() {
        userName = new ArrayList<>();
        passWord = new ArrayList<>();
        site = new ArrayList<>();
    }

    public void addCredentials(String userName, String passWord, String site) {
        this.userName.add(userName);
        this.passWord.add(passWord);
        this.site.add(site);
    }

    public void getAllCredentials() {
        
        for (int i = 0; i < site.size(); i++) {
            System.out.println(userName.get(i));
            System.out.println(passWord.get(i));
            System.out.println(site.get(i));
        }
    }

    public int findByUserName(String userName) {
        int index = 0;
        
        for (String name: this.userName) {
            if (name.equalsIgnoreCase(userName)) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }

    public void deleteCredentials(int index) {

        try {    
            userName.remove(index);
            passWord.remove(index);
            site.remove(index);
        } catch (Exception e) {
            System.err.println("Index Out of Range");
        }
    }

    public void updateCredentials(String userName, String passWord, String site, int index) {
        
        try {
            this.userName.set(index, site);
            this.passWord.set(index, site);
            this.site.set(index, site);
        } catch (Exception e) {
            System.err.println("Index Out of Range");
        }
    }

    public int credentialsCounter() {
        return userName.size();
    }
}