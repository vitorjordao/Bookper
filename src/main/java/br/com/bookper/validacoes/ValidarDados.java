package br.com.bookper.validacoes;

public class ValidarDados {
	private String erro;
	private boolean erros;

	public boolean validaRegistro(String nome, String nomeUnidade, String senha, String repitaSenha, String email) {
		erros = true;
		erro = "";
		if (new Nome().isValido(nome) == TiposValidacoes.NOTOK) {
			erro += "Nome inválido! ";
			erros = false;
		}
		if (new Nome().isValido(nomeUnidade) == TiposValidacoes.NOTOK) {
			erro += "Nome da unidade inválido! ";
			erros = false;
		}
		if (new Senha().isValido(senha) == TiposValidacoes.NOTOK
				|| new Senha().isValido(repitaSenha) == TiposValidacoes.NOTOK) {
			erro += "Senha(s) inválida(s), ou não batem! ";
			erros = false;
		}
		if (new Email().isValido(email) == TiposValidacoes.NOTOK) {
			erro += "Email inválido! ";
			erros = false;
		}
		return erros;
	}

	public boolean validaLogin(String email, String senha) {
		erros = true;
		erro = "";
		if (new Senha().isValido(senha) == TiposValidacoes.NOTOK
				&& new Senha().isValido(senha) == TiposValidacoes.NOTOK) {
			erro += "Senha inválida! ";
			erros = false;
		}
		if (new Email().isValido(email) == TiposValidacoes.NOTOK) {
			erro += "Email inválido! ";
			erros = false;
		}
		return erros;
	}

	public String getValidado() {
		return erro;
	}
}
