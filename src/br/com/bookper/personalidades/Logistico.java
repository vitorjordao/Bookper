package br.com.bookper.personalidades;

public class Logistico implements Personalidades{
	private final String descricaoPersonalidade = "As personalidades log�sticas t�m mentes afiadas, baseadas em fatos, e preferem autonomia e autosufici�ncia do que ter que depender em algu�m ou em algo. Depender nos outros � muitas vezes visto pelos Log�sticos como uma fraqueza, e sua paix�o pelo dever, confiabilidade e impec�vel integridade pessoal pro�bem eles de ca�rem em tal armadilha.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/logistico.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Log�stico")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Logistico();
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
