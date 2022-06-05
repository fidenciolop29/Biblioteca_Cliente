
package Control;

import Modelo.ConsultasUsers;
import Modelo.Usuario;
import Vista.LogIn_Biblioteca;
import Vista.NuevoUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Control_Login implements ActionListener {
   private  LogIn_Biblioteca login;
   private  NuevoUsuario nusu;
   private  Usuario user;
   private  ControlNuevoUsuario nusuc;
   private  ConsultasUsers consulta;
   
    public Control_Login(LogIn_Biblioteca login,Usuario user,NuevoUsuario usu,ControlNuevoUsuario nusuc,ConsultasUsers consulta){
        this.login=login;
        this.login.ingresar_login.addActionListener(this);
        this.user=user;
        this.login.crearUsuario.addActionListener(this);
        this.nusu=usu;
        this.nusu.agregarUser.addActionListener(this);
        this.nusuc=nusuc;
        this.consulta=consulta;
       }
    @Override
    public void actionPerformed(ActionEvent e) {
       
         if(e.getSource()==login.ingresar_login){
            user.setUser(login.txfUsuario_login.getText());
            user.setPassword(login.txfContra_login.getText());
            if(consulta.buscar(user)){
                
                   //inicio de principal
            }else{
                JOptionPane.showMessageDialog(null,"Este usuario no existe");
            }
        }
        
        if(e.getSource()==login.crearUsuario){
            nusuc.iniciar();
            login.setVisible(false);
        }
    }
    
    
  
    public void iniciar(){
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void limpiar(){
        login.txfContra_login.setText("");
        login.txfUsuario_login.setText("");
    }
}
