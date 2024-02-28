package dad.northsentinel.model;

import javafx.geometry.Point2D;

public class Enemigo extends Entidad {

	private int vida;
	private Point2D destino;
	private Point2D origen;
	private double velocidad;

	public Enemigo() {
		super("/assets/enemigos.png");
	}

	@Override
	public void actualizar(double seconds) {

	}

}
