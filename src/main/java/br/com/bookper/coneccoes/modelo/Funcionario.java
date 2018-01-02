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

	public Funcionario() {

	}

	public Funcionario(String nome, String email, String senha, String cargo,
	        Calendar dataDeContratacao,
	        boolean manipulaLivros, boolean manipulaFuncionarios, Gerente gerente) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
		this.dataDeContratacao = dataDeContratacao;
		this.manipulaLivros = manipulaLivros;
		this.manipulaFuncionarios = manipulaFuncionarios;
		this.gerente = gerente;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}
