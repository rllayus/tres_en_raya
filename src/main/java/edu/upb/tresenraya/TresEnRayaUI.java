/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.upb.tresenraya;

import edu.upb.tresenraya.bl.AceptarSolicitud;
import edu.upb.tresenraya.bl.AceptarSolicitudJuego;
import edu.upb.tresenraya.bl.Comando;
import edu.upb.tresenraya.bl.Comando10;
import edu.upb.tresenraya.bl.Contacto;
import edu.upb.tresenraya.bl.Contactos;
import edu.upb.tresenraya.bl.IniciarJuego;
import edu.upb.tresenraya.bl.MarcarPartidaExa;
import edu.upb.tresenraya.bl.RechazarSolicitud;
import edu.upb.tresenraya.bl.RechazarSolicitudJuego;
import edu.upb.tresenraya.bl.SolicitudConexion;
import edu.upb.tresenraya.bl.juego.SimboloType;
import edu.upb.tresenraya.db.ConexionDb;
import edu.upb.tresenraya.mediador.Mediador;
import edu.upb.tresenraya.server.ServidorJuego;
import edu.upb.tresenraya.mediador.OnMessageListener;
import edu.upb.tresenraya.server.SocketClient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author rlaredo
 */
public class TresEnRayaUI extends javax.swing.JFrame implements OnMessageListener, ActionListener {

    private ServidorJuego servidorJuego;
    private SocketClient client;
    private String jugadorBIP;
    private final DefaultListModel<Contacto> contacModel = new DefaultListModel<>();

    /**
     * Creates new form TresEnRayaUI
     */
    public TresEnRayaUI() {
        initComponents();
        Mediador.addListener(this);
        ConexionDb.intance().getConnection();

        jListContactos.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    jListContactos.setSelectedIndex(jListContactos.locationToIndex(e.getPoint()));
                    menuListaContactos.show(jListContactos, e.getPoint().x, e.getPoint().y);
                }
            }
        });
        jListContactos.setCellRenderer(new ContactRenderer());
        jListContactos.setModel(contacModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuListaContactos = new javax.swing.JPopupMenu();
        jMenuItemRetar = new javax.swing.JMenuItem();
        comando10 = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        btnServer = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListContactos = new javax.swing.JList<>();
        jPanelJuego = new edu.upb.tresenraya.JPanelJuego();
        jBtnAgregar = new javax.swing.JButton();

        jMenuItemRetar.setText("Retar");
        jMenuItemRetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRetarActionPerformed(evt);
            }
        });
        menuListaContactos.add(jMenuItemRetar);

        comando10.setText("Comando 10");
        comando10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comando10ActionPerformed(evt);
            }
        });
        menuListaContactos.add(comando10);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btnServer.setText("Iniciar Servidor");
        btnServer.setFocusable(false);
        btnServer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnServer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnServer);

        jSplitPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.blue, new java.awt.Color(204, 204, 204)));
        jSplitPane1.setDividerLocation(600);
        jSplitPane1.setResizeWeight(0.5);

        jScrollPane1.setViewportView(jListContactos);

        jSplitPane1.setRightComponent(jScrollPane1);

        javax.swing.GroupLayout jPanelJuegoLayout = new javax.swing.GroupLayout(jPanelJuego);
        jPanelJuego.setLayout(jPanelJuegoLayout);
        jPanelJuegoLayout.setHorizontalGroup(
            jPanelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );
        jPanelJuegoLayout.setVerticalGroup(
            jPanelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanelJuego);

        jBtnAgregar.setText("Agregar");
        jBtnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServerActionPerformed
        // TODO add your handling code here:
        if (servidorJuego == null) {
            try {
                servidorJuego = new ServidorJuego();
                servidorJuego.start();
                btnServer.setText("Servidor Iniciado");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnServerActionPerformed

    private void jBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarActionPerformed
        // TODO add your handling code here:
        String ip = JOptionPane.showInputDialog("Ingresa la IP del cliente");
        if (ip != null) {
            String nombre = "Ricardo Laredo";
            try {
                client = new SocketClient(new Socket(ip, 1825));
                client.start();
                Contactos.getInstance().onNewClient(client);
                Contactos.getInstance().send(client.getIp(), "0001|" + nombre + System.lineSeparator());
                JOptionPane.showMessageDialog(null, "Conexion exitoso", "Info", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al conectar con el cliente", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jBtnAgregarActionPerformed

    private void jMenuItemRetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRetarActionPerformed
        // TODO add your handling code here:
        Contacto contacto = contacModel.get(jListContactos.getSelectedIndex());
        this.jPanelJuego.iniciarJuego(contacto.getIp(), SimboloType.O);
        Comando comando = new IniciarJuego(SimboloType.X.name());
        Contactos.getInstance().send(jugadorBIP, comando);

    }//GEN-LAST:event_jMenuItemRetarActionPerformed

    private void comando10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comando10ActionPerformed
        // TODO add your handling code here:
        Contacto contacto = contacModel.get(jListContactos.getSelectedIndex());
        Comando10 partidaExa = new Comando10("Ricado Laredo");
        Contactos.getInstance().send(contacto.getIp(), partidaExa);

        contacModel.remove(jListContactos.getSelectedIndex());
    }//GEN-LAST:event_comando10ActionPerformed

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
                if ("Macintosh".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TresEnRayaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TresEnRayaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TresEnRayaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TresEnRayaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TresEnRayaUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnServer;
    private javax.swing.JMenuItem comando10;
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JList<Contacto> jListContactos;
    private javax.swing.JMenuItem jMenuItemRetar;
    private edu.upb.tresenraya.JPanelJuego jPanelJuego;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPopupMenu menuListaContactos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onMessage(String msg) {
        System.out.println(msg);
    }

    @Override
    public void onClose() {
        System.out.println("UI: Cayo el cliente");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("a: " + e.getActionCommand());
    }

    @Override
    public void onMessage(Comando c) {
        System.out.println("UI: " + c.getCodigoComando());
        if (c.getCodigoComando().equals("0001")) {
            SolicitudConexion sol = (SolicitudConexion) c;
            this.jugadorBIP = sol.getIp();
            String nombre = sol.getNombre();
            
            int n = JOptionPane.showConfirmDialog(this, nombre + " te ha solicitado",
                    "Aceptas?",
                    JOptionPane.YES_NO_OPTION);
            switch (n) {
                case JOptionPane.YES_OPTION -> {
                    Contactos.getInstance().send(c.getIp(), new AceptarSolicitud("Ricardo Laredo").getComando());
                    Contacto contacto = new Contacto(sol.getNombre(), sol.getIp(), true);
                    jPanelJuego.iniciarJuego(sol.getIp(), SimboloType.X);
                    contacModel.addElement(contacto);
                }
                case JOptionPane.NO_OPTION ->
                    Contactos.getInstance().send(c.getIp(), new RechazarSolicitud().getComando());
                default -> {
                }
            }
            return;
        }

        if (c.getCodigoComando().equals("0004")) {
            System.out.println("Iniciando Juego");
            IniciarJuego sol = (IniciarJuego) c;
            Contacto contacto = null;
            for (int i = 0; i < contacModel.getSize(); i++) {
                if(contacModel.get(i).getIp().equals(sol.getIp())){
                    contacto= contacModel.get(i);
                }
            }
            if( contacto == null){
                return;
            }
            this.jugadorBIP = sol.getIp();

            int n = JOptionPane.showConfirmDialog(this,  " te ha solicitado",
                    "Aceptas?",
                    JOptionPane.YES_NO_OPTION);
            switch (n) {
                case JOptionPane.YES_OPTION -> {
                    Contactos.getInstance().send(c.getIp(), new AceptarSolicitud("Ricardo Laredo").getComando());
                    Contacto contacto = new Contacto(sol.getNombre(), sol.getIp(), true);
                    jPanelJuego.iniciarJuego(sol.getIp(), SimboloType.X);
                    contacModel.addElement(contacto);
                }
                case JOptionPane.NO_OPTION ->
                    Contactos.getInstance().send(c.getIp(), new RechazarSolicitud().getComando());
                default -> {
                }
            }
            
            Contactos.getInstance().send(c.getIp(), new AceptarSolicitudJuego().getComando());
            jPanelJuego.iniciarJuego(sol.getIp(), SimboloType.valueOf(sol.getSimbolo()));
            return;
        }

        if (c.getCodigoComando().equals("0003")) {
            IniciarJuego inciarJuego = new IniciarJuego("X");
            Contactos.getInstance().send(c.getIp(), inciarJuego.getComando());
            return;
        }

        if (c.getCodigoComando().equals("0002")) {
            jugadorBIP = null;
        }

        if (c.getCodigoComando().equals("0010")) {
            Contactos.getInstance().close(c.getIp());
        }

    }

}
