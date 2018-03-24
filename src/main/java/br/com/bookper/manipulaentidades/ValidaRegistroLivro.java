package br.com.bookper.manipulaentidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.bookper.coneccoes.DAO.DAO;
import br.com.bookper.coneccoes.DAO.FuncionarioDAO;
import br.com.bookper.coneccoes.DAO.GerenteDAO;
import br.com.bookper.coneccoes.modelo.Gerente;
import br.com.bookper.coneccoes.modelo.Livro;
import br.com.bookper.coneccoes.modelo.RankDaBusca;
import br.com.bookper.coneccoes.util.JPAUtil;
import br.com.bookper.controladores.telas.TelasPopUp;
import br.com.bookper.segurancaedados.ControlaUsuario;
import br.com.bookper.validacoes.ValidarDados;
import javafx.scene.control.Alert.AlertType;

public class ValidaRegistroLivro implements Validar {

	private final String nome;
	private final String url;
	private final String sinopse;
	private final String nomeAutor;

	public ValidaRegistroLivro(final String nome, final String url, final String sinopse, final String nomeAutor) {
		this.nome = nome;
		this.url = url;
		this.sinopse = sinopse;
		this.nomeAutor = nomeAutor;
	}

	@Override
	public boolean estaOK() {
		final ValidarDados validarDados = new ValidarDados();
		if (validarDados.validaRegistroLivro(this.nome, this.url, this.nomeAutor)) {
			return this.procurarNoBD();
		} else {
			new TelasPopUp(AlertType.ERROR, "Cadastro", "Erro no cadastro", validarDados.getValidado());
		}
		return false;
	}

	private boolean procurarNoBD() {
		final EntityManager em = new JPAUtil().getEntityManager();
		final ControlaUsuario controlaUsuario = new ControlaUsuario();
		final GerenteDAO gerenteDAO = new GerenteDAO(em);
		new FuncionarioDAO(em);
		final Scanner emailGerente = controlaUsuario.getCredenciais();
		emailGerente.nextLine();
		emailGerente.nextLine();
		emailGerente.nextLine();
		final String email = emailGerente.nextLine();
		final Gerente gerente = gerenteDAO.buscaEmail(email);
		final Livro livro = new Livro(this.nome, gerente, this.url, this.nomeAutor, this.sinopse);
		final List<RankDaBusca> ranks = this.criarRank(livro);

		final DAO dao = new DAO(em);
		dao.abrirCadastro();
		final int id = dao.cadastrarEntidade(livro);
		livro.setId(id);

		ranks.forEach(rank -> {
			rank.setLivro(livro);
			dao.cadastrarEntidade(rank);
		});
		dao.fecharCadastro(livro);

		new TelasPopUp(AlertType.CONFIRMATION, "Cadastro", "Livro cadastrado!",
				"Nome: " + this.nome + ", url da imagem: " + this.url + ", gerente: " + gerente.getNome());
		return true;
	}

	private List<RankDaBusca> criarRank(final Livro livro) {

		final List<RankDaBusca> lista = new ArrayList<>();

		lista.add(new RankDaBusca("Advogado"));
		lista.add(new RankDaBusca("Animador"));
		lista.add(new RankDaBusca("Arquiteto"));
		lista.add(new RankDaBusca("Ativista"));
		lista.add(new RankDaBusca("Aventureiro"));
		lista.add(new RankDaBusca("Comandante"));
		lista.add(new RankDaBusca("Cônsul"));
		lista.add(new RankDaBusca("Defensor"));
		lista.add(new RankDaBusca("Empresário"));
		lista.add(new RankDaBusca("Executivo"));
		lista.add(new RankDaBusca("Inovador"));
		lista.add(new RankDaBusca("Lógico"));
		lista.add(new RankDaBusca("Logistico"));
		lista.add(new RankDaBusca("Mediador"));
		lista.add(new RankDaBusca("Protagonista"));
		lista.add(new RankDaBusca("Robô"));
		lista.add(new RankDaBusca("Virtuoso"));
		livro.setRank(lista);
		return lista;
	}

}
