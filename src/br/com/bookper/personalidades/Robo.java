package br.com.bookper.personalidades;

public class Robo implements Personalidades{
	private final String descricaoPersonalidade = "N�o sei como mais voc� � um rob�, parab�ns voc� n�o � um humano!";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/robo.jpg";
private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("R�bo")) {
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
