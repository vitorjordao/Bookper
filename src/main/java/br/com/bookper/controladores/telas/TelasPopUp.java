package br.com.bookper.controladores.telas;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TelasPopUp {
	public TelasPopUp(final AlertType tipoDeAlerta, final String titulo, final String cabecalho, final String texto) {
		final Alert alert = new Alert(tipoDeAlerta);
		alert.setTitle(titulo);
		alert.setHeaderText(cabecalho);
		alert.setContentText(texto);
		alert.show();
	}
}
