package br.com.bookper.validacoes;

public class Nome implements Validacoes {

	@Override
	public TiposValidacoes isValido(final Object nome) {
		final String nomeOk = (String) nome;
		if (nomeOk.matches("^[a-zA-Z\\s]+") && nomeOk.length() <= 100) {
			return TiposValidacoes.OK;

		} else
			return TiposValidacoes.NOTOK;

	}

}
