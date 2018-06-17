package br.com.bookper.perguntas;

import java.util.Random;

public class PerguntaMente implements Perguntas {
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
		return "Se alguém te chama para uma festa, você prefere ficar em casa ou prefere ir na festa?";
	}

	public String getRespostaTrue1() {
		return "Vou ficar em casa";
	}

	public String getRespostaFalse1() {
		return "Vou ir na festa";
	}

	public String getPergunta2() {
		return "Você acha difícil se expor para outras pessoas?";
	}

	public String getRespostaTrue2() {
		return "Sim, me expor para outra pessoa não é algo simples.";
	}

	public String getRespostaFalse2() {
		return "Não, eu não tenho medo de me expor.";
	}

}