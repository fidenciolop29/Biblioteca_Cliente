
package Control;

import Modelo.Usuario;
import Vista.LogIn_Biblioteca;
import Vista.NuevoUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control_Login implements ActionListener {
   private  LogIn_Biblioteca login= new LogIn_Biblioteca();
   private  NuevoUsuario nusu=  new NuevoUsuario();
   private  Usuario user= new Usuario();
   
    public Control_Login(LogIn_Biblioteca login,Usuario user,NuevoUsuario usu){
        this.login=login;
        this.login.ingresar_login.addActionListener(this);
        this.user=user;
        this.login.crearUsuario.addActionListener(this);
        this.nusu=usu;
        this.nusu.agregarUser.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        user.setId();
        user.setUser(user);
        user.setPassword();
        
        if(e.getSource()==login.crearUsuario){
            
        }
        if(e.getSource()==login.ingresar_login){
            
        }
    }
    
    
}
