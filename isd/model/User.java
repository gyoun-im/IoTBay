
package uts.isd.model;

/**
 *
 * @author Cowton
 */
public class User {
    
    private String email;
    private String name;
    private String password;
    private String dob;

    public User(String email, String name, String password, String dob) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
   
}