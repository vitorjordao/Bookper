package br.com.bookper.coneccoes.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bookper.coneccoes.modelo.Cliente;
import br.com.bookper.segurancaedados.PermisoesESeguranca;

public class ClienteDAO {
	private final EntityManager em;

	public ClienteDAO(final EntityManager em) {
		this.em = em;
	}

	public List<Cliente> pegarTodosOsLvrosDesteGerente() {
		final String jpql = "select f from Cliente f where f.gerente = :pGerente";

		final TypedQuery<Cliente> query = this.em.createQuery(jpql, Cliente.class);

		final String email = PermisoesESeguranca.getEMAIL();
		try {
			query.setParameter("pGerente", new FuncionarioDAO(this.em).buscarGerente(email));
		} catch (final Exception e) {
			query.setParameter("pGerente", new GerenteDAO(this.em).buscaEmail(email));
		}
		return query.getResultList();
	}

}
