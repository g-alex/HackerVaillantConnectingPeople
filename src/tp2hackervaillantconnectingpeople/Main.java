/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2hackervaillantconnectingpeople;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hackervaillant.util.Person;
import hackervaillant.util.TCPServer;
import hackervaillant.util.UDPServer;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp2hackervaillantconnectingpeople.pseudo.Jsondb;
import tp2hackervaillantconnectingpeople.pseudo.JsondbEntity;

/**
 *
 * @author indy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	try {
            System.out.println("bobi");
	    new TCPServer().start();
	    UDPServer udpserv = new UDPServer();
	    udpserv.start();
	    udpserv.join();
	} // main()
	catch (InterruptedException ex) {
	    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	}
    } // main()

    public static String person = "{'nom':'Garnier','prenom':'Alexandre','dateNaissance':'20/09/1986'}";
    public static String pseudoperson = "{'accounts':[{'pseudo':'Hippie2','pers"
            + "on':{'nom':'Durillon','prenom':'Benoit','dateNaissance':'10/12/1"
            + "990'}},{'pseudo':'Hippie','person':{'nom':'Durillon','prenom':'J"
            + "ulien','dateNaissance':'11/01/1989'}}]}";

    public static void testGson() {
        Gson gsonObject = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Person judu = gsonObject.fromJson(person, Person.class);
        System.out.println(judu.nom + " " + judu.prenom + " " + judu.dateNaissance.toString());
        Jsondb obj = gsonObject.fromJson(pseudoperson, Jsondb.class);

        for (JsondbEntity ent : obj.accounts) {
            System.out.println(ent.pseudo + ent.person);
        }
    }
}
