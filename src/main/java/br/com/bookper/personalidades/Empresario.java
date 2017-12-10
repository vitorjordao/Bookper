package br.com.bookper.personalidades;

public class Empresario implements Personalidades{
	private Personalidades outraPersonalidade;
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Empresário")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Empresario();
        }
	}
	
}
