/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackervaillant.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author indy
 */
public class UDPHandler extends Thread {

    private Socket connectionSocket;

    public UDPHandler(Socket sock) {
	connectionSocket = sock;
    }

    public void run() {
	BufferedReader inFromClient = null;
	try {
	    String clientSentence;
	    String capitalizedSentence;
	    inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
	    DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
	    clientSentence = inFromClient.readLine();
	    System.out.println(clientSentence);
	    capitalizedSentence = clientSentence.toUpperCase() + '\n';
	    outToClient.writeBytes(capitalizedSentence);
	} catch (IOException ex) {
	    Logger.getLogger(UDPHandler.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    try {
		inFromClient.close();
	    } catch (IOException ex) {
		Logger.getLogger(UDPHandler.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
    public static String person = "{'nom':'Garnier','prenom':'Alexandre','dateNaissance':'20/09/1986'}";

    public static void testGson() {
	Gson gsonObject = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
	Person judu = gsonObject.fromJson(person, Person.class);
	System.out.println(judu.nom + " " + judu.prenom + " " + judu.dateNaissance.toString());
    }
}
