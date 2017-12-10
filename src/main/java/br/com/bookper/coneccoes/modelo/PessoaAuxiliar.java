package br.com.bookper.coneccoes.modelo;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PessoaAuxiliar {
	// https://www.16personalities.com/br/a-nossa-teoria
	private String nome;
	private boolean mente;
	private boolean energia;
	private boolean natureza;
	private boolean taticas;
	private boolean identidade;
	private String personalidade;
	private boolean avaliacao;
	private int id;

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
			this.nome = nome;
			return true;
		}
		this.nome = null;
		return false;
	}

	public void setPersonalidades(int i, boolean personalidade) {
		if(i == 1) {
			this.mente = personalidade;
		} else if(i == 2) {
			this.energia = personalidade;
		} else if(i == 3) {
			this.natureza = personalidade;
		} else if(i == 4) {
			this.taticas = personalidade;
		} else if(i == 5) {
			this.identidade = personalidade;
		}
	}

	public String getPersonalidade() {
		return personalidade;
	}

	public void setPersonalidade(String personalidade) {
		this.personalidade = personalidade;
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
		this.avaliacao = avaliacao;
	}

	public void limpar() {
		this.nome = null;
		this.mente = false;
		this.energia = false;
		this.natureza = false;
		this.taticas = false;
		this.identidade = false;
		this.personalidade = null;
		this.avaliacao = false;

	}
	public int getId() {
		int i = this.id++;
		this.id = i;
		return i;

	}
	public void setId(int id) {
		this.id = id;
	}
}