package br.com.bookper.coneccoes.DAO;

import java.util.ArrayList;
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

		final TypedQuery<Livro> query = this.em.createQuery(jpql, Livro.class);

		return query.getResultList();
	}

	public List<Livro> pegarLivrosComAPersonalidade(final String personalidade) {
		final List<Livro> query = this.pegarTodosOsLivros();
		final List<Livro> livros = new ArrayList<>();
		for (final Livro livro : query) {
			livro.getRank().forEach(rank -> {
				if (personalidade.equals(rank.getPersonalidade())) {
					livros.add(livro);
				}
			});
		}

		return livros;
	}

}
