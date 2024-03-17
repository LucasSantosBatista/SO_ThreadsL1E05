/**
 * 
 */
package view;

import controller.PingThread;

/**
 * @author Lucas Batista 17 de mar. de 2024
 */
public class Main {

	public static void main(String[] args) {
		PingThread uolThread = new PingThread("www.uol.com.br");
		PingThread terraThread = new PingThread("www.terra.com.br");
		PingThread googleThread = new PingThread("www.google.com.br");

		uolThread.start();
		terraThread.start();
		googleThread.start();

	}

}
