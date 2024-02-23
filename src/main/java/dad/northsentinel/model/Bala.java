package dad.northsentinel.model;

import javafx.geometry.Point2D;

public class Bala extends Entidad {
	
	private int daño;
	private Point2D destino;
	private double velocidad;
	private Point2D normal;
	
	public Bala(Point2D origen, Point2D destino) {
		super("/assets/bala.png");
		setPos(origen);
		this.destino = destino;
		this.normal = origen.subtract(destino).normalize(); 
	}
	
	public int getDaño() {
		return daño;
	}
	
	public Point2D getDestino() {
		return destino;
	}
	
	@Override
	public void actualizar(double segundos) {
		// e = v / t
		double ix = (velocidad / segundos) * normal.getX();
		double iy = (velocidad / segundos) * normal.getY();
		setPos(getX() + ix, getY() + iy);
	}

}
