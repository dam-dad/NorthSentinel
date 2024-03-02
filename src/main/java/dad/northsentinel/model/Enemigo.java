package dad.northsentinel.model;

import dad.northsentinel.mainmenu.PlayController;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Enemigo extends Entidad {

	private int vida;
	private boolean haSidoDestruidoPorDaño = false;

	private Point2D destino;
	private Point2D origen;
	private double velocidad;
	private PathTransition transition; // Para manejar el movimiento a lo largo del camino

	public Enemigo() {
		super("/assets/enemigos/enemigo1.png");
		this.vida = 100;
		this.velocidad = 0.25;
		setFitWidth(100);
		setFitHeight(100);
	}

	@Override
	public void actualizar(double seconds) {

	}

	public void iniciarMovimiento(int delay) {
		transition = new PathTransition();
		transition.setNode(this);
		transition.setDuration(Duration.seconds(10)); // Ajusta según la duración deseada
		transition.setPath(Mapa.supermapa.getPath());
		transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		transition.setInterpolator(Interpolator.LINEAR);
		transition.setCycleCount(1);
		transition.setOnFinished(event -> this.destruir());
		if (delay > 0) {
			PauseTransition pause = new PauseTransition(Duration.seconds(delay));
			pause.setOnFinished(event -> {
				transition.play();
				Platform.runLater(() -> setVisible(true));
			});
			pause.play();
		} else {
			transition.play();
			Platform.runLater(() -> setVisible(true));
		}
	}

	@Override
	public void destruir() {
		if (!haSidoDestruidoPorDaño) {
			PlayController.reducirVida(10);
		}
		Mapa.supermapa.destruir(this);
	}

	public void detenerMovimiento() {
		if (transition != null) {
			transition.stop();
		}
	}

	public void recibirImpacto(int cantidad) {
		vida -= cantidad;
		if (vida <= 0) {
			haSidoDestruidoPorDaño = true;
			//System.out.println("El enemigo ha sido destruido.");
			destruir();
			PlayController.sumarMonedas(20);
		}
	}
	
	@Override
	public Shape getCollisionShape() {
		return new Rectangle(getPos().getX(), getPos().getY(), 60, 60);
	}

	//getters y setters
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public Point2D getDestino() {
		return destino;
	}

	public void setDestino(Point2D destino) {
		this.destino = destino;
	}

	public Point2D getOrigen() {
		return origen;
	}

	public void setOrigen(Point2D origen) {
		this.origen = origen;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public boolean isHaSidoDestruidoPorDaño() {
		return haSidoDestruidoPorDaño;
	}

	public void setHaSidoDestruidoPorDaño(boolean haSidoDestruidoPorDaño) {
		this.haSidoDestruidoPorDaño = haSidoDestruidoPorDaño;
	}

	public PathTransition getTransition() {
		return transition;
	}

	public void setTransition(PathTransition transition) {
		this.transition = transition;
	}
	
}
