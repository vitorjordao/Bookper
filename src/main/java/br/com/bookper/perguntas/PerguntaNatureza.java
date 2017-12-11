package br.com.bookper.perguntas;

import java.util.Random;

public class PerguntaNatureza implements Perguntas{
	private int i;

	public void randomizar() {
		Random gerador = new Random();
		this.i = gerador.nextInt(1);
	}
	public String pergunta() {
		if(i == 0) {
			return getPergunta1();
		}
		return getPergunta1();
	}

	public String RespostaTrue() {
		if(i == 0) {
			return getRespostaTrue1();
		}
		return getRespostaTrue1();
	}

	public String RespostaFalse() {
		if(i == 0) {
			return getRespostaFalse1();
		}
		return getRespostaFalse1();
	}

	public String getPergunta1() {
		return "Você expulsaria o seu melhor amigo(a) de uma empresa, se fosse necessário?";
	}

	public String getRespostaTrue1() {
		return "sim";
	}

	public String getRespostaFalse1() {
		return "não";
	}

}