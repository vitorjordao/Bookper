/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bookper;

import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.informacoes.InformacoesSoftware;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author LABINFO
 */
public class IniciadorDoFX extends Application {

    @Override
    public void start(Stage stage) {
    	ControlaTelas tela = new ControlaTelas();
    	
    	tela.iniciarPadrao("LoginESenha.fxml");
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	InformacoesSoftware info = new InformacoesSoftware();
    	info.carregarDados();
        launch(args);
    }

}
