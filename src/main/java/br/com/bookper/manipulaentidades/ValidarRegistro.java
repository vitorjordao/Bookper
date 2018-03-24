package br.com.bookper.manipulaentidades;

import javax.persistence.EntityManager;

import br.com.bookper.coneccoes.DAO.DAO;
import br.com.bookper.coneccoes.DAO.FuncionarioDAO;
import br.com.bookper.coneccoes.DAO.GerenteDAO;
import br.com.bookper.coneccoes.modelo.Gerente;
import br.com.bookper.coneccoes.util.JPAUtil;
import br.com.bookper.controladores.telas.TelasPopUp;
import br.com.bookper.segurancaedados.Criptografia;
import br.com.bookper.segurancaedados.PermisoesESeguranca;
import br.com.bookper.validacoes.ValidarDados;
import javafx.scene.control.Alert.AlertType;

public class ValidarRegistro implements Validar {
	private final String nomeUnidade;
	private final String nome;
	private final String senha;
	private final String repitaSenha;
	private final String email;

	public ValidarRegistro(final String nomeUnidade, final String nome, final String senha, final String repitaSenha,
			final String email) {
		this.nomeUnidade = nomeUnidade;
		this.nome = nome;
		this.senha = senha;
		this.repitaSenha = repitaSenha;
		this.email = email;
	}

	@Override
	public boolean estaOK() {
		final ValidarDados validarDados = new ValidarDados();
		if (validarDados.validaRegistroGerente(this.nome, this.nomeUnidade, this.senha, this.repitaSenha, this.email)) {
			return this.procurarNoBD();
		} else {
			new TelasPopUp(AlertType.ERROR, "Cadastro", "Erro no cadastro", validarDados.getValidado());
		}
		return false;
	}

	private boolean procurarNoBD() {
		final EntityManager em = new JPAUtil().getEntityManager();
		final GerenteDAO gerenteDAO = new GerenteDAO(em);
		final FuncionarioDAO funcionarioDAO = new FuncionarioDAO(em);
		if (!gerenteDAO.existeEmail(this.email) && !funcionarioDAO.buscarEmail(this.email)) {
			final Gerente gerente = new Gerente(this.nome, this.email, Criptografia.transformaStringEmHash(this.senha),
					this.nomeUnidade);
			final DAO dao = new DAO(em);
			dao.cadastrar(gerente);
			new PermisoesESeguranca(this.email, this.senha, true, true, true);
			return true;
		} else {
			new TelasPopUp(AlertType.ERROR, "Cadastro", "Erro no cadastro", "Já existe esse e-mail!");
		}
		return false;
	}

}
