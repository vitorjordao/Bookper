package br.com.bookper.personalidades;

public class Empresario implements Personalidades{
	private final String descricaoPersonalidade = "Pessoas com a personalidade de Empresário tem um impacto imediato em seus arredores – o melhor jeito de localizá-los numa festa é procurar um monte de pessoas tentando se encaixar quando movem de grupo para grupo. Rir e entreter com um humor direto e terroso, as personalidades de Empresário adoram ser o centro das atenções. Se um membro da audiência for chamado ao palco, o Empresário será um voluntário – ou eles sugerem um amigo tímido. \nTeoria, conceitos abstratos e discussões sobre problemas globais se arrasta, e suas implicações não mantêm pessoas com a personalidade do Empresário interessado por muito tempo. Os Empresários mantêm a conversa enérgica, com uma boa dose de inteligência, mas gostam de falar sobre o que é – ou melhor ainda, apenas sair e fazer. Os Empresários saltam diante de um olhar, corrigindo seus erros ao invés de ficar sentado, preparando contingencias e clausulas de escape.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/empresario.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Empresário")) {
			return outraPersonalidade.verificaPersonalidade(personalidade);
        }else {
        	return new Empresario();
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
