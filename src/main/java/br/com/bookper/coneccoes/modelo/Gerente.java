package br.com.bookper.coneccoes.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Gerente implements Entidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private String nomeUnidade;
	@OneToMany(mappedBy = "gerente", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Funcionario> funcionario;
	@OneToMany(mappedBy = "gerente", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Cliente> cliente;
	@OneToMany(mappedBy = "gerente", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Livro> livro;

	public Gerente() {
	}

	public Gerente(final String nome, final String email, final String senha, final String nomeUnidade) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.nomeUnidade = nomeUnidade;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(final Integer id) {
		this.id = id;
	}

	public List<Funcionario> getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(final List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}

	public List<Cliente> getCliente() {
		return this.cliente;
	}

	public void setCliente(final List<Cliente> cliente) {
		this.cliente = cliente;
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

	public String getNomeUnidade() {
		return this.nomeUnidade;
	}

	public void setNomeUnidade(final String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	public List<Livro> getLivro() {
		return this.livro;
	}

	public void setLivro(final List<Livro> livro) {
		this.livro = livro;
	}

}