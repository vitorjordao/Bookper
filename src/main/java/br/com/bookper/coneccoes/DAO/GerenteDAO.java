package br.com.bookper.coneccoes.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bookper.coneccoes.modelo.Gerente;
import br.com.bookper.segurancaedados.Criptografia;

public class GerenteDAO {
	private final EntityManager em;

	public GerenteDAO(final EntityManager em) {
		this.em = em;
	}

	public boolean buscarLogin(final String email, final String senha) {
		final String jpql = "select m from Gerente m where m.email = :pEmail";

		final TypedQuery<Gerente> query = this.em.createQuery(jpql, Gerente.class);
		query.setParameter("pEmail", email);
		boolean senhaOk = false;
		try {
			final Gerente gerente = query.getSingleResult();
			senhaOk = Criptografia.validaStringComHash(senha, gerente.getSenha());
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return query.getResultList().size() != 0 && senhaOk;
	}

	public boolean existeEmail(final String email) {
		final String jpql = "select m from Gerente m where m.email = :pEmail";

		final TypedQuery<Gerente> query = this.em.createQuery(jpql, Gerente.class);
		query.setParameter("pEmail", email);

		return query.getResultList().size() != 0;
	}

	public Gerente buscaEmail(final String email) {
		final String jpql = "select m from Gerente m where m.email = :pEmail";

		final TypedQuery<Gerente> query = this.em.createQuery(jpql, Gerente.class);
		query.setParameter("pEmail", email);

		return query.getSingleResult();
	}
}
