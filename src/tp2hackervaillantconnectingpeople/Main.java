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
	    new TCPServer().start();
	    UDPServer udpserv = new UDPServer();
	    udpserv.start();
	    udpserv.join();
	} // main()
	catch (InterruptedException ex) {
	    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	}
    } // main()
}
