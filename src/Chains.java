import Auth.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Chains {
    private User user;
    private final DefaultTableModel tableModel = new DefaultTableModel();
    private JPanel Main;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JFrame frame;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public Chains(User user){
        String title = user.getUsername() + " Chains | PSW Chain";
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(850,800));
        frame.setResizable(false);
        frame.add(Main);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void setChains(int id) throws SQLException {

        Connect cnx = new Connect();
        ResultSet rs = cnx.getChains(id);
        ResultSetMetaData metaData = rs.getMetaData();

        // Names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }

        // Data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int i = 1; i <= columnCount; i++) {
                vector.add(rs.getObject(i));
            }
            data.add(vector);
        }

        tableModel.setDataVector(data, columnNames);

    }
}
