package br.com.bookper.dadosnamaquina;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ControlaUsuario {

	public void salvar(String email, String senha, boolean salvar) {
		try {
			Scanner entrada;
			PrintStream saida = new PrintStream(new FileOutputStream("UsuarioLogado.txt"));
			entrada = new Scanner(salvar + "");
			saida.println(entrada.nextLine());
			entrada.close();
			entrada = new Scanner(email);
			saida.println(entrada.nextLine());
			entrada.close();
			entrada = new Scanner(senha);
			saida.println(entrada.nextLine());
			entrada.close();
			saida.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean verificarPermanenciaDeLogin() {
		try {
			Scanner entrada = new Scanner(new FileInputStream("UsuarioLogado.txt"));
			boolean b = entrada.nextBoolean();
			entrada.close();
			return b;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public Scanner getCredenciais() {
		try {
			Scanner entrada = new Scanner(new FileInputStream("UsuarioLogado.txt"));
			entrada.nextLine();
			return entrada;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
