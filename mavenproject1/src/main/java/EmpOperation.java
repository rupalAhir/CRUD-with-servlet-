
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mr. Yadav
 */
public class EmpOperation {
    
    static Connection con = null;
    public static Connection getConnection(){
        
        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/EmpDB", "Euser", "user");  
            
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpOperation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmpOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return con;
    }
    
    public static int addEmp(Emp e) throws SQLException{
        
        con=EmpOperation.getConnection();
        PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?);");
          
        
        //ps.addString(1,e.getImage());
        ps.setString(1,e.getName());
        ps.setString(2,e.getTeam());
        ps.setString(3,e.getRole());
        ps.setDate(4, (Date) e.getJoinDate());
        ps.setDate(5, (Date) e.getEndDate());
        ps.setString(6,e.getTotalDays());
        
        int i=0;
        try {
            i = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return i;
    }
    
    public static List<Emp> view() throws SQLException{
       
        List<Emp> eList = new ArrayList<Emp>();
        
        con = EmpOperation.getConnection();
        PreparedStatement ps = con.prepareStatement("select * from employee") ;
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            
            Emp e = new Emp();
            e.setName(rs.getString("Name"));
            e.setTeam(rs.getString("Team"));
            e.setRole(rs.getString("Role"));
            e.setJoinDate(rs.getDate("Join Date"));
            e.setEndDate(rs.getDate("End Date"));
            e.setTotalDays(rs.getString("Total Days"));
            
            eList.add(e);
           // rs.next();
        }
        
        return eList;
    
    
    }
}
