package dad.northsentinel.model;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Juego extends AnimationTimer {

	private static final double NANO_A_SEGUNDOS = 1e-9;

	private DoubleProperty fps = new SimpleDoubleProperty();

	private long ultimoTiempo;
	private Mapa mapa = new Mapa();
	private List<Entidad> entidades = new ArrayList<>();

	@Override
	public void start() {
		ultimoTiempo = System.nanoTime();
		super.start();
	}

	@Override
	public void handle(long ahora) {
		double diferencia = ahora - ultimoTiempo;
		actualizar(diferencia * NANO_A_SEGUNDOS);
		ultimoTiempo = ahora;
	}

	private void actualizar(double segundos) {
		fps.set(1 / segundos);
		entidades.forEach(entidad -> entidad.actualizar(segundos));
	}

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

}