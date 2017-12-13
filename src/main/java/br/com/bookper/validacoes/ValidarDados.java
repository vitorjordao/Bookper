package br.com.bookper.validacoes;

public class ValidarDados {
	private String erro = "";
	public ValidarDados(String nome, String nomeUnidade, String senha, String repitaSenha, String email) {
		if(new Nome().isValido(nome) == TiposValidacoes.NOTOK){
			erro += "Nome inválido! ";
		}
		if(new Nome().isValido(nomeUnidade) == TiposValidacoes.NOTOK){
			erro += "Nome da unidade inválido! ";
		}
		if(new Senha().isValido(senha) == TiposValidacoes.NOTOK || new Senha().isValido(repitaSenha) == TiposValidacoes.NOTOK) {
			erro += "Senha(s) inválida(s), ou não batem! ";
		}
		if(new Email().isValido(email) == TiposValidacoes.NOTOK){
			erro += "Email inválido! ";
		}
	}
	
	public String getValidado() {
		return erro;
	}
}
