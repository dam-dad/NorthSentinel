package dad.northsentinel.mainmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class ControllerMenu implements Initializable {

	@FXML
	private BorderPane view;

	@FXML
	void onGoHowToPlay(ActionEvent event) {

	}

	@FXML
	void onGoPlay(ActionEvent event) {

	}

	@FXML
	void onGoSettings(ActionEvent event) {

	}

	public ControllerMenu() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainMenu.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public BorderPane getView() {
		return view;
	}
	
}
