package br.com.bookper.perguntas;

import java.util.Random;

public class PerguntaMente implements Perguntas {
	private int i;

	public void randomizar() {
		Random gerador = new Random();
		this.i = gerador.nextInt(2);
	}

	public String pergunta() {
		if (i == 0) {
			return getPergunta1();
		} else if (i == 1) {
			return getPergunta2();
		}
		return getPergunta1();
	}

	public String RespostaTrue() {
		if (i == 0) {
			return getRespostaTrue1();
		} else if (i == 1) {
			return getRespostaTrue2();
		}
		return getRespostaTrue1();
	}

	public String RespostaFalse() {
		if (i == 0) {
			return getRespostaFalse1();
		} else if (i == 1) {
			return getRespostaFalse2();
		}
		return getRespostaFalse1();
	}

	public String getPergunta1() {
		return "Se você é chamado para uma festa, você prefere ficar em casa, jogando, assistindo séries, etc ou você prefere ir na festa?";
	}

	public String getRespostaTrue1() {
		return "Ficar em casa";
	}

	public String getRespostaFalse1() {
		return "Ir na festa";
	}

	public String getPergunta2() {
		return "Você acha difícil se apresentar para outras pessoas?";
	}

	public String getRespostaTrue2() {
		return "Sim, me apresentar para outra pessoa não é algo simples";
	}

	public String getRespostaFalse2() {
		return "Não, eu não tenho medo de me apresentar";
	}

}