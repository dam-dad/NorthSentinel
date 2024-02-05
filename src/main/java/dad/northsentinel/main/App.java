package dad.northsentinel.main;

import java.io.File;

import dad.northsentinel.mainmenu.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class App extends Application {
	
	private MediaPlayer mediaPlayer;
	
	public void start(Stage primaryStage) throws Exception {
		
        MainController controller = new MainController();

        Scene scene = new Scene(controller.getView(), 800, 600);
        
        mediaPlayer = createMediaPlayer("C:\\2023-2024\\NorthSentinel\\src\\main\\resources\\soundTrack\\musicamenu.mp3");
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        
		primaryStage.getIcons().add(new Image("/images/logo.png"));
        primaryStage.setTitle("NorthSentinel");
        primaryStage.setScene(scene);
        
        primaryStage.setOnCloseRequest(event -> {
            mediaPlayer.stop();
            mediaPlayer.dispose();
        });
        
        primaryStage.show();
		
	}
	
	private MediaPlayer createMediaPlayer(String musicFilePath) {
        Media media = new Media(new File(musicFilePath).toURI().toString());
        return new MediaPlayer(media);
    }

	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}

	public void setMediaPlayer(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}
	
}

//Autores: Iván Garrido, Feliciano Pérez y Samuel Padrón.

