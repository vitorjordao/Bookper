package br.com.bookper.controladores;

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
	private void clickFechar(ActionEvent event) {
		tela.fechar(btnManipulaFuncionario.getGraphic());
		System.exit(0);
	}

	@FXML
	private void clickManipulaFuncionario(ActionEvent event) {
		tela.iniciarPadrao("ManipulaFuncionario.fxml");
		tela.fechar(btnManipulaFuncionario.getGraphic());
	}

	@FXML
	private void clickControle(ActionEvent event) {
		tela.fechar(btnManipulaFuncionario.getGraphic());
	}

	@FXML
	private void clickEstatistica(ActionEvent event) {
		tela.fechar(btnManipulaFuncionario.getGraphic());
	}

	@FXML
	private void clickTestePersonalidade(ActionEvent event) {
		tela.iniciarPadrao("Perguntas.fxml");
		tela.fechar(btnManipulaFuncionario.getGraphic());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
