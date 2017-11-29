package br.com.bookper.personalidades;

public class Comandante implements Personalidades{
	private final String descricaoPersonalidade = "Comandantes s�o l�deres naturais. Pessoas com esse tipo de personalidade encarnam os dons de carisma e confian�a e projetam autoridade de uma forma que atrai multid�es que est�o atr�s de um objetivo comum. Mas, ao contr�rio de seu parceiro Protagonista mais sens�vel, os Comandantes s�o caracterizados por um n�vel de racionalidade, muitas vezes cruel, usando sua unidade, determina��o e mentes afiadas para alcan�ar qualquer fim que eles t�m definido para si. Talvez � at� melhor que eles representem apenas tr�s por cento da popula��o, para n�o superarem os tipos de personalidade mais t�midos e sens�veis que comp�em uma grande parte do resto do mundo � mas temos que agradecer muito aos Comandantes pelos neg�cios e institui��es que n�o apreciamos todos os dias.";
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
