package br.com.bookper.manipulaentidades;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.bookper.coneccoes.DAO.DAO;
import br.com.bookper.coneccoes.DAO.FuncionarioDAO;
import br.com.bookper.coneccoes.DAO.GerenteDAO;
import br.com.bookper.coneccoes.modelo.Funcionario;
import br.com.bookper.coneccoes.modelo.Gerente;
import br.com.bookper.coneccoes.util.JPAUtil;
import br.com.bookper.controladores.telas.TelasPopUp;
import br.com.bookper.dadosnamaquina.ControlaUsuario;
import br.com.bookper.manipuladatas.ConversorDeDatas;
import br.com.bookper.validacoes.ValidarDados;
import javafx.scene.control.Alert.AlertType;

public class ValidaRegistroFuncionario implements Validar {

	private String nome;
	private String senha;
	private String email;
	private String cargo;
	private LocalDate data;
	private boolean manipulaLivro;
	private boolean manipulaFuncionarios;

	public ValidaRegistroFuncionario(String nome, String senha, String email, String cargo, LocalDate data,
	        boolean manipulaLivro, boolean manipulaFuncionarios) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.cargo = cargo;
		this.data = data;
		this.manipulaLivro = manipulaLivro;
		this.manipulaFuncionarios = manipulaFuncionarios;
	}

	@Override
	public boolean estaOK() {
		ValidarDados validarDados = new ValidarDados();
		if (validarDados.validaRegistroFuncionario(nome, senha, email, cargo, data)) {
			return procurarNoBD();
		}
		else {
			new TelasPopUp(AlertType.ERROR, "Cadastro", "Erro no cadastro", validarDados.getValidado());
		}
		return false;
	}

	private boolean procurarNoBD() {
		EntityManager em = new JPAUtil().getEntityManager();
		ConversorDeDatas converteData = new ConversorDeDatas();
		ControlaUsuario controlaUsuario = new ControlaUsuario();
		GerenteDAO gerenteDAO = new GerenteDAO(em);
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO(em);
		if (!gerenteDAO.existeEmail(email) && !funcionarioDAO.buscarEmail(email)) {
			Scanner emailGerente = controlaUsuario.getCredenciais();
			emailGerente.nextLine();
			emailGerente.nextLine();
			emailGerente.nextLine();
			Gerente gerente = gerenteDAO.buscaEmail(emailGerente.nextLine());
			Funcionario funcionario = new Funcionario(nome, email, senha, cargo,
			        converteData.converterLocalDataParaJodaTime(this.data), manipulaLivro, manipulaFuncionarios,
			        gerente);
			DAO dao = new DAO(em);
			dao.cadastrar(funcionario);
			new TelasPopUp(AlertType.CONFIRMATION, "Cadastro", "Funcionário cadastrado!",
			        "Nome: " + this.nome + ", senha: " + this.senha + ", email: " + this.email + ", cargo: "
			                + this.cargo + ", data de contratação: " + this.data + ", pode manipular livros: "
			                + this.manipulaLivro + ", pode manipular funcionarios: " + this.manipulaFuncionarios);
			return true;
		}
		else {
			new TelasPopUp(AlertType.ERROR, "Cadastro", "Erro no cadastro", "Já existe esse e-mail!");
		}
		return false;
	}

}
