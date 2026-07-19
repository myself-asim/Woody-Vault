import java.awt.*;
import javax.swing.*;

public class VaultTab extends JPanel {

    protected Color mutedText = new Color(0x718096);
    protected Color containers = new Color(0x222630);
    protected Color mainCanvas = new Color(0x1A1D24);
    protected Color inputField = new Color(0x14161C);
    protected Color destructive = new Color(0xEF4444);
    protected Color primaryText = new Color(0xE2E8F0);
    protected Color buttonAccent = new Color(0x6366F1);

    public VaultTab() {
        setLayout(null);
        setBackground(mainCanvas);

        // JButton addCredential = new JButton("Add Credential");
        // addCredential.setBounds(20, 70, 170, 35);
        // add(addCredential);

        JButton search = new JButton("Search");
        search.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        search.setForeground(primaryText);
        search.setBackground(buttonAccent);
        search.setBounds(520, 35, 100, 25);

        add(search);

        JTextField searchField = new JTextField();
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        searchField.setForeground(primaryText);
        searchField.setBackground(inputField);
        searchField.setBounds(15, 35, 500, 25);

        add(searchField);

        searchField.addActionListener((e) -> {
            String field = searchField.getText();
            Credentials credentials = new Credentials();

            // if (field.equalsIgnoreCasnewe("all")) {
            //     credentials.getAllCredentials();
            // } else if (field.equals("-1") {
            //     credentials.findByUserName(field);
            // }
        });
    }
}