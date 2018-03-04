package br.com.bookper.coneccoes.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bookper.coneccoes.modelo.Funcionario;
import br.com.bookper.coneccoes.modelo.Gerente;
import br.com.bookper.segurancaedados.Criptografia;

public class FuncionarioDAO {
	private final EntityManager em;

	public FuncionarioDAO(final EntityManager em) {
		this.em = em;
	}

	public boolean buscarLogin(final String email, final String senha) {
		final String jpql = "select m from Funcionario m where m.email = :pEmail";

		final TypedQuery<Funcionario> query = this.em.createQuery(jpql, Funcionario.class);
		query.setParameter("pEmail", email);
		boolean senhaOk = false;
		try {
			final Funcionario funcionario = query.getSingleResult();
			senhaOk = Criptografia.validaStringComHash(senha, funcionario.getSenha());
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return query.getResultList().size() != 0 && senhaOk;
	}

	public Funcionario buscarLogin(final String email) {
		final String jpql = "select m from Funcionario m where m.email = :pEmail";

		final TypedQuery<Funcionario> query = this.em.createQuery(jpql, Funcionario.class);
		query.setParameter("pEmail", email);
		try {
			final Funcionario funcionario = query.getSingleResult();
			return funcionario;
		} catch (final Exception e) {
			e.printStackTrace();
			return new Funcionario();
		}
	}

	public boolean buscarEmail(final String email) {
		final String jpql = "select m from Funcionario m where m.email = :pEmail";

		final TypedQuery<Funcionario> query = this.em.createQuery(jpql, Funcionario.class);
		query.setParameter("pEmail", email);

		return query.getResultList().size() != 0;
	}

	public Gerente buscarGerente(final String email) {
		final String jpql = "select m from Funcionario m where m.email = :pEmail";

		final TypedQuery<Funcionario> query = this.em.createQuery(jpql, Funcionario.class);
		query.setParameter("pEmail", email);

		return query.getSingleResult().getGerente();
	}

	public List<Funcionario> pegarTodosOsFuncionarios() {
		final String jpql = "select m from Funcionario m";

		final TypedQuery<Funcionario> query = this.em.createQuery(jpql, Funcionario.class);

		return query.getResultList();
	}

}
