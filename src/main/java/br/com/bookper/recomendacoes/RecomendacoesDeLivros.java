package br.com.bookper.recomendacoes;

import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.bookper.comparator.OrdenarPorLivro;
import br.com.bookper.coneccoes.DAO.LivroDAO;
import br.com.bookper.coneccoes.modelo.Livro;
import br.com.bookper.coneccoes.util.JPAUtil;

public class RecomendacoesDeLivros {
	private final EntityManager em = new JPAUtil().getEntityManager();
	private final LivroDAO livroDAO = new LivroDAO(this.em);
	private final String personalidade = GeradorDePersonalidades.getPersonalidade();
	private final List<Livro> livrosComAPersonalidade;

	public RecomendacoesDeLivros() {
		this.livrosComAPersonalidade = this.livroDAO.pegarTodosOsLivros();
		if (this.livrosComAPersonalidade.size() == 0)
			this.livrosComAPersonalidade.add(new Livro());
		else
			this.calculo();

	}

	public Livro getRecomendacao1() {
		return this.livrosComAPersonalidade.get(0);
	}

	public Livro getRecomendacao2() {

		if (this.livrosComAPersonalidade.size() < 3)
			return this.livrosComAPersonalidade.get(0);
		return this.livrosComAPersonalidade.get(1);

	}

	public Livro getRecomendacao3() {
		if (this.livrosComAPersonalidade.size() < 3)
			return this.livrosComAPersonalidade.get(0);
		return this.livrosComAPersonalidade.get(2);
	}

	public void calculo() {
		final Comparator<Livro> comparador = new OrdenarPorLivro(this.personalidade);
		this.livrosComAPersonalidade.sort(comparador);
	}

}
