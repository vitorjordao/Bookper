/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bookper;

import java.io.IOException;
import java.util.Scanner;

import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.segurancaedados.ControlaUsuario;
import br.com.bookper.validaentidades.ValidarLogin;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Vitor Jordão
 */
public class IniciadorDoFX extends Application {
	@Override
	public void start(final Stage stage) throws IOException {
		final ControlaTelas tela = new ControlaTelas();
		if (this.verificaLogin())
			tela.iniciarPadrao("TelaIntermediaria.fxml");
		else
			tela.iniciarPadrao("LoginESenha.fxml");

	}

	public static void main(final String[] args) {
		launch(args);
	}

	private boolean verificaLogin() {
		final ControlaUsuario controlaUsuario = new ControlaUsuario();
		final Scanner credenciais = controlaUsuario.getCredenciais();
		if (controlaUsuario.verificarPermanenciaDeLogin() && credenciais.nextBoolean()) {
			final String email = credenciais.next();
			final String senha = credenciais.next();
			final ValidarLogin validarLogin = new ValidarLogin(email, senha, true);
			return validarLogin.estaOK();
		}
		return false;
	}

}
