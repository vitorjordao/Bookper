package br.com.bookper.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EnviadorDeEmail {
	public boolean enviadorDeEmail(final String host, final int porta, final String emailAutenticador,
			final String senha, final boolean usaDeCriptografiaOHost, final String emailEnviador, final String titulo,
			final String mensagem, final String emailDestinatario) {
		try {
			final Email email = new SimpleEmail();

			email.setHostName(host);
			email.setSmtpPort(porta);
			email.setAuthenticator(new DefaultAuthenticator(emailAutenticador, senha));
			email.setSSLOnConnect(usaDeCriptografiaOHost);

			email.setFrom(emailEnviador);
			email.setSubject(titulo);
			email.setMsg(mensagem);
			email.addTo(emailDestinatario);
			email.send();

			return true;
		} catch (final EmailException e) {
			System.out.println("Erro ao enviar a mensagem");
			e.printStackTrace();
			return false;
		}
	}
}
