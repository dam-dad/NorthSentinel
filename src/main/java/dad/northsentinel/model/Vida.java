package dad.northsentinel.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Vida {
	
    private IntegerProperty cantidadVida;

    public Vida() {
        this.cantidadVida = new SimpleIntegerProperty(100);
    }

    public int getCantidadVida() {
        return cantidadVida.get();
    }

    public IntegerProperty cantidadVidaProperty() {
        return cantidadVida;
    }

    public void reducirVida(int cantidad) {
        cantidadVida.set(cantidadVida.get() - cantidad);
    }
}

