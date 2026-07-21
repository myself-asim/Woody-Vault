import java.awt.*;
import javax.swing.*;

public class Dashboard extends JFrame{

    protected Color mainCanvas   = new Color(0x0F172A);
    protected Color containers   = new Color(0x1E293B);
    protected Color inputField   = new Color(0x0B1120);
    protected Color borderSubtle = new Color(0x334155);
    protected Color primaryText  = new Color(0xF8FAFC);
    protected Color mutedText    = new Color(0x94A3B8);
    protected Color buttonAccent = new Color(0x0572EC);
    protected Color brandHighlight = new Color(0x38BDF8);
    protected Color destructive  = new Color(0xF87171);

    public Dashboard() {

        setTitle("Woody Vault - Dashboard");
        setResizable(false);
        setSize(1920, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(mainCanvas);
        setLayout(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.setBackground(buttonAccent);
        tabs.setForeground(mainCanvas);
        tabs.setBounds(0, 50, 1920, 910);

        tabs.addTab("Vault", new VaultTab());
        tabs.addTab("Password", new PasswordTab());

        add(tabs);

        JLabel title = new JLabel("Woody Vault - Dashboard");
        title.setFont(new Font("Segoe UI", Font.BOLD, 25));
        title.setForeground(primaryText);
        title.setBounds(820, 0, 500, 50);

        add(title);

        JButton logout = new JButton("Logout");
        logout.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        logout.setForeground(primaryText);
        logout.setBackground(destructive);
        logout.setBounds(1800, 0, 100, 25);

        add(logout);

        logout.addActionListener(e -> {
            System.exit(0);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}