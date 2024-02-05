package dad.northsentinel.mainmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class MenuController implements Initializable {

	private EventHandler<ActionEvent> onPlay;
	private EventHandler<ActionEvent> onSettings;
	private EventHandler<ActionEvent> onHowToPlay;

	@FXML
	private BorderPane view;

	public MenuController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	@FXML
	void onGoPlay(ActionEvent event) {
		if (onPlay != null) {
			onPlay.handle(event);
		}

	}

	@FXML
	void onGoSettings(ActionEvent event) {
		if (onSettings != null) {
			onSettings.handle(event);
		}

	}

	@FXML
	void onGoHowToPlay(ActionEvent event) {
		if (onHowToPlay != null) {
			onHowToPlay.handle(event);
		}

	}

	public void setOnPlay(EventHandler<ActionEvent> onPlay) {
		this.onPlay = onPlay;
	}

	public void setOnSettings(EventHandler<ActionEvent> onSettings) {
		this.onSettings = onSettings;
	}

	public void setOnHowToPlay(EventHandler<ActionEvent> onHowToPlay) {
		this.onHowToPlay = onHowToPlay;
	}

	public BorderPane getView() {
		return view;
	}

}
