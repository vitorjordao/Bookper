package br.com.bookper.personalidades;

public class Consul implements Personalidades{
	private final String descricaoPersonalidade = "As pessoas que compartilham a personalidade Cônsul são, por falta de uma palavra melhor, populares – o que faz sentido, dado que também é um tipo de personalidade muito comum, constituindo doze por cento da população. Na escola secundária, os Cônsules são os chefes de torcidas e os capitães de times ajustando o tom, tomando o projetor e conduzindo suas equipes para a vitória e à fama. Mais tarde na vida, os Cônsules continuam a gostar de apoiar seus amigos e entes queridos, organizando reuniões sociais e fazendo o melhor para garantir que todos estão felizes.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/consul.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Cônsul")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Consul();
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
