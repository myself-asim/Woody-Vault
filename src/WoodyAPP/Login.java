package WoodyAPP;

class Login {

    private String masterPassword = "1";

    public boolean appLogin(String mPass) {
        return masterPassword.equals(mPass);
    }

    public String changeMasterPassword(String masterPassword, String newPass, String confirmPass) {

        if (this.masterPassword.equals(masterPassword)) {
            if (newPass.equals(confirmPass)) {
                this.masterPassword = newPass;
                return "Password Changed Successfully";
            }
            return "New Pass & ConfirmPass Should Be Same";
        }
        return "Wrong Master Password";
    }
}