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
	private Integer avaliacao;
	@OneToMany(mappedBy = "livro", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Personalidade> personalidade;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(final Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public int isAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(final boolean avaliacao) {
		if (avaliacao)
			++this.avaliacao;
		else
			--this.avaliacao;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(final Gerente gerente) {
		this.gerente = gerente;
	}

	public List<Personalidade> getPersonalidade() {
		return personalidade;
	}

	public void setPersonalidade(final List<Personalidade> personalidade) {
		this.personalidade = personalidade;
	}

}
