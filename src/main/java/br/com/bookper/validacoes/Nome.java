package br.com.bookper.validacoes;

public class Nome implements Validacoes {

	public TiposValidacoes isValido(String nome) {
		if (nome.matches("[A-Z][a-z]{1,}")) {
			return TiposValidacoes.OK;

		}
		return TiposValidacoes.NOTOK;

	}

}
