package br.com.bookper.personalidades;

public class Defensor implements Personalidades{
	private final String descricaoPersonalidade = "Apesar da empatia, os Defensores podem ser ferozes quando precisam proteger sua fam�lia ou amigos; embora quietos e reservados, eles geralmente t�m habilidades de pessoas bem desenvolvidas e rela��es sociais robustas; e embora procuram seguran�a e estabilidade, essas personalidades podem estar notavelmente abertas � mudan�a desde que se sintam compreendidas e respeitadas. Como com tantas coisas, as pessoas com o tipo de personalidade de Defensor s�o mais do que a soma de suas partes, e � desta maneira que eles usam essas for�as que definem quem eles s�o.";
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
