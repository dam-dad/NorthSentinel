package dad.northsentinel.model;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;

public abstract class Entidad extends ImageView {
	
	private Point2D pos;
	
	public Entidad(String url) {
		super(url);
	}

	public void setPos(Point2D pos) {
		this.pos = pos;
	}
	
	public Point2D getPos() {
		return pos;
	}
	

	public void destruir() {
		Mapa.supermapa.destruir(this);
	}
	
	public abstract void actualizar(double seconds);
	public abstract Shape getCollisionShape();
	
	public boolean comprobarColision(Entidad entidad) {
		return (getCollisionShape() != null && entidad.getCollisionShape() != null && getCollisionShape().intersects(entidad.getCollisionShape().getLayoutBounds()));
	}
}
