/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ssbean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author student
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public boolean validateAge(String birth) {
        int age = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = formatter.parse(birth);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            int year1 = calendar.get(Calendar.YEAR);
            int year2 = Calendar.getInstance().get(Calendar.YEAR);
            age = year2-year1;
        } catch (ParseException ex) {
            Logger.getLogger(NewSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (age > 18) {
            return true;
        }
        return false;
    }
}
