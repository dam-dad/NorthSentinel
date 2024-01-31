package dad.northsentinel.mainmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import javafx.fxml.Initializable;

public class SettingsController implements Initializable {

    private EventHandler<ActionEvent> onGoBack;
	
	@FXML
	private BorderPane view;

	@FXML
	private ImageView volumeImage;

	@FXML
	private Label volumeLabel;

	@FXML
	private Slider volumeSlider;

	public SettingsController() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SettingsView.fxml"));
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

    @FXML
    void onGoBack(ActionEvent event) {
        if (onGoBack != null) {
            onGoBack.handle(event);
        }
    }

    public void setOnGoBack(EventHandler<ActionEvent> onGoBack) {
        this.onGoBack = onGoBack;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public BorderPane getView() {
		return view;
	}

}
