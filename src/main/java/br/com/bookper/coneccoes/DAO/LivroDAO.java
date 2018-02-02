package br.com.bookper.coneccoes.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bookper.coneccoes.modelo.Livro;

public class LivroDAO {
	private final EntityManager em;

	public LivroDAO(final EntityManager em) {
		this.em = em;
	}

	public List<Livro> pegarTodosOsLivros() {
		final String jpql = "select m from Livro m";

		final TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);

		return query.getResultList();
	}

	public List<Livro> pegarLivrosComAPersonalidade(final String personalidade) {
		final String jpql = "select m from Livro m, Personalidade p where p.personalidade = :pPersonalidade";

		final TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
		query.setParameter("pPersonalidade", personalidade);

		return query.getResultList();
	}

}
