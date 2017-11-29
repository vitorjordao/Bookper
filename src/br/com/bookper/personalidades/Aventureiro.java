package br.com.bookper.personalidades;

public class Aventureiro implements Personalidades{
	private final String descricaoPersonalidade = "Os Aventureiros vivem num mundo colorido e sensual, inspirado atrav�s das conex�es com pessoas e ideias. As personalidades Aventureiras t�m alegria em reinterpretar essas conex�es, reinventando e experimentando com si pr�prias e novas perspectivas. Nenhum outro tipo de personalidade explora e experimenta dessa maneira. Isso cria uma sensa��o de espontaneidade, fazendo os Aventureiros parecerem imprevis�veis, mesmo com seus amigos e entes queridos.";
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
