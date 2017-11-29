package br.com.bookper.personalidades;

public class Comandante implements Personalidades{
	private final String descricaoPersonalidade = "Comandantes são líderes naturais. Pessoas com esse tipo de personalidade encarnam os dons de carisma e confiança e projetam autoridade de uma forma que atrai multidões que estão atrás de um objetivo comum. Mas, ao contrário de seu parceiro Protagonista mais sensível, os Comandantes são caracterizados por um nível de racionalidade, muitas vezes cruel, usando sua unidade, determinação e mentes afiadas para alcançar qualquer fim que eles têm definido para si. Talvez é até melhor que eles representem apenas três por cento da população, para não superarem os tipos de personalidade mais tímidos e sensíveis que compõem uma grande parte do resto do mundo – mas temos que agradecer muito aos Comandantes pelos negócios e instituições que não apreciamos todos os dias.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/comandante.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Comandante")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Comandante();
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
