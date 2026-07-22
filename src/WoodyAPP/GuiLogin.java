package WoodyAPP;

import java.awt.*;
import javax.swing.*;

class GuiLogin {

    protected Color mainCanvas   = new Color(0x0F172A);
    protected Color containers   = new Color(0x1E293B);
    protected Color inputField   = new Color(0x0B1120);
    protected Color borderSubtle = new Color(0x334155);
    protected Color primaryText  = new Color(0xF8FAFC);
    protected Color mutedText    = new Color(0x94A3B8);
    protected Color buttonAccent = new Color(0x0572EC);
    protected Color brandHighlight = new Color(0x38BDF8);
    protected Color destructive  = new Color(0xF87171);
    
    public GuiLogin() {

        JFrame frame = new JFrame("Woody Vault");

        frame.getContentPane().setBackground(mainCanvas);
        frame.setSize(1920, 1000);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel appName = new JLabel("Woody Vault");
        appName.setBounds(900, 250, 500, 60);
        appName.setFont(new Font("Segoe UI", Font.BOLD, 45));
        appName.setForeground(primaryText);
        frame.add(appName);

        JLabel passWord = new JLabel("Master Password");
        passWord.setForeground(primaryText);
        passWord.setFont(new Font("Segoe UI", Font.BOLD, 25));
        passWord.setBounds(250, 400, 500, 35);
        frame.add(passWord);
                                                                                                                
        JTextField passField = new JTextField();
        passField.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        passField.setForeground(primaryText);
        passField.setBackground(inputField);
        passField.setCaretColor(mutedText);
        passField.putClientProperty("caretWidth", 6);
        passField.setBounds(600, 400, 1000, 45);
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