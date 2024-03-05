package dad.northsentinel.mainmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import javafx.fxml.Initializable;

/**
 * Controlador para la vista de "Cómo Jugar".
 */

public class HowToPlayController implements Initializable {

    private EventHandler<ActionEvent> onGoBack;
	
	@FXML
	private BorderPane view;

    @FXML
    private ComboBox<String> howToPlayCombo;

    @FXML
    private ImageView howToPlayImage;

    @FXML
    private TextArea howToPlayTextArea;
	
	public HowToPlayController() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HowToPlayView.fxml"));
		loader.setController(this);
		try {
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
            onGoBack.handle(event);
        }
    }

    public void setOnGoBack(EventHandler<ActionEvent> onGoBack) {
        this.onGoBack = onGoBack;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> options = FXCollections.observableArrayList("Enemigo", "Torreta");
        howToPlayCombo.setItems(options);
        
        howToPlayCombo.getSelectionModel().select("Enemigo");

        howToPlayTextArea.setText("Vida: 100 y por cada oleada se incrementa 50 mas de vida.\r\n"
                		+ "Daño: quita 1 de vida si llegan al final del camino.\r\n"
                		+ "Velocidad: 10 segundos tardan en llegar al final del camino, que \r\n"
                		+ "se va disminuyendo el tiempo por cada oleada que pasa.\r\n"
                		+ "Cantidad: la primera oleada son 5, y por cada oleada se incrememtan 5 mas.\r\n"
                		+ "\r\n"
                		+ "\r\n");
        
        howToPlayCombo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
            	String imageName = newValue.equals("Enemigo") ? "/assets/enemigos/enemigo1.png" : "/assets/torretas/torreta1.png";
            	Image image = new Image(getClass().getResourceAsStream(imageName));


                howToPlayImage.setImage(image);

                String text = newValue.equals("Enemigo") ? "Vida: 100 y por cada oleada se incrementa 50 mas de vida.\r\n"
                		+ "Daño: quita 1 de vida si llegan al final del camino.\r\n"
                		+ "Velocidad: 10 segundos tardan en llegar al final del camino, que \r\n"
                		+ "se va disminuyendo el tiempo por cada oleada que pasa.\r\n"
                		+ "Cantidad: la primera oleada son 5, y por cada oleada se incrememtan 5 mas.\r\n"
                		+ "\r\n"
                		+ "\r\n"
                		+ "" : "Las torretas se colocan por el mapa, y solo se pueden colocar en las zonas con \r\n"
                				+ "cruces grises. \r\n"
                		+ "El objetivo de las torretas es eliminar a los enemigos que te vengan dando click, \r\n"
                		+ "para evitar que estos lleguen alfinal del camino y te quiten vida. Cada bala \r\n "
                		+ "que dispare la torreta e impacte en el enemigo le quitara 25 de vida. \r\n"
                		+ "El coste de cada torreta es de 500 monedas, que deberas tener para que \r\n"
                		+ "te permita colocar la torreta.";
                howToPlayTextArea.setText(text);
            }
        });
	}

	public BorderPane getView() {
		return view;
	}

}
