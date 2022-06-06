
package Principal;

import Control.Control_Login;
import Modelo.ConsultasUsers;
import Modelo.Usuario;
import Vista.AgregarLibro;
import Vista.Informacion;
import Vista.LogIn;
import Vista.Menu_Principal;
import Vista.NuevoUsuario;


public class Main {
    public static void main(String[] args) {
        Usuario usu= new Usuario();
        AgregarLibro vistaALibro= new AgregarLibro();
        Informacion vistainfo= new Informacion();
        Menu_Principal vistamenu= new Menu_Principal();
        NuevoUsuario vistanUsuario= new NuevoUsuario();
        LogIn vistaLogIn= new LogIn();
        ConsultasUsers consulta= new ConsultasUsers();
        
        Control_Login control= new Control_Login(vistaLogIn,usu,vistanUsuario,consulta,vistamenu,vistainfo,vistaALibro);
        control.iniciar();
        
    }
}
