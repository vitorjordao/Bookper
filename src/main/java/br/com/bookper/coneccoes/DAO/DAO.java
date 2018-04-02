package br.com.bookper.coneccoes.DAO;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

	// public int fecharCadastro(final Entidade entidade) {
	// this.em.getTransaction().commit();
	// this.em.close();
	// return entidade.getId();
	// }

	// public void fecharCadastroPuro() {
	// this.em.getTransaction().commit();
	// this.em.close();
	// }

	public void commit() {
		this.em.getTransaction().commit();
	}

	// public void close() {
	// this.em.close();
	// }

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

	// testar
	public List<Entidade> buscaPorNome(final Entidade entidade, final String nome) {
		final Class<?> c = entidade.getClass();
		for (final Field f : c.getFields()) {
			final String valor = f.getName();
			if (valor.equals("nome")) {
				final String jpql = "select * from :pEntidade m where m.nome = :pNome";

				final TypedQuery<Entidade> query = this.em.createQuery(jpql, Entidade.class);
				query.setParameter("pEntidade", entidade);
				query.setParameter("pNome", nome);

				return query.getResultList();
			}
		}
		throw new RuntimeException("Não existe o atributo \"nome\"");

	}
}
