package dad.northsentinel.model;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Enemigo extends Entidad {

    private int vida;
    private Point2D destino;
    private Point2D origen;
    private double velocidad;
    private PathTransition transition; // Para manejar el movimiento a lo largo del camino

    public Enemigo() {
        super("/img/enemigos/enemigo1.png");
        this.vida = 100; // Ejemplo de vida inicial, ajusta según sea necesario
        this.velocidad = 1.0; // Ejemplo de velocidad, ajusta según sea necesario
        iniciarMovimiento();
    }

    @Override
    public void actualizar(double seconds) {
        // Este método podría usarse para actualizar la lógica específica del enemigo, como IA, interacciones, etc.
        // Por ahora, el movimiento se maneja completamente a través de PathTransition
    }

    private void iniciarMovimiento() {
        transition = new PathTransition();
        transition.setNode(this); // 'this' es el ImageView del Enemigo
        transition.setDuration(Duration.seconds(10)); // Ajusta la duración según sea necesario
        transition.setPath(Mapa.supermapa.getPath()); // Utiliza el Path de la instancia de Mapa
        transition.setInterpolator(Interpolator.LINEAR); // Movimiento lineal
        transition.setCycleCount(PathTransition.INDEFINITE); // O cambia a 1 si deseas que solo recorra el camino una vez
        transition.play(); // Inicia el movimiento
    }

    public void detenerMovimiento() {
        if (transition != null) {
            transition.stop();
        }
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

