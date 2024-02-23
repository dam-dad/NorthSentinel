package dad.northsentinel.model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class Mapa extends StackPane {
	
	private static final int VACIO = 10;
	
	int[][] capa1 = { 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
	};

	int[][] capa = { 
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10,  1,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  3, 10 }, 
			{ 10,  0,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  4, 10 },
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 }, 
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 },
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 }, 
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 },
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 }, 
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 },
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 }, 
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 },
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 }, 
			{ 10,  0,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  4, 10 },
			{ 10,  7,  6,  6,  6,  6,  6,  6,  6,  6,  6,  6,  6,  5, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, 
	};

	int[][] capa3 = { 
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10,  7,  1,  1,  1,  1,  1,  1,  1,  1,  8, 10, 10 },
			{ 10, 10, 10,  2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10,  2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10,  2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10,  6,  1,  1,  1,  1,  1,  1,  5, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,  2, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,  2, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,  2, 10, 10, 10, 10 },
			{  0,  3,  1,  1,  1,  1,  1,  1,  1,  1,  4, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, 
	};

	private static final Image[] assets_camino = { 
			new Image("img/camino/barco.png"), 
			new Image("img/camino/camino_central.png"),
			new Image("img/camino/camino_arriba.png"), 
			new Image("img/camino/orilla_camino.png"),
			new Image("img/camino/esquina_1.png"), 
			new Image("img/camino/esquina_2.png"),
			new Image("img/camino/esquina_3.png"), 
			new Image("img/camino/esquina_4.png"),
			new Image("img/camino/base.png"), 
	};

	private static final Image[] assets_agua = { 
			new Image("img/agua/agua.png"), 
	};

	private static final Image [] assets = { 
			new Image("img/terreno/orilla_izquierda.png"),
			new Image("img/terreno/orilla_arriba_izquierda.png"), 
			new Image("img/terreno/orilla_arriba.png"),
			new Image("img/terreno/orilla_arriba_derecha.png"), 
			new Image("img/terreno/orilla_derecha.png"),
			new Image("img/terreno/orilla_abajo_derecha.png"), 
			new Image("img/terreno/orilla_abajo.png"),
			new Image("img/terreno/orilla_abajo_izquierda.png"), 
			new Image("img/terreno/suelo_arena.png"),
			new Image("img/terreno/suelo_verde.png"),
	};
	
	private GridPane fondo;
	private GridPane mapa;
	private GridPane camino;
	private Pane area;
	
	public Mapa() {
		super();
		fondo = crearCapa(capa1, assets_agua);
		mapa = crearCapa(capa, assets);
		camino = crearCapa(capa3, assets_camino);
		area = new Pane(); // aquí es donde se mueven las entidades (balas, torres, enemigos)
		getChildren().addAll(fondo, mapa, camino, area);
	}
	
	public GridPane getFondo() {
		return fondo;
	}
	
	public GridPane getMapa() {
		return mapa;
	}
	
	public GridPane getCamino() {
		return camino;
	}
	
	public Pane getArea() {
		return area;
	}
	
	private GridPane crearCapa(int[][] capa, Image[] assets) {
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(false);

		List<ColumnConstraints> cols = new ArrayList<ColumnConstraints>();
		for (int i = 0; i < capa.length; i++) {
			cols.add(new ColumnConstraints());
		}
		List<RowConstraints> rows = new ArrayList<RowConstraints>();
		for (int i = 0; i < capa[0].length; i++) {
			rows.add(new RowConstraints());
		}
		pane.getColumnConstraints().setAll(cols);
		pane.getRowConstraints().setAll(rows);

		int width = capa[0].length;
		int height = capa.length;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				ImageView view = (capa[j][i] != VACIO) ? new ImageView(assets[capa[j][i]]) : new ImageView();
				view.setFitHeight(50);
				view.setFitWidth(50);
				pane.add(view, i, j);
			}
		}
		return pane;
	}
}
