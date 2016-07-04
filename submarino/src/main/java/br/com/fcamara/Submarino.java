package br.com.fcamara;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Submarino implements ISubmarino {
	private DirecaoSubmarino direcao = DirecaoSubmarino.NORTE;
	private Integer coordX = 0;
	private Integer coordY = 0;
	private Integer coordZ = 0;
	public StringBuilder coordenadas = new StringBuilder();

	public Submarino() {
		geraCoordenada();
	}

	public String navegar(String comando) {

		if (validaComando(comando)) {
			
			for (int index = 0; index < comando.length(); index++) {
				char ch = comando.charAt(index);
				
				if (ch == 'U') {
					up();
				} else if (ch == 'D') {
					down();
				} else if (ch == 'L') {
					left();
				} else if (ch == 'R') {
					right();
				} else {
					System.out.println("Submarino em movimento");
					move();
					System.out.println("Coordenadas do submarino: " + geraCoordenada());
				}
			}
		}

		return geraCoordenada();
	}

	private String geraCoordenada() {
		coordenadas.setLength(0);
		coordenadas.append("(" + coordX.toString());
		coordenadas.append(", " + coordY.toString());
		coordenadas.append(", " + coordZ.toString());
		coordenadas.append(", " + direcao.toString() + ")");

		return coordenadas.toString();
	}

	public boolean validaComando(String comando) {

		if (comando != null && !comando.isEmpty()) {
			comando = comando.trim();
			Pattern pattern = Pattern.compile("^[LRUDM]+$");
			Matcher matcher = pattern.matcher(comando);

			if (!matcher.find()) {
				System.out.println("Comando inválido, por favor tente novamente!");
				return false;
			}
		} else {
			System.out.println("O comando não pode ser mulo ou em branco!");
			return false;
		}

		return true;
	}
	
	public void move() {
		if (direcao.equals(DirecaoSubmarino.NORTE)) {
			coordX++;
		} else if (direcao.equals(DirecaoSubmarino.SUL)) {
			coordX--;
		} else if (direcao.equals(DirecaoSubmarino.LESTE)) {
			coordZ++;
		} else {
			coordZ--;
		}
	}
	
	public void up() {
		coordY++;
	}

	public void down() {
		coordY--;
	}

	public void right() {
		if (direcao.equals(DirecaoSubmarino.NORTE)) {
			setDirecao(DirecaoSubmarino.LESTE);
		} else if (direcao.equals(DirecaoSubmarino.LESTE)) {
			setDirecao(DirecaoSubmarino.SUL);
		} else if (direcao.equals(DirecaoSubmarino.OESTE)) {
			setDirecao(DirecaoSubmarino.NORTE);
		} else {
			setDirecao(DirecaoSubmarino.OESTE);
		}
	}

	public void left() {
		if (direcao.equals(DirecaoSubmarino.NORTE)) {
			setDirecao(DirecaoSubmarino.OESTE);
		} else if (direcao.equals(DirecaoSubmarino.LESTE)) {
			setDirecao(DirecaoSubmarino.NORTE);
		} else if (direcao.equals(DirecaoSubmarino.OESTE)) {
			setDirecao(DirecaoSubmarino.SUL);
		} else {
			setDirecao(DirecaoSubmarino.LESTE);
		}
	}

	public DirecaoSubmarino getDirecao() {
		return direcao;
	}

	public void setDirecao(DirecaoSubmarino direcao) {
		this.direcao = direcao;
	}

	public StringBuilder getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(StringBuilder coordenadas) {
		this.coordenadas = coordenadas;
	}

}
