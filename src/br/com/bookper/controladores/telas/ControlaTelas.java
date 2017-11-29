package br.com.bookper.controladores.telas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControlaTelas {
	private Stage stage;
	public void iniciarPadrao(String nome) {
		try{
			stage =  new Stage();
	        Parent root = FXMLLoader.load(getClass().getResource("/br/com/bookper/telas/"+nome));
	        Scene scene = new Scene(root);
	        stage.initStyle(StageStyle.UNDECORATED);
	        stage.setScene(scene);
	        stage.show();
    	}catch(Exception e) {
    		System.out.println("Aqui tem erro! "+e);
    	}
	}
	public void fechar(Node node) {
		Stage stage = (Stage) node.getScene().getWindow(); //Obtendo a janela atual
	    stage.close();
	}
}
