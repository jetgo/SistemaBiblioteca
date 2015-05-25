/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorLogin;
import controlador.Coordinador;
import controlador.Main;
import funcion.Mensaje;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.PreguntaSecreta;
import modelo.Usuario;


/**
 *
 * @author David
 */
public class InterfazRecuperaPassword extends javax.swing.JDialog {

    private Coordinador controlCoordinador;
    private Usuario miUsuario;
    /**
     * Creates new form InterfazRecuperarPassword
     */
    public InterfazRecuperaPassword(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
//        this.controlRecuperar=controlRecuperar;
    }
    
    public void setCoordinador(Coordinador controlTotal) {
            this.controlCoordinador = controlTotal;
    }
                

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRecuperar = new javax.swing.JPanel();
        cbbPregunta = new javax.swing.JComboBox();
        lblPregunta = new javax.swing.JLabel();
        lblRespuesta = new javax.swing.JLabel();
        lblRut = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        txtRespuesta = new javax.swing.JTextField();
        btnVerificar = new javax.swing.JButton();
        pnlNuevaClave = new javax.swing.JPanel();
        btnActualizarPass = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPassRepetir = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlRecuperar.setBorder(javax.swing.BorderFactory.createTitledBorder("Recuperar Password"));

        lblPregunta.setText("Pregunta Secreta :");

        lblRespuesta.setText("Respuesta Secreta :");

        lblRut.setText("Rut del Alumno :");

        btnVerificar.setText("Verificar Datos");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRecuperarLayout = new javax.swing.GroupLayout(pnlRecuperar);
        pnlRecuperar.setLayout(pnlRecuperarLayout);
        pnlRecuperarLayout.setHorizontalGroup(
            pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecuperarLayout.createSequentialGroup()
                .addGroup(pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRecuperarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblRespuesta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRecuperarLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRecuperarLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPregunta)
                            .addComponent(lblRut))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRecuperarLayout.createSequentialGroup()
                                .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbbPregunta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlRecuperarLayout.setVerticalGroup(
            pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecuperarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRut)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPregunta)
                    .addComponent(cbbPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRespuesta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVerificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlNuevaClave.setBorder(javax.swing.BorderFactory.createTitledBorder("Cambio de Password"));

        btnActualizarPass.setText("Confirmar Cambio");
        btnActualizarPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPassActionPerformed(evt);
            }
        });

        jLabel1.setText("Password Nuevo :");

        jLabel2.setText("Repetir Password Nuevo :");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNuevaClaveLayout = new javax.swing.GroupLayout(pnlNuevaClave);
        pnlNuevaClave.setLayout(pnlNuevaClaveLayout);
        pnlNuevaClaveLayout.setHorizontalGroup(
            pnlNuevaClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNuevaClaveLayout.createSequentialGroup()
                .addGroup(pnlNuevaClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNuevaClaveLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnActualizarPass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlNuevaClaveLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnlNuevaClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlNuevaClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPassRepetir)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnlNuevaClaveLayout.setVerticalGroup(
            pnlNuevaClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNuevaClaveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNuevaClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNuevaClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNuevaClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarPass)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRecuperar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlNuevaClave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlRecuperar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(pnlNuevaClave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public void setVisiblePanelCambio(boolean valor){
        if(valor){
            pnlNuevaClave.setVisible(valor);
            btnVerificar.setEnabled(false);
            txtRut.setEditable(false);
            txtRespuesta.setEditable(false);
            cbbPregunta.setEnabled(false);
            this.setSize(400, 360);
        } else {
            this.setSize(400, 210);
            btnVerificar.setEnabled(true);
            txtRut.setEditable(true);
            txtRespuesta.setEditable(true);
            cbbPregunta.setEnabled(true);
            pnlNuevaClave.setVisible(valor);
        }
    }
    
    public void setPreguntaSecreta(ArrayList<PreguntaSecreta> preguntas){
        cbbPregunta.addItem("Seleccione una Pregunta:");
        for (int i = 0; i < preguntas.size(); i++) {
            cbbPregunta.addItem(preguntas.get(i).getPreSecDescripcion());
        }        
    }
    
    public void limpiar(){
        txtPassword.setText("");
        txtPassRepetir.setText("");
    }
    
    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        miUsuario = new Usuario();
        miUsuario.setPerRut(txtRut.getText());
        miUsuario.setPreSecId(String.valueOf(cbbPregunta.getSelectedIndex()));
        miUsuario.setUsuRespuesta(txtRespuesta.getText());
        controlCoordinador.verificarDatosSecretos(miUsuario);
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnActualizarPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPassActionPerformed
        if(String.valueOf(txtPassword.getPassword()).equals(String.valueOf(txtPassRepetir.getPassword()))){
            miUsuario.setUsuClave(String.valueOf(txtPassword.getPassword()));
            controlCoordinador.cambiarClave(miUsuario);
        } else {
            Mensaje.informacionAdvertencia("Debe repetir la misma Contraseña");
        }
        
    }//GEN-LAST:event_btnActualizarPassActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
        setVisiblePanelCambio(false);
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(InterfazRecuperaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(InterfazRecuperaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(InterfazRecuperaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(InterfazRecuperaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                InterfazRecuperaPassword dialog = new InterfazRecuperaPassword(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarPass;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JComboBox cbbPregunta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JLabel lblRespuesta;
    private javax.swing.JLabel lblRut;
    private javax.swing.JPanel pnlNuevaClave;
    private javax.swing.JPanel pnlRecuperar;
    private javax.swing.JPasswordField txtPassRepetir;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtRespuesta;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}