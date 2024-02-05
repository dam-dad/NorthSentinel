package dad.northsentinel.mainmenu;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.northsentinel.main.App;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class MainController implements Initializable {

	private MenuController menuController;
	private SettingsController settingsController;
	private HowToPlayController howToPlayController;
	private PlayController playController;
	
//	private App app;
//	private MediaPlayer mediaPlayer;
	
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
				
//		app = new App();
		
		menuController = new MenuController();
		menuController.setOnSettings(e -> {
			view.setCenter(settingsController.getView());
		});
		
		menuController.setOnHowToPlay(e -> {
			view.setCenter(howToPlayController.getView());
		});
		
		menuController.setOnPlay(e -> {
			view.setCenter(playController.getView());
//			changedMediaPlayer("C:\\2023-2024\\NorthSentinel\\src\\main\\resources\\soundTrack\\musicajuego.mp3");
		});
		
		settingsController = new SettingsController();
		settingsController.setOnGoBack(e -> {
			view.setCenter(menuController.getView());
		});
		
		howToPlayController = new HowToPlayController();
		howToPlayController.setOnGoBack(e -> {
			view.setCenter(menuController.getView());
		});
		
		playController = new PlayController();
		playController.setOnGoBack(e -> {
			view.setCenter(menuController.getView());
			
		});
		
		view.setCenter(menuController.getView());
	}
	
//	private MediaPlayer changedMediaPlayer(String url) {
//		app.getMediaPlayer().stop();
//		Media media = new Media(new File(url).toURI().toString());
//		mediaPlayer = new MediaPlayer(media);
//		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
//      mediaPlayer.play();
//		return mediaPlayer;
//	}
	
	public BorderPane getView() {
		return view;
	}

}
