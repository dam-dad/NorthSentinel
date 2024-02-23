package dad.northsentinel.mainmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dad.northsentinel.model.Mapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class PlayController implements Initializable {
	
	// model
	
	private Mapa mapa = new Mapa();
//	private List<Enemigo> enemigo = new ArrayList<>(); 
	
	// view

	private EventHandler<ActionEvent> onGoBack;

	@FXML
	private BorderPane view;
	
	@FXML
    private GridPane viewMenu;

    @FXML
    private BorderPane viewPlay;

	// Crear el ImageView para el enemigo
	ImageView enemyView = new ImageView(new Image("mapImages/enemigos/enemy.png"));

	// Crear el StackPane y agregar todos los elementos
	StackPane stackPane = new StackPane();

	public PlayController() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PlayView.fxml"));
			loader.setController(this);
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

		stackPane.getChildren().addAll(mapa.getMapa());
		viewPlay.setCenter(stackPane);

	}

	public BorderPane getView() {
		return view;
	}

}