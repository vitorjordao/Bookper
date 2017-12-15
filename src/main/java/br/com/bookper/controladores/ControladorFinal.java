/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bookper.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXRadioButton;

import br.com.bookper.coneccoes.modelo.Livro;
import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.informacoes.InformacoesSoftware;
import br.com.bookper.recomendacoes.RecomendacoesDeLivros;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author LABINFO
 */
public class ControladorFinal implements Initializable {
	private ControlaTelas tela = new ControlaTelas();

	@FXML
	private Label lblInformacoes;

	@FXML
	private JFXRadioButton rbdGostou1;

	@FXML
	private JFXRadioButton rbdGostou2;

	@FXML
	private JFXRadioButton rbdGostou3;

	@FXML
	private void clickNaoGostou1() {

	}

	@FXML
	private void clickNaoGostou2() {

	}

	@FXML
	private void clickNaoGostou3() {

	}

	@FXML
	private void clickRecomecar() throws IOException {
		if (rbdGostou1.isSelected()) {
			// pessoa.setAvaliacao(true);
		} else if (rbdGostou2.isSelected()) {
			// pessoa.setAvaliacao(true);
		} else if (rbdGostou3.isSelected()) {
			// pessoa.setAvaliacao(true);
		} else {
			// pessoa.setAvaliacao(false);
		}
		salvaPessoa();
		tela.iniciarPadrao("Nome.fxml");
		tela.fechar(lblInformacoes);

	}

	private void salvaPessoa() {

	}

	public void initialize(URL url, ResourceBundle rb) {
		InformacoesSoftware info = new InformacoesSoftware();
		lblInformacoes.setText(info.pegarDados());
		RecomendacoesDeLivros recomendacoesDeLivros = new RecomendacoesDeLivros();
		Livro l1 = recomendacoesDeLivros.getRecomendacao1();
		l1.getNome();
		Livro l2 = recomendacoesDeLivros.getRecomendacao2();
		l2.getNome();
		Livro l3 = recomendacoesDeLivros.getRecomendacao3();
		l3.getNome();

	}

}