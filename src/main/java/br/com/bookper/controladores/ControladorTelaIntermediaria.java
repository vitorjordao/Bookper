package br.com.bookper.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.bookper.controladores.telas.ControlaTelas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ControladorTelaIntermediaria implements Initializable{
	private ControlaTelas tela = new ControlaTelas();
	
	@FXML
	private JFXButton btnManipulaUsuario; 
	
	@FXML
	void clickFechar(ActionEvent event) {
		tela.fechar(btnManipulaUsuario.getGraphic());
		System.exit(0);
	}
	
	@FXML
	void clickManipulaFuncionario(ActionEvent event) {
		tela.iniciarPadrao("ManipulaFuncionario.fxml");
		tela.fechar(btnManipulaUsuario.getGraphic());
	}
	
	@FXML
	void clickManipulaUsuario(ActionEvent event) {
		//tela.iniciarPadrao("ManipulaFuncionario.fxml");
		tela.fechar(btnManipulaUsuario.getGraphic());
	}
	
	@FXML
	void clickEstatistica(ActionEvent event) {
		//tela.iniciarPadrao("ManipulaFuncionario.fxml");
		tela.fechar(btnManipulaUsuario.getGraphic());
	}
	

	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
