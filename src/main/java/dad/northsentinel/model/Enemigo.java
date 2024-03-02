package dad.northsentinel.model;

import dad.northsentinel.mainmenu.PlayController;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Enemigo extends Entidad {
	
	private int vida = 100; // Nueva propiedad para representar la vida del enemigo
	private boolean haSidoDestruidoPorDaño = false;
	
    private Point2D destino;
    private Point2D origen;
    private double velocidad;
    private PathTransition transition; // Para manejar el movimiento a lo largo del camino

    public Enemigo() {
        super("/assets/enemigos/enemigo1.png");
        //this.vida = 100; // Ejemplo de vida inicial, ajusta según sea necesario
        this.velocidad = 0.25; // Ejemplo de velocidad, ajusta según sea necesario
    
    }

    @Override
    public void actualizar(double seconds) {
        // Este método podría usarse para actualizar la lógica específica del enemigo, como IA, interacciones, etc.
        // Por ahora, el movimiento se maneja completamente a través de PathTransition
    }
    
    
 
    public void recibirImpacto(int cantidad) {
        vida -= cantidad;
        if (vida <= 0) {
            haSidoDestruidoPorDaño = true;
            System.out.println("El enemigo ha sido destruido.");
            destruir();
            PlayController.sumarMonedas(20); // Asume que esto ya está implementado
        }
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
            pause.setOnFinished(event -> {
            	transition.play();
            	Platform.runLater(() -> setVisible(true));
            });
            pause.play();
        } else {
            transition.play(); // Inicia inmediatamente si no hay retraso
            Platform.runLater(() -> setVisible(true));
        }
    }

    // Suponiendo que ya tienes implementado el método destruir()
    @Override
    public void destruir() {
        if (!haSidoDestruidoPorDaño) {
            System.out.println("Un enemigo ha llegado al final sin ser destruido.");
            PlayController.reducirVida(10);
        }
        super.destruir(); // Asegúrate de que esta llamada haga lo que se supone que debe hacer, como eliminar el enemigo del juego.
    }
    public void detenerMovimiento() {
        if (transition != null) {
            transition.stop();
        }
    }
    
    @Override
	public Shape getCollisionShape() {
		return new Rectangle(getPos().getX(), getPos().getY(), 50, 50);
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

