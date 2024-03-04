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

        // Configurar listener para el cambio de selección en el ComboBox
        howToPlayCombo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Cambiar la imagen dependiendo de la selección
            	String imageName = newValue.equals("Enemigo") ? "assets/enemigos/enemigo1.png" : "assets/torretas/torreta1.png";
            	Image image = new Image(getClass().getResourceAsStream(imageName));

                howToPlayImage.setImage(image);

                // Cambiar el texto del TextArea
                String text = newValue.equals("Enemigo") ? "Instrucciones para el Enemigo..." : "Instrucciones para la Torreta...";
                howToPlayTextArea.setText(text);
            }
        });
	}

	public BorderPane getView() {
		return view;
	}

}
