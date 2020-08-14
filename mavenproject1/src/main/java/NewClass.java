
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
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
public class NewClass {
    
      public static Date toDate(String s) throws ParseException {
      
          Date d= DateFormat.getDateInstance().parse(s);  // DateFormat();
           return d;
       
    }
}
