package br.com.bookper.personalidades;

public class Mediador implements Personalidades{
	private final String descricaoPersonalidade = "Os Mediadores são guiados pelos seus princípios ao invés da razão, excitação ou praticidade. Ao decidir como avançar, eles vão olhar para a honra, beleza, moralidade e virtude – Mediadores são liderados pela pureza de sua intenção, não recompensas e punições. As pessoas que compartilham a personalidade de Mediador são orgulhosas desta qualidade, e com razão, mas nem todo mundo entende a unidade por trás desses sentimentos, e pode levar ao isolamento.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/mediador.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Mediador")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Mediador();
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
