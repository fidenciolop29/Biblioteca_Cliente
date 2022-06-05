
package Control;

import Modelo.Usuario;
import Vista.NuevoUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlNuevoUsuario implements ActionListener {
    private NuevoUsuario vista;
    private Usuario mod;
    
    public ControlNuevoUsuario(NuevoUsuario vista, Usuario mod){
        this.vista=vista;
        this.mod=mod;
        this.vista.agregarUser.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

    public void iniciar(){
        
    }
    public NuevoUsuario getVista() {
        return vista;
    }

    public Usuario getMod() {
        return mod;
    }

    public void setVista(NuevoUsuario vista) {
        this.vista = vista;
    }

    public void setMod(Usuario mod) {
        this.mod = mod;
    }
    
    
    
}
