package br.com.bookper.perguntas;

public class VerificaPergunta {
	private int cont = 1;
	private Perguntas perguntas = null;

	public void randomizar() {
		perguntas.randomizar();
	}

	public Perguntas pegarPergunta() {
		if(cont == 1) {
			perguntas = new PerguntaMente();
		} else if(cont == 2) {
			perguntas = new PerguntaEnergia();
		} else if(cont == 3) {
			perguntas = new PerguntaNatureza();
		} else if(cont == 4) {
			perguntas = new PerguntaTaticas();
		} else if(cont == 5) {
			perguntas = new PerguntaIdentidade();
		}
		return perguntas;

	}

	public boolean contar() {
		if(cont>=5)
			return false;
		++this.cont;
		return true;
	}

	public boolean voltarContagem() {
		if(cont<=0)
			return false;
		--this.cont;
		return true;
	}

	public int getCont() {
		return cont;
	}
}