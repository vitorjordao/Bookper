package br.com.bookper.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.validaentidades.ValidarLogin;
import br.com.bookper.validaentidades.ValidarRegistro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

public class ControladorLoginESenha implements Initializable {
	private ControlaTelas tela = new ControlaTelas();

	@FXML
	private Tab tabLogin;

	@FXML
	private JFXTextField txtEmailLogin;

	@FXML
	private JFXPasswordField txtSenhaLogin;

	@FXML
	private JFXCheckBox checkLogarAutomaticamente;

	@FXML
	private JFXTextField txtEmailRegistro;

	@FXML
	private JFXPasswordField txtSenhaRegistro;

	@FXML
	private JFXPasswordField txtRepitaSenhaRegistro;

	@FXML
	private JFXTextField txtNomeGerente;

	@FXML
	private JFXTextField txtNomeUnidade;

	@FXML
	private void clickFechar(ActionEvent event) {
		tela.fechar(tabLogin.getTabPane());
		System.exit(0);
	}

	@FXML
	private void clickLogar(ActionEvent event) {
		String email = txtEmailLogin.getText();
		String senha = txtSenhaLogin.getText();
		if (new ValidarLogin(email, senha, checkLogarAutomaticamente.isSelected()).estaOK())
			logar();
	}

	@FXML
	private void clickRegistrar(ActionEvent event) {
		String nome = txtNomeGerente.getText();
		String nomeUnidade = txtNomeUnidade.getText();
		String senha = txtSenhaRegistro.getText();
		String repitaSenha = txtRepitaSenhaRegistro.getText();
		String email = txtEmailRegistro.getText();
		if (new ValidarRegistro(nomeUnidade, nome, senha, repitaSenha, email).estaOK())
			logar();

	}

	private void logar() {

		tela.iniciarPadrao("TelaIntermediaria.fxml");
		tela.fechar(tabLogin.getTabPane());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
}
