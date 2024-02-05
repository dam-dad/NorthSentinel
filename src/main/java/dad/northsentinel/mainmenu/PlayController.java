package dad.northsentinel.mainmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class PlayController implements Initializable{

	private EventHandler<ActionEvent> onGoBack;
	
	@FXML
    private BorderPane view;
		
	public PlayController(){
				
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
			onGoBack.handle(event);
		}
    }
	
	public void setOnGoBack(EventHandler<ActionEvent> onGoBack) {
        this.onGoBack = onGoBack;
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public BorderPane getView() {
		return view;
	}
	
}
