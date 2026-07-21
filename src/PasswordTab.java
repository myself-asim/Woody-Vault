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
    }
}