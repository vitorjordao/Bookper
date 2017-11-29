package br.com.bookper.personalidades;

public class Executivo implements Personalidades{
	private Personalidades outraPersonalidade;
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Executivo")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Executivo();
        }
	}
}
