package dad.northsentinel.model;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;


/**
 * Clase abstracta que representa una entidad genérica en el juego. 
 * Extiende de {@link ImageView} para permitir representar visualmente la entidad en la interfaz de usuario.
 * Define métodos comunes a todas las entidades como posicionamiento, actualización y detección de colisiones.
 */
public abstract class Entidad extends ImageView {

	public Entidad(String url) {
		super(url);
	}

	public void setPos(Point2D pos) {
		this.setTranslateX(pos.getX());
		this.setTranslateY(pos.getY());
	}

	public Point2D getPos() {
		return new Point2D(this.getTranslateX(), this.getTranslateY());
	}

	public void destruir() {
		Mapa.supermapa.destruir(this);
	}

	public abstract void actualizar(double seconds);

	public abstract Shape getCollisionShape();
	
	
	  /**
     * Comprueba si esta entidad está colisionando con otra entidad dada.
     * 
     * @param entidad La entidad con la que se está comprobando la colisión.
     * @return {@code true} si hay colisión, {@code false} en caso contrario.
     */
	public boolean comprobarColision(Entidad entidad) {
		return (getCollisionShape() != null && 
				entidad.getCollisionShape() != null && 
				getCollisionShape().intersects(entidad.getCollisionShape().getLayoutBounds()));
	}
	
	 /**
     * Proporciona una representación en cadena de la entidad, incluyendo su posición, ancho y alto.
     * 
     * @return Una cadena que representa a la entidad.
     */
	
	@Override
	public String toString() {
		return getClass().getName() + " pos=" + getPos() + ", ancho=" + getFitWidth() + ", alto=" + getFitHeight();
	}
	
}
