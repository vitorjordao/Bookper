/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bookper;

import java.io.IOException;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.bookper.coneccoes.DAO.GerenteDAO;
import br.com.bookper.coneccoes.util.JPAUtil;
import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.dadosnamaquina.ControlaUsuario;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Vitor Jordão
 */
public class IniciadorDoFX extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		ControlaTelas tela = new ControlaTelas();
		if (verificaLogin()) {
			tela.iniciarPadrao("TelaIntermediaria.fxml");
		}
		else
			tela.iniciarPadrao("LoginESenha.fxml");
	}

	public static void main(String[] args) {
		launch(args);
	}

	private boolean verificaLogin() {
		ControlaUsuario controlaUsuario = new ControlaUsuario();
		if (controlaUsuario.verificarPermanenciaDeLogin()) {
			EntityManager em = new JPAUtil().getEntityManager();
			GerenteDAO gerenteDAO = new GerenteDAO(em);
			Scanner credenciais = controlaUsuario.getCredenciais();
			credenciais.nextLine();
			return gerenteDAO.buscarLogin(credenciais.nextLine(), credenciais.nextLine());
		}
		return false;
	}

}
