package dad.northsentinel.model;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class Torreta extends Entidad {

	public static final int COSTO_TORRETA = 100;
	private Point2D pos;

	public Torreta(Point2D pos) {
		super("/assets/torretas/torreta1.png");
		this.setPos(pos);
	}

	@Override
	public void actualizar(double seconds) {
		
	}

	// Método para obtener la posición de la torreta
	public void setPos(Point2D pos) {
		double anchoDeseado = 50;
		double altoDeseado = 50;

		// Establece el tamaño fijo de la torreta
		this.setFitWidth(anchoDeseado);
		this.setFitHeight(altoDeseado);

		// Calcula la nueva posición para centrar la torreta en el punto de clic
		// Asumiendo que pos es el punto donde el usuario hizo clic y queremos que sea
		// el centro de la torreta
		this.setLayoutX(pos.getX() - anchoDeseado / 2);
		this.setLayoutY(pos.getY() - altoDeseado / 2);

		this.pos = pos;
	}

	public void dispararBala(Point2D target, Pane area) {
		Bala bala = new Bala(this.getPos());
		bala.disparar(target);
		area.getChildren().add(bala);
		Mapa.supermapa.getEntidades().add(bala);

		if (target != null) {
			// Calcular el ángulo entre la posición actual de la torreta y el destino de la
			// bala
			double deltaX = target.getX() - this.getPos().getX();
			double deltaY = target.getY() - this.getPos().getY();

			double angleRad = Math.atan2(deltaY, deltaX);
			double angleDegrees = Math.toDegrees(angleRad) + 90;

			angleDegrees = (angleDegrees + 360) % 360;

			// Girar la torreta hacia el ángulo calculado
			this.setRotate(angleDegrees);
		}
	}

	//getters y setters
	@Override
	public Shape getCollisionShape() {
		return null;
	}

	public Point2D getPos() {
		return pos;
	}
	
}
