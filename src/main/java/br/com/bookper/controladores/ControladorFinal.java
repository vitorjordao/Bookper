/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bookper.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXRadioButton;

import br.com.bookper.coneccoes.modelo.Livro;
import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.recomendacoes.RecomendacoesDeLivros;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author LABINFO
 */
public class ControladorFinal implements Initializable {
	private final ControlaTelas tela = new ControlaTelas();

	@FXML
	private JFXRadioButton rbdGostou1;

	@FXML
	private JFXRadioButton rbdGostou2;

	@FXML
	private JFXRadioButton rbdGostou3;

	@FXML
	private Label lblNomeLivro1;

	@FXML
	private Label lblNomeLivro2;

	@FXML
	private Label lblNomeLivro3;

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
	private void clickRecomecar() {
		salvaPessoa();
		tela.iniciarPadrao("Nome.fxml");
		tela.fechar(rbdGostou1);

	}

	private void salvaPessoa() {

	}

	@Override
	public void initialize(final URL url, final ResourceBundle rb) {
		final RecomendacoesDeLivros recomendacoesDeLivros = new RecomendacoesDeLivros();
		final Livro l1 = recomendacoesDeLivros.getRecomendacao1();
		lblNomeLivro1.setText(l1.getNome());
		final Livro l2 = recomendacoesDeLivros.getRecomendacao2();
		lblNomeLivro2.setText(l2.getNome());
		final Livro l3 = recomendacoesDeLivros.getRecomendacao3();
		lblNomeLivro3.setText(l3.getNome());

	}

}
