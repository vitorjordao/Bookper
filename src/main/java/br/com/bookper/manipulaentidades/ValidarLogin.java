package br.com.bookper.manipulaentidades;

import javax.persistence.EntityManager;

import br.com.bookper.coneccoes.DAO.FuncionarioDAO;
import br.com.bookper.coneccoes.DAO.GerenteDAO;
import br.com.bookper.coneccoes.modelo.Funcionario;
import br.com.bookper.coneccoes.util.JPAUtil;
import br.com.bookper.controladores.telas.TelasPopUp;
import br.com.bookper.segurancaedados.ControlaUsuario;
import br.com.bookper.segurancaedados.PermisoesESeguranca;
import br.com.bookper.validacoes.ValidarDados;
import javafx.scene.control.Alert.AlertType;

public class ValidarLogin implements Validar {
	private final String email;
	private final String senha;
	private final boolean continuarLogado;

	public ValidarLogin(final String email, final String senha, final boolean continuarLogado) {
		this.email = email;
		this.senha = senha;
		this.continuarLogado = continuarLogado;
	}

	@Override
	public boolean estaOK() {
		final ValidarDados validarDados = new ValidarDados();
		if (validarDados.validaLogin(this.email, this.senha)) {
			return this.procurarNoBD();
		} else {
			new TelasPopUp(AlertType.ERROR, "Login", "Erro no login", validarDados.getValidado());
		}
		return false;
	}

	private boolean procurarNoBD() {
		final EntityManager em = new JPAUtil().getEntityManager();
		final GerenteDAO gerenteDAO = new GerenteDAO(em);
		final FuncionarioDAO funcionarioDAO = new FuncionarioDAO(em);
		if (gerenteDAO.buscarLogin(this.email, this.senha)) {
			final ControlaUsuario controlaUsuario = new ControlaUsuario();
			controlaUsuario.salvar(this.email, this.senha, this.continuarLogado, this.email);
			new PermisoesESeguranca(this.email, this.senha, true, true, true);
			return true;
		} else if (funcionarioDAO.buscarLogin(this.email, this.senha)) {
			final Funcionario funcionario = funcionarioDAO.buscarLogin(this.email);
			final ControlaUsuario controlaUsuario = new ControlaUsuario();
			controlaUsuario.salvar(this.email, this.senha, this.continuarLogado,
					funcionarioDAO.buscarGerente(this.email).getEmail());
			new PermisoesESeguranca(this.email, this.senha, funcionario.isManipulaLivros(),
					funcionario.isManipulaFuncionarios(), funcionario.isManipulaFerramentasAvancadas());
			return true;
		} else {
			new TelasPopUp(AlertType.ERROR, "Login", "Erro no login", "Não existe essa conta!");
		}
		return false;
	}
}
