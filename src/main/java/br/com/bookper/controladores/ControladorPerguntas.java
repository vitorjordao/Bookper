/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bookper.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;

import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.controladores.telas.TelasPopUp;
import br.com.bookper.perguntas.VerificaPergunta;
import br.com.bookper.recomendacoes.GeradorDePersonalidades;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 *
 * @author LABINFO
 */
public class ControladorPerguntas implements Initializable {
	public VerificaPergunta verificaPergunta = new VerificaPergunta();

	private boolean mente;
	private boolean energia;
	private boolean natureza;
	private boolean taticas;
	private boolean identidade;

	@FXML
	private Label lblNumeroPergunta;

	@FXML
	private Text lblPergunta;

	@FXML
	private JFXButton btnVoltar;

	@FXML
	private JFXButton btnAvancar;

	@FXML
	private JFXRadioButton rbdResposta1;

	@FXML
	private JFXRadioButton rbdResposta2;

	@FXML
	private void selecionar() {
		this.btnAvancar.setVisible(true);
	}

	@FXML
	private void clickAvancar() {
		this.alterarPergunta(true);
	}

	@FXML
	private void clickVoltar() {
		this.alterarPergunta(false);
	}

	private void alterarPergunta(final boolean avancaOuVolta) {
		if (avancaOuVolta) {
			this.avancarPergunta();
		} else {
			this.voltarPergunta();
		}
	}

	private void voltarPergunta() {
		if (!this.verificaPergunta.voltarContagem()) {
			System.out.println("Erro no contador");
		}
		if (this.verificaPergunta.getCont() <= 1) {
			this.btnVoltar.setVisible(false);
		}
		this.descelecionarTudo();
	}

	private void avancarPergunta() {
		if (!this.rbdResposta1.isSelected() && !this.rbdResposta2.isSelected()) {
			TelasPopUp.telaPadrao(AlertType.ERROR, "Selecione uma resposta!", "Falha", "Erro na seleção");
		} else {

			if (this.rbdResposta1.isSelected()) {
				this.setPersonalidades(this.verificaPergunta.getCont(), true);
			} else {
				this.setPersonalidades(this.verificaPergunta.getCont(), false);
			}

			if (!this.verificaPergunta.contar()) {
				final ControlaTelas tela = new ControlaTelas();
				tela.iniciarPadrao("Final.fxml");
				tela.fechar(this.lblPergunta);
			}
			this.descelecionarTudo();
			this.btnVoltar.setVisible(true);
			this.rbdResposta1.requestFocus();
		}
	}

	@Override
	public void initialize(final URL url, final ResourceBundle rb) {
		this.btnVoltar.setVisible(false);
		this.descelecionarTudo();
	}

	private void descelecionarTudo() {
		this.verificaPergunta.pegarPergunta();
		this.verificaPergunta.randomizar();
		this.lblPergunta.setText(this.verificaPergunta.pegarPergunta().pergunta());
		this.rbdResposta1.setText(this.verificaPergunta.pegarPergunta().RespostaTrue());
		this.rbdResposta2.setText(this.verificaPergunta.pegarPergunta().RespostaFalse());
		this.lblNumeroPergunta.setText("Pergunta " + this.verificaPergunta.getCont() + "/5");
		this.btnAvancar.setVisible(false);
		this.rbdResposta1.setSelected(false);
		this.rbdResposta2.setSelected(false);
	}

	public void setPersonalidades(final int i, final boolean personalidade) {
		if (i == 1) {
			this.mente = personalidade;
		} else if (i == 2) {
			this.energia = personalidade;
		} else if (i == 3) {
			this.natureza = personalidade;
		} else if (i == 4) {
			this.taticas = personalidade;
		} else if (i == 5) {
			this.identidade = personalidade;
			final GeradorDePersonalidades gerado = new GeradorDePersonalidades();
			gerado.gerarPersonalidade(this.mente, this.energia, this.natureza, this.taticas, this.identidade);
		}
	}
}
