/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackervaillant.util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author judu
 */
public final class PersonDB {

    private final static Map<String,Person> corresp=new HashMap<String,Person>();

    static {
        Calendar cal = Calendar.getInstance();
        cal.set(1987, 5, 28);
        corresp.put("Joël", new Person("Fortun", "Manoel", cal.getTime()));
        cal.set(1989, 0, 11);
        corresp.put("Hippie M", new Person("Durillon", "Julien", cal.getTime()));
        cal.set(1986, 8, 20);
        corresp.put("Autoroute", new Person("Garnier", "Alexandre", cal.getTime()));
        cal.set(1984, 4, 3);
        corresp.put("PédoFred", new Person("Bouvet", "Frédéric", cal.getTime()));
    }

    public static Person getBySurnom(String surnom){
        return corresp.get(surnom);
    }
}
