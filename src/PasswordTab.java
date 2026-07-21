import java.awt.*;
import javax.swing.*;

public class PasswordTab extends JPanel {

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

        JButton passGen = new JButton("Generate Password");
        passGen.setBackground(buttonAccent);
        passGen.setForeground(primaryText);
        passGen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        passGen.setBounds(940, 230, 200, 45);

        JTextField generatedPass = new JTextField();
        generatedPass.setEditable(false);
        generatedPass.setForeground(primaryText);
        generatedPass.setBackground(inputField);
        generatedPass.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        generatedPass.setBounds(700, 230, 230, 45);

        add(generatedPass);

        passGen.addActionListener((actionEvent) -> {
            Password generatingPass = new Password();

            generatedPass.setText(generatingPass.passGenerate());
            revalidate();
            repaint();

            add(generatedPass);
        });
        add(passGen);

        JTextField inputAnalyzePass = new JTextField();
        inputAnalyzePass.setForeground(primaryText);
        inputAnalyzePass.setBackground(inputField);
        inputAnalyzePass.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        inputAnalyzePass.setBounds(630, 300, 300, 45);

        add(inputAnalyzePass);

        JButton analyzePass = new JButton("Analyze Password");
        analyzePass.setBackground(buttonAccent);
        analyzePass.setForeground(primaryText);
        analyzePass.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        analyzePass.setBounds(940, 300, 200, 45);

        JTextField strengthLabel = new JTextField();
        strengthLabel.setForeground(primaryText);
        strengthLabel.setBackground(new Color(0x3B82F6));
        strengthLabel.setEditable(false);
        strengthLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        strengthLabel.setBounds(415, 300, 200, 45);

        add(strengthLabel);

        analyzePass.addActionListener(e -> {
            Password generatingPass = new Password();

            strengthLabel.setText("   " + generatingPass.passStrengthAnalyzer(inputAnalyzePass.getText()));
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

        changePass.addActionListener(e -> {

            String result = login.changeMasterPassword(masterPassField.getText(), currentPassField.getText(), confirmPassField.getText());

        if (result.equalsIgnoreCase("Password Changed Successfully")) {
            masterPassField.setText("");
            currentPassField.setText("");
            confirmPassField.setText("");
        }
            revalidate();
            repaint();
        });
    }
}