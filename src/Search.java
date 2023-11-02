import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Search {
    private JPanel search;
    private JTable table;
    private JTextField id;
    private JButton searchButton;
    Connection connection = database_connection.connection();
    Statement statement = null;

    public Search() {
        JFrame frame = new JFrame("Search");
        frame.setContentPane(search);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(900,600);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    statement  = connection.createStatement();
                    String ID = id.getText();
                    String sql = "SELECT * FROM employees WHERE ID = '"+ID+"'";
                    ResultSet rs = statement.executeQuery(sql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null,exception);
                }
            }

        });
    }
}
