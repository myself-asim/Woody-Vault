import java.awt.*;
import javax.swing.*;

public class Dashboard extends JFrame{

    protected Color mutedText = new Color(0x718096);
    protected Color containers = new Color(0x222630);
    protected Color mainCanvas = new Color(0x1A1D24);
    protected Color inputField = new Color(0x14161C);
    protected Color destructive = new Color(0xEF4444);
    protected Color primaryText = new Color(0xE2E8F0);
    protected Color buttonAccent = new Color(0x6366F1);

    public Dashboard() {

        JFrame dashboard = new JFrame("Woody Vault - Dashboard");
        dashboard.setTitle("WoodyVault");
        dashboard.setSize(1920, 1000);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.getContentPane().setBackground(mainCanvas);
        dashboard.setLayout(null);
        dashboard.setLocationRelativeTo(null);

        JLabel title = new JLabel("Welcome To Woody Vault");
        title.setFont(new Font("Segoe UI", Font.BOLD, 25));
        title.setForeground(primaryText);
        title.setBounds(820, 0, 500, 50);

        dashboard.add(title);

        JButton logout = new JButton("Logout");
        logout.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        logout.setForeground(primaryText);
        logout.setBackground(destructive);
        logout.setBounds(1800, 0, 100, 25);

        dashboard.add(logout);

        logout.addActionListener(e -> {
            System.exit(0);
        });

        JLabel search = new JLabel("Search");
        search.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        search.setForeground(primaryText);
        search.setBounds(30, 70, 500, 50);

        dashboard.add(search);

        dashboard.setVisible(true);
    }
}