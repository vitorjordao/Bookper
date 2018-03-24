package br.com.bookper.segurancaedados;

import org.mindrot.jbcrypt.BCrypt;

public class Criptografia {

	public static String transformaStringEmHash(final String dado) {
		final String salto = BCrypt.gensalt();
		final String hashed = BCrypt.hashpw(dado, salto);
		return hashed;
	}

	public static boolean validaStringComHash(final String string, final String stringRetornada) {
		if (stringRetornada == null)
			return false;

		return BCrypt.checkpw(string, stringRetornada);
	}

}
