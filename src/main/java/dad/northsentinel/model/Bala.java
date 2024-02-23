package dad.northsentinel.model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bala extends Entidad {
	
	private int damage;
	private Point2D pos;
	private Point2D destino;
	private double velocidad;
	private Vector2D normal;
	
	private static final Image imagen = new Image("/assets/bala.png");

	public Bala(Point2D origen, Point2D destino) {
		super(new ImageView(imagen));
		this.pos = origen;
		this.destino = destino;
		this.normal = Vector2D.normalizar(origen, destino); 
	}
	
	@Override
	public void actualizar(double seconds) {
		// e = v / t
		double ix = (velocidad / seconds) * normal.x;
		double iy = (velocidad / seconds) * normal.y;
		pos = new Point2D(pos.getX() + ix, pos.getY() + iy);
		getView().setLayoutX(pos.getX());
		getView().setLayoutY(pos.getY());		
	}

}
