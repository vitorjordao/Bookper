package br.com.bookper.personalidades;

public class Ativista implements Personalidades{
	private final String descricaoPersonalidade = "A personalidade Ativista é um verdadeiro espírito livre. Eles são geralmente os que alegram a festa e estão menos interessados na emoção pura e no prazer do momento do que estão em desfrutar das conexões sociais e emocionais que fazem com os outros. Encantador, independente, enérgico e compassivo, os 7% da população que eles englobam certamente pode ser sentido em qualquer multidão.";
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
