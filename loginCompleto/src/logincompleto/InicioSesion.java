/*
    Escrito y programado por Óscar
*/

//Paquete que engloba al proyecto
package logincompleto;

//Importaciones de librerias externas
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

//Clase para gestionar el inicio de sesión con sus variables tanto de usuario como de contraseña
public class InicioSesion {

    private PasswordField contrasena;
    private TextField usuario;
    
    //Constructor de la clase, en el cual se le pasa los valores necesarios para efectuar un inicio de sesión
    public InicioSesion(PasswordField contrasena, TextField usuario) {
        this.contrasena = contrasena;
        this.usuario = usuario;
    }
    
    //El siguiente método comprueba que el usuario y la contraseña son correctos devolviendo un mensaje de alerta
    public boolean iniciando(){
        if(usuario.getText().equals("dam") && contrasena.getText().equals("dam")){
            //System.out.println("dentro");
            //mensaje.setText("Inicio de sesion correcto");
            
            //Si el inicio de sesion a sido correcto entraria a este bloque IF
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje del sistema");
            alert.setHeaderText(null);
            alert.setHeaderText("Óscar Romero Calonge");
            alert.setContentText("Inicio de sesion correcto");

            alert.showAndWait();
            return true;
        }else{
            //mensaje.setText("Usuario y contraseña incorrecto");
            
            //Si el inicio de sesion a sido erronea entraria a este bloque ELSE
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mensaje del sistema");
            alert.setHeaderText(null);
            alert.setHeaderText("Óscar Romero Calonge");
            alert.setContentText("Inicio de sesion incorrecto");

            alert.showAndWait();
            usuario.setText("");
            contrasena.setText("");
            return false;
        }
    }
    
    //Los siguientes Métodos devuelven tanto el usuario como la contraseña
    public PasswordField getContrasena() {
        return contrasena;
    }

    public TextField getUsuario() {
        return usuario;
    }
}
