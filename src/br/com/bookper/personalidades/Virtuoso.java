package br.com.bookper.personalidades;

public class Virtuoso implements Personalidades{
	private final String descricaoPersonalidade = "Virtuosos adoram explorar com suas mãos e seus olhos, tocando e examinando o mundo a sua volta com racionalismo tranquilo e uma espiritualidade curiosa. Pessoas com esse tipo de personalidade são fabricantes naturais, que movem de projeto a projeto construindo coisas úteis e o supérfluo é para se divertir, e aprender através do ambiente conformem vão. Geralmente mecânicos e engenheiros. Personalidades virtuosas estão contentes quando estão sujando as mãos, desmontando coisas e remontando estas, um pouquinho melhor que antes.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/virtuoso.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Virtuoso")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Virtuoso();
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
