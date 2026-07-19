import java.util.Random;

public class Password {

    private final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String lower = "abcdefghijklmnopqrstuvwxyz";
    private final String symbols = "~!@#$%^&*()_+{}|:<>?";
    private final String nums  = "1234567890";

    public String passGenerate() {

        Random rand = new Random();
        String pass = "";

        for (int i=0; i<5; i++) {
            pass += upper.charAt(rand.nextInt(26));
            pass += lower.charAt(rand.nextInt(26));
            pass += nums.charAt(rand.nextInt(10));
            pass += symbols.charAt(rand.nextInt(20));
        }

        return pass;
    }

    public String passStrengthAnalyzer(String pass) {

        int score = 0;

        if (pass.isEmpty()) {
            return "Enter Password";
        }

        if (pass.length() >= 8) score++;
        if (pass.length() >= 12) score++;
        if (pass.matches(".*[A-Z].*")) score++;
        if (pass.matches(".*[a-z].*")) score++;
        if (pass.matches(".*\\d.*")) score++;
        if (pass.matches(".*[^a-zA-Z0-9].*")) score++;
        
        if (score <= 2) {
            return "Weak";         // Scores 0, 1, 2
        } else if (score == 3) {
            return "Medium";       // Score 3
        } else if (score == 4) {
            return "Strong";       // Score 4
        } else if (score == 5) {
            return "Very Strong";  // Score 5
        } else {
            return "Insanely Strong"; // Score 6
        }
    }
}