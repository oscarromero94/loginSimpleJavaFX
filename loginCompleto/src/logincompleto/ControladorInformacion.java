/*
    Escrito y programado por Óscar
*/
//Paquete que engloba al proyecto
package logincompleto;
//Importaciones de librerias externas
import javafx.fxml.FXML;
import javafx.scene.control.Label;
//Esta clase muestra la información final del programa mostrando tanto el usuario como contraseña con el cual
//hemos accedido mediante JAVA
public class ControladorInformacion {
    //Las siguientes variables almacenan las etiquetas "Label" para poder gestionarlas mas adelante con el metodo
    @FXML
    private Label usuario;
    
    @FXML
    private Label contrasena;
    
    private ControladorCentral controladorcentral;

    //Dos "Setters" para poder modificar las variables de usuario y contraseña
    public void setUsuario(String usuario) {
        this.usuario.setText(usuario);
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena.setText(contrasena);
    }
    // Cogemos el controlador central para gestionar el usuario y contraseña con el cual hemos accedido
    public void controladorCentral(ControladorCentral controladorcentral){
        this.controladorcentral = controladorcentral;   
    }
}
