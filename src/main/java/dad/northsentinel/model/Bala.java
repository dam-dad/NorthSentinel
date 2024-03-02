package dad.northsentinel.model;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Bala extends Entidad {

	private int daño;
	private double velocidad;

	public Bala(Point2D origen) {
		super("/assets/balas/bala1.png");
		setPos(origen);
		this.daño = 25;
		this.velocidad = 800;
		setFitWidth(25);
		setFitHeight(25);
	}

	public Path getRuta(Point2D destino) {
		Path rutaBala = new Path();
		rutaBala.getElements().add(new MoveTo(getPos().getX(), getPos().getY()));
		rutaBala.getElements().add(new LineTo(destino.getX(), destino.getY()));
		return rutaBala;
	}

	@Override
	public void actualizar(double segundos) {

	}

	public void disparar(Point2D target) {
		if (target == null) {
			return;
		}

		double distancia = getPos().distance(target);

		Duration duracion = Duration.seconds(distancia / getVelocidad());

		Path ruta = getRuta(target);
		ruta.setStroke(Color.TRANSPARENT); // Establece el trazo a transparente para que no se vea la línea negra

		Mapa.supermapa.getArea().getChildren().add(ruta);

		PathTransition transition = new PathTransition();
		transition.setInterpolator(Interpolator.LINEAR);
		transition.setPath(getRuta(target));
		transition.setNode(this);
		transition.setDuration(duracion);
		transition.setOnFinished(e -> {
			destruir();
			Mapa.supermapa.getArea().getChildren().remove(ruta);

		});

		// Verificar colisión con enemigos
		for (Enemigo enemigo : Mapa.supermapa.getEnemigos()) {
			if (this.getBoundsInParent().intersects(enemigo.getBoundsInParent())) {
				// System.out.println("¡Impacto de bala en el enemigo!");
				enemigo.recibirImpacto(getDaño());
				destruir();
				break;
			}
		}

		transition.play();
	}

	// getters y setters
	@Override
	public Shape getCollisionShape() {
		return new Rectangle(getPos().getX(), getPos().getY(), 25, 25);
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

}
