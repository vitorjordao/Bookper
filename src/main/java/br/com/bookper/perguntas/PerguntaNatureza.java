package br.com.bookper.perguntas;

import java.util.Random;

public class PerguntaNatureza implements Perguntas {
	private int i;

	@Override
	public void randomizar() {
		final Random gerador = new Random();
		this.i = gerador.nextInt(1);
	}

	@Override
	public String pergunta() {
		if (this.i == 0) {
			return this.getPergunta1();
		}
		return this.getPergunta1();
	}

	@Override
	public String RespostaTrue() {
		if (this.i == 0) {
			return this.getRespostaTrue1();
		}
		return this.getRespostaTrue1();
	}

	@Override
	public String RespostaFalse() {
		if (this.i == 0) {
			return this.getRespostaFalse1();
		}
		return this.getRespostaFalse1();
	}

	public String getPergunta1() {
		return "Você demitiria o seu melhor amigo(a) de uma empresa, se fosse preciso?";
	}

	public String getRespostaTrue1() {
		return "Sim, demitiria.";
	}

	public String getRespostaFalse1() {
		return "Não, continuaria com meu amigo na empresa.";
	}

}