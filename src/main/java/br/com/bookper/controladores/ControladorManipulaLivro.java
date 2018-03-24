package br.com.bookper.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import br.com.bookper.classesdastabelas.TabelaLivro;
import br.com.bookper.coneccoes.DAO.LivroDAO;
import br.com.bookper.coneccoes.modelo.Livro;
import br.com.bookper.coneccoes.util.JPAUtil;
import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.manipulaentidades.ValidaRegistroLivro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;

public class ControladorManipulaLivro implements Initializable {
	private final ControlaTelas tela = new ControlaTelas();
	private final EntityManager em = new JPAUtil().getEntityManager();
	List<Livro> ultimaListaDeLivros;

	@FXML
	private AnchorPane panPrincipal;

	@FXML
	private JFXTextField txtPesquisar;

	@FXML
	private JFXTextField txtCadastrarNomeLivro;

	@FXML
	private JFXTextField txtCadastrarUrl;

	@FXML
	private JFXTreeTableView<TabelaLivro> ttbLivro;

	@FXML
	private JFXTextArea txtSinopse;

	@FXML
	private JFXTextField txtNomeAutor;

	@FXML
	private void clickCadastrar(final ActionEvent event) {
		final String nome = this.txtCadastrarNomeLivro.getText();
		final String url = this.txtCadastrarUrl.getText();
		final String sinopse = this.txtSinopse.getText();
		final String nomeAutor = this.txtNomeAutor.getText();
		final ValidaRegistroLivro registroLivro = new ValidaRegistroLivro(nome, url, sinopse, nomeAutor);
		if (registroLivro.estaOK()) {
			this.ultimaListaDeLivros = this.pegarListaNoBanco();
			this.listarLivros(this.ultimaListaDeLivros);
		}
	}

	@FXML
	private void clickVoltar(final ActionEvent event) throws IOException {
		this.tela.iniciarPadrao("TelaIntermediaria.fxml");
		this.tela.fechar(this.panPrincipal);
	}

	@FXML
	private void clickFechar(final ActionEvent event) {
		this.tela.fechar(this.panPrincipal);
		System.exit(0);
	}

	@FXML
	private void clickPesquisar(final ActionEvent event) {
		this.txtPesquisar.setDisable(true);

		final String textoDaPesquisa = this.txtPesquisar.getText();
		if (textoDaPesquisa.equals("") || textoDaPesquisa == null)
			this.ultimaListaDeLivros = this.pegarListaNoBanco();
		else {
			final List<Livro> listaDaPesquisa = new ArrayList<>();
			this.pegarListaNoBanco().forEach(livro -> {
				if (textoDaPesquisa.contains(livro.getNome()) || textoDaPesquisa.contains(livro.getUrlDaImagem())
						|| textoDaPesquisa.contains(livro.getId() + "")
						|| textoDaPesquisa.contains(livro.getGerente().getNome())) {
					listaDaPesquisa.add(livro);
				}
			});
			this.ultimaListaDeLivros = listaDaPesquisa;
		}
		this.listarLivros(this.ultimaListaDeLivros);
		this.txtPesquisar.setDisable(false);
	}

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		this.ultimaListaDeLivros = this.pegarListaNoBanco();
		this.listarLivros(this.ultimaListaDeLivros);
	}

	private void listarLivros(final List<Livro> livros) {
		final ObservableList<TabelaLivro> listLivroTabela = FXCollections.observableArrayList();
		if (!listLivroTabela.isEmpty())
			listLivroTabela.clear();
		livros.forEach(livro -> {
			listLivroTabela.add(new TabelaLivro(livro.getId(), livro.getNome(), livro.getUrlDaImagem(),
					livro.getGerente(), livro.getRank(), livro.getSinopse(), livro.getNomeAutor()));
		});
		this.adicionaColunasEDados(listLivroTabela);
	}

	private List<Livro> pegarListaNoBanco() {
		return new LivroDAO(this.em).pegarTodosOsLivrosComAPermissao();

	}

	private void adicionaColunasEDados(final ObservableList<TabelaLivro> listLivroTabela) {

		final JFXTreeTableColumn<TabelaLivro, String> colId = new JFXTreeTableColumn<>("#");
		colId.setPrefWidth(30);
		colId.setCellValueFactory(param -> param.getValue().getValue().getIdProperty());

		final JFXTreeTableColumn<TabelaLivro, String> colNome = new JFXTreeTableColumn<>("Nome");
		colNome.setPrefWidth(70);
		colNome.setCellValueFactory(param -> param.getValue().getValue().getNomeProperty());

		final JFXTreeTableColumn<TabelaLivro, String> colGerente = new JFXTreeTableColumn<>("Nome do Gerente");
		colGerente.setPrefWidth(70);
		colGerente.setCellValueFactory(param -> param.getValue().getValue().getGerente());

		final JFXTreeTableColumn<TabelaLivro, String> colUrl = new JFXTreeTableColumn<>("Url da iamegm");
		colUrl.setPrefWidth(70);
		colUrl.setCellValueFactory(param -> param.getValue().getValue().getUrlDaImagem());

		final JFXTreeTableColumn<TabelaLivro, String> colRank = new JFXTreeTableColumn<>("Rank do livro");
		colRank.setPrefWidth(70);
		colRank.setCellValueFactory(param -> param.getValue().getValue().getRank());

		final JFXTreeTableColumn<TabelaLivro, String> colSinopse = new JFXTreeTableColumn<>("Sinopse");
		colRank.setPrefWidth(70);
		colRank.setCellValueFactory(param -> param.getValue().getValue().getSinopse());

		final JFXTreeTableColumn<TabelaLivro, String> colNomeAutor = new JFXTreeTableColumn<>("Nome do autor");
		colRank.setPrefWidth(70);
		colRank.setCellValueFactory(param -> param.getValue().getValue().getNomeAutor());

		final TreeItem<TabelaLivro> root = new RecursiveTreeItem<>(listLivroTabela, RecursiveTreeObject::getChildren);
		this.ttbLivro.getColumns().setAll(colId, colNome, colGerente, colUrl, colRank, colSinopse, colNomeAutor);

		this.ttbLivro.setRoot(root);
		this.ttbLivro.setShowRoot(false);
	}
}
