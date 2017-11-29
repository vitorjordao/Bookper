package br.com.bookper.personalidades;

public class Inovador implements Personalidades{
	private final String descricaoPersonalidade = "Uma estranha justaposição surge com os Inovadores, uma vez que eles são intransigentemente honestos, mas estes vão argumentar incansavelmente por algo que eles realmente não acreditam, se colocando nos sapatos dos sapatos para argumentar uma verdade de outra perspectiva.";
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
