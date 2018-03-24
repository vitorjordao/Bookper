package br.com.bookper.tests.testesmanuais;

import br.com.bookper.personalidades.VerificadorDePersonalidades;

public class TestPersonalidades {
	public static void main(String[] args) {
		VerificadorDePersonalidades personalidades = new VerificadorDePersonalidades();
		personalidades.descobrir("Empresário");
	}
}
