package dad.northsentinel.model;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
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
	
	public static Mapa supermapa;
	
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
			{ 10,  0,  8,  9,  8,  8,  8,  8,  8,  8,  8,  8,  8,  4, 10 },
			{ 10,  0,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 }, 
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 },
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 }, 
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 },
			{ 10,  0,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 }, 
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 },
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 }, 
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 },
			{ 10,  0,  8,  9,  9,  9,  9,  9,  9,  9,  9,  9,  8,  4, 10 }, 
			{ 10,  0,  8,  8,  8,  8,  8,  8,  8,  8,  9,  8,  8,  4, 10 },
			{ 10,  7,  6,  6,  6,  6,  6,  6,  6,  6,  6,  6,  6,  5, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, 
	};

	int[][] capa3 = { 
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 9,  7,  1,  1,  1,  1,  1,  1,  1,  1,  8, 10, 10 },
			{ 10, 10, 10,  2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10,  2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10,  2, 10, 10, 10, 10, 10, 10, 9, 10, 10, 10, 10 },
			{ 10, 10, 9,  6,  1,  1,  1,  1,  1,  1,  5, 9, 10, 10, 10 },
			{ 10, 10, 10, 9, 10, 10, 10, 10, 10, 10,  2, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,  2, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,  2, 10, 10, 10, 10 },
			{  0,  3,  1,  1,  1,  1,  1,  1,  1,  1,  4, 9, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 9, 10, 10, 10, 10 },
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
			new Image("img/terreno/suelo_torreta.png"),
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
	private Path path;
	
	public Mapa() {
		super();
		fondo = crearCapa(capa1, assets_agua);
		mapa = crearCapa(capa, assets);
		camino = crearCapa(capa3, assets_camino);
		
		// path del camino que siguen los enemigos
		
		// Crea el Path para el camino
		path = new Path();
		path.setStroke(Color.RED);
		path.setStrokeWidth(3);

		path.getElements().add(new MoveTo(50, 575));
		path.getElements().add(new LineTo(525, 575));
		path.getElements().add(new LineTo(525, 375));
		path.getElements().add(new LineTo(175, 375));
		path.getElements().add(new LineTo(175, 175));
		path.getElements().add(new LineTo(600, 175));
		
		area = new Pane(); // aquí es donde se mueven las entidades (balas, torres, enemigos)
		area.getChildren().add(path);
		
		getChildren().addAll(fondo, mapa, camino, area);
		
		setOnMouseClicked(e -> {
			System.out.println(e.getX() + "-" + e.getY());
			
			Point2D target = new Point2D(e.getX(), e.getY());
			
			Bala bala = new Bala(new Point2D(300, 300));
			bala.disparar(target);
			System.out.println(target);

			area.getChildren().add(bala);
			
			
			if (esPosicionValida(target)) {
		        
		        colocarTorretaConFondo(target); // Usa el nuevo método para posicionar la torreta
		        System.out.println("Torreta colocada en posición válida: " + target);
		    } else {
		        System.out.println("Posición no válida para colocar torreta.");
		    }
						
		});
		
		supermapa = this;
	}
	
	public void colocarTorretaConFondo(Point2D pos) {
	    Torreta nuevaTorreta = new Torreta();
	    nuevaTorreta.setTorretaPos(pos);

	    // Crea un rectángulo para el fondo
	    Rectangle fondoVerde = new Rectangle(50, 50, Color.GREEN);

	    // Crea un StackPane para contener el fondo y la torreta
	    StackPane torretaConFondo = new StackPane();
	    torretaConFondo.getChildren().addAll(fondoVerde, nuevaTorreta);

	    // Ajusta la posición del StackPane, no de la torreta individualmente
	    torretaConFondo.setLayoutX(pos.getX() - 25); // Ajusta según sea necesario
	    torretaConFondo.setLayoutY(pos.getY() - 25);

	    // Agrega el StackPane al área de juego
	    area.getChildren().add(torretaConFondo);
	}
	
	private boolean esPosicionValida(Point2D target) {
	    double x = target.getX();
	    double y = target.getY();
	    double centroX = 576; // Coordenada X del centro
	    double centroY = 576; // Coordenada Y del centro
	    double margenError = 3;

	    return x >= centroX - margenError && x <= centroX + margenError &&
	           y >= centroY - margenError && y <= centroY + margenError;
	}

	
	
    // Método para crear los enemigos en intervalos de tiempo
    public void crearEnemigos() {
        Path path = getPath();
        if (path.getElements().size() > 0 && path.getElements().get(0) instanceof MoveTo) {
            MoveTo primerPunto = (MoveTo) path.getElements().get(0);
            Timeline timeline = new Timeline();
            for (int i = 0; i < 5; i++) {
                Enemigo enemigo = new Enemigo();
                enemigo.setPos(new Point2D(primerPunto.getX(), primerPunto.getY()));
                getArea().getChildren().add(enemigo);
                KeyFrame keyFrame = new KeyFrame(Duration.seconds(i + 1), event -> {
                    enemigo.iniciarMovimiento();
                });
                timeline.getKeyFrames().add(keyFrame);
            }
            timeline.play();
        } else {
            System.out.println("No se pudo obtener el primer punto del camino.");
        }
    }

	public void destruir(Entidad entidad) {
		area.getChildren().remove(entidad);
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
				int x = i; // Guardar la posición x del ImageView
	            int y = j; // Guardar la posición y del ImageView
				pane.add(view, i, j);
			}
		}
		return pane;
	}
	
}
