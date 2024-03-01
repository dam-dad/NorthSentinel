package dad.northsentinel.model;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;

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

	public boolean comprobarColision(Entidad entidad) {
		return (getCollisionShape() != null && 
				entidad.getCollisionShape() != null && 
				getCollisionShape().intersects(entidad.getCollisionShape().getLayoutBounds()));
	}
	
	@Override
	public String toString() {
		return getClass().getName() + " pos=" + getPos() + ", ancho=" + getFitWidth() + ", alto=" + getFitHeight();
	}
	
}
