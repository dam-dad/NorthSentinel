package dad.northsentinel.model;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Mapa extends StackPane {
	
	
	private List<Torreta> torretas = new ArrayList<>();


	public static Mapa supermapa;

	private static final int VACIO = 10;

	int[][] capa1 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };

	private static final Image[] assets_agua = { new Image("assets/agua/agua.png"), };

	int[][] capa2 = {
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 }, 
			{ 10, 10, 10, 10, 10, 10,10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, };

	private static final Image[] assets_mapa = { new Image("assets/terreno/suelo_verde.png"), // 0
			new Image("assets/terreno/suelo_arena.png"), // 1
			new Image("assets/terreno/orilla_arriba.png"), // 2
			new Image("assets/terreno/orilla_abajo.png"), // 3
	};

	int[][] capa3 = {
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 6, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 0, 0, 0, 0, 0, 0, 0, 3, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 1, 10, 10, 10, 10, 10, 10, 10, 1, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 6, 10, 10, 10, 10, 10, 6, 10, 1, 10, 6, 10, 10, 10, 6, 10, 1, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 1, 10, 10, 10, 10, 10, 10, 10, 1, 10, 6, 10, 10, 10, 10, 10, 10 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 10, 10, 10, 10, 10, 10, 10, 1, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 6, 10, 10, 10, 10, 10, 10, 10, 10, 10, 6, 10, 4, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 6, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
	};

	private static final Image[] assets_camino = { new Image("assets/camino/camino_central.png"), // 0
			new Image("assets/camino/camino_arriba.png"), // 1
			new Image("assets/camino/esquina_1.png"), // 3
			new Image("assets/camino/esquina_2.png"), // 4
			new Image("assets/camino/esquina_3.png"), // 5
			new Image("assets/camino/esquina_4.png"), // 6
			new Image("assets/camino/suelo_torreta.png"), // 7
	};

	private GridPane fondo;
	private GridPane mapa;
	private GridPane camino;
	private Pane area;
	private Path path;

	public Mapa() {
		super();
		fondo = crearCapa(capa1, assets_agua);
		mapa = crearCapa(capa2, assets_mapa);
		camino = crearCapa(capa3, assets_camino);

		// Crea el Path para el camino para los enemigos
		path = crearRuta();
		
		area = new Pane(); // aquí es donde se mueven las entidades (balas, torres, enemigos)
		area.getChildren().add(path);

		getChildren().addAll(fondo, mapa, camino, area);

		setOnMouseClicked(e -> {
			// System.out.println(e.getX() + "-" + e.getY());

			Point2D target = new Point2D(e.getX(), e.getY());

//			Bala bala = new Bala(new Point2D(300, 300));
//			bala.disparar(target);
//
//			area.getChildren().add(bala);

			//Torreta nuevaTorreta = new Torreta(new Point2D(275, 525));
//			
			//Bala bala = new Bala(nuevaTorreta.getPos());
			//bala.disparar(target);
			//area.getChildren().add(bala);
//
			boolean torretaColocada = false;

		    if (esPosicionValida(target)) {
		        Torreta torretaExistente = obtenerTorretaEnPosicion(target);
		        if (torretaExistente == null) {
		            // No hay una torreta en esta posición, así que colocamos una nueva
		            Torreta nuevaTorreta = new Torreta(target);
		            colocarTorreta(target, nuevaTorreta, area);
		            System.out.println("Torreta colocada en posición válida: " + target);
		            torretaColocada = true;
		        }
		    }

		    // Disparar balas desde todas las torretas, incluida la nueva si se colocó
		    for (Torreta torreta : torretas) {
		        torreta.dispararBala(torretaColocada ? target : null, area);
		    }
		});

		supermapa = this;
	}
	
	private Torreta obtenerTorretaEnPosicion(Point2D posicion) {
	    for (Torreta torreta : torretas) {
	        if (torreta.getPos().equals(posicion)) {
	            return torreta;
	        }
	    }
	    return null; // No se encontró ninguna torreta en la posición especificada
	}


	
	public void colocarTorreta(Point2D pos, Torreta nuevaTorreta, Pane area) {
	    // Ajusta la posición de la torreta dentro del área de juego
	    nuevaTorreta.setPos(pos);

	    // Agrega la torreta al área de juego
	    area.getChildren().add(nuevaTorreta);
	    
	    // Agrega la torreta a la lista de torretas del mapa
	    torretas.add(nuevaTorreta);
	}


	private boolean esPosicionValida(Point2D target) {
		// Lista de todas las posiciones centrales válidas para colocar torretas
		List<Point2D> posicionesValidas = List.of(
						new Point2D(275 , 525),
						new Point2D(775, 525), 
						new Point2D(575, 375),
						new Point2D(1125, 575), 
						new Point2D(775, 375), 
						new Point2D(375, 375), 
						new Point2D(75  , 375), 
						new Point2D(975, 425), 
						new Point2D(675, 225)
		);
		double margenError = 25; // Tolerancia alrededor de cada posición válida

		// Verifica si el punto de clic está dentro del margen de error de alguna
		// posición válida
		for (Point2D pos : posicionesValidas) {
			if (target.getX() >= pos.getX() - margenError && target.getX() <= pos.getX() + margenError
					&& target.getY() >= pos.getY() - margenError && target.getY() <= pos.getY() + margenError) {
				return true; // El punto de clic está dentro de una posición válida
			}
		}
		return false; // El punto de clic no está dentro de ninguna posición válida
	}
		

	public void crearEnemigos() {

		Path path = getPath();
		if (!path.getElements().isEmpty() && path.getElements().get(0) instanceof MoveTo) {
			MoveTo primerPunto = (MoveTo) path.getElements().get(0);
			for (int i = 0; i < 1; i++) {
				Enemigo enemigo = new Enemigo();
				enemigo.setPos(new Point2D(primerPunto.getX(), primerPunto.getY()));
				getArea().getChildren().add(enemigo);
				enemigo.iniciarMovimiento(i * 2); // Asegura pasar el retraso como argumento
			}
		} else {
			System.out.println("No se pudo obtener el primer punto del camino.");
		}
	}

	public void destruir(Entidad entidad) {
		area.getChildren().remove(entidad);
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
	
	private Path crearRuta() {
		path = new Path();
		path.setStroke(Color.RED);
		path.setStrokeWidth(3);

		path.getElements().add(new MoveTo(0, 475));
		path.getElements().add(new LineTo(475, 475));
		path.getElements().add(new LineTo(475, 275));
		path.getElements().add(new LineTo(875, 275));
		path.getElements().add(new LineTo(875, 525));
		path.getElements().add(new LineTo(1310, 525));
		
		return path;
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

	public Path getPath() {
		return path;
	}

	public List<Torreta> getTorretas() {
		return torretas;
	}

	public void setTorretas(List<Torreta> torretas) {
		this.torretas = torretas;
	}
	
	

}
