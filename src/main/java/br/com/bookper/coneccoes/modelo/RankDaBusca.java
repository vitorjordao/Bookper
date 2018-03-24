package br.com.bookper.coneccoes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RankDaBusca implements Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String personalidade;
	private long avaliacao;
	@ManyToOne
	private Livro livro;

	public RankDaBusca() {
	}

	public RankDaBusca(final String personalidade) {
		this.personalidade = personalidade;
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

	public void setAvaliacao(final long avaliacao) {
		this.avaliacao = avaliacao;
	}

	public void somaUm() {
		this.avaliacao++;
	}

	public void subtraiUm() {
		this.avaliacao--;
	}

	public Livro getLivro() {
		return this.livro;
	}

	public void setLivro(final Livro livro) {
		this.livro = livro;
	}

	@Override
	public Integer getId() {
		return this.Id;
	}

	@Override
	public void setId(final Integer id) {
		this.Id = id;
	}

}
