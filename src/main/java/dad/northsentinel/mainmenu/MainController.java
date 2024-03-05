package dad.northsentinel.mainmenu;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

/**
 * Controlador principal que gestiona la navegación entre las diferentes vistas del menú.
 */

public class MainController implements Initializable {

	/**
     * Se inicializan todos los controles para cada vista del menú.
     */
	
	private MenuController menuController;
	private SettingsController settingsController;
	private HowToPlayController howToPlayController;
	private PlayController playController;
	private MediaPlayer mediaPlayerMenu;
	private MediaPlayer mediaPlayerJuego;

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

		String menuMusicPath = new File("src/main/resources/soundTrack/musicamenu.mp3").toURI().toString();
		Media mediaMenu = new Media(menuMusicPath);
		mediaPlayerMenu = new MediaPlayer(mediaMenu);
		mediaPlayerMenu.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayerMenu.play();

		menuController = new MenuController();
		menuController.setOnSettings(e -> {
			view.setCenter(settingsController.getView());
		});

		menuController.setOnHowToPlay(e -> {
			view.setCenter(howToPlayController.getView());
		});

		menuController.setOnPlay(e -> {
			mediaPlayerMenu.stop();
			String juegoMusicPath = new File("src/main/resources/soundTrack/musicajuego.mp3").toURI().toString();
			Media mediaJuego = new Media(juegoMusicPath);
			mediaPlayerJuego = new MediaPlayer(mediaJuego);
			mediaPlayerJuego.play();
			view.setCenter(playController.getView());

		});

		settingsController = new SettingsController();
		settingsController.setMainController(this);
		settingsController.setOnGoBack(e -> {
			view.setCenter(menuController.getView());
		});

		howToPlayController = new HowToPlayController();
		howToPlayController.setOnGoBack(e -> {
			view.setCenter(menuController.getView());
		});

		playController = new PlayController();
		playController.setOnGoBack(e -> {
			mediaPlayerJuego.stop();
			mediaPlayerMenu.play();
			view.setCenter(menuController.getView());

		});

		settingsController.volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
			double volume = newValue.doubleValue() / 100;
			if (mediaPlayerMenu != null) {
				mediaPlayerMenu.setVolume(volume);
			}
			if (mediaPlayerJuego != null) {
				mediaPlayerJuego.setVolume(volume);
			}
		});

		view.setCenter(menuController.getView());
	}
	
	/**
     * Obtiene el reproductor de música para el menú.
     * @return El reproductor de música para el menú.
     */

	public MediaPlayer getMediaPlayerMenu() {
		return mediaPlayerMenu;
	}

	public MediaPlayer getMediaPlayerJuego() {
		return mediaPlayerJuego;
	}

	public BorderPane getView() {
		return view;
	}

}
