package br.com.bookper.personalidades;

public class Logistico implements Personalidades{
	private final String descricaoPersonalidade = "As personalidades logísticas têm mentes afiadas, baseadas em fatos, e preferem autonomia e autosuficiência do que ter que depender em alguém ou em algo. Depender nos outros é muitas vezes visto pelos Logísticos como uma fraqueza, e sua paixão pelo dever, confiabilidade e impecável integridade pessoal proíbem eles de caírem em tal armadilha.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/logistico.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Logístico")) {
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
