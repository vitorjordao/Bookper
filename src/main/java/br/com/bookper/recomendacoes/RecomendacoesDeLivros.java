package br.com.bookper.recomendacoes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.bookper.coneccoes.DAO.LivroDAO;
import br.com.bookper.coneccoes.modelo.Livro;
import br.com.bookper.coneccoes.modelo.RankDaBusca;
import br.com.bookper.coneccoes.util.JPAUtil;

public class RecomendacoesDeLivros {
	private final EntityManager em = new JPAUtil().getEntityManager();
	private final LivroDAO livroDAO = new LivroDAO(this.em);
	private final String personalidade = GeradorDePersonalidades.getPersonalidade();
	private final List<Livro> livrosComAPersonalidade;

	public RecomendacoesDeLivros() {
		this.livrosComAPersonalidade = this.livroDAO.pegarLivrosComAPersonalidade(this.personalidade);
		if (this.livrosComAPersonalidade.size() == 0)
			this.livrosComAPersonalidade.add(new Livro());
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
		for (final Livro livro : this.livrosComAPersonalidade) {

			int cont = 0;
			for (final RankDaBusca rank : livro.getRank()) {
				if (rank.getPersonalidade().contains(this.personalidade)) {
					final int n = this.livrosComAPersonalidade.size();
					for (int i = 1; i < n; i++) {
						final long cur = this.livrosComAPersonalidade.get(i).getRank().get(cont).getAvaliacao();
						int j = i - 1;
						while (j > 0 && this.livrosComAPersonalidade.get(j).getRank().get(cont).getAvaliacao() > cur) {
							this.livrosComAPersonalidade.get(j + 1).getRank().get(cont).setAvaliacao(
									this.livrosComAPersonalidade.get(--j).getRank().get(cont).getAvaliacao());
						}
						this.livrosComAPersonalidade.get(j + 1).getRank().get(cont).setAvaliacao(cur);
					}
				}
				cont++;
			}
		}

	}

}
