package uts.isd.model;
import java.io.Serializable;

public class User implements Serializable{
    
    private int accid;
    private String email;
    private String password;
    private String dob;
    private String gender;
    private boolean news;
    private int points;

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isNews() {
        return news;
    }

    public void setNews(boolean news) {
        this.news = news;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public User(int accid, String email, String password, String dob, String gender, boolean news, int points) {
        this.accid = accid;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.news = news;
        this.points = points;
    }
    
}
