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
	
	public abstract void actualizar(double seconds);

}
