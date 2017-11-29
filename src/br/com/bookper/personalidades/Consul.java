package br.com.bookper.personalidades;

public class Consul implements Personalidades{
	private final String descricaoPersonalidade = "As pessoas que compartilham a personalidade C�nsul s�o, por falta de uma palavra melhor, populares � o que faz sentido, dado que tamb�m � um tipo de personalidade muito comum, constituindo doze por cento da popula��o. Na escola secund�ria, os C�nsules s�o os chefes de torcidas e os capit�es de times ajustando o tom, tomando o projetor e conduzindo suas equipes para a vit�ria e � fama. Mais tarde na vida, os C�nsules continuam a gostar de apoiar seus amigos e entes queridos, organizando reuni�es sociais e fazendo o melhor para garantir que todos est�o felizes.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/consul.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("C�nsul")) {
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
