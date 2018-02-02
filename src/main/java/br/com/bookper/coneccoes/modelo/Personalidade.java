package br.com.bookper.coneccoes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Personalidade implements Entidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Livro livro;
	private String personalidade;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(final Integer id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(final Livro livro) {
		this.livro = livro;
	}

	public String getPersonalidade() {
		return personalidade;
	}

	public void setPersonalidade(final String personalidade) {
		this.personalidade = personalidade;
	}

}
