package br.com.bookper.controladores;

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
import br.com.bookper.controladores.telas.TelasPopUp;
import br.com.bookper.validacoes.ValidarDados;
import br.com.bookper.validaentidades.ValidaRegistroLivro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;

public class ControladorManipulaLivro implements Initializable {
	private final ControlaTelas tela = new ControlaTelas();
	private final EntityManager em = new JPAUtil().getEntityManager();
	private final LivroDAO livroDao = new LivroDAO(this.em);
	private List<Livro> ultimaListaDeLivros = this.livroDao.pegarTodosOsLivros();

	@FXML
	private AnchorPane panPrincipal;

	@FXML
	private JFXTextField txtPesquisar;

	@FXML
	private JFXTextField txtCadastrarNomeLivro;

	@FXML
	private JFXTextField txtCadastrarUrl;

	@FXML
	private JFXTextArea txtCadastrarSinopse;

	@FXML
	private JFXTextField txtCadastrarNomeAutor;

	@FXML
	private JFXTextField txtAlterarNomeLivro;

	@FXML
	private JFXTextField txtAlterarUrl;

	@FXML
	private JFXTextArea txtAlterarSinopse;

	@FXML
	private JFXTextField txtAlterarNomeAutor;

	@FXML
	private Label lblId;

	@FXML
	private Tab tbAlterarLivro;

	@FXML
	private JFXTreeTableView<TabelaLivro> ttbLivro;

	@FXML
	private TabPane tabPane;

	@FXML
	private void clickCadastrar(final ActionEvent event) {
		final String nome = this.txtCadastrarNomeLivro.getText();
		final String url = this.txtCadastrarUrl.getText();
		final String sinopse = this.txtCadastrarSinopse.getText();
		final String nomeAutor = this.txtCadastrarNomeAutor.getText();
		final ValidaRegistroLivro registroLivro = new ValidaRegistroLivro(nome, url, sinopse, nomeAutor);
		if (registroLivro.estaOK()) {
			this.ultimaListaDeLivros = this.pegarListaNoBanco();
			this.listarLivros(this.ultimaListaDeLivros);

			this.txtCadastrarNomeLivro.setText("");
			this.txtCadastrarUrl.setText("");
			this.txtCadastrarSinopse.setText("");
			this.txtCadastrarNomeAutor.setText("");
		}
	}

	@FXML
	private void clickVoltar(final ActionEvent event) {
		this.tela.iniciarPadrao("TelaIntermediaria.fxml");
		this.tela.fechar(this.panPrincipal);
	}

	@FXML
	private void clickDeletarLivro(final ActionEvent event) {
		this.lblId.setText("");
		this.txtAlterarNomeLivro.setText("");
		this.txtAlterarUrl.setText("");
		this.txtAlterarSinopse.setText("");
		this.txtAlterarNomeAutor.setText("");

		final TabelaLivro livro = this.ttbLivro.getSelectionModel().getSelectedItem().getValue();
		this.livroDao.deletarLivro(livro);
		this.ultimaListaDeLivros = this.pegarListaNoBanco();
		this.listarLivros(this.ultimaListaDeLivros);
		TelasPopUp.telaPadrao(AlertType.INFORMATION, "Deletado", "Livro deletado!",
				"Livro deletado: " + livro.getNome());
	}

	@FXML
	private void clickAlterarLivro(final ActionEvent event) {
		final TabelaLivro tabelaLivro = this.ttbLivro.getSelectionModel().getSelectedItem().getValue();

		final String id = tabelaLivro.getId();
		final String nomeAutor = tabelaLivro.getNomeAutor();
		final String nome = tabelaLivro.getNome();
		final String sinopse = tabelaLivro.getSinopse();
		final String url = tabelaLivro.getUrlDaImagem();

		this.lblId.setText(id);
		this.txtAlterarNomeAutor.setText(nomeAutor);
		this.txtAlterarNomeLivro.setText(nome);
		this.txtAlterarSinopse.setText(sinopse);
		this.txtAlterarUrl.setText(url);

		this.tbAlterarLivro.setDisable(false);

		final SingleSelectionModel<Tab> selectionModel = this.tabPane.getSelectionModel();

		selectionModel.select(this.tbAlterarLivro);
		this.txtAlterarNomeLivro.requestFocus();
	}

	@FXML
	private void clickAlterar(final ActionEvent event) {
		final String id = this.lblId.getText();

		final String nomeAutor = this.txtAlterarNomeAutor.getText();
		final String livro = this.txtAlterarNomeLivro.getText();
		final String sinopse = this.txtAlterarSinopse.getText();
		final String url = this.txtAlterarUrl.getText();

		final ValidarDados validarDados = new ValidarDados();
		if (validarDados.validaLivro(livro, url, nomeAutor) && !id.equals("")) {
			this.livroDao.alterarDados(Integer.parseInt(id), nomeAutor, livro, sinopse, url);
			this.ultimaListaDeLivros = this.pegarListaNoBanco();
			this.listarLivros(this.ultimaListaDeLivros);
			TelasPopUp.telaPadrao(AlertType.INFORMATION, "Alterado", "Livro alterado!",
					"Livro " + livro + " alterado com sucesso!");

			this.lblId.setText("");
			this.txtAlterarNomeLivro.setText("");
			this.txtAlterarUrl.setText("");
			this.txtAlterarSinopse.setText("");
			this.txtAlterarNomeAutor.setText("");
		} else
			TelasPopUp.telaPadrao(AlertType.ERROR, "Alteracao", "Erro ao alterar o livro", validarDados.getValidado());

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

	@SuppressWarnings("unchecked")
	private void adicionaColunasEDados(final ObservableList<TabelaLivro> listLivroTabela) {

		final JFXTreeTableColumn<TabelaLivro, String> colId = new JFXTreeTableColumn<>("#");
		colId.setPrefWidth(30);
		colId.setCellValueFactory(param -> param.getValue().getValue().getIdProperty());

		final JFXTreeTableColumn<TabelaLivro, String> colNome = new JFXTreeTableColumn<>("Nome");
		colNome.setPrefWidth(70);
		colNome.setCellValueFactory(param -> param.getValue().getValue().getNomeProperty());

		final JFXTreeTableColumn<TabelaLivro, String> colUrl = new JFXTreeTableColumn<>("Url da imagem");
		colUrl.setPrefWidth(70);
		colUrl.setCellValueFactory(param -> param.getValue().getValue().getUrlDaImagemProperty());

		final JFXTreeTableColumn<TabelaLivro, String> colRank = new JFXTreeTableColumn<>("Rank do livro");
		colRank.setPrefWidth(70);
		colRank.setCellValueFactory(param -> param.getValue().getValue().getRankProperty());

		final JFXTreeTableColumn<TabelaLivro, String> colSinopse = new JFXTreeTableColumn<>("Sinopse");
		colSinopse.setPrefWidth(70);
		colSinopse.setCellValueFactory(param -> param.getValue().getValue().getSinopseProperty());

		final JFXTreeTableColumn<TabelaLivro, String> colNomeAutor = new JFXTreeTableColumn<>("Nome do autor");
		colNomeAutor.setPrefWidth(70);
		colNomeAutor.setCellValueFactory(param -> param.getValue().getValue().getNomeAutorProperty());

		final TreeItem<TabelaLivro> root = new RecursiveTreeItem<>(listLivroTabela, RecursiveTreeObject::getChildren);
		this.ttbLivro.getColumns().setAll(colId, colNome, colUrl, colRank, colSinopse, colNomeAutor);

		this.ttbLivro.setRoot(root);
		this.ttbLivro.setShowRoot(false);
	}
}
