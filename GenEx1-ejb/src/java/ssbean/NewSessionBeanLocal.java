/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssbean;

import javax.ejb.Local;

/**
 *
 * @author student
 */
@Local
public interface NewSessionBeanLocal {

    public boolean validateAge(String birth);

    

}
