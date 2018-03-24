package br.com.bookper.tests.testesmanuais;

import br.com.bookper.controladores.telas.ControlaTelas;
import javafx.application.Application;
import javafx.stage.Stage;

public class TestTelaIntermediaria extends Application {
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ControlaTelas controla = new ControlaTelas();
		controla.iniciarSimples("TelaIntermediaria.fxml");
	}
}
