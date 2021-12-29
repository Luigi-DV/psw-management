import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Register {
    private JTextField username;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JPanel RegisterPanel;
    private JButton signUpButton;
    private JFrame frame;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


    public Register(){
        frame = new JFrame("Register | PSW Chain");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(450,400));
        frame.setResizable(false);

        frame.add(RegisterPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
