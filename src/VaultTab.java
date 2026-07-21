import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class VaultTab extends JPanel {

    protected Color mutedText = new Color(0x718096);
    protected Color containers = new Color(0x222630);
    protected Color mainCanvas = new Color(0x1A1D24);
    protected Color inputField = new Color(0x14161C);
    protected Color destructive = new Color(0xEF4444);
    protected Color primaryText = new Color(0xE2E8F0);
    protected Color buttonAccent = new Color(0x6366F1);

    protected Credentials credentials = new Credentials();
    protected Login login = new Login();

    public VaultTab() {

        setLayout(null);
        setBackground(mainCanvas);

        JButton search = new JButton("Search");
        search.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        search.setForeground(primaryText);
        search.setBackground(buttonAccent);
        search.setBounds(520, 35, 100, 40);

        add(search);

        JTextField searchField = new JTextField();
        searchField.setFont(new Font("Segoe UI", Font.BOLD, 20));
        searchField.setForeground(primaryText);
        searchField.setBackground(inputField);
        searchField.setBounds(15, 35, 500, 40);

        add(searchField);

        String[] columns = {"Username", "Password", "Platform"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        search.addActionListener(e -> {
            String field = searchField.getText();

            if (field.equalsIgnoreCase("all")) {
                credentials.loadVault();

                model.setRowCount(0);

                for (int i = 0; i < credentials.vault.size(); i += 3) {

                    model.addRow(new Object[]{
                        credentials.vault.get(i),
                        credentials.vault.get(i + 1),
                        credentials.vault.get(i + 2)
                    });
                }
            }
        });

        JTable table = new JTable(model);
        table.setBackground(mainCanvas);
        table.setForeground(primaryText);
        table.setSelectionBackground(mutedText);
        table.setSelectionForeground(primaryText);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(15, 90, 1200, 700);
        scrollPane.setForeground(primaryText);
        add(scrollPane);

        JTextField userNameField = new JTextField();
        userNameField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        userNameField.setForeground(primaryText);
        userNameField.setBackground(inputField);
        userNameField.setBounds(1400, 35, 500, 40);
        add(userNameField);

        JTextField passwordField = new JTextField();
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        passwordField.setForeground(primaryText);
        passwordField.setBackground(inputField);
        passwordField.setBounds(1400, 80, 500, 40);
        add(passwordField);

        JTextField siteField = new JTextField();
        siteField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        siteField.setForeground(primaryText);
        siteField.setBackground(inputField);
        siteField.setBounds(1400, 125, 500, 40);
        add(siteField);

        JLabel userNameLabel = new JLabel("Username");
        userNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        userNameLabel.setForeground(primaryText);
        userNameLabel.setBackground(inputField);
        userNameLabel.setBounds(1280, 35, 500, 40);
        add(userNameLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        passwordLabel.setForeground(primaryText);
        passwordLabel.setBackground(inputField);
        passwordLabel.setBounds(1280, 80, 500, 40);
        add(passwordLabel);

        JLabel siteLabel = new JLabel("Platform");
        siteLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        siteLabel.setForeground(primaryText);
        siteLabel.setBackground(inputField);
        siteLabel.setBounds(1280, 125, 500, 40);
        add(siteLabel);

        JButton enterCredentials = new JButton("ADD Credentials");
        enterCredentials.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        enterCredentials.setForeground(primaryText);
        enterCredentials.setBackground(buttonAccent);
        enterCredentials.setBounds(1280, 180, 620, 40);
        add(enterCredentials);

        JLabel enterCredOut = new JLabel("");
        enterCredOut.setBackground(mainCanvas);
        enterCredOut.setOpaque(true);
        enterCredOut.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        enterCredOut.setForeground(primaryText);
        enterCredOut.setBounds(1280, 230, 620, 40);
        add(enterCredOut);

        enterCredentials.addActionListener(e -> {
            String result = credentials.addCredentials(userNameField.getText(), passwordField.getText(), siteField.getText());

            if (result.equalsIgnoreCase("   Fill All Fields")) {
            enterCredOut.setBackground(destructive);
            } else {
                enterCredOut.setBackground(mutedText);
            }
            enterCredOut.setText(result);
        
        });

        JLabel masterPass = new JLabel("                                  Change Master Password");
        masterPass.setBackground(mainCanvas);
        masterPass.setOpaque(true);
        masterPass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        masterPass.setForeground(primaryText);
        masterPass.setBounds(1280, 300, 620, 40);
        add(masterPass);

        JTextField masterPassField = new JTextField();
        masterPassField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        masterPassField.setForeground(primaryText);
        masterPassField.setBackground(inputField);
        masterPassField.setBounds(1280, 350, 620, 40);
        add(masterPassField);

        JButton changePass = new JButton("Change Password");
        changePass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        changePass.setForeground(primaryText);
        changePass.setBackground(buttonAccent);
        changePass.setBounds(1280, 400, 620, 40);
        add(changePass);

        changePass.addActionListener(e -> {

            // if (login.changeMasterPassword(masterPassField.getText())) {
            // enterCredOut.setBackground(mutedText);
            // masterPass
            // } else {
            //     enterCredOut.setBackground(destructive);
            //     enterCredOut.setText("Wrong Password");
            // }
            revalidate();
            repaint();
        });
    }
}