package br.com.bookper.personalidades;

public class Aventureiro implements Personalidades{
	private final String descricaoPersonalidade = "Os Aventureiros vivem num mundo colorido e sensual, inspirado através das conexões com pessoas e ideias. As personalidades Aventureiras têm alegria em reinterpretar essas conexões, reinventando e experimentando com si próprias e novas perspectivas. Nenhum outro tipo de personalidade explora e experimenta dessa maneira. Isso cria uma sensação de espontaneidade, fazendo os Aventureiros parecerem imprevisíveis, mesmo com seus amigos e entes queridos.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/aventureiro.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Aventureiro")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Aventureiro();
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
