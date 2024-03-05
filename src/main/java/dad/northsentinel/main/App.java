package dad.northsentinel.main;

import dad.northsentinel.mainmenu.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

	public static Stage primarySatge;

	/**
     * Método principal de inicio de la aplicación.
     * @param primaryStage El escenario principal de la aplicación.
     * @throws Exception Si ocurre algún error durante la inicialización.
     */
	
	public void start(Stage primaryStage) throws Exception {

		MainController controller = new MainController();

		App.primarySatge = primaryStage;

		Scene scene = new Scene(controller.getView(), 800, 600);
		
		primaryStage.getIcons().add(new Image("/images/logo.png"));
		primaryStage.setTitle("NorthSentinel");
		primaryStage.setScene(scene);

		primaryStage.setFullScreen(false);

		primaryStage.show();

	}

}
