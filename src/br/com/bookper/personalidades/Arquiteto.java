package br.com.bookper.personalidades;

public class Arquiteto implements Personalidades{
	private final String descricaoPersonalidade = "Regras, limitações e tradições são um anátema para pessoas com o tipo de personalidade do Arquiteto – tudo deve estar aberto para questionamentos e reavaliações, e se os Arquitetos verem uma maneira, eles irão agir unilateralmente para promulgar seus métodos e ideias tecnicamente superiores, às vezes insensíveis e quase sempre heterodoxas.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/arquiteto.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Arquiteto")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Arquiteto();
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
