/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import lib.Database;

/**
 *
 * @author ashary
 */
public class Menu extends javax.swing.JDialog {
    
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    /**
     * Creates new form Menu
     * @param parent
     * @param modal
     */
    public Menu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        showDataToTable();
    }
    
    public void showDataToTable() {
        try {
            conn = Database.getCon();
            stmt = conn.createStatement();
            DefaultTableModel tb = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false; //To change body of generated methods, choose Tools | Templates.
                }
            };
            tb.addColumn("No");
            tb.addColumn("Nama");
            tb.addColumn("Harga");
            tb.addColumn("Status");
            TableBarang.setModel(tb);
            TableBarang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            TableBarang.setDragEnabled(false);
            rs = stmt.executeQuery("SELECT * FROM `masakan`");
            while (rs.next()) {
                tb.addRow(new Object[]{
                    rs.getString("id_masakan"),
                    rs.getString("nama_masakan"),
                    rs.getString("harga"),
                    rs.getInt("status_masakan") == 1 ? "Tersedia" : "Habis"
                });
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(
                Level.SEVERE, 
                "Data tidak dapat ditampilkan. {0}", 
                ex.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        TableBarang = new javax.swing.JTable();
        EditBtn = new javax.swing.JButton();
        NewBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableBarang);

        EditBtn.setText("Edit");
        EditBtn.setEnabled(false);
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        NewBtn.setText("New");
        NewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditBtn)
                    .addComponent(NewBtn))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableBarangMouseClicked
        // TODO add your handling code here:
        TableModel table = TableBarang.getModel();
        int row = TableBarang.getSelectedRow();
        if (table.getValueAt(row, 3).toString().equals("Tersedia")) {
            EditBtn.setEnabled(true);
        }
    }//GEN-LAST:event_TableBarangMouseClicked

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        // TODO add your handling code here:
        TableModel table = TableBarang.getModel();
        int row = TableBarang.getSelectedRow();
        new EditMenu(null, true, Integer.parseInt((String) table.getValueAt(row, 0))).setVisible(true);
        EditBtn.setEnabled(false);
        showDataToTable();
    }//GEN-LAST:event_EditBtnActionPerformed

    private void NewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewBtnActionPerformed
        // TODO add your handling code here:
        new NewMenu(null, true).setVisible(true);
        showDataToTable();
    }//GEN-LAST:event_NewBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Menu dialog = new Menu(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditBtn;
    private javax.swing.JButton NewBtn;
    private javax.swing.JTable TableBarang;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
