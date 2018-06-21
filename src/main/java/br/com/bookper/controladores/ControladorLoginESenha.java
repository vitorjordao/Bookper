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
import javafx.scene.image.ImageView;

public class ControladorLoginESenha implements Initializable {
	private final ControlaTelas tela = new ControlaTelas();

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
	private ImageView imgIcon;

	@FXML
	private void clickFechar(final ActionEvent event) {
		this.tela.fechar(this.tabLogin.getTabPane());
		System.exit(0);
	}

	@FXML
	private void clickLogar(final ActionEvent event) {
		final String email = this.txtEmailLogin.getText();
		final String senha = this.txtSenhaLogin.getText();
		if (new ValidarLogin(email, senha, this.checkLogarAutomaticamente.isSelected()).estaOK())
			this.logar();
	}

	@FXML
	private void clickRegistrar(final ActionEvent event) {
		final String nome = this.txtNomeGerente.getText();
		final String nomeUnidade = this.txtNomeUnidade.getText();
		final String senha = this.txtSenhaRegistro.getText();
		final String repitaSenha = this.txtRepitaSenhaRegistro.getText();
		final String email = this.txtEmailRegistro.getText();
		if (new ValidarRegistro(nomeUnidade, nome, senha, repitaSenha, email).estaOK())
			this.logar();

	}

	private void logar() {

		this.tela.iniciarPadrao("TelaIntermediaria.fxml");
		this.tela.fechar(this.tabLogin.getTabPane());
	}

	@Override
	public void initialize(final URL arg0, final ResourceBundle arg1) {
	}
}
