package dad.northsentinel.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;

public class Torreta extends Entidad{

	private double tiempoDisparo;
	private IntegerProperty cost = new SimpleIntegerProperty();
	private DoubleProperty rango = new SimpleDoubleProperty();
	private Point2D pos;
	
	public Torreta() {
		super("/assets/torreta.png");
	}

	@Override
	public void actualizar(double seconds) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
