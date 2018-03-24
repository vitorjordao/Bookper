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
	private boolean manipulaFerramentasAvancadas;

	public Funcionario() {

	}

	public Funcionario(final String nome, final String email, final String senha, final String cargo,
			final Calendar dataDeContratacao, final boolean manipulaLivros, final boolean manipulaFuncionarios,
			final boolean manipulaFerramentasAvancadas, final Gerente gerente) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
		this.dataDeContratacao = dataDeContratacao;
		this.manipulaLivros = manipulaLivros;
		this.manipulaFuncionarios = manipulaFuncionarios;
		this.manipulaFerramentasAvancadas = manipulaFerramentasAvancadas;
		this.gerente = gerente;
	}

	public boolean isManipulaFerramentasAvancadas() {
		return this.manipulaFerramentasAvancadas;
	}

	public void setManipulaFerramentasAvancadas(final boolean manipulaFerramentasAvancadas) {
		this.manipulaFerramentasAvancadas = manipulaFerramentasAvancadas;
	}

	public Gerente getGerente() {
		return this.gerente;
	}

	public void setGerente(final Gerente gerente) {
		this.gerente = gerente;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(final Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(final String cargo) {
		this.cargo = cargo;
	}

	public Calendar getDataDeContratacao() {
		return this.dataDeContratacao;
	}

	public void setDataDeContratacao(final Calendar dataDeContratacao) {
		this.dataDeContratacao = dataDeContratacao;
	}

	public boolean isManipulaLivros() {
		return this.manipulaLivros;
	}

	public void setManipulaLivros(final boolean manipulaLivros) {
		this.manipulaLivros = manipulaLivros;
	}

	public boolean isManipulaFuncionarios() {
		return this.manipulaFuncionarios;
	}

	public void setManipulaFuncionarios(final boolean manipulaFuncionarios) {
		this.manipulaFuncionarios = manipulaFuncionarios;
	}

}
