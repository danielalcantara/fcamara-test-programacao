package br.com.fcamara;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubmarinoMain {

	public static void main(String[] args) throws IOException {
		Submarino submarino = new Submarino();
		String comando;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.print("Digite comando para navegação ou exit para finalizar: ");
			comando = in.readLine();
			
			if (comando.equals("exit")) {
				System.exit(0);
			}
			
			submarino.navegar(comando);
		}
	}

}
