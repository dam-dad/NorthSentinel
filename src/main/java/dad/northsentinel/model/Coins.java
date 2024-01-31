package dad.northsentinel.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

//Clase que representa el elemento "Moneda", se establece su valor inicial y los get y set para obtener los valores necesarios.

public class Coins {
	
private DoubleProperty	moneda = new SimpleDoubleProperty();
	
	public Coins(){
		setMoneda(100);	
	}
	
	public final DoubleProperty monedaProperty() {
		return this.moneda;
	}

	public final double getmoneda() {
		return this.monedaProperty().get();
	}

	public final void setMoneda(final double moneda) {
		this.monedaProperty().set(moneda);
	}

}
//Autores: Iván Garrido, Samuel Padrón y Feliciano Pérez.
