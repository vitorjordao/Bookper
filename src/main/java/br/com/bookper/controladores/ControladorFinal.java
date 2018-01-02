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

/**
 *
 * @author LABINFO
 */
public class ControladorFinal implements Initializable {
	private ControlaTelas tela = new ControlaTelas();

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
	private void clickRecomecar() {
		salvaPessoa();
		tela.iniciarPadrao("Nome.fxml");
		tela.fechar(rbdGostou1);

	}

	private void salvaPessoa() {

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		RecomendacoesDeLivros recomendacoesDeLivros = new RecomendacoesDeLivros();
		Livro l1 = recomendacoesDeLivros.getRecomendacao1();
		l1.getNome();
		Livro l2 = recomendacoesDeLivros.getRecomendacao2();
		l2.getNome();
		Livro l3 = recomendacoesDeLivros.getRecomendacao3();
		l3.getNome();

	}

}
