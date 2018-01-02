package br.com.bookper.controladores;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import br.com.bookper.classesdastabelas.TabelaFuncionario;
import br.com.bookper.coneccoes.DAO.FuncionarioDAO;
import br.com.bookper.coneccoes.modelo.Funcionario;
import br.com.bookper.coneccoes.util.JPAUtil;
import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.manipulaentidades.ValidaRegistroFuncionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;

public class ControladorManipulaFuncionario implements Initializable {
	private ControlaTelas tela = new ControlaTelas();
	private EntityManager em = new JPAUtil().getEntityManager();
	List<Funcionario> ultimaListaDeFuncionarios = new FuncionarioDAO(em).pegarTodosOsFuncionarios();

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
	private JFXTreeTableView<TabelaFuncionario> ttbFuncionario;

	@FXML
	private void clickCadastrar(ActionEvent event) {
		String nome = txtCadastrarNomeFuncionario.getText();
		String senha = txtCadastrarSenhaFuncionario.getText();
		String email = txtCadastrarEmailFuncionario.getText();
		String cargo = txtCadastrarCargoFuncionario.getText();
		LocalDate data = dpCadastrarDataFuncionario.getValue();
		boolean manipulaLivro = tgCadastrarManipulaLivroFuncionario.isSelected();
		boolean manipulaFuncionarios = tgCadastrarManipulaFuncionariosFuncionario.isSelected();
		ValidaRegistroFuncionario registroFuncionario = new ValidaRegistroFuncionario(nome, senha, email, cargo, data,
		        manipulaLivro, manipulaFuncionarios);
		if (registroFuncionario.estaOK()) {
			listarFuncionarios(ultimaListaDeFuncionarios);
		}
	}

	@FXML
	private void clickVoltar(ActionEvent event) throws IOException {
		tela.iniciarPadrao("TelaIntermediaria.fxml");
		tela.fechar(panPrincipal);
	}

	@FXML
	private void clickFechar(ActionEvent event) {
		tela.fechar(panPrincipal);
		System.exit(0);
	}

	@FXML
	private void clickPesquisar(ActionEvent event) {
		txtPesquisar.setDisable(true);

		String textoDaPesquisa = txtPesquisar.getText();
		if (textoDaPesquisa.equals("") || textoDaPesquisa == null)
			ultimaListaDeFuncionarios = pegarListaNoBanco();
		else {
			List<Funcionario> listaDaPesquisa = new ArrayList<>();
			pegarListaNoBanco().forEach(funcionario -> {
				if (textoDaPesquisa.contains(funcionario.getNome()) || textoDaPesquisa.contains(funcionario.getSenha())
				        || textoDaPesquisa.contains(funcionario.getEmail())
				        || textoDaPesquisa.contains(funcionario.getCargo())
				        || textoDaPesquisa.contains(funcionario.getDataDeContratacao().getTime().toString())
				        || textoDaPesquisa.contains(funcionario.isManipulaLivros() + "")
				        || textoDaPesquisa.contains(funcionario.isManipulaFuncionarios() + "")) {
					listaDaPesquisa.add(funcionario);
				}
			});
			ultimaListaDeFuncionarios = listaDaPesquisa;
		}
		listarFuncionarios(ultimaListaDeFuncionarios);
		txtPesquisar.setDisable(false);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ultimaListaDeFuncionarios = pegarListaNoBanco();
		listarFuncionarios(ultimaListaDeFuncionarios);
	}

	private void listarFuncionarios(List<Funcionario> funcionarios) {
		ObservableList<TabelaFuncionario> listFuncionarioTabela = FXCollections.observableArrayList();
		if (!listFuncionarioTabela.isEmpty())
			listFuncionarioTabela.clear();
		funcionarios.forEach(funcionario -> {
			listFuncionarioTabela
			        .add(new TabelaFuncionario(funcionario.getId(), funcionario.getNome(), funcionario.getEmail(),
			                funcionario.getSenha(), funcionario.getCargo(), funcionario.getDataDeContratacao(),
			                funcionario.isManipulaLivros(), funcionario.isManipulaFuncionarios()));
		});
		adicionaColunasEDados(listFuncionarioTabela);
	}

	private List<Funcionario> pegarListaNoBanco() {
		return new FuncionarioDAO(em).pegarTodosOsFuncionarios();

	}

	private void adicionaColunasEDados(ObservableList<TabelaFuncionario> listFuncionarioTabela) {
		JFXTreeTableColumn<TabelaFuncionario, String> colId = new JFXTreeTableColumn<>("#");
		colId.setPrefWidth(30);
		colId.setCellValueFactory(param -> param.getValue().getValue().getIdProperty());

		JFXTreeTableColumn<TabelaFuncionario, String> colNome = new JFXTreeTableColumn<>("Nome");
		colNome.setPrefWidth(70);
		colNome.setCellValueFactory(param -> param.getValue().getValue().getNomeProperty());

		JFXTreeTableColumn<TabelaFuncionario, String> colSenha = new JFXTreeTableColumn<>("Senha");
		colSenha.setPrefWidth(70);
		colSenha.setCellValueFactory(param -> param.getValue().getValue().getSenhaProperty());

		JFXTreeTableColumn<TabelaFuncionario, String> colEmail = new JFXTreeTableColumn<>("Email");
		colEmail.setPrefWidth(70);
		colEmail.setCellValueFactory(param -> param.getValue().getValue().getEmailProperty());

		JFXTreeTableColumn<TabelaFuncionario, String> colCargo = new JFXTreeTableColumn<>("Cargo");
		colCargo.setPrefWidth(70);
		colCargo.setCellValueFactory(param -> param.getValue().getValue().getCargoProperty());

		JFXTreeTableColumn<TabelaFuncionario, String> colDataDeContratacao = new JFXTreeTableColumn<>(
		        "Data de contratação");
		colDataDeContratacao.setPrefWidth(70);
		colDataDeContratacao.setCellValueFactory(param -> param.getValue().getValue().getDataProperty());

		JFXTreeTableColumn<TabelaFuncionario, String> colManipulaLivros = new JFXTreeTableColumn<>("Manipula livros");
		colManipulaLivros.setPrefWidth(110);
		colManipulaLivros.setCellValueFactory(param -> param.getValue().getValue().getManipulaLivrosProperty());

		JFXTreeTableColumn<TabelaFuncionario, String> colManipulaFuncionarios = new JFXTreeTableColumn<>(
		        "Manipula funcionarios");
		colManipulaFuncionarios.setPrefWidth(120);
		colManipulaFuncionarios
		        .setCellValueFactory(param -> param.getValue().getValue().getManipulaFuncionariosProperty());

		final TreeItem<TabelaFuncionario> root = new RecursiveTreeItem<>(listFuncionarioTabela,
		        RecursiveTreeObject::getChildren);
		ttbFuncionario.getColumns().setAll(colId, colNome, colSenha, colEmail, colCargo, colDataDeContratacao,
		        colManipulaLivros, colManipulaFuncionarios);
		ttbFuncionario.setRoot(root);
		ttbFuncionario.setShowRoot(false);
	}

}
