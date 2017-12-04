package br.com.bookper.coneccoes.DAO;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bookper.coneccoes.modelo.Entidade;
import br.com.bookper.coneccoes.modelo.Gerente;

public class DAO {
	private EntityManager em;

	public DAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Entidade entidade) {
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
	}

	public void remover(Entidade entidade, int id) {
		em.getTransaction().begin();
		entidade = em.find(Gerente.class, id);
		em.remove(entidade);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Entidade> buscaPorNome(Entidade entidade, String nome) {
        Class<?> c = entidade.getClass();
        for(Field f : c.getFields()){
        	String valor = f.getName();
        	if(valor.equals("nome")) {
        		String jpql = "select * from :pEntidade m where m.nome = :pNome";

        		TypedQuery<Entidade> query = em.createQuery(jpql, Entidade.class);
        		query.setParameter("pEntidade", entidade);
        		query.setParameter("pNome", nome);

        		return query.getResultList();
        	}
        }
        throw new RuntimeException("Não existe o atributo \"nome\"");
		
	}
}
