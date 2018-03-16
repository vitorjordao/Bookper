package br.com.bookper.controladores;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import br.com.bookper.classesdastabelas.TabelaFuncionario;
import br.com.bookper.coneccoes.DAO.DAO;
import br.com.bookper.coneccoes.DAO.FuncionarioDAO;
import br.com.bookper.coneccoes.modelo.Funcionario;
import br.com.bookper.coneccoes.util.JPAUtil;
import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.manipulaentidades.ValidaRegistroFuncionario;
import br.com.bookper.segurancaedados.Criptografia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;

public class ControladorManipulaFuncionario implements Initializable {
	private final ControlaTelas tela = new ControlaTelas();
	private final EntityManager em = new JPAUtil().getEntityManager();
	FuncionarioDAO funcionarioDao = new FuncionarioDAO(this.em);
	List<Funcionario> ultimaListaDeFuncionarios = this.funcionarioDao.pegarTodosOsFuncionarios();
	DAO dao = new DAO(this.em);

	@FXML
	private AnchorPane panPrincipal;

	@FXML
	private JFXTextField txtCadastrarNomeFuncionario;

	@FXML
	private JFXTextField txtCadastrarSenhaFuncionario;

	@FXML
	private JFXTextField txtCadastrarEmailFuncionario;

	@FXML
	private JFXTextField txtCadastrarCargoFuncionario;

	@FXML
	private JFXTextField txtPesquisar;

	@FXML
	private JFXDatePicker dpCadastrarDataFuncionario;

	@FXML
	private JFXToggleButton tgCadastrarManipulaLivroFuncionario;

	@FXML
	private JFXToggleButton tgCadastrarManipulaFuncionariosFuncionario;

	@FXML
	private JFXToggleButton tgCadastrarManipulaFerramentasAvancadasFuncionario;

	@FXML
	private JFXTreeTableView<TabelaFuncionario> ttbFuncionario;

	@FXML
	private void clickCadastrar(final ActionEvent event) {

		final String nome = this.txtCadastrarNomeFuncionario.getText();
		final String senha = Criptografia.transformaStringEmHash(this.txtCadastrarSenhaFuncionario.getText());
		final String email = this.txtCadastrarEmailFuncionario.getText();
		final String cargo = this.txtCadastrarCargoFuncionario.getText();
		final LocalDate data = this.dpCadastrarDataFuncionario.getValue();
		final boolean manipulaLivros = this.tgCadastrarManipulaLivroFuncionario.isSelected();
		final boolean manipulaFuncionarios = this.tgCadastrarManipulaFuncionariosFuncionario.isSelected();
		final boolean manipulaFerramentasAvancadas = this.tgCadastrarManipulaFerramentasAvancadasFuncionario
				.isSelected();
		final ValidaRegistroFuncionario registroFuncionario = new ValidaRegistroFuncionario(nome, senha, email, cargo,
				data, manipulaLivros, manipulaFuncionarios, manipulaFerramentasAvancadas);
		if (registroFuncionario.estaOK()) {
			this.ultimaListaDeFuncionarios = this.pegarListaNoBanco();
			this.listarFuncionarios(this.ultimaListaDeFuncionarios);
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
	private void clickDeletarFuncionario(final ActionEvent event) {
		final TabelaFuncionario tabelaFuncionario = this.ttbFuncionario.getSelectionModel().getSelectedItem()
				.getValue();
		final Funcionario funcionario = this.funcionarioDao
				.pegarOFuncionario(Integer.parseInt(tabelaFuncionario.getId()));
		this.dao.abrirCadastro();
		this.dao.removeEntidade(funcionario);
		this.dao.fecharCadastroPuro();
		this.ultimaListaDeFuncionarios = this.pegarListaNoBanco();
		this.listarFuncionarios(this.ultimaListaDeFuncionarios);
	}

	@FXML
	private void clickAlterarFuncionario(final ActionEvent event) {
		this.tela.fechar(this.panPrincipal);
		System.exit(0);
	}

	@FXML
	private void clickPesquisar(final ActionEvent event) {
		this.txtPesquisar.setDisable(true);

		final String textoDaPesquisa = this.txtPesquisar.getText();
		if (textoDaPesquisa.equals("") || textoDaPesquisa == null)
			this.ultimaListaDeFuncionarios = this.pegarListaNoBanco();
		else {
			final List<Funcionario> listaDaPesquisa = new ArrayList<>();
			this.pegarListaNoBanco().forEach(funcionario -> {
				if (textoDaPesquisa.contains(funcionario.getNome()) || textoDaPesquisa.contains(funcionario.getSenha())
						|| textoDaPesquisa.contains(funcionario.getEmail())
						|| textoDaPesquisa.contains(funcionario.getCargo())
						|| textoDaPesquisa.contains(funcionario.getDataDeContratacao().getTime().toString())
						|| textoDaPesquisa.contains(funcionario.isManipulaLivros() + "")
						|| textoDaPesquisa.contains(funcionario.isManipulaFuncionarios() + "")) {
					listaDaPesquisa.add(funcionario);
				}
			});
			this.ultimaListaDeFuncionarios = listaDaPesquisa;
		}
		this.listarFuncionarios(this.ultimaListaDeFuncionarios);
		this.txtPesquisar.setDisable(false);
	}

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		this.ultimaListaDeFuncionarios = this.pegarListaNoBanco();
		this.listarFuncionarios(this.ultimaListaDeFuncionarios);
	}

	private void listarFuncionarios(final List<Funcionario> funcionarios) {
		final ObservableList<TabelaFuncionario> listFuncionarioTabela = FXCollections.observableArrayList();
		if (!listFuncionarioTabela.isEmpty())
			listFuncionarioTabela.clear();
		funcionarios.forEach(funcionario -> {
			listFuncionarioTabela.add(new TabelaFuncionario(funcionario.getId(), funcionario.getNome(),
					funcionario.getEmail(), funcionario.getSenha(), funcionario.getCargo(),
					funcionario.getDataDeContratacao(), funcionario.isManipulaLivros(),
					funcionario.isManipulaFuncionarios(), funcionario.isManipulaFerramentasAvancadas()));
		});
		this.adicionaColunasEDados(listFuncionarioTabela);
	}

	private List<Funcionario> pegarListaNoBanco() {
		return new FuncionarioDAO(this.em).pegarTodosOsFuncionariosMenosEste();

	}

	private void adicionaColunasEDados(final ObservableList<TabelaFuncionario> listFuncionarioTabela) {

		final JFXTreeTableColumn<TabelaFuncionario, String> colId = new JFXTreeTableColumn<>("#");
		colId.setPrefWidth(30);
		colId.setCellValueFactory(param -> param.getValue().getValue().getIdProperty());

		final JFXTreeTableColumn<TabelaFuncionario, String> colNome = new JFXTreeTableColumn<>("Nome");
		colNome.setPrefWidth(70);
		colNome.setCellValueFactory(param -> param.getValue().getValue().getNomeProperty());

		final JFXTreeTableColumn<TabelaFuncionario, String> colSenha = new JFXTreeTableColumn<>("Senha");
		colSenha.setPrefWidth(70);
		colSenha.setCellValueFactory(param -> param.getValue().getValue().getSenhaProperty());

		final JFXTreeTableColumn<TabelaFuncionario, String> colEmail = new JFXTreeTableColumn<>("Email");
		colEmail.setPrefWidth(70);
		colEmail.setCellValueFactory(param -> param.getValue().getValue().getEmailProperty());

		final JFXTreeTableColumn<TabelaFuncionario, String> colCargo = new JFXTreeTableColumn<>("Cargo");
		colCargo.setPrefWidth(70);
		colCargo.setCellValueFactory(param -> param.getValue().getValue().getCargoProperty());

		final JFXTreeTableColumn<TabelaFuncionario, String> colDataDeContratacao = new JFXTreeTableColumn<>(
				"Data de contratação");
		colDataDeContratacao.setPrefWidth(70);
		colDataDeContratacao.setCellValueFactory(param -> param.getValue().getValue().getDataProperty());

		final JFXTreeTableColumn<TabelaFuncionario, String> colManipulaLivros = new JFXTreeTableColumn<>(
				"Manipula livros");
		colManipulaLivros.setPrefWidth(110);
		colManipulaLivros.setCellValueFactory(param -> param.getValue().getValue().getManipulaLivrosProperty());

		final JFXTreeTableColumn<TabelaFuncionario, String> colManipulaFuncionarios = new JFXTreeTableColumn<>(
				"Manipula funcionarios");
		colManipulaFuncionarios.setPrefWidth(120);
		colManipulaFuncionarios
				.setCellValueFactory(param -> param.getValue().getValue().getManipulaFuncionariosProperty());

		final JFXTreeTableColumn<TabelaFuncionario, String> colManipulaFerramentasAvancadas = new JFXTreeTableColumn<>(
				"Manipula ferramentas avancadas");
		colManipulaFerramentasAvancadas.setPrefWidth(120);
		colManipulaFerramentasAvancadas
				.setCellValueFactory(param -> param.getValue().getValue().getManipulaFerramentasAvancadasProperty());

		final JFXTreeTableColumn<TabelaFuncionario, JFXButton> colAlteraRemoveFuncionario = new JFXTreeTableColumn<>(
				"Altera/Remove");
		colAlteraRemoveFuncionario.setPrefWidth(70);
		colAlteraRemoveFuncionario.setCellValueFactory(param -> param.getValue().getValue().getJfxButton());

		final TreeItem<TabelaFuncionario> root = new RecursiveTreeItem<>(listFuncionarioTabela,
				RecursiveTreeObject::getChildren);
		this.ttbFuncionario.getColumns().setAll(colId, colNome, colEmail, colCargo, colDataDeContratacao,
				colManipulaLivros, colManipulaFuncionarios, colManipulaFerramentasAvancadas,
				colAlteraRemoveFuncionario);

		this.ttbFuncionario.setRoot(root);
		this.ttbFuncionario.setShowRoot(false);
	}

}
