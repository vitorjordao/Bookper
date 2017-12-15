package br.com.bookper.personalidades;

public class VerificadorDePersonalidades {

	public void descobrir(String personalidade) {
		Personalidades d1 = new Arquiteto();
		Personalidades d2 = new Comandante();
		Personalidades d3 = new Logico();
		Personalidades d4 = new Inovador();
		Personalidades d5 = new Protagonista();
		Personalidades d6 = new Advogado();
		Personalidades d7 = new Mediador();
		Personalidades d8 = new Ativista();
		Personalidades d9 = new Logistico();
		Personalidades d10 = new Executivo();
		Personalidades d11 = new Defensor();
		Personalidades d12 = new Consul();
		Personalidades d13 = new Virtuoso();
		Personalidades d14 = new Empresario();
		Personalidades d15 = new Aventureiro();
		Personalidades d16 = new Animador();
		Personalidades d17 = new Robo();

		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);
		d4.setProximo(d5);
		d5.setProximo(d6);
		d6.setProximo(d7);
		d7.setProximo(d8);
		d8.setProximo(d9);
		d9.setProximo(d10);
		d10.setProximo(d11);
		d11.setProximo(d12);
		d12.setProximo(d13);
		d13.setProximo(d14);
		d14.setProximo(d15);
		d15.setProximo(d16);
		d16.setProximo(d17);
	}

	/*
	 * private Personalidades dercobrirPersonalidade(String personalidade) {
	 * 
	 * if(personalidade.equals("Arquiteto")) { Personalidades personalidades = new
	 * Arquiteto(); return personalidades; }else
	 * if(personalidade.equals("Comandante")) { Personalidades personalidades = new
	 * Comandante(); return personalidades; }else if(personalidade.equals("L�gico"))
	 * { Personalidades personalidades = new Logico(); return personalidades; }else
	 * if(personalidade.equals("Inovador")) { Personalidades personalidades = new
	 * Inovador(); return personalidades; }else
	 * if(personalidade.equals("Protagonista")) { Personalidades personalidades =
	 * new Protagonista(); return personalidades; }else
	 * if(personalidade.equals("Advogado")) { Personalidades personalidades = new
	 * Advogado(); return personalidades; }else if(personalidade.equals("Mediador"))
	 * { Personalidades personalidades = new Mediador(); return personalidades;
	 * }else if(personalidade.equals("Ativista")) { Personalidades personalidades =
	 * new Ativista(); return personalidades; }else
	 * if(personalidade.equals("Log�stico")) { Personalidades personalidades = new
	 * Logistico(); return personalidades; }else
	 * if(personalidade.equals("Executivo")) { Personalidades personalidades = new
	 * Executivo(); return personalidades; }else
	 * if(personalidade.equals("Defensor")) { Personalidades personalidades = new
	 * Defensor(); return personalidades; }else if(personalidade.equals("C�nsul")) {
	 * Personalidades personalidades = new Consul(); return personalidades; }else
	 * if(personalidade.equals("Virtuoso")) { Personalidades personalidades = new
	 * Virtuoso(); return personalidades; }else
	 * if(personalidade.equals("Empres�rio")) { Personalidades personalidades = new
	 * Empresario(); return personalidades; }else
	 * if(personalidade.equals("Aventureiro")) { Personalidades personalidades = new
	 * Aventureiro(); return personalidades; }else
	 * if(personalidade.equals("Animador")) { Personalidades personalidades = new
	 * Animador(); return personalidades; }else { Personalidades personalidades =
	 * new Robo(); return personalidades; }
	 * 
	 * }
	 */

}
