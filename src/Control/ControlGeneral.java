
package Control;

import Modelo.ConsultasLibros;
import Modelo.ConsultasUsers;
import Modelo.Libro;
import Modelo.ModeloComunicacion;
import Modelo.ThreadComunicacion;
import Modelo.Usuario;
import Vista.AgregarLibro;
import Vista.Informacion;
import Vista.LogIn;
import Vista.Menu_Principal;
import Vista.NuevoUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControlGeneral implements ActionListener {
   private  LogIn login;
   private  NuevoUsuario nusu;
   private  Usuario user;
   private  ConsultasUsers consulta;
   private  Menu_Principal menu;
   private  Informacion info;
   private  AgregarLibro agg;
   private  ConsultasLibros consultalibro;
   private  Libro libro;
   private  ModeloComunicacion modc;
   
   
    public ControlGeneral(LogIn login,Usuario user,NuevoUsuario usu,ConsultasUsers consulta, Menu_Principal menu, Informacion info, AgregarLibro agg,ConsultasLibros consultalibro, Libro libro,ModeloComunicacion modc){
        this.login=login;
        this.login.ingresar_login.addActionListener(this);
        this.user=user;
        this.login.crearUsuario.addActionListener(this);
        this.nusu=usu;
        this.nusu.agregarUser.addActionListener(this);
        this.nusu.Regresar2.addActionListener(this);
        this.consulta=consulta;
        this.menu=menu;
        this.info=info;
        this.agg=agg;
        this.menu.Conectar.addActionListener(this);
        this.menu.enviar.addActionListener(this);
        this.menu.Información.addActionListener(this);
        this.menu.Agregar_Libro.addActionListener(this);
        this.info.Regresar1.addActionListener(this);
        this.agg.Regresar3.addActionListener(this);
        this.agg.actualizar.addActionListener(this);
        this.nusu.Regresar2.addActionListener(this);
        this.agg.buscar.addActionListener(this);
        this.agg.agregarlibro.addActionListener(this);
        this.agg.eliminar.addActionListener(this);
        this.consultalibro=consultalibro;
        this.libro=libro;
        this.modc=modc;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
         if(e.getSource()==login.ingresar_login){
            user.setUser(login.txfUsuario_login.getText());
            user.setPassword(login.txfContra.getText());
            if(consulta.buscar(user)){
                JOptionPane.showMessageDialog(null, "Usuario aceptado");
                menu.setVisible(true);
                 menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 login.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null,"El usuario no existe");
                limpiar();
            }
        }
        
        if(e.getSource()==login.crearUsuario){
            nusu.setVisible(true);
            login.setVisible(false);
        }
        
         if(e.getSource()==nusu.agregarUser){
           user.setUser(nusu.txfUsuario.getText());
           user.setPassword(nusu.txfContra.getText());
           if(consulta.registrar(user))
            {
                JOptionPane.showMessageDialog(null, "registro guardado");
                limpiar2();
                login.setVisible(true);
                nusu.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar2();
            }
       }
       ///////////////////////////////////////////////////////////////////////
         //redireccion del menu
         if(e.getSource()==menu.Información){
            info.setVisible(true);
            menu.setVisible(false);
         }
         
         if(e.getSource()==menu.Agregar_Libro){
            agg.setVisible(true);
            menu.setVisible(false);
         }         
         //controles de regreso de las ventanas
         if(e.getSource()==info.Regresar1){
            info.setVisible(false);
            menu.setVisible(true);      
             }
         
         if(e.getSource()==nusu.Regresar2){
            nusu.setVisible(false);
            login.setVisible(true);
             }
         
         if(e.getSource()==agg.Regresar3){
            agg.setVisible(false);
            menu.setVisible(true);      
             }
         
         ///////////////////////////////////////////////////////////////
            if(e.getSource()==menu.Conectar){
                iniciarComunicacion();
            }
            
            if(e.getSource()==menu.enviar){
                modc.respuesta = menu.Mensaje.getText();
                System.out.println(modc.respuesta);
            }
       ////////////////////////////////////////////////////////////////////////    
         if(e.getSource()==agg.agregarlibro){
             libro.setId(agg.txfId.getText());
             libro.setTitulo(agg.txfNomLibro.getText());
             libro.setAutor(agg.txfNomAutor.getText());
             libro.setEditorial(agg.txfEditorial.getText());
             libro.setCategoria(agg.txfCat.getText());
             libro.setCantidad(Integer.parseInt(agg.txfCantidad.getText()));
             if(consultalibro.registrar(libro)){
                 JOptionPane.showMessageDialog(null,"Resgistro exitoso");
                 limpiar3();
             }else{
                 JOptionPane.showMessageDialog(null, "Error al guardar");
                  limpiar3();
             }
         }
       /////////////////////////////////////////////////////////////////////////
        if(e.getSource()==agg.buscar){
             libro.setId(agg.txfId.getText());
            if(consultalibro.buscar(libro)){
                agg.txfId.setText(String.valueOf(libro.getId()));
                agg.txfNomLibro.setText(libro.getTitulo());
                agg.txfNomAutor.setText(libro.getAutor());
                agg.txfEditorial.setText(libro.getEditorial());
                agg.txfCat.setText(libro.getCategoria());
                agg.txfCantidad.setText(String.valueOf(libro.getCantidad()));
            }else{
                JOptionPane.showMessageDialog(null,"No existe libro con este codigo");
                limpiar3();
            }
        }
        
        ///////////////////////////////////////////////////////////////////////
        if(e.getSource()==agg.actualizar){
             libro.setId(agg.txfId.getText());
             libro.setTitulo(agg.txfNomLibro.getText());
             libro.setAutor(agg.txfNomAutor.getText());
             libro.setEditorial(agg.txfEditorial.getText());
             libro.setCategoria(agg.txfCat.getText());
             libro.setCantidad(Integer.parseInt(agg.txfCantidad.getText()));
             if(consultalibro.modificar(libro)){
                 JOptionPane.showMessageDialog(null, "registro modificado");
                 limpiar3();
             }else{
                 JOptionPane.showMessageDialog(null, "Error al modificar");
                  limpiar3();
             }
        }
        /////////////////////////////////////////////////////////
        if(e.getSource()==agg.eliminar){
             libro.setId(agg.txfId.getText());
             if(consultalibro.eliminar(libro)){
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiar3();
             }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar3();
             }
        }
    }

    
  
    public void iniciar(){
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void limpiar(){
        login.txfContra.setText("");
        login.txfUsuario_login.setText("");
    }
     public void limpiar2(){
        nusu.txfContra.setText("");
        nusu.txfUsuario.setText("");
    }
   
    public void limpiar3(){
        agg.txfId.setText("");
        agg.txfNomAutor.setText("");
        agg.txfNomLibro.setText("");
        agg.txfEditorial.setText("");
        agg.txfCat.setText("");
        agg.txfCantidad.setText("");
    }
    
    public void iniciarComunicacion(){
        (new ThreadComunicacion(menu,modc)).execute();
    }
}
