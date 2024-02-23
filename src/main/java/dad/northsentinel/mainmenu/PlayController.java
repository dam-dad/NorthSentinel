package dad.northsentinel.mainmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class PlayController implements Initializable {

	private EventHandler<ActionEvent> onGoBack;

	@FXML
	private BorderPane view;
	
	@FXML
    private GridPane viewMenu;

    @FXML
    private BorderPane viewPlay;

	int[][] capa1 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };

	int[][] capa2 = { { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 10 }, { 10, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 4, 10 },
			{ 10, 0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 }, { 10, 0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 },
			{ 10, 0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 }, { 10, 0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 },
			{ 10, 0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 }, { 10, 0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 },
			{ 10, 0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 }, { 10, 0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 },
			{ 10, 0, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 }, { 10, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 4, 10 },
			{ 10, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, };

	int[][] capa3 = { { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 7, 1, 1, 1, 1, 1, 1, 1, 1, 8, 10, 10 },
			{ 10, 10, 10, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 6, 1, 1, 1, 1, 1, 1, 5, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 2, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 2, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 2, 10, 10, 10, 10 },
			{ 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 4, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, };

	Image[] assets_camino = { new Image("img/camino/barco.png"), new Image("img/camino/camino_central.png"),
			new Image("img/camino/camino_arriba.png"), new Image("img/camino/orilla_camino.png"),
			new Image("img/camino/esquina_1.png"), new Image("img/camino/esquina_2.png"),
			new Image("img/camino/esquina_3.png"), new Image("img/camino/esquina_4.png"),
			new Image("img/camino/base.png"), };

	Image[] assets_agua = { new Image("img/agua/agua.png"), };

	Image[] assets_suelo = { new Image("img/terreno/orilla_izquierda.png"),
			new Image("img/terreno/orilla_arriba_izquierda.png"), new Image("img/terreno/orilla_arriba.png"),
			new Image("img/terreno/orilla_arriba_derecha.png"), new Image("img/terreno/orilla_derecha.png"),
			new Image("img/terreno/orilla_abajo_derecha.png"), new Image("img/terreno/orilla_abajo.png"),
			new Image("img/terreno/orilla_abajo_izquierda.png"), new Image("img/terreno/suelo_arena.png"),
			new Image("img/terreno/suelo_verde.png"),

	};

	GridPane agua = crearFondo(capa1, assets_agua);
	GridPane suelo = crearMapa(capa2, assets_suelo);
	GridPane camino = crearCamino(capa3, assets_camino);

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

		stackPane.getChildren().addAll(agua, suelo, camino);

		viewPlay.setCenter(stackPane);

	}

	public GridPane crearFondo(int[][] capa1, Image[] assets_agua) {
		GridPane agua = new GridPane();
		agua.setGridLinesVisible(true);

		List<ColumnConstraints> cols = new ArrayList<ColumnConstraints>();
		for (int i = 0; i < capa1.length; i++) {
			cols.add(new ColumnConstraints());
		}
		List<RowConstraints> rows = new ArrayList<RowConstraints>();
		for (int i = 0; i < capa1[0].length; i++) {
			rows.add(new RowConstraints());
		}
		agua.getColumnConstraints().setAll(cols);
		agua.getRowConstraints().setAll(rows);

		for (int i = 0; i < capa1[0].length; i++) {
			for (int j = 0; j < capa1.length; j++) {
				ImageView view = new ImageView(assets_agua[capa1[j][i]]);
				view.setFitHeight(50);
				view.setFitWidth(50);
				agua.add(view, i, j);
			}
		}
		return agua;
	}

	public GridPane crearMapa(int[][] capa2, Image[] assets_suelo) {
		GridPane suelo = new GridPane();
		suelo.setGridLinesVisible(false);

		List<ColumnConstraints> cols = new ArrayList<ColumnConstraints>();
		for (int i = 0; i < capa2.length; i++) {
			cols.add(new ColumnConstraints());
		}
		List<RowConstraints> rows = new ArrayList<RowConstraints>();
		for (int i = 0; i < capa2[0].length; i++) {
			rows.add(new RowConstraints());
		}
		suelo.getColumnConstraints().setAll(cols);
		suelo.getRowConstraints().setAll(rows);

		for (int i = 0; i < capa2[0].length; i++) {
			for (int j = 0; j < capa2.length; j++) {
				ImageView view;
				if (capa2[j][i] != 10) {
					view = new ImageView(assets_suelo[capa2[j][i]]);
				} else {
					view = new ImageView(); // ImageView vacío
				}
				view.setFitHeight(50);
				view.setFitWidth(50);
				suelo.add(view, i, j);
			}
		}
		return suelo;
	}

	public GridPane crearCamino(int[][] capa3, Image[] assets_camino) {
		GridPane camino = new GridPane();
		camino.setGridLinesVisible(false);

		List<ColumnConstraints> cols = new ArrayList<ColumnConstraints>();
		for (int i = 0; i < capa3.length; i++) {
			cols.add(new ColumnConstraints());
		}
		List<RowConstraints> rows = new ArrayList<RowConstraints>();
		for (int i = 0; i < capa3[0].length; i++) {
			rows.add(new RowConstraints());
		}
		camino.getColumnConstraints().setAll(cols);
		camino.getRowConstraints().setAll(rows);

		for (int i = 0; i < capa3[0].length; i++) {
			for (int j = 0; j < capa3.length; j++) {
				ImageView view;
				if (capa3[j][i] != 10) {
					view = new ImageView(assets_camino[capa3[j][i]]);
				} else {
					view = new ImageView(); // ImageView vacío
				}
				view.setFitHeight(50);
				view.setFitWidth(50);
				camino.add(view, i, j);
			}
		}
		return camino;
	}

	public BorderPane getView() {
		return view;
	}

}