package dad.northsentinel.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Mapa {
	
	int[][] capa1 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };

	int[][] capa2 = { 
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10,  1,  2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 10 }, 
			{ 10,  0,  8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 4, 10 },
			{ 10,  0,  8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 }, 
			{ 10,  0,  8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 },
			{ 10,  0,  8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 }, 
			{ 10,  0,  8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 },
			{ 10,  0,  8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 }, 
			{ 10,  0,  8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 },
			{ 10,  0,  8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 }, 
			{ 10,  0,  8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 },
			{ 10,  0,  8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8, 4, 10 }, 
			{ 10,  0,  8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 4, 10 },
			{ 10,  7,  6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, 
	};

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

	Image[] assets_camino = { 
			new Image("img/camino/barco.png"), 
			new Image("img/camino/camino_central.png"),
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
	
	public List<GridPane> getMapa() {
		GridPane agua = crearFondo(capa1, assets_agua);
		GridPane suelo = crearMapa(capa2, assets_suelo);
		GridPane camino = crearCamino(capa3, assets_camino);
		return Arrays.asList(agua, suelo, camino);
	}

}
