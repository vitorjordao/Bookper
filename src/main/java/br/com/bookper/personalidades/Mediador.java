package br.com.bookper.personalidades;

public class Mediador implements Personalidades{
	private Personalidades outraPersonalidade;
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Mediador")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Mediador();
        }
	}
}
