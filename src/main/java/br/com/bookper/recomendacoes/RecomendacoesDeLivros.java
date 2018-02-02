package br.com.bookper.recomendacoes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.bookper.coneccoes.DAO.LivroDAO;
import br.com.bookper.coneccoes.modelo.Livro;
import br.com.bookper.coneccoes.util.JPAUtil;

public class RecomendacoesDeLivros {
	private final EntityManager em = new JPAUtil().getEntityManager();
	private final LivroDAO livroDAO = new LivroDAO(em);
	private final List<Livro> livrosComAPersonalidade;

	public RecomendacoesDeLivros() {
		livrosComAPersonalidade = livroDAO
		        .pegarLivrosComAPersonalidade(GeradorDePersonalidades.getPersonalidade());
		if (livrosComAPersonalidade.size() == 0)
			livrosComAPersonalidade.add(new Livro());
	}

	public Livro getRecomendacao1() {
		return livrosComAPersonalidade.get(0);
	}

	public Livro getRecomendacao2() {
		if (livrosComAPersonalidade.size() < 3)
			return livrosComAPersonalidade.get(0);
		return livrosComAPersonalidade.get(1);
	}

	public Livro getRecomendacao3() {
		if (livrosComAPersonalidade.size() < 3)
			return livrosComAPersonalidade.get(0);
		return livrosComAPersonalidade.get(2);
	}

}
