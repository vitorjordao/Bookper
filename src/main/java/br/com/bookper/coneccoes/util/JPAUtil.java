package br.com.bookper.coneccoes.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookper");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
