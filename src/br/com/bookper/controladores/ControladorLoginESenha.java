package br.com.bookper.controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.com.bookper.controladores.telas.ControlaTelas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class ControladorLoginESenha {
	private ControlaTelas tela = new ControlaTelas();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab tabLogin;

    @FXML
    private JFXButton btnLogar;

    @FXML
    private JFXTextField txtEmailLogin;

    @FXML
    private JFXPasswordField txtSenhaLogin;

    @FXML
    private JFXCheckBox checkLogarAutomaticamente;

    @FXML
    private Tab tabRegistro;

    @FXML
    private JFXButton btnRegistrar;

    @FXML
    private JFXTextField txtEmailRegistro;

    @FXML
    private JFXPasswordField txtSenhaRegistro;

    @FXML
    private JFXPasswordField txtRepitaSenhaRegistro;

    @FXML
    private JFXTextField txtCodigoDeAtivacao;

    @FXML
    private JFXTextField txtNomeGerente;

    @FXML
    private JFXTextField txtNomeUnidade;

    @FXML
    private JFXButton btnFechar;

	@FXML
	void clickFechar(ActionEvent event) {
		tela.fechar(tabLogin.getTabPane());
		System.exit(0);
	}

	@FXML
	private void clickLogar(ActionEvent event) {
		tela.fechar(tabLogin.getTabPane());
		logar();
	}

	@FXML
	private void clickRegistrar(ActionEvent event) {

		logar();
	}

	private void logar() {
		
		tela.iniciarPadrao("Perguntas.fxml");
		tela.fechar(tabLogin.getTabPane());
	}

	@FXML
    void initialize() {
		
	}
}

	