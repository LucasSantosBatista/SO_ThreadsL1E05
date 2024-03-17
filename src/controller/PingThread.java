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
		if (os.contains("Linux")) {
			String comando = "ping -4 -c 10 " + server;

			try {
				Process process = Runtime.getRuntime().exec(comando);

				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

				String linha;
				double avgTime = 0;

				while ((linha = reader.readLine()) != null) {
					String[] partes = linha.split(" ");
					for (String parte : partes) {
						if (parte.contains("time=")) {
							System.out.println(server + ": " + parte);

						}
						if (linha.contains("avg")) {
							String[] parts = linha.split("/");
							if (parts.length > 4) {
								avgTime = Double.parseDouble(parts[4]);
								System.out.println(server + " - Tempo médio: " + avgTime + "ms");
								break; // Saindo do loop assim que o tempo médio é encontrado
							}
						}

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Sistema Operacional não Linux!");
		}
	}
}