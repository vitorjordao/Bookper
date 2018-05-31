package br.com.bookper.segurancaedados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ControlaUsuario {

	public void salvar(final String email, final String senha, final boolean salvar, final String emailGerente) {

		try {
			Scanner entrada;
			final FileOutputStream fileOutputStream = new FileOutputStream(
					"C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Local\\UsuarioLogado.txt");

			final PrintStream saida = new PrintStream(fileOutputStream);
			entrada = new Scanner(salvar + "");
			saida.println(entrada.nextLine());
			entrada.close();
			entrada = new Scanner(email);
			saida.println(entrada.nextLine());
			entrada.close();
			entrada = new Scanner(senha);
			saida.println(entrada.nextLine());
			entrada.close();
			entrada = new Scanner(emailGerente);
			saida.println(entrada.nextLine());
			entrada.close();
			saida.close();
		} catch (final Exception e) {
			System.out.println(e);
		}
	}

	public boolean verificarPermanenciaDeLogin() {
		try {
			final Scanner entrada = new Scanner(new FileInputStream(
					"C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Local\\UsuarioLogado.txt"));
			final boolean b = entrada.nextBoolean();
			entrada.close();
			return b;
		} catch (final Exception e) {
			System.out.println("Não achado o login");
			return false;
		}
	}

	public Scanner getCredenciais() {
		try {
			final Scanner entrada = new Scanner(new FileInputStream(
					"C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Local\\UsuarioLogado.txt"));

			return entrada;
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deslogar() {
		try {
			final FileOutputStream fileOutputStream = new FileOutputStream(
					"C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Local\\UsuarioLogado.txt");
			final PrintStream saida = new PrintStream(fileOutputStream);
			saida.print("");
			saida.close();
			fileOutputStream.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}

}
