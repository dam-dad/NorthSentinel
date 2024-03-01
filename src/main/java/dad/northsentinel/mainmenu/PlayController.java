package dad.northsentinel.mainmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.northsentinel.model.Juego;
import dad.northsentinel.model.Mapa;
import dad.northsentinel.model.Vida;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class PlayController implements Initializable {
	
	// model
	
	private Juego juego = new Juego();
	
	private Vida vida = new Vida();
	
	private static int monedas = 100;
	
	// actions

	private EventHandler<ActionEvent> onGoBack;

	// view

	@FXML
	private BorderPane view;

    @FXML
    private BorderPane viewPlay;
    
    @FXML
    private Label monedaLabel;

    @FXML
    private Label vidaLabel;

	public PlayController() {		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PlayView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@FXML
	void onGoBack(ActionEvent event) {
		if (onGoBack != null) {
			juego.stop();
			onGoBack.handle(event);
		}
	}

	@FXML
    void onStartWave(ActionEvent event) {
		juego.getMapa().crearEnemigos(); // Añade esta línea para crear enemigos.
    }
	
	public void setOnGoBack(EventHandler<ActionEvent> onGoBack) {
		this.onGoBack = onGoBack;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
        vidaLabel.textProperty().bind(vida.cantidadVidaProperty().asString());
		
        vida.cantidadVidaProperty().addListener((o, ov, nv) -> {
			System.out.println("vida=" + nv);
			vidaLabel.setText(nv+"");
		});
        
//		juego.fpsProperty().addListener((o, ov, nv) -> {
//			System.out.println("fps=" + nv);
//		});
		
		viewPlay.setCenter(juego.getMapa());
		juego.start();
		
	}
	
	public static void sumarMonedas(int cantidad) {
        monedas += cantidad;
        System.out.println("Se han sumado " + cantidad + " monedas. Total de monedas: " + monedas);
    }
	
	public static int getMonedas() {
        return monedas;
    }

	public BorderPane getView() {
		return view;
	}
	
	

}