package br.com.bookper.coneccoes.DAO;

import javax.persistence.EntityManager;

import br.com.bookper.coneccoes.modelo.Entidade;
import br.com.bookper.coneccoes.modelo.Gerente;

public class DAO {
	private final EntityManager em;

	public DAO(final EntityManager em) {
		this.em = em;
	}

	public void abrirCadastro() {
		this.em.getTransaction().begin();
	}

	public int cadastrarEntidade(final Entidade entidade) {
		this.em.persist(entidade);
		return entidade.getId();
	}

	public void removeEntidade(final Entidade entidade) {
		this.em.remove(entidade);
	}

	public void commit() {
		this.em.getTransaction().commit();
	}

	public int cadastrar(final Entidade entidade) {
		this.abrirCadastro();
		final int idEntidade = this.cadastrarEntidade(entidade);
		this.commit();
		return idEntidade;

	}

	public int reSubir(final Entidade entidade) {
		this.em.merge(entidade);
		return entidade.getId();
	}

	public void remover(Entidade entidade, final int id) {
		this.em.getTransaction().begin();
		entidade = this.em.find(Gerente.class, id);
		this.em.remove(entidade);
		this.em.getTransaction().commit();
	}

}
