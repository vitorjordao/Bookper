package br.com.bookper.personalidades;

public class Logico implements Personalidades{
	private final String descricaoPersonalidade = "Os L�gicos s�o conhecidos por suas teorias brilhantes e l�gica implac�vel � na verdade, eles s�o considerados o mais logicamente precisos de todos os tipos de personalidades.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/logico.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("L�gico")) {
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
