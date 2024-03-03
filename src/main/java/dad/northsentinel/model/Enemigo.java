package dad.northsentinel.model;

import java.util.ArrayList;
import java.util.List;

import dad.northsentinel.mainmenu.PlayController;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Enemigo extends Entidad {

	private int vida;
	private boolean haSidoDestruidoPorDaño = false;

	private int daño;
	private Point2D destino;
	private Point2D origen;
	private PathTransition transition; // Para manejar el movimiento a lo largo del camino

	public Enemigo() {
		super("/assets/enemigos/enemigo1.png");
		this.vida = 100;
		this.daño = 1;
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
			PlayController.reducirVida(getDaño());
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

	    Image imagenEnemigoRojo = new Image("/assets/enemigos/enemigo1_rojo.png");
	    Image imagenOriginalEnemigo = new Image("/assets/enemigos/enemigo1.png");
	    setImage(imagenEnemigoRojo);

	    PauseTransition pause = new PauseTransition(Duration.seconds(0.2));
	    pause.setOnFinished(event -> setImage(imagenOriginalEnemigo));
	    pause.play();

	    if (vida <= 0 && !haSidoDestruidoPorDaño) {
	        haSidoDestruidoPorDaño = true;

	        // Crear y mostrar la explosión
	        ImageView explosion = new ImageView("/assets/efectos/explosion1.png");
	        Point2D posicionEnemigo = this.getPos();

	        double offsetX = 40; 
	        double offsetY = 30; 

	        explosion.setLayoutX(posicionEnemigo.getX() + offsetX); 
	        explosion.setLayoutY(posicionEnemigo.getY() + offsetY); 

	        Pane area = (Pane) this.getParent(); 
	        area.getChildren().add(explosion);

	        List<Image> explosionFrames = new ArrayList<>();
	        explosionFrames.add(new Image("/assets/efectos/explosion1.png"));
	        explosionFrames.add(new Image("/assets/efectos/explosion2.png"));

	        int frameDurationMillis = 100; 
	        int numFrames = explosionFrames.size();

	        Timeline explosionAnimation = new Timeline();
	        for (int i = 0; i < numFrames; i++) {
	            KeyFrame keyFrame = new KeyFrame(Duration.millis(frameDurationMillis * i),
	                    new KeyValue(explosion.imageProperty(), explosionFrames.get(i)));
	            explosionAnimation.getKeyFrames().add(keyFrame);
	        }

	        explosionAnimation.getKeyFrames()
	                .add(new KeyFrame(Duration.millis(frameDurationMillis * numFrames), event -> {
	                    area.getChildren().remove(explosion); 
	                    destruir();
	                    PlayController.sumarMonedas(20);
	                }));

	        explosionAnimation.play();
	    }
	}

	@Override
	public Shape getCollisionShape() {
		return new Rectangle(getPos().getX(), getPos().getY(), 60, 60);
	}

	// getters y setters
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

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
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
