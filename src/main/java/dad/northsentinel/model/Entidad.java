package dad.northsentinel.model;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

public abstract class Entidad extends ImageView {
	
	public Entidad(String url) {
		super(url);
	}
	
	public void setPos(Point2D pos) {
		setPos(pos.getX(), pos.getY());
	}
	
	public void setPos(double x, double y) {
		setLayoutX(x);
		setLayoutY(y);
	}
	
	public Point2D getPos() {
		return new Point2D(getLayoutX(), getLayoutY());
	}
	
	public void destruir() {
		Mapa.supermapa.destruir(this);
	}
	
	public abstract void actualizar(double seconds);

}
