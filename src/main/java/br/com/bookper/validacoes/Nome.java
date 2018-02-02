package br.com.bookper.validacoes;

public class Nome implements Validacoes {

	@Override
	public TiposValidacoes isValido(Object nome) {
		String nomeOk = (String) nome;
		if (nomeOk.matches("[A-Z][a-z]{1,} [A-Z][a-z]{0,} [A-Z][a-z]{0,} [A-Z][a-z]{0,}") && nomeOk.length() <= 50) {
			return TiposValidacoes.OK;

		}
		return TiposValidacoes.NOTOK;

	}

}
