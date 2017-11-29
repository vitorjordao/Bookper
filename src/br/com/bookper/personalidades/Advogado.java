package br.com.bookper.personalidades;

public class Advogado implements Personalidades{
	private final String descricaoPersonalidade = "Advogados tendem a ver como seu objetivo ajudar os outros na vida, mas enquanto as pessoas com este tipo de personalidade podem ser encontradas envolvendo esforços de resgate e fazendo trabalho de caridade, a sua verdadeira paixão é chegar ao cerne da questão para que as pessoas não precisam ser resgatadas de maneira alguma.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/advogado.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Advogado")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Advogado();
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
