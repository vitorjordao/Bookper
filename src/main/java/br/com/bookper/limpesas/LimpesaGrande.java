package br.com.bookper.limpesas;

import br.com.bookper.coneccoes.modelo.Pessoa;

public class LimpesaGrande {
	public void limpesaTotal() {
		limparStatics();
		System.gc();
	}
	public void limparStatics() {
		Pessoa pessoa = new Pessoa();
		pessoa.limpar();
	}
}
