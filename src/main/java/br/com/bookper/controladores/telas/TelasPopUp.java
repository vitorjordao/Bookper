package br.com.bookper.controladores.telas;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TelasPopUp {
	public TelasPopUp(AlertType tipoDeAlerta, String titulo, String cabecalho, String texto) {
		Alert alert = new Alert(tipoDeAlerta);
		alert.setTitle(titulo);
		alert.setHeaderText(cabecalho);
		alert.setContentText(texto);
		alert.show();
	}
}
