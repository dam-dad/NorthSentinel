package dad.northsentinel.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Torreta extends Entidad {

    private double tiempoDisparo;
    private IntegerProperty cost = new SimpleIntegerProperty();
    private DoubleProperty rango = new SimpleDoubleProperty();
    private Point2D pos;

    public Torreta(Point2D pos) {
        super("/assets/torretas/torreta1.png");
        // Aquí puedes inicializar las propiedades si es necesario, por ejemplo:
        cost.set(100);
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
	
	public void dispararBala(Point2D target, Pane area) {
        Bala bala = new Bala(this.getPos());
        bala.disparar(target);
        area.getChildren().add(bala);
        Mapa.supermapa.getEntidades().add(bala);

        if (target != null) { // Verificar si target no es nulo
            // Calcular el ángulo entre la posición actual de la torreta y el destino de la bala
            double deltaX = target.getX() - this.getPos().getX();
            double deltaY = target.getY() - this.getPos().getY();

            // Calcular el ángulo en radianes
            double angleRad = Math.atan2(deltaY, deltaX);

            // Convertir el ángulo a grados y ajustar la orientación
            double angleDegrees = Math.toDegrees(angleRad) + 90;

            // Asegurarse de que el ángulo esté en el rango [0, 360)
            angleDegrees = (angleDegrees + 360) % 360;

            // Girar la torreta hacia el ángulo calculado
            this.setRotate(angleDegrees);
        }
    }
	
	@Override
	public Shape getCollisionShape() {
		return null;
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

