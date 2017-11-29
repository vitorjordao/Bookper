package br.com.bookper.personalidades;

public class Animador implements Personalidades{
	private final String descricaoPersonalidade = "Se alguém é visto cantando e dançando espontaneamente, essa é a pessoa com a personalidade de Animador. Os Animadores ficam presos na excitação do momento, e querem que todos os outros se sintam assim também. Nenhum outro tipo de personalidade é tão generosa com seu tempo e energia como os Animadores quando se trata de encorajar outros, e nenhum outro tipo de personalidade o faz com um estilo tão irresistível.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/animador.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Animador")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Animador();
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
