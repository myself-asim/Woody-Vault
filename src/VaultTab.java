import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class VaultTab extends JPanel {

    protected Color mainCanvas   = new Color(0x0F172A);
    protected Color containers   = new Color(0x1E293B);
    protected Color inputField   = new Color(0x0B1120);
    protected Color borderSubtle = new Color(0x334155);
    protected Color primaryText  = new Color(0xF8FAFC);
    protected Color mutedText    = new Color(0x94A3B8);
    protected Color buttonAccent = new Color(0x0572EC);
    protected Color brandHighlight = new Color(0x38BDF8);
    protected Color destructive  = new Color(0xF87171);

    protected Credentials credentials = new Credentials();
    protected Password password = new Password();
    protected Login login = new Login();

    public VaultTab() {

        setLayout(null);
        setBackground(mainCanvas);

        JTextField searchField = new JTextField();
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        searchField.setForeground(primaryText);
        searchField.setBackground(inputField);
        searchField.setBounds(15, 35, 500, 40);

        add(searchField);

        JButton search = new JButton("Search");
        search.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        search.setForeground(primaryText);
        search.setBackground(buttonAccent);
        search.setBounds(520, 35, 100, 40);

        add(search);

        JTextField deleteCred = new JTextField();
        deleteCred.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        deleteCred.setForeground(primaryText);
        deleteCred.setBackground(inputField);
        deleteCred.setBounds(640, 35, 300, 40);

        add(deleteCred);

        JButton deletebtn = new JButton("Delete Cred");
        deletebtn.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        deletebtn.setForeground(primaryText);
        deletebtn.setBackground(buttonAccent);
        deletebtn.setBounds(960, 35, 200, 40);

        add(deletebtn);

        deletebtn.addActionListener(e -> {

            String tempStr = deleteCred.getText();

            if (!(tempStr.isEmpty())) {
                credentials.deleteCredentials(Integer.parseInt(tempStr));
            }
            
        });

        String[] columns = {"S.NO", "Username", "Password", "Platform"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        search.addActionListener(e -> {
            String field = searchField.getText();

            if (field.equalsIgnoreCase("all")) {
                credentials.loadVault();

                model.setRowCount(0);
                
                int num = 1;
                for (int i = 0; i < credentials.vault.size(); i += 3) {

                    model.addRow(new Object[]{
                        num,
                        credentials.vault.get(i),
                        credentials.vault.get(i + 1),
                        credentials.vault.get(i + 2)
                    });
                    num++;
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
                enterCredOut.setText(result);
            } else if (result.equalsIgnoreCase("Dispose")) {
                enterCredOut.setText("");
                enterCredOut.setBackground(mainCanvas);
            } else {
                enterCredOut.setBackground(mutedText);
                enterCredOut.setText(result);
            }
            
        
        });

        JTextArea changePassNote = new JTextArea(10, 30);

        changePassNote.setBackground(mainCanvas);
        changePassNote.setOpaque(true);
        changePassNote.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        changePassNote.setForeground(primaryText);
        changePassNote.setBounds(1280, 280, 620, 100);

        changePassNote.setLineWrap(true);
        changePassNote.setWrapStyleWord(true);

        changePassNote.setText("Note:\nEnter your current master password.\nEnter your new master password.\nConfirm the new master password.\nThe new password and confirmation must match.");
        add(changePassNote);

        JLabel masterPass = new JLabel("                                  Change Master Password");
        masterPass.setBackground(mainCanvas);
        masterPass.setOpaque(true);
        masterPass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        masterPass.setForeground(primaryText);
        masterPass.setBounds(1280, 400, 620, 40);
        add(masterPass);

        JTextField currentPassField = new JTextField();
        currentPassField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        currentPassField.setForeground(primaryText);
        currentPassField.setBackground(inputField);
        currentPassField.setBounds(1280, 450, 620, 40);
        add(currentPassField);

        JTextField masterPassField = new JTextField();
        masterPassField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        masterPassField.setForeground(primaryText);
        masterPassField.setBackground(inputField);
        masterPassField.setBounds(1280, 500, 620, 40);
        add(masterPassField);

        JTextField confirmPassField = new JTextField();
        confirmPassField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        confirmPassField.setForeground(primaryText);
        confirmPassField.setBackground(inputField);
        confirmPassField.setBounds(1280, 550, 620, 40);
        add(confirmPassField);

        JButton changePass = new JButton("Change Password");
        changePass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        changePass.setForeground(primaryText);
        changePass.setBackground(buttonAccent);
        changePass.setBounds(1280, 600, 620, 40);
        add(changePass);

        JLabel tipLabel = new JLabel("TIP:");
        tipLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        tipLabel.setForeground(primaryText);
        tipLabel.setBackground(buttonAccent);
        tipLabel.setBounds(1280, 650, 620, 40);
        add(tipLabel);

        JLabel secTip = new JLabel(password.tip());
        secTip.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        secTip.setForeground(primaryText);
        secTip.setBackground(buttonAccent);
        secTip.setBounds(1280, 680, 620, 40);
        add(secTip);

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