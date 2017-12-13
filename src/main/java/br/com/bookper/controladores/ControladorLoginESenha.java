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
import br.com.bookper.coneccoes.DAO.GerenteDAO;
import br.com.bookper.coneccoes.modelo.Gerente;
import br.com.bookper.coneccoes.util.JPAUtil;
import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.controladores.telas.TelasPopUp;
import br.com.bookper.dadosnamaquina.ControlaUsuario;
import br.com.bookper.validacoes.ValidarDados;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Tab;

public class ControladorLoginESenha implements Initializable{
	private EntityManager em = new JPAUtil().getEntityManager();
	private ControlaTelas tela = new ControlaTelas();
	private GerenteDAO gerenteDAO = new GerenteDAO(em);
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
		if(gerenteDAO.buscarLogin(txtEmailLogin.getText(), txtSenhaLogin.getText())) {
			//remover as classe: Pessoa e Pessoa Auxiliar
			ControlaUsuario controlaUsuario = new ControlaUsuario();
			controlaUsuario.salvar(txtEmailLogin.getText(), txtSenhaLogin.getText(), checkLogarAutomaticamente.isSelected());
			logar();
		}else
			new TelasPopUp(AlertType.ERROR, "Login", "Erro no login", "Não existe essa conta!");
	}

	@FXML
	private void clickRegistrar(ActionEvent event) {
		String nome = txtNomeGerente.getText();
		String nomeUnidade = txtNomeUnidade.getText();
		String senha = txtSenhaRegistro.getText();
		String repitaSenha = txtRepitaSenhaRegistro.getText();
		String email = txtEmailRegistro.getText();
		ValidarDados validarDados = new ValidarDados(nome, nomeUnidade, senha, repitaSenha, email);
		if(validarDados.getValidado().equals("")) {
			try {
				if(!gerenteDAO.buscarEmail(email)) {
					Gerente gerente = new Gerente();
					gerente.setEmail(email);
					gerente.setNome(nome);
					gerente.setSenha(senha);
					gerente.setNomeUnidade(nomeUnidade);
					DAO dao = new DAO(em);
					dao.cadastrar(gerente);
					logar();
				}else {
					new TelasPopUp(AlertType.ERROR, "Cadastro", "Erro no cadastro", "Já existe esse e-mail!");
				}
			}catch(Exception e){
				System.out.println(e);
			}
			
		}else {
			new TelasPopUp(AlertType.ERROR, "Cadastro", "Erro no cadastro", validarDados.getValidado());
		}
		
	}

	private void logar() throws IOException {
		
		tela.iniciarPadrao("TelaIntermediaria.fxml");
		tela.fechar(tabLogin.getTabPane());
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
	}
}

	