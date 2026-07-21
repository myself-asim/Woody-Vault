import java.awt.*;
import javax.swing.*;

class GuiLogin {

    protected Color mutedText = new Color(0x718096);
    protected Color containers = new Color(0x222630);
    protected Color mainCanvas = new Color(0x1A1D24);
    protected Color inputField = new Color(0x14161C);
    protected Color destructive = new Color(0xEF4444);
    protected Color primaryText = new Color(0xE2E8F0);
    protected Color buttonAccent = new Color(0x6366F1);
    
    public GuiLogin() {

        JFrame frame = new JFrame("Woody Vault");

        frame.getContentPane().setBackground(mainCanvas);
        frame.setSize(1920, 1000);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel appName = new JLabel("Woody Vault");
        appName.setBounds(900, 250, 500, 50);
        appName.setFont(new Font("Segoe UI", Font.BOLD, 35));
        appName.setForeground(primaryText);
        frame.add(appName);

        JLabel passWord = new JLabel("Master Password");
        passWord.setForeground(primaryText);
        passWord.setFont(new Font("Segoe UI", Font.BOLD, 18));
        passWord.setBounds(400, 400, 500, 35);
        frame.add(passWord);                                                      
                                                                                                                                                                                             
        JTextField passField = new JTextField();
        passField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        passField.setForeground(primaryText);
        passField.setBackground(inputField);
        passField.setCaretColor(mutedText);
        passField.putClientProperty("caretWidth", 6);
        passField.setBounds(600, 400, 1000, 35);
        frame.add(passField);

        JButton button = new JButton("Login");
        button.setBounds(930, 500, 150, 50);
        button.setBackground(buttonAccent);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setForeground(primaryText);
        frame.add(button);

        JLabel loginSuccessful = new JLabel("Login Successful");
        loginSuccessful.setBounds(930, 0, 200, 60);
        loginSuccessful.setForeground(primaryText);
        loginSuccessful.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        loginSuccessful.setVisible(false);
        frame.add(loginSuccessful);

        JLabel incPass = new JLabel("Incorrect Password");
        incPass.setBounds(925, 450, 200, 60);
        incPass.setForeground(primaryText);
        incPass.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        incPass.setVisible(false);

        frame.add(incPass);


        button.addActionListener(e -> {
            String passInput = passField.getText();
            Login login = new Login();

            if (login.appLogin(passInput)) {
                incPass.setVisible(false);
                loginSuccessful.setVisible(true);

                Dashboard dashboard = new Dashboard();
                frame.dispose();
            } else {
                loginSuccessful.setVisible(false);
                incPass.setVisible(true);
            }
        });


        frame.setVisible(true);
    }
}