package uts.isd.model;
import java.io.Serializable;

public class Customer  implements Serializable{
    
    private String name;
    private String dob;
    private String gender;
    private String number;
    private String email;
    private String address;
    private String password;
    private Boolean promo;
    private Integer reward;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPromo() {
        return promo;
    }

    public void setPromo(Boolean promo) {
        this.promo = promo;
    }

    public Integer getReward() {
        return reward;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }

    public Customer(String name, String dob, String gender, String number, String email, String address, String password, Boolean promo, Integer reward) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.number = number;
        this.email = email;
        this.address = address;
        this.password = password;
        this.promo = promo;
        this.reward = reward;
    }
    
    
}
