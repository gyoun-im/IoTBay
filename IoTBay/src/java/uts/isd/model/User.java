package uts.isd.model;

import java.io.Serializable;

public class User implements Serializable {

    private int userID;
    private String email;
    private String password;
    private String dob;
    private String gender;
    private boolean news;
    private int points;

    public User(int userID, String email, String password, String dob, String gender, boolean news, int points) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.news = news;
        this.points = points;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

}
