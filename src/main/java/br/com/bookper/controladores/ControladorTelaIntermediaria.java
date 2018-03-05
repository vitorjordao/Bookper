package br.com.bookper.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.controladores.telas.TelasPopUp;
import br.com.bookper.segurancaedados.PermisoesESeguranca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;

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
		if (PermisoesESeguranca.isCADASTROFUNCIONARIO()) {
			this.tela.iniciarPadrao("ManipulaFuncionario.fxml");
			this.tela.fechar(this.btnManipulaFuncionario.getGraphic());
		} else
			this.erroPermissaoNaTela();
	}

	@FXML
	private void clickEstatistica(final ActionEvent event) {
		if (PermisoesESeguranca.isFERRAMENTASAVANCADAS()) {
			this.tela.iniciarPadrao(".fxml");
			this.tela.fechar(this.btnManipulaFuncionario.getGraphic());
		} else
			this.erroPermissaoNaTela();
	}

	@FXML
	private void clickManipulaLivro(final ActionEvent event) {
		if (PermisoesESeguranca.isCADASTROLIVRO()) {
			this.tela.iniciarPadrao("ManipulaLivro.fxml");
			this.tela.fechar(this.btnManipulaFuncionario.getGraphic());
		} else
			this.erroPermissaoNaTela();
	}

	@FXML
	private void clickTestePersonalidade(final ActionEvent event) {
		this.tela.iniciarPadrao("Perguntas.fxml");
		this.tela.fechar(this.btnManipulaFuncionario.getGraphic());
	}

	private void erroPermissaoNaTela() {
		new TelasPopUp(AlertType.CONFIRMATION, "Erro ao tentar abri tela", "Permissão não OK",
				"Você não tem permissão para entrar nesta tela");
	}

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {

	}

}
