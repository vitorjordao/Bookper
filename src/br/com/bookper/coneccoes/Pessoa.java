package br.com.bookper.coneccoes;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Pessoa {
	// https://www.16personalities.com/br/a-nossa-teoria
	private static String nome;
	private static boolean mente;
	private static boolean energia;
	private static boolean natureza;
	private static boolean taticas;
	private static boolean identidade;
	private static String personalidade;
	private static boolean avaliacao;
	private static int id;

	public String getNome() {
		return nome;
	}
	public boolean setNome(String nome) {
		final JPanel panel = new JPanel();
		if(nome.equals("")) {
			JOptionPane.showMessageDialog(panel, "Digite um nome!", "Erro no nome", JOptionPane.ERROR_MESSAGE);
		}else if(nome.length()<3 || nome.length()>30) {
			JOptionPane.showMessageDialog(panel, "O nome digitado é inválido!", "Erro no nome", JOptionPane.ERROR_MESSAGE);
		}else {
			Pessoa.nome = nome;
			return true;
		}
		Pessoa.nome = null;
		return false;
	}

	public void setPersonalidades(int i, boolean personalidade) {
		if(i == 1) {
			Pessoa.mente = personalidade;
		} else if(i == 2) {
			Pessoa.energia = personalidade;
		} else if(i == 3) {
			Pessoa.natureza = personalidade;
		} else if(i == 4) {
			Pessoa.taticas = personalidade;
		} else if(i == 5) {
			Pessoa.identidade = personalidade;
		}
	}

	public String getPersonalidade() {
		return personalidade;
	}

	public void setPersonalidade(String personalidade) {
		Pessoa.personalidade = personalidade;
	}
	public boolean isMente() {
		return mente;
	}
	public boolean isEnergia() {
		return energia;
	}
	public boolean isNatureza() {
		return natureza;
	}
	public boolean isTaticas() {
		return taticas;
	}
	public boolean isIdentidade() {
		return identidade;
	}
	public boolean isAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(boolean avaliacao) {
		Pessoa.avaliacao = avaliacao;
	}

	public void limpar() {
		Pessoa.nome = null;
		Pessoa.mente = false;
		Pessoa.energia = false;
		Pessoa.natureza = false;
		Pessoa.taticas = false;
		Pessoa.identidade = false;
		Pessoa.personalidade = null;
		Pessoa.avaliacao = false;

	}
	public int getId() {
		int i = Pessoa.id++;
		Pessoa.id = i;
		return i;

	}
	public void setId(int id) {
		Pessoa.id = id;
	}
}