package WoodyAPP;

import java.util.Random;

interface PasswordUtils {
    String passGenerate();
    String passStrengthAnalyzer(String pass);
    String tip();
}

class Password implements PasswordUtils{

        String[] securityTips = {
        "Use a unique password for every account.",
        "Avoid using personal information in passwords.",
        "Use at least 12 characters for strong passwords.",
        "Combine uppercase, lowercase, numbers, and symbols.",
        "Never reuse the same password across websites.",
        "Change important passwords periodically.",
        "Do not share your passwords with anyone.",
        "Avoid common passwords like '123456' or 'password'.",
        "Store your passwords in a trusted password manager.",
        "Enable two-factor authentication whenever available.",
        "Do not save passwords on public computers.",
        "Always log out after using shared devices.",
        "Be cautious of phishing emails asking for passwords.",
        "Verify website URLs before entering your credentials.",
        "Do not click suspicious links from unknown sources.",
        "Update weak passwords as soon as possible.",
        "Longer passwords are generally more secure.",
        "Avoid using the same password for work and personal accounts.",
        "Keep your operating system and browser updated.",
        "Never send passwords through email or messaging apps.",
        "Lock your computer when leaving it unattended.",
        "Use randomly generated passwords for sensitive accounts.",
        "Review your saved credentials regularly.",
        "Delete credentials you no longer use.",
        "Never write passwords where others can easily find them.",
        "A password manager helps organize multiple credentials.",
        "Strong passwords reduce the risk of unauthorized access.",
        "Avoid predictable patterns like 'qwerty' or 'abc123'.",
        "Think twice before entering passwords on unknown websites.",
        "Security starts with good password habits."
    };

    Random rand = new Random();

    private final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String lower = "abcdefghijklmnopqrstuvwxyz";
    private final String symbols = "~!@#$%^&*()_+{}|:<>?";
    private final String nums  = "1234567890";

    @Override
    public String passGenerate() {
        String pass = "";

        for (int i=0; i<6; i++) {
            pass += upper.charAt(rand.nextInt(26));
            pass += lower.charAt(rand.nextInt(26));
            pass += nums.charAt(rand.nextInt(10));
            pass += symbols.charAt(rand.nextInt(20));
        }

        return pass;
    }

    @Override
    public String passStrengthAnalyzer(String pass) {

        int score = 0;

        if (pass.isEmpty()) {
            return "Enter Password";
        }

        if (pass.length() >= 8) score++;
        if (pass.length() >= 12) score++;
        if (pass.length() >= 16) score++;
        if (pass.matches(".*[A-Z].*")) score++;
        if (pass.matches(".*[a-z].*")) score++;
        if (pass.matches(".*\\d.*")) score++;
        if (pass.matches(".*[^a-zA-Z0-9].*")) score++;

        if (score <= 1) {
            return "Very Weak";
        } else if (score == 2) {
            return "Weak";
        } else if (score == 3) {
            return "Fair";
        } else if (score == 4) {
            return "Strong";
        } else if (score >= 5 && score <= 7 ) {
            return "Very Strong";
        } else {
            return "Insanely Strong";
        }
    }

    @Override
    public String tip() {
        return securityTips[rand.nextInt(securityTips.length)];
    }

    public static String shiftedText(String message, int key) {

        String encrypted = "";

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) ('A' + (ch - 'A' + key) % 26);
            }
            else if (ch >= 'a' && ch <= 'z') {
                ch = (char) ('a' + (ch - 'a' + key) % 26);
            }
            
            encrypted += ch;
        }

        return encrypted;
    }
}