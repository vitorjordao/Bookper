package br.com.bookper.tests.testesmanuais;

import java.util.Scanner;

import br.com.bookper.segurancaedados.ControlaUsuario;

public class TestControlaUsuario {
	public static void main(String[] args) {
		ControlaUsuario controlaUsuario = new ControlaUsuario();
		System.out.println(controlaUsuario.verificarPermanenciaDeLogin() + "");
		Scanner s = controlaUsuario.getCredenciais();
		while (s.hasNextLine()) {
			System.out.println(s.nextLine());
		}
		s.close();
	}
}
