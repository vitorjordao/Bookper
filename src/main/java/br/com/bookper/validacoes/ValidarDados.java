package br.com.bookper.validacoes;

import java.time.LocalDate;

public class ValidarDados {
	private String erro = "";
	private boolean erros;

	public boolean validaRegistroGerente(final String nome, final String nomeUnidade, final String senha,
			final String repitaSenha, final String email) {
		this.erros = true;
		this.erro = "";
		if (new Nome().isValido(nome) == TiposValidacoes.NOTOK) {
			this.erro += "Nome inválido!\n";
			this.erros = false;
		}
		if (new Nome().isValido(nomeUnidade) == TiposValidacoes.NOTOK) {
			this.erro += "Nome da unidade inválido!\n";
			this.erros = false;
		}
		if (new Senha().isValido(senha) == TiposValidacoes.NOTOK
				|| new Senha().isValido(repitaSenha) == TiposValidacoes.NOTOK) {
			this.erro += "Senha(s) inválida(s), ou não batem!\n";
			this.erros = false;
		}
		if (new Email().isValido(email) == TiposValidacoes.NOTOK) {
			this.erro += "Email inválido!\n";
			this.erros = false;
		}
		return this.erros;
	}

	public boolean validaLogin(final String email, final String senha) {
		this.erros = true;
		this.erro = "";
		if (new Senha().isValido(senha) == TiposValidacoes.NOTOK
				&& new Senha().isValido(senha) == TiposValidacoes.NOTOK) {
			this.erro += "Senha inválida!\n";
			this.erros = false;
		}
		if (new Email().isValido(email) == TiposValidacoes.NOTOK) {
			this.erro += "Email inválido!\n";
			this.erros = false;
		}
		return this.erros;
	}

	public boolean validaFuncionario(final String nome, final String senha, final String email, final String cargo,
			final LocalDate dataDeContratacao) {
		this.erros = true;
		this.erro = "";
		if (new Nome().isValido(nome) == TiposValidacoes.NOTOK) {
			this.erro += "Nome inválido!\n";
			this.erros = false;
		}
		if (new Senha().isValido(senha) == TiposValidacoes.NOTOK
				&& new Senha().isValido(senha) == TiposValidacoes.NOTOK) {
			this.erro += "Senha inválida!\n";
			this.erros = false;
		}
		if (new Email().isValido(email) == TiposValidacoes.NOTOK) {
			this.erro += "Email inválido!\n";
			this.erros = false;
		}
		if (new Nome().isValido(cargo) == TiposValidacoes.NOTOK) {
			this.erro += "Cargo inválido!\n";
			this.erros = false;
		}
		if (new Data().isValido(dataDeContratacao) == TiposValidacoes.NOTOK) {
			this.erro += "Data inválida!\n";
			this.erros = false;
		}
		return this.erros;
	}

	public String getValidado() {
		return this.erro;
	}

	public boolean validaLivro(final String nomeDoLivro, final String url, final String nomeAutor) {
		this.erros = true;
		this.erro = "";
		if (nomeDoLivro.equals("")) {
			this.erro += "Nome do livro é inválido!\n";
			this.erros = false;
		}
		if (new Url().isValido(url) == TiposValidacoes.NOTOK) {
			this.erro += "Link inválido!\n";
			this.erros = false;
		}
		if (new Nome().isValido(nomeAutor) == TiposValidacoes.NOTOK) {
			this.erro += "Nome do autor é inválido!\n";
			this.erros = false;
		}
		return this.erros;
	}
}
