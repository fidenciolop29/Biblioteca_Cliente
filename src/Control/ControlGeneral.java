
package Control;

import Modelo.ConsultasLibros;
import Modelo.ConsultasUsers;
import Modelo.Libro;
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
   Socket socket = null;
   BufferedReader lee =null;
   PrintWriter escribe = null;
   
    public ControlGeneral(LogIn login,Usuario user,NuevoUsuario usu,ConsultasUsers consulta, Menu_Principal menu, Informacion info, AgregarLibro agg,ConsultasLibros consultalibro, Libro libro){
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
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
         if(e.getSource()==login.ingresar_login){
            user.setUser(login.txfUsuario_login.getText());
            user.setPassword(login.txfContra_login.getText());
            if(consulta.buscar(user)){
                JOptionPane.showMessageDialog(null, "Usuario aceptado");
                menu.setVisible(true);
                 menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 login.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null,"El usuario no existe");
                limpiar();
            }
         if(consulta.buscar(user)){
                
                 menu.setVisible(true);
                 menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 login.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null,"Este usuario no existe");
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
         //Mensajes
            if(e.getSource()==menu.Conectar){
                 Thread inicio = new Thread(new Runnable(){
                  public void run(){
                      try{
                     socket=new Socket("LocalHost",1000);
                     leer();
                     escribir();
                  }catch(Exception ex){
                    ex.printStackTrace();}}
        });}
         if(e.getSource()==agg.agregarlibro){
             libro.setId(Integer.parseInt(agg.txfId.getText()));
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
        if(e.getSource()==agg.buscar){
             libro.setId(Integer.parseInt(agg.txfId.getText()));
            if(consultalibro.buscar(libro)){
                agg.txfId.setText(String.valueOf(libro.getId()));
                agg.txfNomLibro.setText(libro.getTitulo());
                agg.txfNomAutor.setText(libro.getAutor());
                agg.txfEditorial.setText(libro.getEditorial());
                
            }
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
    
    public void escribir(){
        Thread escritorHilo =new Thread (new Runnable(){
        public void run(){ 
        try{
        escribe =new PrintWriter(socket.getOutputStream(),true);
        menu.enviar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        String envio = null;
        envio.equals(menu.Mensaje.getText());
        escribe.println(envio);
        menu.Mensaje.setText("");
        } 
        });}
        catch(Exception ex){
        ex.printStackTrace();}}
        });
       escritorHilo.start();
    }
    public void leer(){
        Thread lectorHilo =new Thread (new Runnable(){
        public void run(){    
        try{
        lee =new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true){
         String recibido=lee.readLine();
         menu.jTADialogo.append("Servidor:" + recibido);
        }
        }
        catch(Exception ex){
        ex.printStackTrace();}
        }
        });
        lectorHilo.start();
    }
}
