package br.com.bookper.personalidades;

public class Arquiteto implements Personalidades{
	private final String descricaoPersonalidade = "Regras, limita��es e tradi��es s�o um an�tema para pessoas com o tipo de personalidade do Arquiteto � tudo deve estar aberto para questionamentos e reavalia��es, e se os Arquitetos verem uma maneira, eles ir�o agir unilateralmente para promulgar seus m�todos e ideias tecnicamente superiores, �s vezes insens�veis e quase sempre heterodoxas.";
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
