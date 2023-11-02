import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update_Data {
    private JPanel update;
    private JTextField name;
    private JButton updateButton;
    private JButton backButton;
    private JTextField id;
    private JButton searchh;
    private JTextField father;
    private JTextField date;
    private JTextField addresss;
    private JTextField phone;
    private JTextField salary;
    private JTextField email;
    private JButton delete;
    Connection connection = database_connection.connection();
    Statement statement = null;

    public Update_Data() {

        JFrame frame = new JFrame("Update_Data");
        frame.setContentPane(update);
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
        searchh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    statement  = connection.createStatement();
                    String ID = id.getText();
                    String sql = "SELECT * FROM employees WHERE ID = '"+ID+"'";
                    ResultSet rs = statement.executeQuery(sql);
                    if (rs.next()){
                        name.setText(rs.getString(2));
                        father.setText(rs.getString(3));
                        date.setText(rs.getString(4));
                        salary.setText(rs.getString(5));
                        addresss.setText(rs.getString(6));
                        phone.setText(rs.getString(7));
                        email.setText(rs.getString(8));
                    }else {
                        JOptionPane.showMessageDialog(null,"Record Not Found","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null,exception);
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    statement = connection.createStatement();
                    String Name = name.getText();
                    String Father = father.getText();
                    String Phone = phone.getText();
                    String Email = email.getText();
                    String Address = addresss.getText();
                    String Salary = salary.getText();
                    String Date = date.getText();
                    String sql = "UPDATE employees SET employee_name = '"+Name+"',father_name = '"+Father+"',DateOFBirth = '"+Date+"',salary = '"+Salary+"',address = '"+Address+"',phone = '"+Phone+"',Email_ID = '"+Email+"' WHERE ID = '"+id.getText()+"' ";
                    statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null,"Data Update Successfully..!");
                    clear();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,exception);
                }
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    statement = connection.createStatement();
                    String sql = "DELETE FROM employees WHERE ID = '"+id.getText()+"'";
                    statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Delete Data Successfully...!");
                    clear();

                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,exception);
                }
            }
        });
    }

    public void clear(){
        name.setText("");
        father.setText("");
        phone.setText("");
        addresss.setText("");
        email.setText("");
        salary.setText("");
        date.setText("");
    }
}
