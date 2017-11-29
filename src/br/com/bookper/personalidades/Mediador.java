package br.com.bookper.personalidades;

public class Mediador implements Personalidades{
	private final String descricaoPersonalidade = "Os Mediadores s�o guiados pelos seus princ�pios ao inv�s da raz�o, excita��o ou praticidade. Ao decidir como avan�ar, eles v�o olhar para a honra, beleza, moralidade e virtude � Mediadores s�o liderados pela pureza de sua inten��o, n�o recompensas e puni��es. As pessoas que compartilham a personalidade de Mediador s�o orgulhosas desta qualidade, e com raz�o, mas nem todo mundo entende a unidade por tr�s desses sentimentos, e pode levar ao isolamento.";
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
