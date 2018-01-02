package br.com.bookper.manipulaentidades;

import javax.persistence.EntityManager;

import br.com.bookper.coneccoes.DAO.FuncionarioDAO;
import br.com.bookper.coneccoes.DAO.GerenteDAO;
import br.com.bookper.coneccoes.util.JPAUtil;
import br.com.bookper.controladores.telas.TelasPopUp;
import br.com.bookper.dadosnamaquina.ControlaUsuario;
import br.com.bookper.validacoes.ValidarDados;
import javafx.scene.control.Alert.AlertType;

public class ValidarLogin implements Validar {
	private String email;
	private String senha;
	private boolean continuarLogado;

	public ValidarLogin(String email, String senha, boolean continuarLogado) {
		this.email = email;
		this.senha = senha;
		this.continuarLogado = continuarLogado;
	}

	@Override
	public boolean estaOK() {
		ValidarDados validarDados = new ValidarDados();
		if (validarDados.validaLogin(email, senha)) {
			return procurarNoBD();
		}
		else {
			new TelasPopUp(AlertType.ERROR, "Login", "Erro no login", validarDados.getValidado());
		}
		return false;
	}

	private boolean procurarNoBD() {
		EntityManager em = new JPAUtil().getEntityManager();
		GerenteDAO gerenteDAO = new GerenteDAO(em);
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO(em);
		if (gerenteDAO.buscarLogin(email, senha)) {
			ControlaUsuario controlaUsuario = new ControlaUsuario();
			controlaUsuario.salvar(email, senha, continuarLogado, email);
			return true;
		}
		else if (funcionarioDAO.buscarLogin(email, senha)) {
			ControlaUsuario controlaUsuario = new ControlaUsuario();
			controlaUsuario.salvar(email, senha, continuarLogado, funcionarioDAO.buscarGerente(email).getEmail());
			return true;
		}
		else {
			new TelasPopUp(AlertType.ERROR, "Login", "Erro no login", "Não existe essa conta!");
		}
		return false;
	}
}
