package br.com.bookper.personalidades;

public class Robo implements Personalidades{
	private final String descricaoPersonalidade = "Não sei como mais você é um robô, parabéns você não é um humano!";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/robo.jpg";
private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Rôbo")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Robo();
        }
	}
	
	@Override
	public String getDescricaoPersonalidade() {
		return this.descricaoPersonalidade;
	}

	@Override
	public String getImagemPersonalidade() {
		return this.imagemPersonalidade;
	}
}
