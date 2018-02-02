/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bookper.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.bookper.controladores.telas.ControlaTelas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author LABINFO
 */
public class ControladorAlteraERemoveFuncionarios implements Initializable {
	private final ControlaTelas tela = new ControlaTelas();

	@FXML
	private Label lblId;

	@FXML
	private void clickFechar() {
		tela.fechar(lblId);
	}

	@FXML
	private void clickAlterar() {

	}

	@FXML
	private void clickRemover() {
		// remove

		tela.fechar(lblId);
	}

	@Override
	public void initialize(final URL url, final ResourceBundle rb) {

	}

}
