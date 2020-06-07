package uts.isd.model;
import java.io.Serializable;


public class Access_Log implements Serializable{
    
    private int accessid;
    private int accid;
    private String date;
    private String time;
    
    public Access_Log(int accessid, int accid, String date, String time) {
        this.accessid = accessid;
        this.accid = accid;
        this.date = date;
        this.time = time;
    }

    public int getAccessid() {
        return accessid;
    }

    public void setAccessid(int accessid) {
        this.accessid = accessid;
    }

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
}
