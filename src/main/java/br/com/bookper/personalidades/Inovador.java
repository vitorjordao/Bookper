package br.com.bookper.personalidades;

public class Inovador implements Personalidades {
	private Personalidades outraPersonalidade;

	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}

	public Personalidades verificaPersonalidade(String personalidade) {
		if (!personalidade.equals("Inovador")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
		} else {
			return new Inovador();
		}
	}
}
