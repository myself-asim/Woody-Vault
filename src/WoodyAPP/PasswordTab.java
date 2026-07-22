package WoodyAPP;

import java.awt.*;
import javax.swing.*;

class PasswordTab extends JPanel {

    protected Color mainCanvas   = new Color(0x0F172A);
    protected Color containers   = new Color(0x1E293B);
    protected Color inputField   = new Color(0x0B1120);
    protected Color borderSubtle = new Color(0x334155);
    protected Color primaryText  = new Color(0xF8FAFC);
    protected Color mutedText    = new Color(0x94A3B8);
    protected Color buttonAccent = new Color(0x0572EC);
    protected Color brandHighlight = new Color(0x38BDF8);
    protected Color destructive  = new Color(0xF87171);

    protected Login login = new Login();

    public PasswordTab() {

        setLayout(null);
        setBackground(mainCanvas);

        JLabel genPass = new JLabel("                                   Password Generator");
        genPass.setForeground(primaryText);
        genPass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        genPass.setBounds(1280, 450, 620, 40);

        add(genPass);

        JTextField generatedPass = new JTextField();
        generatedPass.setEditable(false);
        generatedPass.setForeground(primaryText);
        generatedPass.setBackground(inputField);
        generatedPass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        generatedPass.setBounds(1280, 500, 620, 40);

        add(generatedPass);

        JButton passGen = new JButton("     Generate Password");
        passGen.setBackground(buttonAccent);
        passGen.setForeground(primaryText);
        passGen.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        passGen.setBounds(1280, 550, 620, 40);

        add(passGen);


        passGen.addActionListener((actionEvent) -> {
            Password generatingPass = new Password();

            generatedPass.setText(generatingPass.passGenerate());
            revalidate();
            repaint();

            add(generatedPass);
        });
        add(passGen);

        JLabel strengthCheckerLabel = new JLabel("                              Password Strength Analyzer");
        strengthCheckerLabel.setForeground(primaryText);
        strengthCheckerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        strengthCheckerLabel.setBounds(1280, 600, 620, 40);

        add(strengthCheckerLabel);

        JTextField inputAnalyzePass = new JTextField();
        inputAnalyzePass.setForeground(primaryText);
        inputAnalyzePass.setBackground(inputField);
        inputAnalyzePass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        inputAnalyzePass.setBounds(1280, 650, 620, 40);

        add(inputAnalyzePass);

        JButton analyzePass = new JButton("Analyze Password Strength");
        analyzePass.setBackground(buttonAccent);
        analyzePass.setForeground(primaryText);
        analyzePass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        analyzePass.setBounds(1280, 700, 620, 40);

        JLabel strengthLabel = new JLabel("");
        strengthLabel.setForeground(primaryText);
        strengthLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        strengthLabel.setBounds(1280, 750, 620, 40);

        add(strengthLabel);

        analyzePass.addActionListener(e -> {
            Password generatingPass = new Password();

            strengthLabel.setText("                                     " + generatingPass.passStrengthAnalyzer(inputAnalyzePass.getText()));
            revalidate();
            repaint();
        });

        add(analyzePass);

        JTextArea changePassNote = new JTextArea(10, 30);

        changePassNote.setBackground(mainCanvas);
        changePassNote.setOpaque(true);
        changePassNote.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        changePassNote.setForeground(primaryText);
        changePassNote.setBounds(1280, 35, 620, 100);

        changePassNote.setLineWrap(true);
        changePassNote.setWrapStyleWord(true);

        changePassNote.setText("Note:\nEnter your current master password.\nEnter your new master password.\nConfirm the new master password.\nThe new password and confirmation must match.");
        add(changePassNote);

        JLabel masterPass = new JLabel("                                  Change Master Password");
        masterPass.setBackground(mainCanvas);
        masterPass.setOpaque(true);
        masterPass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        masterPass.setForeground(primaryText);
        masterPass.setBounds(1280, 150, 620, 40);
        add(masterPass);

        JTextField currentPassField = new JTextField();
        currentPassField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        currentPassField.setForeground(primaryText);
        currentPassField.setBackground(inputField);
        currentPassField.setBounds(1280, 200, 620, 40);
        add(currentPassField);

        JTextField masterPassField = new JTextField();
        masterPassField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        masterPassField.setForeground(primaryText);
        masterPassField.setBackground(inputField);
        masterPassField.setBounds(1280, 250, 620, 40);
        add(masterPassField);

        JTextField confirmPassField = new JTextField();
        confirmPassField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        confirmPassField.setForeground(primaryText);
        confirmPassField.setBackground(inputField);
        confirmPassField.setBounds(1280, 300, 620, 40);
        add(confirmPassField);

        JButton changePass = new JButton("Change Password");
        changePass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        changePass.setForeground(primaryText);
        changePass.setBackground(buttonAccent);
        changePass.setBounds(1280, 350, 620, 40);
        add(changePass);

        JLabel passSuccess = new JLabel("");
        passSuccess.setBackground(mainCanvas);
        passSuccess.setOpaque(true);
        passSuccess.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        passSuccess.setForeground(primaryText);
        passSuccess.setBounds(1280, 400, 620, 40);
        add(passSuccess);

        changePass.addActionListener(e -> {

            String result = login.changeMasterPassword(masterPassField.getText(), currentPassField.getText(), confirmPassField.getText());

        if (result.equalsIgnoreCase("Password Changed Successfully")) {

            passSuccess.setText("                       Password Changed Successfully");
            masterPassField.setText("");
            currentPassField.setText("");
            confirmPassField.setText("");
        }
            revalidate();
            repaint();
        });

        JTextArea textArea = new JTextArea(100, 200);
        textArea.setForeground(primaryText);
        textArea.setBackground(inputField);
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        textArea.setBounds(10, 30, 1200, 300);

        textArea.setOpaque(true);

        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setText("\nPassword Strength Guide\n\n" +
    "Modern password managers such as Bitwarden and 1Password evaluate passwords " +
    "based on their length, the use of uppercase and lowercase letters, numbers, " +
    "special characters, and overall randomness. Based on these factors, they estimate " +
    "how resistant a password is to cracking.\n\n" +
    "Weak passwords can often be cracked instantly or within seconds, while longer " +
    "and more complex passwords may take years, millions of years, or even billions " +
    "of years to crack using current computing technology. These estimates help users " +
    "understand the importance of creating strong, unique passwords for every account.\n\n" +
    "WoodyVault analyzes password strength using similar factors and classifies passwords " +
    "into different strength levels to encourage better password security.");

        add(textArea);
    }
}