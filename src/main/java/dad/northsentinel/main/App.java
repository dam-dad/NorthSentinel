package dad.northsentinel.main;

import dad.northsentinel.mainmenu.ControllerMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	public void start(Stage primaryStage) throws Exception {
		
        ControllerMenu controller = new ControllerMenu();

        Scene scene = new Scene(controller.getView(), 600, 400);

        primaryStage.setTitle("NorthSentinel");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}

}
//Autores: Iván Garrido, Feliciano Pérez y Samuel Padrón.

