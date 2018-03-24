package br.com.bookper.coneccoes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente implements Entidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Gerente gerente;
	private String email;
	private String personalidade;

	public Cliente(final Gerente gerente, String email, final String personalidade) {
		this.gerente = gerente;
		if (email == null)
			email = "";
		this.email = email;
		this.personalidade = personalidade;
	}

	public Cliente() {

	}

	public String getPersonalidade() {
		return this.personalidade;
	}

	public void setPersonalidade(final String personalidade) {
		this.personalidade = personalidade;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(final Integer id) {
		this.id = id;
	}

	public Gerente getGerente() {
		return this.gerente;
	}

	public void setGerente(final Gerente gerente) {
		this.gerente = gerente;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

}
