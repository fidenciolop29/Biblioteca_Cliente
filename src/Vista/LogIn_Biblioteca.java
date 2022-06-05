/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author fidea
 */
public class LogIn_Biblioteca extends javax.swing.JFrame {

    /**
     * Creates new form LogIn_Biblioteca
     */
    public LogIn_Biblioteca() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_login = new javax.swing.JPanel();
        titulo1 = new javax.swing.JLabel();
        titulo2 = new javax.swing.JLabel();
        logo_login = new javax.swing.JLabel();
        txfUsuario_login = new javax.swing.JTextField();
        txfContra_login = new javax.swing.JTextField();
        labUusario_login = new javax.swing.JLabel();
        labContra_login = new javax.swing.JLabel();
        ingresar_login = new javax.swing.JButton();
        crearUsuario = new javax.swing.JButton();

        setTitle("LOGIN_EL ARTE DE LEER");
        setResizable(false);

        panel_login.setBackground(new java.awt.Color(0, 204, 204));
        panel_login.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        titulo1.setFont(new java.awt.Font("Brand New Retro", 0, 60)); // NOI18N
        titulo1.setText("El ARTE ");

        titulo2.setFont(new java.awt.Font("KG Starting Over", 1, 36)); // NOI18N
        titulo2.setText("de leer");

        logo_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo_BibliotecaListo.png"))); // NOI18N

        labUusario_login.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        labUusario_login.setText("USUARIO");

        labContra_login.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        labContra_login.setText("CONTRASEÑA");

        ingresar_login.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ingresar_login.setText("INGRESAR");

        crearUsuario.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        crearUsuario.setText("NUEVO");

        javax.swing.GroupLayout panel_loginLayout = new javax.swing.GroupLayout(panel_login);
        panel_login.setLayout(panel_loginLayout);
        panel_loginLayout.setHorizontalGroup(
            panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_loginLayout.createSequentialGroup()
                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_loginLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(titulo1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_loginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo_login, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_loginLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(labContra_login, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_loginLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfContra_login, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfUsuario_login, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_loginLayout.createSequentialGroup()
                                .addComponent(ingresar_login)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(crearUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panel_loginLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(labUusario_login))
                    .addGroup(panel_loginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panel_loginLayout.setVerticalGroup(
            panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_loginLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_loginLayout.createSequentialGroup()
                        .addComponent(labUusario_login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfUsuario_login, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labContra_login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfContra_login, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ingresar_login)
                            .addComponent(crearUsuario)))
                    .addComponent(logo_login, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogIn_Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn_Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn_Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn_Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn_Biblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton crearUsuario;
    public javax.swing.JButton ingresar_login;
    public javax.swing.JLabel labContra_login;
    public javax.swing.JLabel labUusario_login;
    public javax.swing.JLabel logo_login;
    public javax.swing.JPanel panel_login;
    public javax.swing.JLabel titulo1;
    public javax.swing.JLabel titulo2;
    public javax.swing.JTextField txfContra_login;
    public javax.swing.JTextField txfUsuario_login;
    // End of variables declaration//GEN-END:variables
}
