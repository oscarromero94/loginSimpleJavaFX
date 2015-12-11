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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public  class ControladorCentral implements Initializable {
    
    //Variables tanto de FXML como de la clase para guardar valores como el panel principal, el controlador de la información que 
    // es la última ventana que parece como los valores que genera el FXML
    private BorderPane panelPrincipal;
    private ControladorInformacion masPane;
    
    @FXML
    private Button isesion;
    
    @FXML
    private TextField usuario;
    
    @FXML
    private PasswordField contrasena;

    //Método para devolver el valor del usuario
    public TextField getUsuario() {
        return usuario;
    }

    //Método para devolver el valor de la contraseña
    public PasswordField getContrasena() {
        return contrasena;
    }
    
    //Método para cargar en la clase el panel principal
    public void cargaPrincipal(BorderPane panelPrincipal){
        this.panelPrincipal = panelPrincipal;
    }
    
    //Acción de el boton de inicio de sesión
    @FXML
    public void handleButtonAction() {
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
               masPane.controladorCentral(this);
               String user = inicio.getUsuario().getText();
               String pass = inicio.getContrasena().getText();
               masPane.setUsuario(user);
               masPane.setContrasena(pass);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void salir(){
        //Salida de nuestro programa
        System.exit(0);
    }
    
    @FXML
    public void moverSobreBoton(){  
        //Controlador de versión
        System.out.println("============================");
        System.out.println("=========6F73636172=========");
        System.out.println("============================");
    }
}