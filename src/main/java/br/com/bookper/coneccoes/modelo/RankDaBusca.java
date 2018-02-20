package br.com.bookper.coneccoes.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RankDaBusca {

	@Id
	private String personalidade;
	private long avaliacao;
	@ManyToOne
	private Livro livro;

	public RankDaBusca() {
	}

	public RankDaBusca(final String personalidade, final long id) {
		this.personalidade = personalidade + id;
	}

	public String getPersonalidade() {
		return this.personalidade;
	}

	public void setPersonalidade(final String personalidade) {
		this.personalidade = personalidade;
	}

	public Long getAvaliacao() {
		return this.avaliacao;
	}

	public void setAvaliacao(final Long avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Livro getLivro() {
		return this.livro;
	}

	public void setLivro(final Livro livro) {
		this.livro = livro;
	}

}
