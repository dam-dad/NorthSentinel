package dad.northsentinel.model;

import java.util.List;

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

    public Torreta() {
        super("/assets/torretas/torreta1.png");
        // Aquí puedes inicializar las propiedades si es necesario, por ejemplo:
        // cost.set(100); // Ejemplo de coste
        // rango.set(150.0); // Ejemplo de rango
    }
    
    public void setTorretaPos(Point2D pos) {
        // Tamaño fijo deseado para la torreta
        double anchoDeseado = 50;
        double altoDeseado = 50;

        // Establece el tamaño fijo de la torreta
        this.setFitWidth(anchoDeseado);
        this.setFitHeight(altoDeseado);

        // Calcula la nueva posición para centrar la torreta en el punto de clic
        // Asumiendo que pos es el punto donde el usuario hizo clic y queremos que sea el centro de la torreta
        this.setLayoutX(pos.getX() - anchoDeseado / 2);
        this.setLayoutY(pos.getY() - altoDeseado / 2);
    }
    
  //Método para obtener la posición de la torreta
    public Path getPosTorreta() {
		Path posTorreta = new Path();
		posTorreta.getElements().add(new MoveTo(getPos().getX() ,getPos().getY()));
		return posTorreta;
	}
    
    

    @Override
    public void actualizar(double seconds) {
        // Implementación de la lógica de actualización de la torreta, si es necesaria
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
    
 
}

