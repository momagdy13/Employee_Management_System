import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Add_employee {
    private JPanel add;
    private JTextField name;
    private JTextField FAther;
    private JTextField date;
    private JButton submintButton;
    private JButton backButton;
    private JTextField salary;
    private JTextField address;
    private JTextField phone;
    private JTextField email;
    Connection connection = database_connection.connection();
    Statement statement = null;

    public Add_employee() {

        JFrame frame = new JFrame("Add_employee");
        frame.setContentPane(add);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(900, 700);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Home();
            }
        });
        submintButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String Name = name.getText();
                String Father = FAther.getText();
                String Phone = phone.getText();
                String Email = email.getText();
                String Address = address.getText();
                String Salary = salary.getText();
                String Date = date.getText();
                try {
                    statement = connection.createStatement();
                    String sql = "INSERT INTO employees (employee_name,father_name,DateOFBirth,salary,address,phone,Email_ID) VALUES ('" + Name + "','" + Father + "','" + Date + "','" + Salary + "','" + Address + "','" + Phone + "','" + Email + "') ";
                    statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data Insert Successfully..!");
                    clear();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception);
                }


            }
        });
    }
    public void clear(){
        name.setText("");
        FAther.setText("");
        phone.setText("");
        address.setText("");
        email.setText("");
        salary.setText("");
        date.setText("");
    }

}
