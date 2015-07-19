package br.com.teste.netshoes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.teste.netshoes.stream.EncontraChar;
import br.com.teste.netshoes.stream.StreamImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { TesteNetshoesApplication.class })
@WebAppConfiguration
public class TestStream {
	
	private static final String case1 = "aTxuTBucaTTB";
	private static final String case2 = "1q2w3e4r5t6y?7u!Z@X#C$V%B¨N1q2w3e4r5t6y7u!Z@X#C$V%B¨N";
	private static final String case3 = "AbscAbscIAbs";
	private static final String case4 = "NetshoesNetshoes";
	
	/***O caracter 'x' é o primeiro que não se repete***/
	@Test
	public void testeCaracterxNaoRepete() {

		char result = EncontraChar.firstChar(new StreamImpl(case1));
		assertNotNull(result);
		assertEquals('x', result);
	}
	
	/***O caracter 'I' é o primeiro que não se repete***/
	@Test
	public void testeCaracterINaoRepete() {

		char result = EncontraChar.firstChar(new StreamImpl(case3));
		assertNotNull(result);
		assertEquals('I', result);
	}
	
	/***O caracter '?' é o primeiro que não se repete***/
	@Test
	public void testeCaracterNaoRepete() {

		char result = EncontraChar.firstChar(new StreamImpl(case2));
		assertNotNull(result);
		assertEquals('?', result);
	}
	
	/***Todos os caracteres se repete***/
	@Test
	public void testTodosCaracteresRepetem() {

		char result = EncontraChar.firstChar(new StreamImpl(case4));
		assertNotNull(result);
		assertEquals(' ', result);
	}
}
