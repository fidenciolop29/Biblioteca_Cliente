
package Control;

import Modelo.Usuario;
import Vista.LogIn_Biblioteca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control_Login implements ActionListener {
   private  LogIn_Biblioteca login= new LogIn_Biblioteca();
   private  Usuario user= new Usuario();
    public Control_Login(LogIn_Biblioteca login,Usuario user){
        this.login=login;
        this.login.ingresar_login.addActionListener(this);
        this.user=user;
        this.login.crearUsuario.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==login.crearUsuario){
            
        }
        if(e.getSource()==login.ingresar_login){
            
        }
    }
    
    
}
