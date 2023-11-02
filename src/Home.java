import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private JPanel home;
    private JButton addButton;
    private JButton updateButton;
    private JButton searchViewButton;
    private JButton logOutButton;

    public Home() {
        JFrame frame = new JFrame("Home");
        frame.setContentPane(home);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800,700);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Add_Delete_employee();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Update_Data();
            }
        });
        searchViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Search();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LogIn();
            }
        });
    }


}
