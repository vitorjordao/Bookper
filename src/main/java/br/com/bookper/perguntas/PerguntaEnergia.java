package br.com.bookper.perguntas;

import java.util.Random;

public class PerguntaEnergia implements Perguntas{
	private int i;

	public void randomizar() {
		Random gerador = new Random();
		this.i = gerador.nextInt(2);
	}
	public String pergunta() {
		if(i == 0) {
			return getPergunta1();
		}else if(i == 1){
			return getPergunta2();
		}
		return getPergunta1();
	}

	public String RespostaTrue() {
		if(i == 0) {
			return getRespostaTrue1();
		}else if(i == 1){
			return getRespostaTrue2();
		}
		return getRespostaTrue1();
	}

	public String RespostaFalse() {
		if(i == 0) {
			return getRespostaFalse1();
		}else if(i == 1){
			return getRespostaFalse2();
		}
		return getRespostaFalse1();
	}

	public String getPergunta1() {
		return "Você é mais um improvisador nato do que um planejador cuidadoso?";
	}

	public String getRespostaTrue1() {
		return "Sim, sou um improvisador";
	}

	public String getRespostaFalse1() {
		return "Não, sou mais pé no chão";
	}

	public String getPergunta2() {
		return "Você prefere improvisar do que gastar tempo para criar um plano detalhado?";
	}

	public String getRespostaTrue2() {
		return "Prefiro improvisar";
	}

	public String getRespostaFalse2() {
		return "Não, prefiro algo mais planejado";
	}

}