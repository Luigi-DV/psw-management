package Auth;

import java.util.Objects;

/**
 * @Author Luigi_DV
 */
public class User {
    public Integer id;
    private String username;
    private String password;

    /**
     * Username Getter
     * @return string
     */
    public String getUsername()
    {
        return this.username;
    }
    /**
     * Username Setter
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    /**
     * Password Setter
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    /**
     * Password check
     * @return int
     */
    public int checkPassword(String password){
        if(Objects.equals(this.password, password))
        {
            return 1;
        }
        else{
            return 0;
        }
    }

}
