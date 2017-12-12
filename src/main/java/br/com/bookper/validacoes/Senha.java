package br.com.bookper.validacoes;

public class Senha implements Validacoes{
	private static String senha;
	private static String repitaSenha;
	private static int count;
	public TiposValidacoes isValido(String dado) {
		if(count != 1) {
			senha = dado;
		}else {
			repitaSenha = dado;
		}
		
		
		if(dado.length() >= 8) {
			if(count == 1) {
				count =0;
				if(senha.equals(repitaSenha)) {
					return TiposValidacoes.OK;
				}
			}
			return TiposValidacoes.TEST;
		}
		return TiposValidacoes.NOTOK;
	}
	
}
