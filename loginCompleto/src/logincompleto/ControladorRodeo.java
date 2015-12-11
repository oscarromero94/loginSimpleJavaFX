/*
    Escrito y programado por Óscar
*/
//Paquete que engloba al proyecto
package logincompleto;
//Importaciones de librerias externas
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ControladorRodeo implements Initializable {  
    //Variables para guardar tanto los controladores como el panel principal
    private ControladorCentral controladorcentral;
    private ControladorInformacion masPane;
    private BorderPane panelPrincipal;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    // Método para iniciar sesión desde la ventaran que engloba, la ventana
    @FXML
    public void inicioSesion() {
        TextField usuario = controladorcentral.getUsuario();
        PasswordField contrasena = controladorcentral.getContrasena();
        InicioSesion inicio = new InicioSesion(contrasena,usuario);
        
        //Guardamos la respuesta que nos devuelve la clase para poder saber si el inicio de sesión es correcto
        
        Boolean respuesta = inicio.iniciando();
        //System.out.println(respuesta);
        if(respuesta==true){
            try {
               //Si todo va correctamente cargaria la nueva ventana para mostrar la información 
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("informacion.fxml"));
               AnchorPane masPanel = (AnchorPane) loader.load();
               panelPrincipal.setCenter(masPanel);  
               masPane = loader.getController();
               masPane.controladorCentral(controladorcentral);
               String user = inicio.getUsuario().getText();
               String pass = inicio.getContrasena().getText();
               masPane.setUsuario(user);
               masPane.setContrasena(pass);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } 
    //Cargar el controlador central
    public void controler(ControladorCentral controladorcentral){
        this.controladorcentral = controladorcentral;
    } 
    //Cargar el controlador principal
    public void cargaPrincipal(BorderPane panelPrincipal){
        this.panelPrincipal = panelPrincipal;
    }
    //Cerrar el programa
    @FXML
    public void cerrar(){
        System.exit(0);
    }
}
