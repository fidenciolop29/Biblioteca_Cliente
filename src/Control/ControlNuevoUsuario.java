
package Control;

import Modelo.ConsultasUsers;
import Modelo.Usuario;
import Vista.NuevoUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControlNuevoUsuario implements ActionListener {
    private NuevoUsuario vista;
    private Usuario mod;
    private ConsultasUsers consulta;
    private Control_Login controlusu;
    
    public ControlNuevoUsuario(NuevoUsuario vista, Usuario mod, ConsultasUsers consulta,Control_Login controlusu){
        this.vista=vista;
        this.mod=mod;
        this.vista.agregarUser.addActionListener(this);
        this.consulta=consulta;
        this.controlusu=controlusu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==vista.agregarUser){
           mod.setUser(vista.txfUsuario.getText());
           mod.setPassword(vista.txfContra.getText());
           if(consulta.registrar(mod))
            {
                JOptionPane.showMessageDialog(null, "registro guardado");
                limpiar();
                controlusu.iniciar();
                vista.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
       }
    }

    public void iniciar(){
        vista.setVisible(true);
        vista.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
    
    public void limpiar(){
        vista.txfContra.setText("");
        vista.txfUsuario.setText("");
    }
    
    
}
