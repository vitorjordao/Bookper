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
import br.com.bookper.dadosnamaquina.ControlaUsuario;
import br.com.bookper.validacoes.ValidarDados;
import javafx.scene.control.Alert.AlertType;

public class ValidaRegistroLivro implements Validar {

	private static final String Personalidades = null;
	private final String nome;
	private final String url;

	public ValidaRegistroLivro(final String nome, final String url) {
		this.nome = nome;
		this.url = url;
	}

	@Override
	public boolean estaOK() {
		final ValidarDados validarDados = new ValidarDados();
		if (validarDados.validaRegistroLivro(this.nome, this.url)) {
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
		final Livro livro = new Livro(this.nome, gerente, this.url);

		final DAO dao = new DAO(em);
		this.criarRank(dao.cadastrar(livro), livro);
		new TelasPopUp(AlertType.CONFIRMATION, "Cadastro", "Livro cadastrado!",
				"Nome: " + this.nome + ", url da imagem: " + this.url + ", gerente: " + gerente.getNome());
		return true;
	}

	private void criarRank(final int id, final Livro livro) {

		final List<RankDaBusca> lista = new ArrayList<>();

		lista.add(new RankDaBusca("Advogado", id));
		lista.add(new RankDaBusca("Animador", id));
		lista.add(new RankDaBusca("Arquiteto", id));
		lista.add(new RankDaBusca("Ativista", id));
		lista.add(new RankDaBusca("Aventureiro", id));
		lista.add(new RankDaBusca("Comandante", id));
		lista.add(new RankDaBusca("Cônsul", id));
		lista.add(new RankDaBusca("Defensor", id));
		lista.add(new RankDaBusca("Empresário", id));
		lista.add(new RankDaBusca("Executivo", id));
		lista.add(new RankDaBusca("Inovador", id));
		lista.add(new RankDaBusca("Lógico", id));
		lista.add(new RankDaBusca("Logistico", id));
		lista.add(new RankDaBusca("Mediador", id));
		lista.add(new RankDaBusca("Protagonista", id));
		lista.add(new RankDaBusca("Robô", id));
		lista.add(new RankDaBusca("Virtuoso", id));
		livro.setRank(lista);
	}

}
