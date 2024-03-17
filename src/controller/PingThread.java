/**
 * 
 */
package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Lucas Batista 17 de mar. de 2024
 */
public class PingThread extends Thread {
	private String server;

	public PingThread(String server) {
		super();
		this.server = server;
	}

	public void run() {
		String os = System.getProperty("os.name");
		if (os == "Linux") {
			String comando = "ping -4 -c 10 " + server;
			try {
				Process process = Runtime.getRuntime().exec(comando);
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				
				String linha = reader.readLine();
				while (linha != null) {
					System.out.println(server + ": " + linha);
					linha = reader.readLine();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
		} else {
			System.out.println("Sistema Operacional não Linux!");
		}
		
	}
}