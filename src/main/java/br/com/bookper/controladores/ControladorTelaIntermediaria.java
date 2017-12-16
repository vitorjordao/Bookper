package br.com.bookper.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.bookper.controladores.telas.ControlaTelas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ControladorTelaIntermediaria implements Initializable {
	private ControlaTelas tela = new ControlaTelas();

	@FXML
	private JFXButton btnManipulaFuncionario;

	@FXML
	void clickFechar(ActionEvent event) {
		tela.fechar(btnManipulaFuncionario.getGraphic());
		System.exit(0);
	}

	@FXML
	void clickManipulaFuncionario(ActionEvent event) throws IOException {
		tela.iniciarPadrao("ManipulaFuncionario.fxml");
		tela.fechar(btnManipulaFuncionario.getGraphic());
	}

	@FXML
	void clickControle(ActionEvent event) {
		tela.fechar(btnManipulaFuncionario.getGraphic());
	}

	@FXML
	void clickEstatistica(ActionEvent event) {
		tela.fechar(btnManipulaFuncionario.getGraphic());
	}

	@FXML
	void clickTestePersonalidade(ActionEvent event) throws IOException {
		tela.iniciarPadrao("Perguntas.fxml");
		tela.fechar(btnManipulaFuncionario.getGraphic());
	}

	public void initialize(URL location, ResourceBundle resources) {

	}

}
