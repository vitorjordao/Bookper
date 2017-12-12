package br.com.bookper.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.com.bookper.coneccoes.DAO.DAO;
import br.com.bookper.coneccoes.modelo.Gerente;
import br.com.bookper.coneccoes.util.JPAUtil;
import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.validacoes.ValidarDados;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.text.Text;

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
    private Text lblErro;

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
	private void clickLogar(ActionEvent event) throws IOException {
		tela.fechar(tabLogin.getTabPane());
		logar();
	}

	@FXML
	private void clickRegistrar(ActionEvent event) {
		String nome = txtNomeGerente.getText();
		String nomeUnidade = txtNomeUnidade.getText();
		String senha = txtSenhaRegistro.getText();
		String repitaSenha = txtRepitaSenhaRegistro.getText();
		String email = txtEmailRegistro.getText();
		ValidarDados validarDados = new ValidarDados(nome, nomeUnidade, senha, repitaSenha, email);

		if(validarDados.getValidado() == null) {
			Gerente gerente = new Gerente();
			gerente.setEmail(email);
			gerente.setNome(nome);
			gerente.setSenha(senha);
			gerente.setNomeUnidade(nomeUnidade);
			try {
				EntityManager em = new JPAUtil().getEntityManager();
				DAO dao = new DAO(em);
				dao.cadastrar(gerente);
				logar();
			}catch(Exception e){
				System.out.println(e);
			}
			
		}else {
			lblErro.setText(validarDados.getValidado());
			lblErro.setVisible(true);
		}
		
	}

	private void logar() throws IOException {
		
		tela.iniciarPadrao("Perguntas.fxml");
		tela.fechar(tabLogin.getTabPane());
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		lblErro.setVisible(false);
	}
}

	