package br.com.bookper.coneccoes.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Funcionario implements Entidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private String cargo;
	@Temporal(TemporalType.DATE)
	private Calendar dataDeContratacao;
	private boolean manipulaLivros;
	private boolean manipulaFuncionarios;
	@ManyToOne
	private Gerente gerente;

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Calendar getDataDeContratacao() {
		return dataDeContratacao;
	}

	public void setDataDeContratacao(Calendar dataDeContratacao) {
		this.dataDeContratacao = dataDeContratacao;
	}

	public boolean isManipulaLivros() {
		return manipulaLivros;
	}

	public void setManipulaLivros(boolean manipulaLivros) {
		this.manipulaLivros = manipulaLivros;
	}

	public boolean isManipulaFuncionarios() {
		return manipulaFuncionarios;
	}

	public void setManipulaFuncionarios(boolean manipulaFuncionarios) {
		this.manipulaFuncionarios = manipulaFuncionarios;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
