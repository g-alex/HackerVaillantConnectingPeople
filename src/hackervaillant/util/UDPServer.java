/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackervaillant.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author indy
 */
public class UDPServer extends Thread {

    @Override
    public void run() {
	try {
	    ServerSocket welcomeSocket = new ServerSocket(6789);
	    while (true) {
		Socket connectionSocket = welcomeSocket.accept();
		new UDPHandler(connectionSocket).start();
	    }
	} catch (IOException ex) {
	    Logger.getLogger(UDPHandler.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}
