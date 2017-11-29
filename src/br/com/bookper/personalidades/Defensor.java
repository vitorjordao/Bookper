package br.com.bookper.personalidades;

public class Defensor implements Personalidades{
	private final String descricaoPersonalidade = "Apesar da empatia, os Defensores podem ser ferozes quando precisam proteger sua família ou amigos; embora quietos e reservados, eles geralmente têm habilidades de pessoas bem desenvolvidas e relações sociais robustas; e embora procuram segurança e estabilidade, essas personalidades podem estar notavelmente abertas à mudança desde que se sintam compreendidas e respeitadas. Como com tantas coisas, as pessoas com o tipo de personalidade de Defensor são mais do que a soma de suas partes, e é desta maneira que eles usam essas forças que definem quem eles são.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/defensor.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Defensor")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Defensor();
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
