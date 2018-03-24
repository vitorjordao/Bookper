package br.com.bookper.personalidades;

public class Ativista implements Personalidades {
	private Personalidades outraPersonalidade;

	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}

	public Personalidades verificaPersonalidade(String personalidade) {
		if (!personalidade.equals("Ativista")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
		} else {
			return new Ativista();
		}
	}

}
