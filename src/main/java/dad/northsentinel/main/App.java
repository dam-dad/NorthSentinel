package dad.northsentinel.main;

import dad.northsentinel.mainmenu.MainController;
import dad.northsentinel.model.Mapa;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
	
	
	public void start(Stage primaryStage) throws Exception {
		
		
        MainController controller = new MainController();
        
        Scene scene = new Scene(controller.getView(), 1200, 800);

		primaryStage.getIcons().add(new Image("/images/logo.png"));
        primaryStage.setTitle("NorthSentinel");
        primaryStage.setScene(scene);
        
        
        primaryStage.show();
		
	}
	
	
	
	public static void main(String[] args) {
        launch(args);
    }
}


