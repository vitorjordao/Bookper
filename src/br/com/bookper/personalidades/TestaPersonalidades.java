package br.com.bookper.personalidades;

public class TestaPersonalidades {
	public static void main(String[] args) {
		VerificadorDePersonalidades personalidades = new VerificadorDePersonalidades();
		personalidades.descobrir("Empres�rio");
		System.out.println(personalidades.getDescricao());
		System.out.println(personalidades.getImagem());
	}
}
