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
public class TCPServer extends Thread {

    @Override
    public void run() {
	try {
	    ServerSocket welcomeSock = new ServerSocket(4242);
	    while (true) {
		Socket connectionSock = welcomeSock.accept();
		new TCPHandler(connectionSock).start();
	    }
	} catch (IOException ex) {
	    Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}
