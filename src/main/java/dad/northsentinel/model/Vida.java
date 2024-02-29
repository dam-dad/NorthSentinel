package dad.northsentinel.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Vida {

	private IntegerProperty vida = new SimpleIntegerProperty();
	
	public Vida() {
		setVida(15);
	}

	public final IntegerProperty vidaProperty() {
		return this.vida;
	}
	

	public final int getVida() {
		return this.vidaProperty().get();
	}
	

	public final void setVida(final int vida) {
		this.vidaProperty().set(vida);
	}
	
}
