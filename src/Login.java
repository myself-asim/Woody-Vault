public class Login {

    private String masterPassword = "1";

    public boolean appLogin(String mPass) {
        return masterPassword.equals(mPass);
    }

    public void changeMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
    }
}