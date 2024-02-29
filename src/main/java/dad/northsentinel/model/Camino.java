package dad.northsentinel.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Camino {
	
	Path camino;
	
	public Camino() {}
	
	public Path crearCamino() {
		camino = new Path();
		camino.setStroke(Color.RED);
		camino.setStrokeWidth(3);

		camino.getElements().add(new MoveTo(0, 475));
		camino.getElements().add(new LineTo(475, 475));
		camino.getElements().add(new LineTo(475, 275));
		camino.getElements().add(new LineTo(875, 275));
		camino.getElements().add(new LineTo(875, 525));
		camino.getElements().add(new LineTo(1310, 525));
		
		return camino;
		
	}
	
}
