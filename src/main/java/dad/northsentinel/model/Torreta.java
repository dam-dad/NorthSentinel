package dad.northsentinel.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Torreta extends Entidad {

    private double tiempoDisparo;
    private IntegerProperty cost = new SimpleIntegerProperty();
    private DoubleProperty rango = new SimpleDoubleProperty();
    private Point2D pos;

    public Torreta(Point2D pos) {
        super("/assets/torretas/torreta1.png");
        // Aquí puedes inicializar las propiedades si es necesario, por ejemplo:
        // cost.set(100); // Ejemplo de coste
        // rango.set(150.0); // Ejemplo de rango
        setPos(pos);
    }
    
  //Método para obtener la posición de la torreta
    
    @Override
    public void actualizar(double seconds) {
        // Implementación de la lógica de actualización de la torreta, si es necesaria
    }

	public void setPos(Point2D pos) {
		double anchoDeseado = 50;
        double altoDeseado = 50;

        // Establece el tamaño fijo de la torreta
        this.setFitWidth(anchoDeseado);
        this.setFitHeight(altoDeseado);

        // Calcula la nueva posición para centrar la torreta en el punto de clic
        // Asumiendo que pos es el punto donde el usuario hizo clic y queremos que sea el centro de la torreta
        this.setLayoutX(pos.getX() - anchoDeseado / 2);
        this.setLayoutY(pos.getY() - altoDeseado / 2);
        
		this.pos = pos;
	}
    
    public double getTiempoDisparo() {
        return tiempoDisparo;
    }

    public void setTiempoDisparo(double tiempoDisparo) {
        this.tiempoDisparo = tiempoDisparo;
    }

    public IntegerProperty costProperty() {
        return cost;
    }

    public DoubleProperty rangoProperty() {
        return rango;
    }

	public Point2D getPos() {
		return pos;
	}
 
}

