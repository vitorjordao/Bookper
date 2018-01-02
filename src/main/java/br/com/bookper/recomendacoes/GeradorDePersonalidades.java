package br.com.bookper.recomendacoes;

public class GeradorDePersonalidades {
	private boolean mente;
	private boolean energia;
	private boolean natureza;
	private boolean taticas;
	private boolean identidade;
	private String papeis;
	private String estrategia;
	private static String personalidade;

	public String gerarPersonalidade(boolean mente, boolean energia, boolean natureza, boolean taticas,
	        boolean identidade) {
		this.mente = mente;
		this.energia = energia;
		this.natureza = natureza;
		this.taticas = taticas;
		this.identidade = identidade;
		gerarPapeis();
		gerarEstrategia();

		return GeradorDePersonalidades.personalidade = calculosDaTabela();
	}

	private void gerarPapeis() {
		if (energia == true && natureza == true) {
			papeis = "analistas";
		}
		else if (energia == true && natureza == false) {
			papeis = "diplomatas";
		}
		else if (energia == false && taticas == true) {
			papeis = "sentinelas";
		}
		else if (energia == false && taticas == false) {
			papeis = "exploradores";
		}
	}

	private void gerarEstrategia() {
		if (mente == true && identidade == true) {
			estrategia = "individualismoConfiante";
		}
		else if (mente == false && identidade == true) {
			estrategia = "dominioEmPessoas";
		}
		else if (mente == true && identidade == false) {
			estrategia = "melhoriaConstante";
		}
		else if (mente == false && identidade == false) {
			estrategia = "compromissoSocial";
		}
	}

	private String calculosDaTabela() {
		if (papeis.equals("analistas") && estrategia.equals("individualismoConfiante") && taticas) {
			return "Arquiteto";
		}
		else if (papeis.equals("analistas") && estrategia.equals("individualismoConfiante") && !taticas) {
			return "Lógico";
		}

		else if (papeis.equals("analistas") && estrategia.equals("dominioEmPessoas") && taticas) {
			return "Comandante";
		}
		else if (papeis.equals("analistas") && estrategia.equals("dominioEmPessoas") && !taticas) {
			return "Inovador";
		}

		else if (papeis.equals("analistas") && estrategia.equals("melhoriaConstante") && taticas) {
			return "Arquiteto";
		}
		else if (papeis.equals("analistas") && estrategia.equals("melhoriaConstante") && !taticas) {
			return "Lógico";
		}

		else if (papeis.equals("analistas") && estrategia.equals("compromissoSocial") && taticas) {
			return "Comandante";
		}
		else if (papeis.equals("analistas") && estrategia.equals("compromissoSocial") && !taticas) {
			return "Inovador";
		}

		else if (papeis.equals("diplomatas") && estrategia.equals("individualismoConfiante") && taticas) {
			return "Protagonista";
		}
		else if (papeis.equals("diplomatas") && estrategia.equals("individualismoConfiante") && !taticas) {
			return "Mediador";
		}

		else if (papeis.equals("diplomatas") && estrategia.equals("dominioEmPessoas") && taticas) {
			return "Advogado";
		}
		else if (papeis.equals("diplomatas") && estrategia.equals("dominioEmPessoas") && !taticas) {
			return "Ativista";
		}

		else if (papeis.equals("diplomatas") && estrategia.equals("melhoriaConstante") && taticas) {
			return "Protagonista";
		}
		else if (papeis.equals("diplomatas") && estrategia.equals("melhoriaConstante") && !taticas) {
			return "Mediador";
		}

		else if (papeis.equals("diplomatas") && estrategia.equals("compromissoSocial") && taticas) {
			return "Advogado";
		}
		else if (papeis.equals("diplomatas") && estrategia.equals("compromissoSocial") && !taticas) {
			return "Ativista";
		}

		else if (papeis.equals("sentinelas") && estrategia.equals("individualismoConfiante") && natureza) {
			return "Logístico";
		}
		else if (papeis.equals("sentinelas") && estrategia.equals("individualismoConfiante") && !natureza) {
			return "Defensor";
		}

		else if (papeis.equals("sentinelas") && estrategia.equals("dominioEmPessoas") && natureza) {
			return "Executivo";
		}
		else if (papeis.equals("sentinelas") && estrategia.equals("dominioEmPessoas") && !natureza) {
			return "Cônsul";
		}

		else if (papeis.equals("sentinelas") && estrategia.equals("melhoriaConstante") && natureza) {
			return "Logístico";
		}
		else if (papeis.equals("sentinelas") && estrategia.equals("melhoriaConstante") && !natureza) {
			return "Defensor";
		}

		else if (papeis.equals("sentinelas") && estrategia.equals("compromissoSocial") && natureza) {
			return "Executivo";
		}
		else if (papeis.equals("sentinelas") && estrategia.equals("compromissoSocial") && !natureza) {
			return "Cônsul";
		}

		else if (papeis.equals("exploradores") && estrategia.equals("individualismoConfiante") && natureza) {
			return "Virtuoso";
		}
		else if (papeis.equals("exploradores") && estrategia.equals("individualismoConfiante") && !natureza) {
			return "Aventureiro";
		}

		else if (papeis.equals("exploradores") && estrategia.equals("dominioEmPessoas") && natureza) {
			return "Empresário";
		}
		else if (papeis.equals("exploradores") && estrategia.equals("dominioEmPessoas") && !natureza) {
			return "Animador";
		}

		else if (papeis.equals("exploradores") && estrategia.equals("melhoriaConstante") && natureza) {
			return "Virtuoso";
		}
		else if (papeis.equals("exploradores") && estrategia.equals("melhoriaConstante") && !natureza) {
			return "Aventureiro";
		}

		else if (papeis.equals("exploradores") && estrategia.equals("compromissoSocial") && natureza) {
			return "Empresário";
		}
		else if (papeis.equals("exploradores") && estrategia.equals("compromissoSocial") && !natureza) {
			return "Animador";
		}

		else {
			return "Robô";
		}
	}

	public static String getPersonalidade() {
		return personalidade;
	}

}
