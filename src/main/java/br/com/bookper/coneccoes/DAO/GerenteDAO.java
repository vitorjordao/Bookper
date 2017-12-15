package br.com.bookper.coneccoes.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bookper.coneccoes.modelo.Gerente;

public class GerenteDAO {
	private EntityManager em;

	public GerenteDAO(EntityManager em) {
		this.em = em;
	}

	public boolean buscarLogin(String email, String senha) {
		String jpql = "select m from Gerente m where m.email = :pEmail and m.senha = :pSenha";

		TypedQuery<Gerente> query = em.createQuery(jpql, Gerente.class);
		query.setParameter("pEmail", email);
		query.setParameter("pSenha", senha);

		return query.getResultList().size() != 0;
	}

	public boolean buscarEmail(String email) {
		String jpql = "select m from Gerente m where m.email = :pEmail";

		TypedQuery<Gerente> query = em.createQuery(jpql, Gerente.class);
		query.setParameter("pEmail", email);

		return query.getResultList().size() != 0;
	}
}
