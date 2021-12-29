import Auth.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Connect {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/main.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public User getUserByUsername(String username)
    {
        User user = new User();
        String sql = "SELECT * FROM users WHERE username = ?";

        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql))
        {
             // Set the value
             statement.setString(1,username);
             ResultSet rs = statement.executeQuery();
            // loop through the result set
            while (rs.next()) {
               user.id =  rs.getInt("id");
               user.setUsername(rs.getString("username"));
               user.setPassword(rs.getString("password"));
            }
            return user;

        } catch (SQLException e) {
            return null;
        }
    }
    public ResultSet getChains(Integer userID)
    {
        String sql = "SELECT * FROM chains WHERE user_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql))
        {
            // Set the value
            statement.setInt(1, userID);
            ResultSet rs = statement.executeQuery();
            // loop through the result set
           return rs;

        } catch (SQLException e) {
            return null;
        }
    }





}
