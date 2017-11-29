package br.com.bookper.personalidades;

public class Executivo implements Personalidades{
	private final String descricaoPersonalidade = "Os Executivos representam tradi��o e ordem, usando sua compreens�o do que � certo, errado e socialmente aceit�vel para unir fam�lias e comunidades. Eles abra�am os valores da honestidade, da dedica��o e da dignidade, pessoas com o tipo da personalidade de Executivo s�o valorizados pelos seus conselho e orienta��o clara, e conduzem com prazer os caminhos dif�ceis. Eles se orgulham em aproximar as pessoas, os Executivos geralmente tem pap�is de organizadores da comunidade, trabalham duro para unir as pessoas em eventos locais, ou eles defendem os valores tradicionais que mant�m as fam�lias e as comunidades unidas.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/executivo.png";
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
	
	@Override
	public String getDescricaoPersonalidade() {
		return this.descricaoPersonalidade;
	}

	@Override
	public String getImagemPersonalidade() {
		return this.imagemPersonalidade;
	}
}
