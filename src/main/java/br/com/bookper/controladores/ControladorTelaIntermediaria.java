package br.com.bookper.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.bookper.controladores.telas.ControlaTelas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ControladorTelaIntermediaria implements Initializable {
	private final ControlaTelas tela = new ControlaTelas();

	@FXML
	private JFXButton btnManipulaFuncionario;

	@FXML
	private void clickFechar(final ActionEvent event) {
		this.tela.fechar(this.btnManipulaFuncionario.getGraphic());
		System.exit(0);
	}

	@FXML
	private void clickManipulaFuncionario(final ActionEvent event) {
		this.tela.iniciarPadrao("ManipulaFuncionario.fxml");
		this.tela.fechar(this.btnManipulaFuncionario.getGraphic());
	}

	@FXML
	private void clickEstatistica(final ActionEvent event) {
		this.tela.iniciarPadrao(".fxml");
		this.tela.fechar(this.btnManipulaFuncionario.getGraphic());
	}

	@FXML
	private void clickManipulaLivro(final ActionEvent event) {
		this.tela.iniciarPadrao("ManipulaLivro.fxml");
		this.tela.fechar(this.btnManipulaFuncionario.getGraphic());
	}

	@FXML
	private void clickTestePersonalidade(final ActionEvent event) {
		this.tela.iniciarPadrao("Perguntas.fxml");
		this.tela.fechar(this.btnManipulaFuncionario.getGraphic());
	}

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {

	}

}
