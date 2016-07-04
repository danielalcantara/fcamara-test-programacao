package br.com.fcamara;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class SubmarinoTest {
	
	private Submarino submarino = new Submarino();

	@Test
	public void testNavegar() {
		submarino.navegar("LMRDDMMUU");
	}

	@Test
	public void testValidaComandoValido() {
		assertTrue(submarino.validaComando("LMRDDMMUU"));
	}
	
	@Test
	public void testValidaComandoInvalido() {
		assertFalse(submarino.validaComando("LMRX_45MMUU"));
	}
	
	@Test
	public void testGerarCoordenadas() {
		String comando = "UULLRMMDMULLM";
		String coodenadas;
		
		coodenadas = submarino.navegar(comando);
		
		Pattern pattern = Pattern.compile("^(\\()\\d+,\\s\\d+,\\s\\d+,\\s((NORTE)|(SUL)|(LESTE)|(OESTE))\\)$");
		Matcher matcher = pattern.matcher(coodenadas);
		
		assertTrue(matcher.find());
	}

}
