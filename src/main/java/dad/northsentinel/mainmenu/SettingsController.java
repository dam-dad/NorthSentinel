package dad.northsentinel.mainmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import javafx.fxml.Initializable;

public class SettingsController implements Initializable {

    private EventHandler<ActionEvent> onGoBack;
    
    private MainController mainController;

    @FXML
    private BorderPane view;

    @FXML
    private ImageView volumeImage;

    @FXML
    private Label volumeLabel;

    @FXML Slider volumeSlider;
    
    public SettingsController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SettingsView.fxml"));
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

    // Método setter para mainController
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        volumeLabel.textProperty().bind(Bindings.format("%.0f", volumeSlider.valueProperty()));
        
        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (mainController != null) { // Verificar que mainController no sea null
                double volume = newValue.doubleValue() / 100;
                //System.out.println(volume); Depuración por consola.
                mainController.getMediaPlayerMenu().setVolume(volume);
                mainController.getMediaPlayerJuego().setVolume(volume); // Ajustar volumen del juego también.
                
                if (newValue.doubleValue() > 75) {
                    volumeImage.setImage(new Image(getClass().getResource("/images/musica.png").toExternalForm()));
                } else if (newValue.doubleValue() > 25) {
                    volumeImage.setImage(new Image(getClass().getResource("/images/altavoz2.png").toExternalForm()));
                } else if (newValue.doubleValue() > 1) {
                    volumeImage.setImage(new Image(getClass().getResource("/images/altavoz1.png").toExternalForm()));
                } else if (newValue.doubleValue() == 0) {
                    volumeImage.setImage(new Image(getClass().getResource("/images/nomusica.png").toExternalForm()));
                }
            }
        });
    }


    public BorderPane getView() {
        return view;
    }

}

