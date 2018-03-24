package br.com.bookper.validacoes;

public class Url {

	public TiposValidacoes isValido(final String url) {
		if (url.contains("."))
			return TiposValidacoes.OK;
		return TiposValidacoes.NOTOK;
	}

}
