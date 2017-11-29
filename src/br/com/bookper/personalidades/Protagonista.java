package br.com.bookper.personalidades;

public class Protagonista implements Personalidades{
	private final String descricaoPersonalidade = "Os Protagonistas são genuínos, pessoas atenciosas que falam e agem, e nada os torna mais felizes do que liderar, unindo e motivando sua equipe com um entusiasmo infeccioso.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/protagonista.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Protagonista")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Protagonista();
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
