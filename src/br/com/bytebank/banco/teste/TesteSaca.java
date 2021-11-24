package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*;

public class TesteSaca {

	public static void main(String[] args) {

		ContaCorrente c = new ContaCorrente(123, 321);
		c.deposita(200.0);
		try {
			c.saca(200.0);
		} catch(SaldoInsuficenteException ex) {
			System.out.println("Ex: " + ex.getMessage());
		}
		System.out.println(c.getSaldo());
	}

}
