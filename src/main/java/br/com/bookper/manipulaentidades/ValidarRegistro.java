package br.com.bookper.manipulaentidades;

import javax.persistence.EntityManager;

import br.com.bookper.coneccoes.DAO.DAO;
import br.com.bookper.coneccoes.DAO.FuncionarioDAO;
import br.com.bookper.coneccoes.DAO.GerenteDAO;
import br.com.bookper.coneccoes.modelo.Gerente;
import br.com.bookper.coneccoes.util.JPAUtil;
import br.com.bookper.controladores.telas.TelasPopUp;
import br.com.bookper.validacoes.ValidarDados;
import javafx.scene.control.Alert.AlertType;

public class ValidarRegistro implements Validar {
	private String nomeUnidade;
	private String nome;
	private String senha;
	private String repitaSenha;
	private String email;
	public ValidarRegistro(String nomeUnidade, String nome, String senha, String repitaSenha, String email) {
		this.nomeUnidade = nomeUnidade;
		this.nome = nome;
		this.senha = senha;
		this.repitaSenha = repitaSenha;
		this.email = email;
	}
	@Override
	public boolean estaOK() {
		ValidarDados validarDados = new ValidarDados();
		if (validarDados.validaRegistroGerente(nome, nomeUnidade, senha, repitaSenha, email)) {
			return procurarNoBD();
		}
		else {
			new TelasPopUp(AlertType.ERROR, "Cadastro", "Erro no cadastro", validarDados.getValidado());
		}
		return false;
	}
	private boolean procurarNoBD() {
		EntityManager em = new JPAUtil().getEntityManager();
		GerenteDAO gerenteDAO = new GerenteDAO(em);
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO(em);
		if (!gerenteDAO.existeEmail(email) && !funcionarioDAO.buscarEmail(email)) {
			Gerente gerente = new Gerente(nome, email, senha, nomeUnidade);
			DAO dao = new DAO(em);
			dao.cadastrar(gerente);
			return true;
		}
		else {
			new TelasPopUp(AlertType.ERROR, "Cadastro", "Erro no cadastro", "Já existe esse e-mail!");
		}
		return false;
	}

}
