package br.com.bookper.coneccoes.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bookper.coneccoes.modelo.Livro;
import br.com.bookper.segurancaedados.PermisoesESeguranca;

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

	public List<Livro> pegarTodosOsLivrosComAPermissao() {
		final String jpql = "select m from Livro m where m.gerente = :pGerente";

		final TypedQuery<Livro> query = this.em.createQuery(jpql, Livro.class);

		query.setParameter("pGerente", new GerenteDAO(this.em).buscaEmail(PermisoesESeguranca.getEMAIL()));

		return query.getResultList();
	}

}
