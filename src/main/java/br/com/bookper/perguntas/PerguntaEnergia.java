package br.com.bookper.perguntas;

import java.util.Random;

public class PerguntaEnergia implements Perguntas {
	private int i;

	@Override
	public void randomizar() {
		final Random gerador = new Random();
		this.i = gerador.nextInt(2);
	}

	@Override
	public String pergunta() {
		if (this.i == 0) {
			return this.getPergunta1();
		} else if (this.i == 1) {
			return this.getPergunta2();
		}
		return this.getPergunta1();
	}

	@Override
	public String RespostaTrue() {
		if (this.i == 0) {
			return this.getRespostaTrue1();
		} else if (this.i == 1) {
			return this.getRespostaTrue2();
		}
		return this.getRespostaTrue1();
	}

	@Override
	public String RespostaFalse() {
		if (this.i == 0) {
			return this.getRespostaFalse1();
		} else if (this.i == 1) {
			return this.getRespostaFalse2();
		}
		return this.getRespostaFalse1();
	}

	public String getPergunta1() {
		return "Você é mais um improvisador do que um planejador cauteloso?";
	}

	public String getRespostaTrue1() {
		return "Sim, sou um improvisador";
	}

	public String getRespostaFalse1() {
		return "Não, sou mais pé no chão";
	}

	public String getPergunta2() {
		return "Você se identifica como ser uma pessoa boa de improviso mais do que uma elaboradora cuidadosa?";
	}

	public String getRespostaTrue2() {
		return "Sim, gosto de improvisar.";
	}

	public String getRespostaFalse2() {
		return "Não, sou mais calculista.";
	}

}