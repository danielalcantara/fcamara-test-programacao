package br.com.fcamara;

public enum DirecaoSubmarino {
	NORTE("Norte"),
	SUL("Sul"),
	LESTE("Leste"),
	OESTE("Oeste");
	
	private String value;
	
	DirecaoSubmarino(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
}
