/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bookper.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXRadioButton;

import br.com.bookper.coneccoes.modelo.Pessoa;
import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.informacoes.InformacoesSoftware;
import br.com.bookper.limpesas.LimpesaGrande;
import br.com.bookper.personalidade.GeradorDePersonalidades;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author LABINFO
 */
public class ControladorFinal implements Initializable {
	private Pessoa pessoa = new Pessoa();
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
	private void clickRecomecar() {
		if(rbdGostou1.isSelected()) {
			//pessoa.setAvaliacao(true);
		}else if(rbdGostou2.isSelected()) {
			//pessoa.setAvaliacao(true);
		}else if(rbdGostou3.isSelected()) {
			//pessoa.setAvaliacao(true);
		}else {
			pessoa.setAvaliacao(false);
		}
		salvaPessoa();
		tela.iniciarPadrao("Nome.fxml");
		tela.fechar(lblInformacoes);
		LimpesaGrande limpesa = new LimpesaGrande();
		limpesa.limpesaTotal();

	}


	


	private void salvaPessoa() {
		
		
	}


	
	public void initialize(URL url, ResourceBundle rb) {
		InformacoesSoftware info = new InformacoesSoftware();
		lblInformacoes.setText(info.pegarDados());
		GeradorDePersonalidades gerado = new GeradorDePersonalidades();
		gerado.gerarPersonalidade();
	}

}