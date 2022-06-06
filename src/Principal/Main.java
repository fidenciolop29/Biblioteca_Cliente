
package Principal;

import Control.ControlGeneral;
import Modelo.ConsultasLibros;
import Modelo.ConsultasUsers;
import Modelo.Libro;
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
        ConsultasLibros consultalibro= new ConsultasLibros();
        Libro libro= new Libro();
        
        ControlGeneral control= new ControlGeneral(vistaLogIn,usu,vistanUsuario,consulta,vistamenu,vistainfo,vistaALibro,consultalibro,libro);
        control.iniciar();
        
    }
}
