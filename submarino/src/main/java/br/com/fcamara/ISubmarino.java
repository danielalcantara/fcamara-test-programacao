package br.com.fcamara;

public interface ISubmarino {
	public String navegar(String comando);
	
	public boolean validaComando(String comando);
	
	public void up();
	
	public void down();
	
	public void right();
	
	public void left();
	
	public void move();
}
