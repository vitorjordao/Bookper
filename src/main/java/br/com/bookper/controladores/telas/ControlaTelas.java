package br.com.bookper.controladores.telas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControlaTelas {
	private Stage stage;

	public void iniciarPadrao(final String nome) {
		try {
			this.stage = new Stage();
			final Parent root = FXMLLoader.load(this.getClass().getResource("/br/com/bookper/telas/" + nome));
			final Scene scene = new Scene(root);
			this.stage.initStyle(StageStyle.UNDECORATED);
			this.stage.setScene(scene);
			this.stage.show();
		} catch (final Exception e) {
			System.out.println("Erro ao carregar tela");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void iniciarSimples(final String nome) {
		try {
			this.stage = new Stage();
			final Parent root = FXMLLoader.load(this.getClass().getResource("/br/com/bookper/telas/" + nome));
			final Scene scene = new Scene(root);
			this.stage.initStyle(StageStyle.UTILITY);
			this.stage.setScene(scene);
			this.stage.show();
		} catch (final Exception e) {
			System.out.println("Aqui tem erro! " + e);
		}
	}

	public void fechar(final Node node) {
		final Stage stage = (Stage) node.getScene().getWindow(); // Obtendo a janela
		// atual
		stage.close();
	}
}
