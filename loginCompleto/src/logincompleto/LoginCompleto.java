/*
    Escrito y programado por Óscar
*/

//Paquete que engloba al proyecto
package logincompleto;

//Importaciones de librerias externas
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//Main del programa

public class LoginCompleto extends Application {
    
    //Estas variables almacenan tanto las ventanas como los controladores.
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ControladorRodeo controladorrodeo;
    private ControladorCentral controladorcentral;
            
    //Este método arranca los métodos principales
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initRootLayout();

        showPersonOverview();
    }
    public void initRootLayout() {
         try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("rodeo.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            //Capturando controladores
            controladorrodeo = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPersonOverview() {
        try {
            // Load player overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("central.fxml"));
            AnchorPane mainLayout = (AnchorPane) loader.load();
            
            // Set person overview into the center of root layout.
            rootLayout.setCenter(mainLayout);
            
            // Give the controller access to the main app.
            //Movimiento de controladores hacia otros controladores
            controladorcentral = loader.getController();
            controladorrodeo.cargaPrincipal(rootLayout);
            controladorcentral.cargaPrincipal(rootLayout);
            controladorrodeo.controler(controladorcentral);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
