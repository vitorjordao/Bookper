package br.com.bookper.validaentidades;

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
import br.com.bookper.manipuladatas.ConversorDeDatas;
import br.com.bookper.segurancaedados.ControlaUsuario;
import br.com.bookper.validacoes.ValidarDados;
import javafx.scene.control.Alert.AlertType;

public class ValidaRegistroFuncionario implements Validar {

	private final String nome;
	private final String senha;
	private final String email;
	private final String cargo;
	private final LocalDate data;
	private final boolean manipulaLivro;
	private final boolean manipulaFuncionarios;
	private final boolean manipulaFerramentasAvancadas;

	public ValidaRegistroFuncionario(final String nome, final String senha, final String email, final String cargo,
			final LocalDate data, final boolean manipulaLivro, final boolean manipulaFuncionarios,
			final boolean manipulaFerramentasAvancadas) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.cargo = cargo;
		this.data = data;
		this.manipulaLivro = manipulaLivro;
		this.manipulaFuncionarios = manipulaFuncionarios;
		this.manipulaFerramentasAvancadas = manipulaFerramentasAvancadas;
	}

	@Override
	public boolean estaOK() {
		final ValidarDados validarDados = new ValidarDados();
		if (validarDados.validaFuncionario(this.nome, this.senha, this.email, this.cargo, this.data)) {
			return this.procurarNoBD();
		} else {
			TelasPopUp.telaPadrao(AlertType.ERROR, "Cadastro", "Erro no cadastro", validarDados.getValidado());
		}
		return false;
	}

	private boolean procurarNoBD() {
		final EntityManager em = new JPAUtil().getEntityManager();
		final ConversorDeDatas converteData = new ConversorDeDatas();
		final ControlaUsuario controlaUsuario = new ControlaUsuario();
		final GerenteDAO gerenteDAO = new GerenteDAO(em);
		final FuncionarioDAO funcionarioDAO = new FuncionarioDAO(em);
		if (!gerenteDAO.existeEmail(this.email) && !funcionarioDAO.buscaEmail(this.email)) {
			final Scanner emailGerente = controlaUsuario.getCredenciais();
			emailGerente.nextLine();
			emailGerente.nextLine();
			emailGerente.nextLine();
			final Gerente gerente = gerenteDAO.buscaEmail(emailGerente.nextLine());
			final Funcionario funcionario = new Funcionario(this.nome, this.email, this.senha, this.cargo,
					converteData.converterLocalDataParaJodaTime(this.data), this.manipulaLivro,
					this.manipulaFuncionarios, this.manipulaFerramentasAvancadas, gerente);
			final DAO dao = new DAO(em);
			dao.cadastrar(funcionario);
			TelasPopUp.telaPadrao(AlertType.INFORMATION, "Cadastro", "Funcionário cadastrado!",
					"\nNome: " + this.nome + "\nEmail: " + this.email + "\nCargo: " + this.cargo
							+ "\nData de contratação: " + this.data + "\nPode manipular livros: " + this.manipulaLivro
							+ "\nPode manipular funcionarios: " + this.manipulaFuncionarios
							+ "\nPode manipular ferramentas avançada: " + this.manipulaFerramentasAvancadas);
			return true;
		} else {
			TelasPopUp.telaPadrao(AlertType.ERROR, "Cadastro", "Erro no cadastro", "Já existe esse e-mail!");
		}
		return false;
	}

}
