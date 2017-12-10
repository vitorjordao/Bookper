package br.com.bookper.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.com.bookper.coneccoes.DAO.DAO;
import br.com.bookper.coneccoes.modelo.Entidade;
import br.com.bookper.coneccoes.modelo.Gerente;
import br.com.bookper.coneccoes.util.JPAUtil;
import br.com.bookper.controladores.telas.ControlaTelas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

import br.com.bookper.coneccoes.modelo.Gerente;
import br.com.bookper.coneccoes.modelo.Entidade;

public class ControladorLoginESenha implements Initializable{
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
		if(!txtEmailRegistro.getText().equals("") &&
				!txtCodigoDeAtivacao.getText().equals("") && 
				!txtNomeGerente.getText().equals("") && 
				!txtNomeUnidade.getText().equals("")) {

			//validação do e-mail
			//validação do código de ativação
			//validação do nome do gerente e do nome da unidade

			if(txtSenhaRegistro.getText().length() >= 8 &&
					txtRepitaSenhaRegistro.getText().length() >= 8 &&
					txtSenhaRegistro.getText().equals(txtRepitaSenhaRegistro.getText())){
				Gerente gerente = new Gerente();
				gerente.setNome(txtNomeGerente.getText());
				gerente.setSenha(txtSenhaRegistro.getText());
				gerente.setNomeUnidade(txtNomeUnidade.getText());
				gerente.setCodigoAtivacao(txtCodigoDeAtivacao.getText());
				try {
					EntityManager em = new JPAUtil().getEntityManager();
					DAO dao = new DAO(em);
					dao.cadastrar(gerente);
					logar();
				}catch(Exception e){
					System.out.println(e);
				}
			}
		}
		
	}

	private void logar() {
		
		tela.iniciarPadrao("Perguntas.fxml");
		tela.fechar(tabLogin.getTabPane());
	}


	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}

	