package br.com.bookper.validacoes;

import java.time.LocalDate;

public class ValidarDados {
	private String erro;
	private boolean erros;

	public boolean validaRegistroGerente(final String nome, final String nomeUnidade, final String senha,
			final String repitaSenha, final String email) {
		this.erros = true;
		this.erro = "";
		if (new Nome().isValido(nome) == TiposValidacoes.NOTOK) {
			this.erro += "Nome inválido! ";
			this.erros = false;
		}
		if (new Nome().isValido(nomeUnidade) == TiposValidacoes.NOTOK) {
			this.erro += "Nome da unidade inválido! ";
			this.erros = false;
		}
		if (new Senha().isValido(senha) == TiposValidacoes.NOTOK
				|| new Senha().isValido(repitaSenha) == TiposValidacoes.NOTOK) {
			this.erro += "Senha(s) inválida(s), ou não batem! ";
			this.erros = false;
		}
		if (new Email().isValido(email) == TiposValidacoes.NOTOK) {
			this.erro += "Email inválido! ";
			this.erros = false;
		}
		return this.erros;
	}

	public boolean validaLogin(final String email, final String senha) {
		this.erros = true;
		this.erro = "";
		if (new Senha().isValido(senha) == TiposValidacoes.NOTOK
				&& new Senha().isValido(senha) == TiposValidacoes.NOTOK) {
			this.erro += "Senha inválida! ";
			this.erros = false;
		}
		if (new Email().isValido(email) == TiposValidacoes.NOTOK) {
			this.erro += "Email inválido! ";
			this.erros = false;
		}
		return this.erros;
	}

	public boolean validaRegistroFuncionario(final String nome, final String senha, final String email,
			final String cargo, final LocalDate data) {
		this.erros = true;
		this.erro = "";
		if (new Nome().isValido(nome) == TiposValidacoes.NOTOK) {
			this.erro += "Nome inválido! ";
			this.erros = false;
		}
		if (new Senha().isValido(senha) == TiposValidacoes.NOTOK
				&& new Senha().isValido(senha) == TiposValidacoes.NOTOK) {
			this.erro += "Senha inválida! ";
			this.erros = false;
		}
		if (new Email().isValido(email) == TiposValidacoes.NOTOK) {
			this.erro += "Email inválido! ";
			this.erros = false;
		}
		if (new Nome().isValido(cargo) == TiposValidacoes.NOTOK) {
			this.erro += "Cargo inválido! ";
			this.erros = false;
		}
		if (new Data().isValido(data) == TiposValidacoes.NOTOK) {
			this.erro += "Data inválida! ";
			this.erros = false;
		}
		return this.erros;
	}

	public String getValidado() {
		return this.erro;
	}

	public boolean validaRegistroLivro(final String nome, final String url) {
		this.erros = true;
		this.erro = "";
		if (new Nome().isValido(nome) == TiposValidacoes.NOTOK) {
			this.erro += "Nome inválido! ";
			this.erros = false;
		}
		if (new Url().isValido(url) == TiposValidacoes.NOTOK) {
			this.erro += "Link inválido! ";
			this.erros = false;
		}
		return this.erros;
	}
}
