package br.com.bookper.personalidades;

public class Inovador implements Personalidades{
	private final String descricaoPersonalidade = "Uma estranha justaposi��o surge com os Inovadores, uma vez que eles s�o intransigentemente honestos, mas estes v�o argumentar incansavelmente por algo que eles realmente n�o acreditam, se colocando nos sapatos dos sapatos para argumentar uma verdade de outra perspectiva.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/inovador.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Inovador")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Inovador();
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
