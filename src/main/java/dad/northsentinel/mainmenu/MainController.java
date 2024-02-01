package dad.northsentinel.mainmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class MainController implements Initializable {

	private MenuController menuController;
	private SettingsController settingsController;
	private HowToPlayController howToPlayController;
	
	@FXML
	private BorderPane view;

	public MainController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		menuController = new MenuController();
		menuController.setOnSettings(e -> {
			view.setCenter(settingsController.getView());
		});
		
		menuController.setOnHowToPlay(e -> {
			view.setCenter(howToPlayController.getView());
		});
		
		settingsController = new SettingsController();
		settingsController.setOnGoBack(e -> {
			view.setCenter(menuController.getView());
		});
		
		howToPlayController = new HowToPlayController();
		howToPlayController.setOnGoBack(e -> {
			view.setCenter(menuController.getView());
		});
		
		view.setCenter(menuController.getView());

	}

	public BorderPane getView() {
		return view;
	}

}
