/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package graphmaker;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author ASUS TUF GAMING F15
 */
public class Maker extends javax.swing.JFrame {

    /**
     * Creates new form Maker
     */
    public static Grafo graf = new Grafo();
    public static Lienzo obl = new Lienzo();
    public static Graphics h;

    public Maker() {
        this.getContentPane().setBackground(new Color(245, 239, 230));
        obl.setSize(708, 516);
        obl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(6, 40, 61), 5, true));
        //obl.setBackground(new java.awt.Color(204, 204, 255));
        
        
        initComponents();
        mostrar.setTabSize(4);
        muestra.setVisible(false);
        ver.add(obl);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        ver = new Lienzo();
        jLabel1 = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        vertice = new javax.swing.JToggleButton();
        arista = new javax.swing.JToggleButton();
        eliminarA = new javax.swing.JToggleButton();
        enumeracion = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        muestra = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrar = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        floyd = new javax.swing.JToggleButton();
        editarV = new javax.swing.JToggleButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Maker");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        ver.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ver.setForeground(new java.awt.Color(0, 102, 204));
        ver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout verLayout = new javax.swing.GroupLayout(ver);
        ver.setLayout(verLayout);
        verLayout.setHorizontalGroup(
            verLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );
        verLayout.setVerticalGroup(
            verLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(6, 40, 61));
        jLabel1.setText("Estado");

        estado.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N

        vertice.setBackground(new java.awt.Color(6, 40, 61));
        buttonGroup1.add(vertice);
        vertice.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        vertice.setForeground(new java.awt.Color(255, 255, 255));
        vertice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus (2).png"))); // NOI18N
        vertice.setText("Add Vertice");
        vertice.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        vertice.setBorderPainted(false);
        vertice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vertice.setDisabledIcon(null);
        vertice.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus (1).png"))); // NOI18N
        vertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verticeActionPerformed(evt);
            }
        });

        arista.setBackground(new java.awt.Color(6, 40, 61));
        buttonGroup1.add(arista);
        arista.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        arista.setForeground(new java.awt.Color(255, 255, 255));
        arista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/destino.png"))); // NOI18N
        arista.setText("Add Arista");
        arista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        arista.setBorderPainted(false);
        arista.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/destino2.png"))); // NOI18N
        arista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aristaActionPerformed(evt);
            }
        });

        eliminarA.setBackground(new java.awt.Color(6, 40, 61));
        buttonGroup1.add(eliminarA);
        eliminarA.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        eliminarA.setForeground(new java.awt.Color(255, 255, 255));
        eliminarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        eliminarA.setText("Del Arista");
        eliminarA.setToolTipText("Eliminar arista");
        eliminarA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.red, null, null));
        eliminarA.setBorderPainted(false);
        eliminarA.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton-eliminar (1).png"))); // NOI18N
        eliminarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAActionPerformed(evt);
            }
        });

        enumeracion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        enumeracion.setForeground(new java.awt.Color(6, 40, 61));
        enumeracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A, B... Z", "1, 2, 3...", "Propio" }));
        enumeracion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        enumeracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enumeracionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(6, 40, 61));
        jLabel2.setText("ENUMERACIÓN DE VERTICES");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(6, 40, 61));
        jLabel3.setText("FUNCIONES");

        muestra.setBackground(new java.awt.Color(245, 239, 230));

        mostrar.setEditable(false);
        mostrar.setColumns(20);
        mostrar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        mostrar.setForeground(new java.awt.Color(6, 40, 61));
        mostrar.setRows(5);
        jScrollPane1.setViewportView(mostrar);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(6, 40, 61));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Matriz de costos");

        javax.swing.GroupLayout muestraLayout = new javax.swing.GroupLayout(muestra);
        muestra.setLayout(muestraLayout);
        muestraLayout.setHorizontalGroup(
            muestraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(muestraLayout.createSequentialGroup()
                .addGroup(muestraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(muestraLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(muestraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))
                .addContainerGap())
        );
        muestraLayout.setVerticalGroup(
            muestraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(muestraLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        floyd.setBackground(new java.awt.Color(6, 40, 61));
        buttonGroup1.add(floyd);
        floyd.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        floyd.setForeground(new java.awt.Color(255, 255, 255));
        floyd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/conexiones3.png"))); // NOI18N
        floyd.setText("Floyd Warshall");
        floyd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        floyd.setBorderPainted(false);
        floyd.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/conexiones87.png"))); // NOI18N
        floyd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floydActionPerformed(evt);
            }
        });

        editarV.setBackground(new java.awt.Color(6, 40, 61));
        buttonGroup1.add(editarV);
        editarV.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        editarV.setForeground(new java.awt.Color(255, 255, 255));
        editarV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar1.png"))); // NOI18N
        editarV.setText("Edit vertice");
        editarV.setToolTipText("Editar Vertice");
        editarV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editarV.setBorderPainted(false);
        editarV.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar (1).png"))); // NOI18N
        editarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarVActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back_1.png"))); // NOI18N
        jButton3.setToolTipText("VOLVER ");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(arista, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(vertice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(floyd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(eliminarA, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(editarV, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                                    .addComponent(enumeracion, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 23, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(muestra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vertice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arista, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eliminarA, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editarV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(floyd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enumeracion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(muestra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void linea(int x, int y, int w, int z) {
        h.setColor(Color.RED);
        if (x == w && y == z) {
            h.drawArc(x + 10, y + 5, 20, 30, 320, 290);
            x = x + 15;
            y = y + 20;
        } else {
            h.drawLine(x + 20, y + 45, w + 20, z + 45);
            x = ((x + 20 - w + 20) / 2) + w;
            y = ((y + 45 - z + 45) / 2) + z;
        }
        h.setColor(Color.BLACK);

    }

    private void verMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_verMouseClicked

    private void verticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verticeActionPerformed
        estado.setText("Clickea el espacio de trabajo para agregar un vértice.");
        muestra.setVisible(false);
        obl.resetFloyd();
    }//GEN-LAST:event_verticeActionPerformed

    private void aristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aristaActionPerformed
        estado.setText("Selecciona el vertice inicial y final de la arista.");
        muestra.setVisible(false);
        obl.resetFloyd();
    }//GEN-LAST:event_aristaActionPerformed

    private void eliminarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarAActionPerformed
        estado.setText("Selecciona el vertice final e inicial de la arista a eliminar.");
        muestra.setVisible(false);
        obl.resetFloyd();
    }//GEN-LAST:event_eliminarAActionPerformed

    private void enumeracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enumeracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enumeracionActionPerformed

    private void floydActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floydActionPerformed
        estado.setText("Clickea el vertice inicial y final.");
        muestra.setVisible(true);
        obl.resetFloyd();
        

    }//GEN-LAST:event_floydActionPerformed

    private void editarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarVActionPerformed
        estado.setText("Selecciona el vertice a editar .");
        muestra.setVisible(false);
        obl.resetFloyd();
    }//GEN-LAST:event_editarVActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Inicio otro = new Inicio();
        otro.setVisible(true);
        graf = new Grafo();
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Maker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Maker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Maker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Maker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Maker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JToggleButton arista;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JToggleButton editarV;
    public static javax.swing.JToggleButton eliminarA;
    public static javax.swing.JComboBox<String> enumeracion;
    public static javax.swing.JLabel estado;
    public static javax.swing.JToggleButton floyd;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea mostrar;
    private javax.swing.JPanel muestra;
    private javax.swing.JPanel ver;
    public static javax.swing.JToggleButton vertice;
    // End of variables declaration//GEN-END:variables
}
