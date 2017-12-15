package br.com.bookper.validacoes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email implements Validacoes {

	public TiposValidacoes isValido(String email) {
		if ((email == null) || (email.trim().length() < 5))
			return TiposValidacoes.NOTOK;

		String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
		Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return TiposValidacoes.OK;
		}
		return TiposValidacoes.NOTOK;
	}
}
