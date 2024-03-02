package dad.northsentinel.mainmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.northsentinel.model.Juego;
import dad.northsentinel.model.Mapa;
import dad.northsentinel.model.Vida;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class PlayController implements Initializable {
	
	private static int vida = 100; // Vida inicial del jugador
	
	
	// model
	
	private Juego juego = new Juego();
	
	
	
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
    
    private static PlayController instance; // Referencia estática a la instancia

    @FXML
    private Label vidaLabel;

	public PlayController() {	
		 instance = this;
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
		
		monedaLabel.setText("100");
		vidaLabel.setText("100");
		
       
        
//		juego.fpsProperty().addListener((o, ov, nv) -> {
//			System.out.println("fps=" + nv);
//		});
		
		viewPlay.setCenter(juego.getMapa());
		juego.start();
		
	}
	
	// Método estático para reducir la vida
	public static void reducirVida(int cantidad) {
	    vida -= cantidad;
	    Platform.runLater(() -> {
	        if (instance != null && instance.vidaLabel != null) {
	            instance.vidaLabel.setText(String.valueOf(vida));
	            System.out.println("Vida restante: " + vida); // Para depuración
	        }
	    });
	    if (vida <= 0) {
	        System.out.println("El jugador ha perdido."); // Manejo del juego perdido
	    }
	}
	
	// Método para obtener la vida actual, por si acaso lo necesitas
	public static int getVida() {
	    return vida;
	}
	
	
	 public static void sumarMonedas(int cantidad) {
	        monedas += cantidad;
	        // Actualiza el label de monedas
	        if (instance != null && instance.monedaLabel != null) {
	            Platform.runLater(() -> instance.monedaLabel.setText(String.valueOf(monedas)));
	        }
	    }
	
	public static int getMonedas() {
        return monedas;
    }

	public BorderPane getView() {
		return view;
	}
	
	

}