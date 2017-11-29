package br.com.bookper.limpesas;

import br.com.bookper.coneccoes.Pessoa;

public class TestaLimpesaGrande {
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		pessoa.setPersonalidades(1, true);
		LimpesaGrande limpa = new LimpesaGrande();
		limpa.limpesaTotal();
	}
}
