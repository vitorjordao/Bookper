package br.com.bookper.personalidades;

public class Arquiteto implements Personalidades {
	private Personalidades outraPersonalidade;

	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}

	public Personalidades verificaPersonalidade(String personalidade) {
		if (!personalidade.equals("Arquiteto")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
		} else {
			return new Arquiteto();
		}
	}

}
