package dad.northsentinel.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

//Clase que representa el elemento "Moneda", se establece su valor inicial y los get y set para obtener los valores necesarios.

public class Moneda {
	
private DoubleProperty	monedas = new SimpleDoubleProperty();
	
	public Moneda(){
		setMoneda(100);	
	}
	
	public final DoubleProperty monedaProperty() {
		return this.monedas;
	}

	public final double getMoneda() {
		return this.monedaProperty().get();
	}

	public final void setMoneda(final double moneda) {
		this.monedaProperty().set(moneda);
	}
	
	

}
//Autores: Iván Garrido, Samuel Padrón y Feliciano Pérez.
