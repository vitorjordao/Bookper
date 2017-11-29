/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bookper.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;

import br.com.bookper.coneccoes.Pessoa;
import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.perguntas.VerificaPergunta;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 *
 * @author LABINFO
 */
public class ControladorPerguntas implements Initializable {
	public VerificaPergunta verificaPergunta = new VerificaPergunta();

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
		btnAvancar.setVisible(true);
	}

	@FXML
	private void clickAvancar() {
		alterarPergunta(true);
	}

	@FXML
	private void clickVoltar() {
		alterarPergunta(false);
	}

	private void alterarPergunta(boolean avancaOuVolta) {
		Pessoa pessoa = new Pessoa();
		if(avancaOuVolta) {
			if(!rbdResposta1.isSelected() && !rbdResposta2.isSelected()) {
				JPanel panel = new JPanel();
				JOptionPane.showMessageDialog(panel, "Selecione uma resposta!", "Erro na seleção", JOptionPane.ERROR_MESSAGE);
			}else {

				if(rbdResposta1.isSelected()) {
					pessoa.setPersonalidades(verificaPergunta.getCont(), true);
				}else {
					pessoa.setPersonalidades(verificaPergunta.getCont(), false);
				}

				if(!verificaPergunta.contar()) {
					ControlaTelas tela = new ControlaTelas();
					tela.iniciarPadrao("Final.fxml");
					tela.fechar(lblPergunta);
				}
				setarTudo();
				btnVoltar.setVisible(true);
			}
		}else {
			if(!verificaPergunta.voltarContagem()) {
				System.out.println("Erro no contador");
			}
			if(verificaPergunta.getCont() <= 1) {
				btnVoltar.setVisible(false);
			}
			setarTudo();
		}
	}
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btnVoltar.setVisible(false);
		setarTudo();
	}

	private void setarTudo() {
		verificaPergunta.pegarPergunta();
		verificaPergunta.randomizar();
		rbdResposta1.setSelected(false);
		rbdResposta2.setSelected(false);
		btnAvancar.setVisible(false);
		lblPergunta.setText(verificaPergunta.pegarPergunta().pergunta());
		rbdResposta1.setText(verificaPergunta.pegarPergunta().RespostaTrue());
		rbdResposta2.setText(verificaPergunta.pegarPergunta().RespostaFalse());
		lblNumeroPergunta.setText("Pergunta "+verificaPergunta.getCont()+"/5");
	}

}