/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackervaillant.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author indy
 */
public class TCPHandler extends Thread {

    private Socket connectionSock;

    public TCPHandler(Socket sock) {
	connectionSock = sock;
    }

    @Override
    public void run() {
	BufferedReader inFromClient = null;
	try {
	    String surnom;
	    Person leType;
	    inFromClient = new BufferedReader(new InputStreamReader(connectionSock.getInputStream()));
	    ObjectOutputStream outToClient = new ObjectOutputStream(connectionSock.getOutputStream());
	    surnom = inFromClient.readLine();
	    Logger.getAnonymousLogger().log(Level.INFO, surnom);
	    leType = PersonDB.getBySurnom(surnom);
	    outToClient.writeObject(leType);
	} catch (IOException ex) {
	    Logger.getLogger(TCPHandler.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    try {
		inFromClient.close();
	    } catch (IOException ex) {
		Logger.getLogger(TCPHandler.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
}
