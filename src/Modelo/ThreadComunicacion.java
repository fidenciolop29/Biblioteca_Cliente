
package Modelo;

import Vista.Menu_Principal;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

public class ThreadComunicacion extends SwingWorker<String, Object> {

    Menu_Principal menu;
    ModeloComunicacion mod;
    public ThreadComunicacion(Menu_Principal menu,ModeloComunicacion mod){
        this.menu=menu;
        this.mod=mod;
    }
    @Override
    protected String doInBackground() throws Exception {
        // Thinking for 4 seconds, but not blocking the UI
                 
                Thread t = new Thread() {
                    String nombre="";
                    int contador;
                    public void run() {
                            String nombre="";
                            final String HOST = "192.168.1.73";
                            final int PORT = 1000;
                            int contador =0;
                            System.out.println("Client started.");


                            try {

                            Socket socket = new Socket(HOST, PORT);
                            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                            Scanner in = new Scanner(socket.getInputStream());
                            Scanner s = new Scanner(System.in);  
                            while (true) {

                                //preguntar por usaurio caso 1
                                if(contador==0){
                                    System.out.println("Ingrese su usuario: ");
                                    String input = "Emmanuel";
                                    menu.jTADialogo.append("\nUsuario ingresado: "+input);
                                    nombre = input;
                                    out.println(input);
                                    contador++;
                                }
                                else{
                                    mod.respuesta = null;
                                    
                                    System.out.println("Tu Respuesta: ");
                                    menu.jTADialogo.append("\n>>>>Ingrese opcion");
                                    
                                    String input = mod.respuesta;
                                    
                                    
                                    while(input==null){ 
                                        System.out.println("");
                                        input = mod.respuesta;
                                    }
                                    menu.jTADialogo.append("\nIngresaste: "+mod.respuesta);
                                    out.println(input);
                                    
                          
                                    
                                    if("exit".equals(input)){
                                        System.out.println("te haz desconectado");
                                        contador=0;
                                        menu.jTADialogo.append("\nte desconcetatste");
                                        break;
                                    }
                                    if("1".equals(input)){
                                        menu.jTADialogo.append("\n>>>>Esperando server");
                                        String res= in.nextLine();
                                        menu.jTADialogo.append("\n"+res);
                                    }else if("2".equals(input)){
                                        menu.jTADialogo.append("\n>>>>Esperando server");
                                        String res= in.nextLine();
                                        menu.jTADialogo.append("\n"+res);
                                    }else if("3".equals(input)){
                                        menu.jTADialogo.append("\n>>>>Esperando server");
                                        String res= in.nextLine();
                                        menu.jTADialogo.append("\n"+res);
                                    }else if( "4".equals(input)){
                                        menu.jTADialogo.append("\n>>>>Ingrese el codigo del proveedor");
                                        input=null;
                                        mod.respuesta=null;
                                        while(input==null){
                                            System.out.println("");
                                            input=mod.respuesta;
                                            
                                        }
                                        out.println(input);
                                        
                                        String res= in.nextLine();
                                        System.out.println("Server: "+res);
                                        menu.jTADialogo.append("\n"+res);
                                       
                                    }
                                    else{
                                        String res = in.nextLine();
                                        System.out.println("Echoed from server: " + res);
                                        menu.jTADialogo.append("\n"+res);
                                        
                                    }
                                    
                                }

                            }
                        } catch (IOException ex) {
                            Logger.getLogger(Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                       
                    }
                 };
               
                t.start();
                
                return "\n";
    }
    
     protected void done() {
                try {
                    menu.jTADialogo.append(get());
                } catch (Exception ignore) {}
            }
    
}
