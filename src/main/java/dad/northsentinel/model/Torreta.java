package dad.northsentinel.model;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;


/**
 * Clase que representa una torreta en el juego. 
 * Gestiona la ubicación de la torreta, el disparo de balas y la actualización de su estado.
 */
public class Torreta extends Entidad {
	
	private static int disparosRealizados = 0;

	public static final int COSTO_TORRETA = 100;
	private Point2D pos;

	
	/**
     * Construye una nueva Torreta y la inicializa en una posición específica.
     * 
     * @param pos La posición inicial de la torreta como un objeto {@link Point2D}.
     */
	public Torreta(Point2D pos) {
		super("/assets/torretas/torreta1.png");
		this.setPos(pos);
	}

	@Override
	public void actualizar(double seconds) {
		
	}

	/**
     * Establece la posición de la torreta y ajusta su tamaño y orientación.
     * 
     * @param pos La nueva posición de la torreta como un objeto {@link Point2D}.
     */
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
		
		//Variable para reports
		disparosRealizados++;

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
	
	public static int getDisparosRealizados() {
        return disparosRealizados;
    }
	
}
