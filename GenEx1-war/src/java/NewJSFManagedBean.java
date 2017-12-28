/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import ssbean.NewSessionBeanLocal;

/**
 *
 * @author student
 */
@ManagedBean
@RequestScoped
public class NewJSFManagedBean {

    @EJB
    private NewSessionBeanLocal newSessionBean;

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    String cardNum, birthString, mess = null;
    Date birth;

    public String getBirthString() {
        return birthString;
    }

    public void setBirthString(String birthString) {
        this.birthString = birthString;
    }

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public NewJSFManagedBean() {
    }

    public void action1() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(birth);
        birthString = calendar.get(Calendar.DATE)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.YEAR);
        if (newSessionBean.validateAge(birthString)) {
            mess = "You are validate";
        } else {
            mess = "You are invalid!!!";
        }
    }
}
