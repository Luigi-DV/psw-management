import Auth.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static javax.swing.JOptionPane.showMessageDialog;

public class Login extends JFrame{
    private JPanel Panel1;
    private JTextField username;
    private JPasswordField password;
    private JButton signInButton;
    private JFrame frame;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public Login(){
        frame = new JFrame("Login | PSW Chain");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(450,400));
        frame.setResizable(false);
        frame.add(Panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameText = username.getText();
                String passwordText = new String(password.getPassword());
                User authUser = signIn(usernameText, passwordText);

              if(authUser != null){
                  frame.dispose();
                  new Chains(authUser);
              }
              else{
                  showMessageDialog(null, "Incorrect username/password");
              }

            }
        });
    }

    public User signIn(String username, String password){
        Connect cnx = new Connect();
        // Reading data using readLine
        User user = cnx.getUserByUsername(username);
        if(user.getUsername() != null)
        {
            if(user.checkPassword(password) == 1)
            {
                return user;
            }
            else{
                return null;
            }
        }
        else
        {
            return null;
        }
    }
}
