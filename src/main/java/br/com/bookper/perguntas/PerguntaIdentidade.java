package br.com.bookper.perguntas;

import java.util.Random;

public class PerguntaIdentidade implements Perguntas {
	private int i;

	public void randomizar() {
		Random gerador = new Random();
		this.i = gerador.nextInt(1);
	}

	public String pergunta() {
		if (i == 0) {
			return getPergunta1();
		}
		return getPergunta1();
	}

	public String RespostaTrue() {
		if (i == 0) {
			return getRespostaTrue1();
		}
		return getRespostaTrue1();
	}

	public String RespostaFalse() {
		if (i == 0) {
			return getRespostaFalse1();
		}
		return getRespostaFalse1();
	}

	public String getPergunta1() {
		return "Suas emoções o controlam mais do que você as controla?";
	}

	public String getRespostaTrue1() {
		return "Eu controlo minhas emoções";
	}

	public String getRespostaFalse1() {
		return "Eu sou mais levado pelas minhas emoções";
	}

}