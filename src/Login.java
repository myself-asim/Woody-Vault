public class Login {

    private String masterPassword = "1";

    public boolean appLogin(String mPass) {
        return masterPassword.equals(mPass);
    }

    public boolean  changeMasterPassword(String masterPassword) {

        if (this.masterPassword.equals(masterPassword)) {
            this.masterPassword = masterPassword;
            return true;
        }
        return false;
    }
}