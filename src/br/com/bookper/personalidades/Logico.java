package br.com.bookper.personalidades;

public class Logico implements Personalidades{
	private final String descricaoPersonalidade = "Os Lógicos são conhecidos por suas teorias brilhantes e lógica implacável – na verdade, eles são considerados o mais logicamente precisos de todos os tipos de personalidades.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/logico.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Lógico")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Logico();
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
