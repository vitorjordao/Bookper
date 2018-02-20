package br.com.bookper.coneccoes.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Livro implements Entidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@ManyToOne
	private Gerente gerente;
	private String urlDaImagem;
	@OneToMany(mappedBy = "livro", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<RankDaBusca> rank;

	public Livro() {
	}

	public Livro(final String nome, final Gerente gerente, final String url) {
		this.nome = nome;
		this.gerente = gerente;
		this.urlDaImagem = url;
	}

	public List<RankDaBusca> getRank() {
		return this.rank;
	}

	public void setRank(final List<RankDaBusca> rank) {
		this.rank = rank;
	}

	public String getUrlDaImagem() {
		return this.urlDaImagem;
	}

	public void setUrlDaImagem(final String urlDaImagem) {
		this.urlDaImagem = urlDaImagem;
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

	public Gerente getGerente() {
		return this.gerente;
	}

	public void setGerente(final Gerente gerente) {
		this.gerente = gerente;
	}

}
