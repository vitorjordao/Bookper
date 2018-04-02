package br.com.bookper.coneccoes.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bookper.classesdastabelas.TabelaLivro;
import br.com.bookper.coneccoes.modelo.Livro;
import br.com.bookper.coneccoes.modelo.RankDaBusca;
import br.com.bookper.segurancaedados.PermisoesESeguranca;

public class LivroDAO {
	private final EntityManager em;

	public LivroDAO(final EntityManager em) {
		this.em = em;
	}

	public List<Livro> pegarTodosOsLivros() {
		final String jpql = "select m from Livro m";

		final TypedQuery<Livro> query = this.em.createQuery(jpql, Livro.class);

		return query.getResultList();
	}

	public List<Livro> pegarTodosOsLivrosComAPermissao() {
		final String jpql = "select m from Livro m where m.gerente = :pGerente";

		final TypedQuery<Livro> query = this.em.createQuery(jpql, Livro.class);

		query.setParameter("pGerente", new GerenteDAO(this.em).buscaEmail(PermisoesESeguranca.getEMAIL()));

		return query.getResultList();
	}

	public void deletarLivro(final TabelaLivro tabelaLivro) {
		final DAO dao = new DAO(this.em);
		final Livro livro = this.pegarOLivro(Integer.parseInt(tabelaLivro.getId()));
		final String jpql = "select f from RankDaBusca f where f.livro = :pLivro";
		final TypedQuery<RankDaBusca> query = this.em.createQuery(jpql, RankDaBusca.class);
		query.setParameter("pLivro", livro);
		dao.abrirCadastro();
		query.getResultList().forEach(rank -> dao.removeEntidade(rank));
		dao.removeEntidade(livro);
		dao.commit();
	}

	private Livro pegarOLivro(final int id) {
		final String jpql = "select m from Livro m where m.id = :pId";

		final TypedQuery<Livro> query = this.em.createQuery(jpql, Livro.class);
		query.setParameter("pId", id);
		return query.getSingleResult();
	}

	public void alterarDados(final int id, final String nomeAutor, final String nomeLivro, final String sinopse,
			final String url) {

		final DAO dao = new DAO(this.em);

		final Livro livro = this.em.find(Livro.class, id);

		livro.setNome(nomeLivro);
		livro.setNomeAutor(nomeAutor);
		livro.setSinopse(sinopse);
		livro.setUrlDaImagem(url);
		dao.cadastrar(livro);
	}

}
