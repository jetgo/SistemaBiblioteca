/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorLogin;
import controlador.Coordinador;
import controlador.MantenedorUsuario;
import funcion.Mensaje;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.event.InternalFrameAdapter;
import modelo.EstadoInterfaz;

/**
 *
 * @author David
 */
public class PrincipalGUI extends javax.swing.JFrame {

    private Coordinador controlCoordinador;
    
    /**
     * Creates new form InterfazPrincipal
     */
    public PrincipalGUI() {
        initComponents();
            
   

    }

    public void setCoordinador(Coordinador controlTotal) {
            this.controlCoordinador = controlTotal;
    }
    
    public void setVisibleOpciones(){
        btnActualizarUsuario.setVisible(false);
        btnCerrar.setVisible(false);
        btnMantenedorRecurso.setVisible(false);
        btnMantenedorUsuario.setVisible(false);
        btnReserva.setVisible(false);
    }
    

    
    public void setComponentes(ArrayList<EstadoInterfaz> interfazUsuario){
        Integer interfaz;
        for (int i = 0; i < interfazUsuario.size(); i++) {
            interfaz=Integer.parseInt(interfazUsuario.get(i).getIntId());
            switch(interfaz){
                case 1: btnReserva.setVisible(true);
                    break;
                case 2: btnMantenedorUsuario.setVisible(true);
                    break;
                case 3: btnCerrar.setVisible(true);
                    break;
                case 4: btnMantenedorRecurso.setVisible(true);
                    break;
                case 5:
                    break;
                default:Mensaje.informacionAdvertencia("Error grave de la Interfaz");
                        
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnMantenedorRecurso = new javax.swing.JButton();
        btnActualizarUsuario = new javax.swing.JButton();
        btnReserva = new javax.swing.JButton();
        btnMantenedorUsuario = new javax.swing.JToggleButton();
        btnReserva1 = new javax.swing.JButton();
        pnlEstado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lyrContenido = new javax.swing.JLayeredPane();
        mnbPrincipal = new javax.swing.JMenuBar();
        mnuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1200, 680));

        btnCerrar.setText("Cerrar Sesion");
        btnCerrar.setFocusable(false);
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnMantenedorRecurso.setText("Mantenedor de Recursos");
        btnMantenedorRecurso.setFocusable(false);
        btnMantenedorRecurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMantenedorRecurso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMantenedorRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedorRecursoActionPerformed(evt);
            }
        });

        btnActualizarUsuario.setText("Actualizar Datos Personales");
        btnActualizarUsuario.setFocusable(false);
        btnActualizarUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizarUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarUsuarioActionPerformed(evt);
            }
        });

        btnReserva.setText("Realiza tus Reservas");
        btnReserva.setFocusable(false);
        btnReserva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReserva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservaActionPerformed(evt);
            }
        });

        btnMantenedorUsuario.setText("Mantenedor Usuario");
        btnMantenedorUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedorUsuarioActionPerformed(evt);
            }
        });

        btnReserva1.setText("Revisa tus Reservas");
        btnReserva1.setFocusable(false);
        btnReserva1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReserva1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReserva1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReserva1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMantenedorRecurso, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
            .addComponent(btnActualizarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMantenedorUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReserva1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMantenedorRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMantenedorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReserva1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout pnlEstadoLayout = new javax.swing.GroupLayout(pnlEstado);
        pnlEstado.setLayout(pnlEstadoLayout);
        pnlEstadoLayout.setHorizontalGroup(
            pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEstadoLayout.setVerticalGroup(
            pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout lyrContenidoLayout = new javax.swing.GroupLayout(lyrContenido);
        lyrContenido.setLayout(lyrContenidoLayout);
        lyrContenidoLayout.setHorizontalGroup(
            lyrContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1339, Short.MAX_VALUE)
        );
        lyrContenidoLayout.setVerticalGroup(
            lyrContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        mnuAyuda.setText("File");
        mnbPrincipal.add(mnuAyuda);

        setJMenuBar(mnbPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lyrContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnlEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lyrContenido)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 150, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        

    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMantenedorRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedorRecursoActionPerformed
        InterfazMantenedorRecurso mantenedorRecurso=new InterfazMantenedorRecurso();
//        dtpContenedor.add(mantenedorRecurso);
//        mantenedorRecurso.show();
    }//GEN-LAST:event_btnMantenedorRecursoActionPerformed

    private void btnReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservaActionPerformed
        InterfazReserva reserva=new InterfazReserva();
//        dtpContenedor.add(reserva);
//        reserva.show();
    }//GEN-LAST:event_btnReservaActionPerformed

    private void btnActualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarUsuarioActionPerformed
        InterfazActualizarUsuario actualizarUsuario=new InterfazActualizarUsuario();
//        dtpContenedor.add(actualizarUsuario);
//        actualizarUsuario.limpiarTodo();
//        actualizarUsuario.show();
    }//GEN-LAST:event_btnActualizarUsuarioActionPerformed

    private void btnMantenedorUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedorUsuarioActionPerformed
        if(btnMantenedorUsuario.isSelected()){
            controlCoordinador.setInterfazUsuario(lyrContenido);

        }else{
            controlCoordinador.destroyInterfazUsuario();
        }
    }//GEN-LAST:event_btnMantenedorUsuarioActionPerformed

    private void btnReserva1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReserva1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReserva1ActionPerformed

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
//            java.util.logging.Logger.getLogger(PrincipalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PrincipalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PrincipalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PrincipalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PrincipalGUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarUsuario;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnMantenedorRecurso;
    private javax.swing.JToggleButton btnMantenedorUsuario;
    private javax.swing.JButton btnReserva;
    private javax.swing.JButton btnReserva1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane lyrContenido;
    private javax.swing.JMenuBar mnbPrincipal;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JPanel pnlEstado;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
