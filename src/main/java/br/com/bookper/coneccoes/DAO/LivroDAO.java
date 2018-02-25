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
		final String jpql = "select m from Livro m inner join m.rank";

		final TypedQuery<Livro> query = this.em.createQuery(jpql, Livro.class);
		final List<Livro> listaLivros = query.getResultList();
		final List<Livro> livros = new ArrayList<>();
		for (final Livro livro : listaLivros) {
			livro.getRank().forEach(rank -> {
				if (personalidade.contains(rank.getPersonalidade())) {
					livros.add(livro);
				}
			});
		}

		return livros;
	}

}
