package dad.northsentinel.model;

import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;


/**
 * Clase principal del juego que extiende AnimationTimer para proporcionar un bucle de juego.
 * Gestiona la actualización del estado del juego, incluyendo entidades y colisiones.
 */
public class Juego extends AnimationTimer {

	private static final double NANO_A_SEGUNDOS = 1e-9;

	private DoubleProperty fps = new SimpleDoubleProperty();

	private long ultimoTiempo;
	
	private Mapa mapa = new Mapa();

	/**
	 * Inicia el bucle del juego. Establece la marca de tiempo inicial y añade un manejador de clics al mapa.
	 */
	@Override
	public void start() {
		ultimoTiempo = System.nanoTime();
		super.start();

		mapa.getArea().setOnMouseClicked(e -> {
			Point2D target = new Point2D(e.getX(), e.getY());
			// Dispara desde todas las torretas existentes
			mapa.getTorretas().forEach(torreta -> torreta.dispararBala(target, mapa.getArea()));
		});
	}

	@Override
	public void handle(long ahora) {
		double diferencia = ahora - ultimoTiempo;
		actualizar(diferencia * NANO_A_SEGUNDOS);
		comprobarColisiones(diferencia * NANO_A_SEGUNDOS);
		ultimoTiempo = ahora;
	}

	private void actualizar(double segundos) {
		Mapa.supermapa.getEntidades().forEach(entidad -> entidad.actualizar(segundos));
	}

	/**
	 * Comprueba y maneja las colisiones entre entidades.
	 * 
	 * @param segundos El tiempo transcurrido desde el último frame en segundos.
	 */
	private void comprobarColisiones(double segundos) {
		fps.set(1 / segundos);
		Mapa.supermapa.getBalas().forEach(bala -> {
			Mapa.supermapa.getEnemigos().stream().filter(
					enemigo -> bala.getCollisionShape().intersects(enemigo.getCollisionShape().getBoundsInLocal()))
					.forEach(enemigo -> {
						enemigo.recibirImpacto(25);
						bala.destruir();
					});
		});
	}

	//getters y setters
	public Mapa getMapa() {
		return mapa;
	}

	public final DoubleProperty fpsProperty() {
		return this.fps;
	}

	public final double getFps() {
		return this.fpsProperty().get();
	}

	public final void setFps(final double fps) {
		this.fpsProperty().set(fps);
	}

	public long getUltimoTiempo() {
		return ultimoTiempo;
	}

	public void setUltimoTiempo(long ultimoTiempo) {
		this.ultimoTiempo = ultimoTiempo;
	}

	public static double getNanoASegundos() {
		return NANO_A_SEGUNDOS;
	}

	public void setFps(DoubleProperty fps) {
		this.fps = fps;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

}
