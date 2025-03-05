/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.upb.tresenraya;

import edu.upb.tresenraya.bl.AceptarSolicitud;
import edu.upb.tresenraya.bl.AceptarSolicitudJuego;
import edu.upb.tresenraya.bl.Comando;
import edu.upb.tresenraya.bl.Contactos;
import edu.upb.tresenraya.bl.IniciarJuego;
import edu.upb.tresenraya.bl.MarcarPartida;
import edu.upb.tresenraya.bl.RechazarSolicitud;
import edu.upb.tresenraya.bl.RechazarSolicitudJuego;
import edu.upb.tresenraya.bl.SolicitudConexion;
import edu.upb.tresenraya.bl.juego.JuegoTresEnRaya;
import edu.upb.tresenraya.bl.juego.SimboloType;
import edu.upb.tresenraya.db.ConexionDb;
import edu.upb.tresenraya.mediador.Mediador;
import edu.upb.tresenraya.server.ServidorJuego;
import javax.swing.JLabel;
import edu.upb.tresenraya.mediador.OnMessageListener;
import edu.upb.tresenraya.server.SocketClient;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author rlaredo
 */
public class TresEnRayaUI extends javax.swing.JFrame implements OnMessageListener, ActionListener, MouseListener {

    private ServidorJuego servidorJuego;
    private JuegoTresEnRaya juego;
    private SocketClient client;
    private String jugadorBIP;
    private GridLayout gridLayout;
    private JLabel[][] tableroUI;

    /**
     * Creates new form TresEnRayaUI
     */
    public TresEnRayaUI() {
        initComponents();
        Mediador.addListener(this);
        ConexionDb.intance().getConnection();

        init();
    }

    private void init() {
        gridLayout = new GridLayout(3, 3);
        panelJuego.setLayout(gridLayout);
        tableroUI = new JLabel[3][3];
        juego = new JuegoTresEnRaya();
        for (int i = 0; i < gridLayout.getRows(); i++) {
            for (int j = 0; j < gridLayout.getColumns(); j++) {
                JLabel label = new JLabel();             
                label.setName(String.format("%s|%s", String.valueOf(i), String.valueOf(j)));
                label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
                label.addMouseListener(this);
                tableroUI[i][j]= label;
                panelJuego.add("Label " + i + "-" + j, label);
            }
        }

        mostrar();
    }

    private void mostrar() {
        if (juego != null) {
            SimboloType [][] tablero = juego.getTablero();
            for (int i = 0; i < gridLayout.getRows(); i++) {
                for (int j = 0; j < gridLayout.getColumns(); j++) {
                    JLabel label = tableroUI[i][j];
                    label.setText(tablero[i][j].name());
                }
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

        jToolBar1 = new javax.swing.JToolBar();
        btnServer = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        panelJuego = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jBtnAgregar = new javax.swing.JButton();

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

        jSplitPane1.setDividerLocation(550);

        panelJuego.setLayout(new java.awt.GridLayout(3, 3));
        jSplitPane1.setLeftComponent(panelJuego);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jSplitPane1.setRightComponent(jScrollPane1);

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
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1))
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
                Contactos.getInstance().send(ip, "0001|" + nombre + System.lineSeparator());
                JOptionPane.showMessageDialog(null, "Conexion exitoso", "Info", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al conectar con el cliente", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jBtnAgregarActionPerformed

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
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panelJuego;
    // End of variables declaration//GEN-END:variables

    private void initServer() {
        if (servidorJuego == null) {
            try {
                servidorJuego = new ServidorJuego();
                servidorJuego.start();
                btnServer.setText("Servidor Iniciado");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

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
    public void mouseClicked(MouseEvent e) {
        JLabel source = (JLabel) e.getSource();
        source.setText("X");
        System.out.println(source.getName());
        String s[] = source.getName().split(Pattern.quote("|"));
        MarcarPartida marcar = new MarcarPartida("X", Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        Contactos.getInstance().send(jugadorBIP, marcar.getComando());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void onMessage(Comando c) {
        if (c.getCodigoComando().equals("0001")) {
            SolicitudConexion sol = (SolicitudConexion) c;
            this.jugadorBIP = sol.getIp();
            String nombre = sol.getNombre();
            int n = JOptionPane.showConfirmDialog(this, nombre + " te ha solicitado",
                    "Aceptas?",
                    JOptionPane.YES_NO_OPTION);
            switch (n) {
                case JOptionPane.YES_OPTION ->
                    Contactos.getInstance().send(c.getIp(), new AceptarSolicitud("Ricardo Laredo").getComando());
                case JOptionPane.NO_OPTION ->
                    Contactos.getInstance().send(c.getIp(), new RechazarSolicitud().getComando());
                default -> {
                }
            }
            return;
        }
        
        if (c.getCodigoComando().equals("0004")) {
            IniciarJuego sol = (IniciarJuego) c;
            this.jugadorBIP = sol.getIp();
           
            int n = JOptionPane.showConfirmDialog(this,  " Te ha solicitado iniciar Juego",
                    "Aceptas?",
                    JOptionPane.YES_NO_OPTION);
            switch (n) {
                case JOptionPane.YES_OPTION ->
                    Contactos.getInstance().send(c.getIp(), new AceptarSolicitudJuego().getComando());
                case JOptionPane.NO_OPTION ->
                    Contactos.getInstance().send(c.getIp(), new RechazarSolicitudJuego().getComando());
                default -> {
                }
            }
            return;
        }
        if (c.getCodigoComando().equals("0008")) {
            MarcarPartida sol = (MarcarPartida) c;
            tableroUI[sol.getPosicionX()][sol.getPosicionY()].setText(sol.getSimbolo());
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
       

    }

}
