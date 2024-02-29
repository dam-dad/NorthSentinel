package dad.northsentinel.model;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.geometry.Point2D;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Bala extends Entidad {
	
	private int daño;
	private double velocidad = 800;
	
	public Bala(Point2D origen) {
		super("/assets/balas/bala1.png");
		setPos(origen);
	}
	
	public double getVelocidad() {
		return velocidad;
	}
	
	public int getDaño() {
		return daño;
	}
	
	public Path getRuta(Point2D destino) {
		Path rutaBala = new Path();
		rutaBala.getElements().add(new MoveTo(getPos().getX() ,getPos().getY()));
		rutaBala.getElements().add(new LineTo(destino.getX(), destino.getY()));
		return rutaBala;
	}
	
	@Override
	public void actualizar(double segundos) {
		// e = v / t
//		double ix = (velocidad / segundos) * normal.getX();
//		double iy = (velocidad / segundos) * normal.getY();
//		setPos(getX() + ix, getY() + iy);
	}

	
	public void disparar(Point2D target) {
		double distancia = getPos().distance(target);
		
		Duration duracion = Duration.seconds(distancia / getVelocidad());
		//System.out.println("velocidad=" + getVelocidad() + ", duracion=" + duracion.toSeconds() + ", distancia=" + distancia);
		
		Path ruta = getRuta(target);
		
		Mapa.supermapa.getArea().getChildren().add(ruta);
		
		PathTransition transition = new PathTransition();
		transition.setInterpolator(Interpolator.LINEAR);
		transition.setPath(getRuta(target));
		transition.setNode(this);
		transition.setDuration(duracion);
		transition.setOnFinished(e -> {
			//System.out.println("boom!");
			destruir();
			Mapa.supermapa.getArea().getChildren().remove(ruta);
		});
		transition.play();
		
	}

}
