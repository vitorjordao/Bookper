package br.com.bookper.comparator;

import java.util.Comparator;

import br.com.bookper.coneccoes.modelo.Livro;
import br.com.bookper.coneccoes.modelo.RankDaBusca;

public class OrdenarPorLivro implements Comparator<Livro> {

	private final String classe;
	private long l1;
	private long l2;

	public OrdenarPorLivro(final String classe) {
		this.classe = classe;
	}

	@Override
	public int compare(final Livro livro1, final Livro livro2) {
		for (final RankDaBusca rank : livro1.getRank()) {
			if (rank.getPersonalidade().equals(this.classe))
				this.l1 = rank.getAvaliacao();
		}
		for (final RankDaBusca rank : livro2.getRank()) {
			if (rank.getPersonalidade().equals(this.classe))
				this.l2 = rank.getAvaliacao();
		}
		if (this.l1 > this.l2)
			return -1;
		if (this.l1 < this.l2)
			return 1;
		return 0;
	}

}
