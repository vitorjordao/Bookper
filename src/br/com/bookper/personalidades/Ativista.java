package br.com.bookper.personalidades;

public class Ativista implements Personalidades{
	private final String descricaoPersonalidade = "A personalidade Ativista � um verdadeiro esp�rito livre. Eles s�o geralmente os que alegram a festa e est�o menos interessados na emo��o pura e no prazer do momento do que est�o em desfrutar das conex�es sociais e emocionais que fazem com os outros. Encantador, independente, en�rgico e compassivo, os 7% da popula��o que eles englobam certamente pode ser sentido em qualquer multid�o.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/ativista.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Ativista")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Ativista();
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
