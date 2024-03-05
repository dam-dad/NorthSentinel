package dad.northsentinel.mainmenu;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.northsentinel.main.App;
import dad.northsentinel.model.Enemigo;
import dad.northsentinel.model.Juego;
import dad.northsentinel.model.Mapa;
import dad.northsentinel.model.ReportGenerator;
import dad.northsentinel.model.Torreta;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Controlador para la vista de juego.
 */

public class PlayController implements Initializable {

	// model
	private static Juego juego = new Juego();

	private static PlayController instance;

	private static int vida = 15;

	private static int monedas = 500;
	
    private static boolean alertaMostrada = false;

	// actions

	private EventHandler<ActionEvent> onGoBack;

	// view

	@FXML
	private HBox view;

	@FXML
	private BorderPane viewPlay;

	@FXML
	private Label monedaLabel;

	@FXML
	private Label vidaLabel;

	@FXML
	private Label oleadaLabel;

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

	/**
     * Establece el manejador de eventos para volver atrás.
     * @param onGoBack El manejador de eventos para volver atrás.
     */
	
	@FXML
	void onGoBack(ActionEvent event) {
		if (onGoBack != null) {
			juego.stop();
			onGoBack.handle(event);
		}
	}

	@FXML
	void onStartWave(ActionEvent event) {
		juego.getMapa().generarOleada();
		oleadaLabel.setText("" + juego.getMapa().getOleada());
		juego.getMapa().aumentarOleada();
	}

	public void setOnGoBack(EventHandler<ActionEvent> onGoBack) {
		this.onGoBack = onGoBack;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

//		juego.fpsProperty().addListener((o, ov, nv) -> {
//		System.out.println("fps=" + nv);
//	});

		monedaLabel.setText(getMonedas() + "");
		vidaLabel.setText(getVida() + "");

		viewPlay.setCenter(juego.getMapa());
		juego.start();

	}

	
	/**
     * Reduce la vida por cada enemigo que llegue al final.
     * @param cantidad La cantidad de vida a reducir.
     */

	public static void reducirVida(int cantidad) {
	    if (vida > 0) {
	        vida -= cantidad;
	        if (vida <= 0 && !alertaMostrada) {
	            vida = 0;
	            alertaMostrada = true;
	            Platform.runLater(() -> {
	                if (instance != null && instance.vidaLabel != null) {
	                    instance.vidaLabel.setText("0");
	                }

	                boolean confirmado = mostrarDialogoPerdiste(App.primarySatge);
	                finalizarPartida();
	                if (confirmado) {
	                    juego.getMapa().reiniciarJuego();
	                    vida = 15;
	                    if (instance != null && instance.vidaLabel != null) {
	                        Platform.runLater(() -> instance.vidaLabel.setText(String.valueOf(vida)));
	                    }
	                    monedas = 500;
	                    if (instance != null && instance.monedaLabel != null) {
	                        Platform.runLater(() -> instance.monedaLabel.setText(String.valueOf(monedas)));
	                    }
	                    juego.getMapa().setOleada(0);
	                    if (instance != null && instance.oleadaLabel != null) {
	                        Platform.runLater(() -> instance.oleadaLabel.setText(String.valueOf(juego.getMapa().getOleada())));
	                    }
	                } else {
	                	juego.getMapa().reiniciarJuego();
	                    vida = 15;
	                    if (instance != null && instance.vidaLabel != null) {
	                        Platform.runLater(() -> instance.vidaLabel.setText(String.valueOf(vida)));
	                    }
	                    monedas = 500;
	                    if (instance != null && instance.monedaLabel != null) {
	                        Platform.runLater(() -> instance.monedaLabel.setText(String.valueOf(monedas)));
	                    }
	                    juego.getMapa().setOleada(0);
	                    if (instance != null && instance.oleadaLabel != null) {
	                        Platform.runLater(() -> instance.oleadaLabel.setText(String.valueOf(juego.getMapa().getOleada())));
	                    }	                }
	            });
	        } else if (vida > 0) {
	            alertaMostrada = false;
	        }
	        Platform.runLater(() -> {
	            if (instance != null && instance.vidaLabel != null) {
	                instance.vidaLabel.setText(String.valueOf(vida));
	            }
	        });
	    }
	}

	/**
     * Suma monedas por cada enemigo muerto.
     * @param cantidad La cantidad de monedas a sumar.
     */
	
	public static void sumarMonedas(int cantidad) {
		monedas += cantidad;
		if (instance != null && instance.monedaLabel != null) {
			Platform.runLater(() -> instance.monedaLabel.setText(String.valueOf(monedas)));
		}
	}

	 /**
     * Resta monedas.
     * @param cantidad La cantidad de monedas a restar.
     */
	
	public static void restarMonedas(int cantidad) {
		monedas -= cantidad;
		// Actualiza el label de monedas
		if (instance != null && instance.monedaLabel != null) {
			Platform.runLater(() -> instance.monedaLabel.setText(String.valueOf(monedas)));
		}
	}

	/**
     * Muestra el diálogo de pérdida.
     * @param stage La ventana en la que se mostrará el diálogo.
     * @return true si se elige reiniciar la partida, false en caso contrario.
     */
	
	public static boolean mostrarDialogoPerdiste(Stage stage) {
		Alert alert = new Alert(Alert.AlertType.NONE);
		alert.setTitle("");

		ImageView imageView = new ImageView(new Image("assets/sprites/derrota.png"));
		VBox vBox = new VBox(imageView);
		alert.getDialogPane().setContent(vBox);

		ButtonType botonSi = new ButtonType("Reiniciar partida", ButtonBar.ButtonData.YES);
		alert.getButtonTypes().setAll(botonSi);

		Optional<ButtonType> resultado = alert.showAndWait();

		return resultado.isPresent() && resultado.get() == botonSi;
	}
	
	/**
     * Finaliza la partida y genera un informe.
     */
	
	public static void finalizarPartida() {
        int totalEnemigos = Enemigo.getTotalEnemigos();
        int numTorretas = Mapa.obtenerNumeroTorretas();
        int disparosRealizados = Torreta.getDisparosRealizados();

        ReportGenerator.generateReport(totalEnemigos, numTorretas, disparosRealizados);
    }

	public static int getVida() {
		return vida;
	}

	public static int getMonedas() {
		return monedas;
	}

	public HBox getView() {
		return view;
	}

}