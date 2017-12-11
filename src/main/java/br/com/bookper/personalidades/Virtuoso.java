package br.com.bookper.personalidades;

public class Virtuoso implements Personalidades{
	private Personalidades outraPersonalidade;
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Virtuoso")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Virtuoso();
        }
	}
}
