package dad.northsentinel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dad.northsentinel.main.App;
import dad.northsentinel.mainmenu.PlayController;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
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
import javafx.stage.Stage;


/**
 * Clase Mapa que representa el área de juego, incluyendo la gestión de torretas, entidades, y la generación de oleadas de enemigos.
 */
public class Mapa extends StackPane {

	private static List<Torreta> torretas = new ArrayList<>();

	private List<Entidad> entidades = new ArrayList<>();

	public static Mapa supermapa;

	private int oleada = 1;

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

	private static final Image[] assets_agua = { new Image("assets/agua/agua.png"), // 0
	};

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
			{ 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 }, { 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, };

	private static final Image[] assets_mapa = { new Image("assets/terreno/suelo_verde.png"), // 0
			new Image("assets/terreno/suelo_arena.png"), // 1
			new Image("assets/terreno/orilla_arriba.png"), // 2
			new Image("assets/terreno/orilla_abajo.png"), // 3
	};

	int[][] capa3 = {
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 9, 7, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 9, 10, 10, 10, 10 },
			{ 10, 10, 9, 7, 10, 10, 10, 10, 10, 10, 10, 10, 10, 6, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 7, 8, 7, 10, 10, 10, 10, 5, 0, 0, 0, 0, 0, 0, 0, 3, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 1, 10, 10, 10, 10, 10, 10, 10, 1, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 6, 10, 10, 10, 10, 10, 6, 10, 1, 10, 6, 10, 10, 10, 6, 10, 1, 10, 10, 10, 9, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 1, 10, 10, 10, 10, 10, 10, 10, 1, 10, 6, 10, 10, 10, 10, 10, 10 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 10, 10, 8, 7, 8, 10, 10, 1, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 6, 10, 10, 10, 10, 10, 10, 10, 8, 10, 6, 10, 4, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 6, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10 }, };

	private static final Image[] assets_camino = { new Image("assets/camino/camino_central.png"), // 0
			new Image("assets/camino/camino_arriba.png"), // 1
			new Image("assets/camino/esquina_1.png"), // 2
			new Image("assets/camino/esquina_2.png"), // 3
			new Image("assets/camino/esquina_3.png"), // 4
			new Image("assets/camino/esquina_4.png"), // 5
			new Image("assets/camino/suelo_torreta.png"), // 6
			new Image("assets/decoracion/palmera.png"), new Image("assets/decoracion/arbusto.png"),
			new Image("assets/decoracion/roca_grande.png"), };

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
			Point2D target = new Point2D(e.getX(), e.getY());

			if (esPosicionValida(target)) {
				if (PlayController.getMonedas() >= Torreta.COSTO_TORRETA) { // Verificar si tienes suficientes monedas
					boolean confirmado = mostrarDialogoColocarTorreta(App.primarySatge,
							"¿Estás seguro de realizar esta acción? Te costará " + Torreta.COSTO_TORRETA + " monedas.");
					if (confirmado) {
						Torreta torretaExistente = obtenerTorretaEnPosicion(target);
						if (torretaExistente == null) {
							Torreta nuevaTorreta = new Torreta(target);
							colocarTorreta(target, nuevaTorreta, area);
							PlayController.restarMonedas(Torreta.COSTO_TORRETA);
						}
					}
				} else {
					System.out.println("No tienes suficientes monedas para colocar una torreta.");
				}
			} else {

			}
		});

		supermapa = this;
	}

	private boolean esPosicionValida(Point2D target) {
		// Lista de todas las posiciones válidas para colocar torretas
		List<Point2D> posicionesValidas = List.of(new Point2D(275, 525), new Point2D(775, 525), new Point2D(575, 375),
				new Point2D(1125, 575), new Point2D(775, 375), new Point2D(375, 375), new Point2D(75, 375),
				new Point2D(975, 425), new Point2D(675, 225));
		double margenError = 25; // Tolerancia alrededor de cada posición válida

		// Verifica si el punto de clic está dentro del margen de error de alguna
		for (Point2D pos : posicionesValidas) {
			if (target.getX() >= pos.getX() - margenError && target.getX() <= pos.getX() + margenError
					&& target.getY() >= pos.getY() - margenError && target.getY() <= pos.getY() + margenError) {
				return true; // El punto de clic está dentro de una posición válida
			}
		}
		return false;
	}
	
	
	 /**
     * Obtiene una torreta existente en la posición especificada.
     * @param posicion La posición en la que se busca la torreta.
     * @return La torreta en la posición especificada o null si no hay ninguna.
     */
	private Torreta obtenerTorretaEnPosicion(Point2D posicion) {
		for (Torreta torreta : torretas) {
			if (torreta.getPos().equals(posicion)) {
				return torreta;
			}
		}
		return null;
	}
	
	
	 /**
     * Coloca una torreta en la posición especificada dentro del área de juego.
     * @param pos La posición en la que se colocará la torreta.
     * @param nuevaTorreta La torreta a colocar.
     * @param area El área de juego donde se colocará la torreta.
     */
	public void colocarTorreta(Point2D pos, Torreta nuevaTorreta, Pane area) {
		nuevaTorreta.setPos(pos);
		// Agrega la torreta al área de juego y añadirla a la lista
		area.getChildren().add(nuevaTorreta);
		torretas.add(nuevaTorreta);
		entidades.add(nuevaTorreta);
	}

	// crear la oleada de enemigos
	public void generarOleada() {
		int cantidadEnemigos = oleada * 5; // Aumentar la cantidad de enemigos según el nivel de dificultad
		Path path = getPath();
		if (!path.getElements().isEmpty() && path.getElements().get(0) instanceof MoveTo) {
			MoveTo primerPunto = (MoveTo) path.getElements().get(0);
			for (int i = 0; i < cantidadEnemigos; i++) {
				Enemigo enemigo = new Enemigo();
				enemigo.setVida(enemigo.getVida() * (oleada * 0.50));

				if (oleada < 5) {
					enemigo.setVelocidad(enemigo.getVelocidad() - oleada);
				} else {
					enemigo.setVelocidad(6);
				}
				System.out.println(enemigo.getVelocidad());

				enemigo.setPos(new Point2D(primerPunto.getX(), primerPunto.getY()));
				getArea().getChildren().add(enemigo);
				Mapa.supermapa.getEntidades().add(enemigo);
				enemigo.setVisible(false);
				enemigo.iniciarMovimiento(i * 1); // Asegura pasar el retraso como argumento
			}
		} else {
			System.out.println("No se pudo obtener el primer punto del camino.");
		}
	}

	public void destruir(Entidad entidad) {
		entidades.remove(entidad);
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

	// creacion camino enemigos
	private Path crearRuta() {
		path = new Path();
		path.setStroke(Color.TRANSPARENT);
		path.setStrokeWidth(3);

		path.getElements().add(new MoveTo(0, 475));
		path.getElements().add(new LineTo(475, 475));
		path.getElements().add(new LineTo(475, 275));
		path.getElements().add(new LineTo(875, 275));
		path.getElements().add(new LineTo(875, 525));
		path.getElements().add(new LineTo(1310, 525));

		return path;
	}

	public void reiniciarJuego() {
		area.getChildren().removeAll(torretas);
		torretas.clear();

		area.getChildren().removeAll(entidades);
		entidades.clear();
	}

	/**
     * Muestra un diálogo de confirmación para colocar una torreta.
     * @param stage El Stage principal.
     * @param mensaje El mensaje a mostrar en el diálogo.
     * @return true si el usuario confirma, false en caso contrario.
     */
	public static boolean mostrarDialogoColocarTorreta(Stage stage, String mensaje) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("");
		alert.setHeaderText("¿Colocar torreta aquí?");
		alert.setContentText(mensaje);

		ButtonType botonSi = new ButtonType("Sí", ButtonBar.ButtonData.YES);
		ButtonType botonNo = new ButtonType("No", ButtonBar.ButtonData.NO);
		alert.getButtonTypes().setAll(botonSi, botonNo);

		Optional<ButtonType> resultado = alert.showAndWait();

		return resultado.isPresent() && resultado.get() == botonSi;
	}

	// getters y setters

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

	public int getOleada() {
		return oleada;
	}

	public void setOleada(int oleada) {
		this.oleada = oleada;
	}

	public int aumentarOleada() {
		return ++oleada;
	}

	public List<Torreta> getTorretas() {
		return torretas;
	}

	public void setTorretas(List<Torreta> torretas) {
		this.torretas = torretas;
	}

	public List<Entidad> getEntidades() {
		return entidades;
	}

	public List<Bala> getBalas() {
		return Mapa.supermapa.getEntidades().stream().filter(e -> (e instanceof Bala)).map(e -> (Bala) e)
				.collect(Collectors.toList());
	}

	public List<Enemigo> getEnemigos() {
		return Mapa.supermapa.getEntidades().stream().filter(e -> (e instanceof Enemigo)).map(e -> (Enemigo) e)
				.collect(Collectors.toList());
	}

	public static int obtenerNumeroTorretas() {
		return torretas.size();
	}

}
