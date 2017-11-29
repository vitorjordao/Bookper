package br.com.bookper.personalidades;

public class Empresario implements Personalidades{
	private final String descricaoPersonalidade = "Pessoas com a personalidade de Empres�rio tem um impacto imediato em seus arredores � o melhor jeito de localiz�-los numa festa � procurar um monte de pessoas tentando se encaixar quando movem de grupo para grupo. Rir e entreter com um humor direto e terroso, as personalidades de Empres�rio adoram ser o centro das aten��es. Se um membro da audi�ncia for chamado ao palco, o Empres�rio ser� um volunt�rio � ou eles sugerem um amigo t�mido. \nTeoria, conceitos abstratos e discuss�es sobre problemas globais se arrasta, e suas implica��es n�o mant�m pessoas com a personalidade do Empres�rio interessado por muito tempo. Os Empres�rios mant�m a conversa en�rgica, com uma boa dose de intelig�ncia, mas gostam de falar sobre o que � � ou melhor ainda, apenas sair e fazer. Os Empres�rios saltam diante de um olhar, corrigindo seus erros ao inv�s de ficar sentado, preparando contingencias e clausulas de escape.";
	private final String imagemPersonalidade = "/br/com/bookper/imagens/personalidades/empresario.png";
	private Personalidades outraPersonalidade;
	
	
	
	public void setProximo(Personalidades outraPersonalidade) {
		this.outraPersonalidade = outraPersonalidade;
	}
	@Override
	public Personalidades verificaPersonalidade(String personalidade) {
		if(!personalidade.equals("Empres�rio")) {
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
