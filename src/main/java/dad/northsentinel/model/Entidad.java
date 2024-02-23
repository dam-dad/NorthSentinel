package dad.northsentinel.model;

import javafx.scene.image.ImageView;

public abstract class Entidad {
	
	private ImageView view;
	
	public Entidad(ImageView view) {
		this.view = view;
	}
	
	public ImageView getView() {
		return view;
	}
	
	public abstract void actualizar(double seconds);

}
