package br.com.bookper.personalidades;

public class Executivo implements Personalidades{
	private final String descricaoPersonalidade = "Os Executivos representam tradição e ordem, usando sua compreensão do que é certo, errado e socialmente aceitável para unir famílias e comunidades. Eles abraçam os valores da honestidade, da dedicação e da dignidade, pessoas com o tipo da personalidade de Executivo são valorizados pelos seus conselho e orientação clara, e conduzem com prazer os caminhos difíceis. Eles se orgulham em aproximar as pessoas, os Executivos geralmente tem papéis de organizadores da comunidade, trabalham duro para unir as pessoas em eventos locais, ou eles defendem os valores tradicionais que mantêm as famílias e as comunidades unidas.";
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
