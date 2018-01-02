package br.com.bookper.coneccoes.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bookper.coneccoes.modelo.Funcionario;
import br.com.bookper.coneccoes.modelo.Gerente;

public class FuncionarioDAO {
	private EntityManager em;

	public FuncionarioDAO(EntityManager em) {
		this.em = em;
	}

	public boolean buscarLogin(String email, String senha) {
		String jpql = "select m from Funcionario m where m.email = :pEmail and m.senha = :pSenha";

		TypedQuery<Funcionario> query = em.createQuery(jpql, Funcionario.class);
		query.setParameter("pEmail", email);
		query.setParameter("pSenha", senha);

		return query.getResultList().size() != 0;
	}

	public boolean buscarEmail(String email) {
		String jpql = "select m from Funcionario m where m.email = :pEmail";

		TypedQuery<Funcionario> query = em.createQuery(jpql, Funcionario.class);
		query.setParameter("pEmail", email);

		return query.getResultList().size() != 0;
	}

	public Gerente buscarGerente(String email) {
		String jpql = "select m from Funcionario m where m.email = :pEmail";

		TypedQuery<Funcionario> query = em.createQuery(jpql, Funcionario.class);
		query.setParameter("pEmail", email);

		return query.getSingleResult().getGerente();
	}

	public List<Funcionario> pegarTodosOsFuncionarios() {
		String jpql = "select m from Funcionario m";

		TypedQuery<Funcionario> query = em.createQuery(jpql, Funcionario.class);

		return query.getResultList();
	}

}
