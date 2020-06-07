package uts.isd.iotbay;
import java.io.Serializable;

public class User implements Serializable{
    
    private String name;
    private String dob;
    private String email;
    private String number;
    private String password;
    
     public User(){}
    
    public User(String name, String dob, String email, String number, String password)
    {
        this.name=name;
        this.dob=dob;
        this.email=email;
        this.number=number;
        this.password=password;        
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
