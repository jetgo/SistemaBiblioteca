/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Contenido;
import java.util.Date;

/**
 *
 * @author David
 */
public class Principal extends javax.swing.JFrame {

    private Contenido controlGeneral;
    /**
     * Creates new form InterfazPrincipal
     */
    public Principal(Contenido controlGeneral) {
        initComponents();
        this.controlGeneral = controlGeneral;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar2 = new javax.swing.JToolBar();
        btnActualizarUsuario = new javax.swing.JButton();
        btnMantenedorUsuario = new javax.swing.JButton();
        btnMantenedorRecurso = new javax.swing.JButton();
        btnPrestamo = new javax.swing.JButton();
        btnReserva = new javax.swing.JButton();
        btnReporteActividad = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dtpContenedor = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar2.setRollover(true);

        btnActualizarUsuario.setText("Actualizar Datos");
        btnActualizarUsuario.setFocusable(false);
        btnActualizarUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizarUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarUsuarioActionPerformed(evt);
            }
        });
        jToolBar2.add(btnActualizarUsuario);

        btnMantenedorUsuario.setText("Mantenedor de Usuarios");
        btnMantenedorUsuario.setFocusable(false);
        btnMantenedorUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMantenedorUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMantenedorUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedorUsuarioActionPerformed(evt);
            }
        });
        jToolBar2.add(btnMantenedorUsuario);

        btnMantenedorRecurso.setText("Mantenedor de Recursos");
        btnMantenedorRecurso.setFocusable(false);
        btnMantenedorRecurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMantenedorRecurso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMantenedorRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedorRecursoActionPerformed(evt);
            }
        });
        jToolBar2.add(btnMantenedorRecurso);

        btnPrestamo.setText("Realizar Prestamo");
        btnPrestamo.setFocusable(false);
        btnPrestamo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrestamo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamoActionPerformed(evt);
            }
        });
        jToolBar2.add(btnPrestamo);

        btnReserva.setText("Tus Reservas");
        btnReserva.setFocusable(false);
        btnReserva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReserva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservaActionPerformed(evt);
            }
        });
        jToolBar2.add(btnReserva);

        btnReporteActividad.setText("Reporte De Actividades");
        btnReporteActividad.setFocusable(false);
        btnReporteActividad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReporteActividad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReporteActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActividadActionPerformed(evt);
            }
        });
        jToolBar2.add(btnReporteActividad);

        btnCerrar.setText("Cerrar Sesion");
        btnCerrar.setFocusable(false);
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jToolBar2.add(btnCerrar);

        javax.swing.GroupLayout dtpContenedorLayout = new javax.swing.GroupLayout(dtpContenedor);
        dtpContenedor.setLayout(dtpContenedorLayout);
        dtpContenedorLayout.setHorizontalGroup(
            dtpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        dtpContenedorLayout.setVerticalGroup(
            dtpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(dtpContenedor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnMantenedorUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedorUsuarioActionPerformed
        InterfazMantenedorUsuario mantenedorUsuario=new InterfazMantenedorUsuario();
        dtpContenedor.add(mantenedorUsuario);
        mantenedorUsuario.show();
        
    }//GEN-LAST:event_btnMantenedorUsuarioActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
//        Login login=new Login();
//        login.setLocationRelativeTo(null);
//        login.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMantenedorRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedorRecursoActionPerformed
        InterfazMantenedorRecurso mantenedorRecurso=new InterfazMantenedorRecurso();
        dtpContenedor.add(mantenedorRecurso);
        mantenedorRecurso.show();
    }//GEN-LAST:event_btnMantenedorRecursoActionPerformed

    private void btnPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamoActionPerformed
        InterfazPrestamo prestamo=new InterfazPrestamo();
        dtpContenedor.add(prestamo);
        prestamo.show();
    }//GEN-LAST:event_btnPrestamoActionPerformed

    private void btnReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservaActionPerformed
        InterfazReserva reserva=new InterfazReserva();
        dtpContenedor.add(reserva);
        reserva.show();
    }//GEN-LAST:event_btnReservaActionPerformed

    private void btnReporteActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActividadActionPerformed
        InterfazReporteActividad reporteActividad=new InterfazReporteActividad();
        dtpContenedor.add(reporteActividad);
        reporteActividad.show();
    }//GEN-LAST:event_btnReporteActividadActionPerformed

    private void btnActualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarUsuarioActionPerformed
        InterfazActualizarUsuario actualizarUsuario=new InterfazActualizarUsuario();
        dtpContenedor.add(actualizarUsuario);
        actualizarUsuario.limpiarTodo();
        actualizarUsuario.show();
    }//GEN-LAST:event_btnActualizarUsuarioActionPerformed

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
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Principal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarUsuario;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnMantenedorRecurso;
    private javax.swing.JButton btnMantenedorUsuario;
    private javax.swing.JButton btnPrestamo;
    private javax.swing.JButton btnReporteActividad;
    private javax.swing.JButton btnReserva;
    private javax.swing.JDesktopPane dtpContenedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
}