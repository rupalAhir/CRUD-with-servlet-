/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *
 * @author Mr. Yadav
 */
public class addServlet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
  
    
    
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        
      
            ServletConfig c = getServletConfig();
            PrintWriter out = response.getWriter();
            
            Emp e= new Emp();
            Date jd = null;
            Date ed = null;
             
            e.setName(request.getParameter("name"));
            e.setTeam(request.getParameter("team"));
            e.setRole(request.getParameter("role"));        
            
            String js = request.getParameter("joinDate");
            String es = request.getParameter("endDate");
          
        try {
            
            jd = NewClass.toDate(js);
            ed = NewClass.toDate(es);
            
        } catch (ParseException ex) {
            Logger.getLogger(addServlet1.class.getName()).log(Level.SEVERE, null, ex);
        }
            e.setJoinDate(jd);
            e.setEndDate(ed);
            
            String joinDt[]=request.getParameter("joinDate").split("/");
            String endDt[]=request.getParameter("endDate").split("/");
            
            
            int year = Integer.valueOf(joinDt[2]) - Integer.valueOf(endDt[2]);
            int month = Integer.valueOf(joinDt[1]) - Integer.valueOf(endDt[1]);
            int day = Integer.valueOf(joinDt[0]) - Integer.valueOf(endDt[0]);
            
            String[] totalD = null ;
            totalD[0] = String.valueOf(day)+" days ";
            totalD[1] = String.valueOf(month)+" months ";
            totalD[2] = String.valueOf(year)+" years ";
            
            String finalString = totalD[0]+totalD[1]+totalD[2];
            
            e.setTotalDays(finalString);
            
            // e.setImage(request.getParameter("name"));
            
            
            int f = 0;
        try {
            f = EmpOperation.addEmp(e);
        } catch (SQLException ex) {
            Logger.getLogger(addServlet1.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(f>0){
                out.println("Employee added successfully");
                //RequestDispatcher d =  new RequestDispatcher("");
                c.getServletContext().getRequestDispatcher("viewServlet.java");
                // d.forward(request, response);
                
            }
            else{
                out.println("Could not add");
                c.getServletContext().getRequestDispatcher("index.html");
            }
       
    }
  
  
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
