package dad.northsentinel.model;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Enemigo extends Entidad {

    private int vida;
    private Point2D destino;
    private Point2D origen;
    private double velocidad;
    private PathTransition transition; // Para manejar el movimiento a lo largo del camino

    public Enemigo() {
        super("/assets/enemigos/enemigo1.png");
        this.vida = 100; // Ejemplo de vida inicial, ajusta según sea necesario
        this.velocidad = 1.0; // Ejemplo de velocidad, ajusta según sea necesario
        //iniciarMovimiento();
           
    }

    @Override
    public void actualizar(double seconds) {
        // Este método podría usarse para actualizar la lógica específica del enemigo, como IA, interacciones, etc.
        // Por ahora, el movimiento se maneja completamente a través de PathTransition
    }

    public void iniciarMovimiento(int delay) {
        transition = new PathTransition(); // Usa la variable de instancia
        transition.setNode(this);
        transition.setDuration(Duration.seconds(10)); // Ajusta según la duración deseada
        transition.setPath(Mapa.supermapa.getPath()); // Usa el path del mapa
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition.setInterpolator(Interpolator.LINEAR);
        transition.setCycleCount(1); // Ejecuta solo una vez
        transition.setOnFinished(event -> this.destruir());

        // Aplica el retraso antes de iniciar el movimiento
        if (delay > 0) {
            PauseTransition pause = new PauseTransition(Duration.seconds(delay));
            pause.setOnFinished(event -> transition.play());
            pause.play();
        } else {
            transition.play(); // Inicia inmediatamente si no hay retraso
        }
    }
    
 // Método para detectar impacto de bala
    public void detectarImpacto(Bala bala) {
        if (this.getBoundsInParent().intersects(bala.getBoundsInParent())) {
            System.out.println("¡El enemigo ha sido impactado por la bala!");
        } else {
            System.out.println("La bala no ha impactado al enemigo.");
        }
    }


    // Suponiendo que ya tienes implementado el método destruir()
    @Override
    public void destruir() {
        // Elimina este enemigo de la pantalla o del contenedor padre
        Mapa.supermapa.destruir(this);
    }

    public void detenerMovimiento() {
        if (transition != null) {
            transition.stop();
        }
    }

    //Método para obtener la posición del enemigo
    public Path getPosEnemigo() {
		Path posEnemigo = new Path();
		posEnemigo.getElements().add(new MoveTo(getPos().getX() ,getPos().getY()));
		return posEnemigo;
	}
    
    // Métodos getters y setters para vida, destino, origen, velocidad, etc., según sea necesario
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Point2D getDestino() {
        return destino;
    }

    public void setDestino(Point2D destino) {
        this.destino = destino;
    }

    public Point2D getOrigen() {
        return origen;
    }

    public void setOrigen(Point2D origen) {
        this.origen = origen;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
}

