
import java.io.FileInputStream;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mr. Yadav
 */
public class Emp {
    private String name, team, role;
    private Date joinDate, endDate;
    private String totalDays;
   // private FileInputStream image;
    
    public void setName(String name){
        this.name=name;
    }
    public void setTeam(String team){
        this.team=team;
    }
    public void setRole(String role){
        this.role=role;
    }
    public void setJoinDate(Date dt){
        this.joinDate=dt;
    }
    public void setEndDate(Date dt){
        this.endDate = dt;
    }
    public void setTotalDays(String totalDays){
        this.totalDays=totalDays;
    }
 /*   public void setImage(FileInputStream img){
        this.image=img;
    }*/
    
    public String getName(){
        return name;
    }
    public String getTeam(){
        return team;
    }
    public String getRole(){
        return role;
    }
    public Date getJoinDate(){
        return joinDate;
    }
    public Date getEndDate(){
        return endDate;
    }
    public String getTotalDays(){
        return totalDays;
    }
 /*   public FileInputStream getImage(){
        return image;
    }*/
}
