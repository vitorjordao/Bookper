package br.com.bookper.perguntas;

import java.util.Random;

public class PerguntaTaticas implements Perguntas {
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
		return "Você frequentemente gasta tempo explorando ideias irrealistas e impraticáveis, ainda que intrigantes?";
	}

	public String getRespostaTrue1() {
		return "Eu não gasto tempo para ideias irrealistas.";
	}

	public String getRespostaFalse1() {
		return "Sim, eu gasto tempo em ideias irrealistas.";
	}

}