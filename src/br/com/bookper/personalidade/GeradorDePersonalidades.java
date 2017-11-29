package br.com.bookper.personalidade;

import br.com.bookper.coneccoes.Pessoa;

public class GeradorDePersonalidades {
	private Pessoa pessoa = new Pessoa();
	private boolean mente;
	private boolean energia;
	private boolean natureza;
	private boolean taticas;
	private boolean identidade;
	private String papeis;
	private String estrategia;
	
	public void gerarPersonalidade() {
		this.mente = pessoa.isMente();
		this.energia = pessoa.isEnergia();
		this.natureza = pessoa.isNatureza();
		this.taticas = pessoa.isTaticas();
		this.identidade = pessoa.isIdentidade();
		papeis();
	}
	
	private void papeis() {
		if(energia == true && natureza == true) {
			papeis = "analistas";
		}else if(energia == true && natureza == false) {
			papeis = "diplomatas";
		}else if(energia == false && taticas == true) {
			papeis = "sentinelas";
		}else if(energia == false && taticas == false) {
			papeis = "exploradores";
		}
		estrategia();
	}
	
	private void estrategia() {
		if(mente == true && identidade == true) {
			estrategia = "individualismoConfiante";
		}else if(mente == false && identidade == true) {
			estrategia = "dominioEmPessoas";
		}else if(mente == true && identidade == false) {
			estrategia = "melhoriaConstante";
		}else if(mente == false && identidade == false) {
			estrategia = "compromissoSocial";
		}
		calculosDaTabela();
	}
	
	private void calculosDaTabela() {
		if(papeis.equals("analistas") && estrategia.equals("individualismoConfiante") && taticas) {
			pessoa.setPersonalidade("Arquiteto");
		}else if(papeis.equals("analistas") && estrategia.equals("individualismoConfiante") && !taticas) {
			pessoa.setPersonalidade("Lógico");
		}
		
		else if(papeis.equals("analistas") && estrategia.equals("dominioEmPessoas") && taticas) {
			pessoa.setPersonalidade("Comandante");
		}else if(papeis.equals("analistas") && estrategia.equals("dominioEmPessoas") && !taticas) {
			pessoa.setPersonalidade("Inovador");
		}
		
		else if(papeis.equals("analistas") && estrategia.equals("melhoriaConstante") && taticas) {
			pessoa.setPersonalidade("Arquiteto");
		}else if(papeis.equals("analistas") && estrategia.equals("melhoriaConstante") && !taticas) {
			pessoa.setPersonalidade("Lógico");
		}
		
		else if(papeis.equals("analistas") && estrategia.equals("compromissoSocial") && taticas) {
			pessoa.setPersonalidade("Comandante");
		}else if(papeis.equals("analistas") && estrategia.equals("compromissoSocial") && !taticas) {
			pessoa.setPersonalidade("Inovador");
		}
		
		else if(papeis.equals("diplomatas") && estrategia.equals("individualismoConfiante") && taticas) {
			pessoa.setPersonalidade("Protagonista");
		}else if(papeis.equals("diplomatas") && estrategia.equals("individualismoConfiante") && !taticas) {
			pessoa.setPersonalidade("Mediador");
		}
		
		else if(papeis.equals("diplomatas") && estrategia.equals("dominioEmPessoas") && taticas) {
			pessoa.setPersonalidade("Advogado");
		}else if(papeis.equals("diplomatas") && estrategia.equals("dominioEmPessoas") && !taticas) {
			pessoa.setPersonalidade("Ativista");
		}
		
		else if(papeis.equals("diplomatas") && estrategia.equals("melhoriaConstante") && taticas) {
			pessoa.setPersonalidade("Protagonista");
		}else if(papeis.equals("diplomatas") && estrategia.equals("melhoriaConstante") && !taticas) {
			pessoa.setPersonalidade("Mediador");
		}
		
		else if(papeis.equals("diplomatas") && estrategia.equals("compromissoSocial") && taticas) {
			pessoa.setPersonalidade("Advogado");
		}else if(papeis.equals("diplomatas") && estrategia.equals("compromissoSocial") && !taticas) {
			pessoa.setPersonalidade("Ativista");
		}
		
		else if(papeis.equals("sentinelas") && estrategia.equals("individualismoConfiante") && natureza) {
			pessoa.setPersonalidade("Logístico");
		}else if(papeis.equals("sentinelas") && estrategia.equals("individualismoConfiante") && !natureza) {
			pessoa.setPersonalidade("Defensor");
		}
		
		else if(papeis.equals("sentinelas") && estrategia.equals("dominioEmPessoas") && natureza) {
			pessoa.setPersonalidade("Executivo");
		}else if(papeis.equals("sentinelas") && estrategia.equals("dominioEmPessoas") && !natureza) {
			pessoa.setPersonalidade("Cônsul");
		}
		
		else if(papeis.equals("sentinelas") && estrategia.equals("melhoriaConstante") && natureza) {
			pessoa.setPersonalidade("Logístico");
		}else if(papeis.equals("sentinelas") && estrategia.equals("melhoriaConstante") && !natureza) {
			pessoa.setPersonalidade("Defensor");
		}
		
		else if(papeis.equals("sentinelas") && estrategia.equals("compromissoSocial") && natureza) {
			pessoa.setPersonalidade("Executivo");
		}else if(papeis.equals("sentinelas") && estrategia.equals("compromissoSocial") && !natureza) {
			pessoa.setPersonalidade("Cônsul");
		}
		
		else if(papeis.equals("exploradores") && estrategia.equals("individualismoConfiante") && natureza) {
			pessoa.setPersonalidade("Virtuoso");
		}else if(papeis.equals("exploradores") && estrategia.equals("individualismoConfiante") && !natureza) {
			pessoa.setPersonalidade("Aventureiro");
		}
		
		else if(papeis.equals("exploradores") && estrategia.equals("dominioEmPessoas") && natureza) {
			pessoa.setPersonalidade("Empresário");
		}else if(papeis.equals("exploradores") && estrategia.equals("dominioEmPessoas") && !natureza) {
			pessoa.setPersonalidade("Animador");
		}
		
		else if(papeis.equals("exploradores") && estrategia.equals("melhoriaConstante") && natureza) {
			pessoa.setPersonalidade("Virtuoso");
		}else if(papeis.equals("exploradores") && estrategia.equals("melhoriaConstante") && !natureza) {
			pessoa.setPersonalidade("Aventureiro");
		}
		
		else if(papeis.equals("exploradores") && estrategia.equals("compromissoSocial") && natureza) {
			pessoa.setPersonalidade("Empresário");
		}else if(papeis.equals("exploradores") && estrategia.equals("compromissoSocial") && !natureza) {
			pessoa.setPersonalidade("Animador");
		}
		
		else {
			pessoa.setPersonalidade("Robô");
		}
	}
	
}
