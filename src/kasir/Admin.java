/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir;

import java.io.File;
import java.util.logging.*;
import lib.Database;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author ashary
 */
public final class Admin extends javax.swing.JFrame {    
    /**
     * Creates new form Dashboard
     */
    public Admin() {
        initComponents();
        switch (Login.role) {
            case "Owner":
                UserMenu.setVisible(false);
                MenuRes.setVisible(false);
                OrderMenu.setVisible(false);
                TransaksiMenu.setVisible(false);
                break;
            case "Kasir":
                MenuRes.setVisible(false);
                OrderMenu.setVisible(false);
                break;
            case "Waiter":
                MenuRes.setVisible(false);
                TransaksiMenu.setVisible(false);
                break;
            default:
                break;
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

        jMenu1 = new javax.swing.JMenu();
        AdminMenuBar = new javax.swing.JMenuBar();
        UserMenu = new javax.swing.JMenu();
        AddUser = new javax.swing.JMenuItem();
        ManageUserMenu = new javax.swing.JMenuItem();
        MenuRes = new javax.swing.JMenu();
        OrderMenu = new javax.swing.JMenu();
        TransaksiMenu = new javax.swing.JMenu();
        LaporanMenu = new javax.swing.JMenu();
        AccountMenu = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kasir");

        UserMenu.setText("User");

        AddUser.setText("Add User");
        AddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddUserMouseClicked(evt);
            }
        });
        AddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserActionPerformed(evt);
            }
        });
        UserMenu.add(AddUser);

        ManageUserMenu.setText("Manage User");
        ManageUserMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageUserMenuMouseClicked(evt);
            }
        });
        ManageUserMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageUserMenuActionPerformed(evt);
            }
        });
        UserMenu.add(ManageUserMenu);

        AdminMenuBar.add(UserMenu);

        MenuRes.setText("Menu");
        MenuRes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuResMouseClicked(evt);
            }
        });
        MenuRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuResActionPerformed(evt);
            }
        });
        AdminMenuBar.add(MenuRes);

        OrderMenu.setText("Order");
        OrderMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderMenuMouseClicked(evt);
            }
        });
        AdminMenuBar.add(OrderMenu);

        TransaksiMenu.setText("Transaksi");
        TransaksiMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransaksiMenuMouseClicked(evt);
            }
        });
        AdminMenuBar.add(TransaksiMenu);

        LaporanMenu.setText("Laporan");
        LaporanMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LaporanMenuMouseClicked(evt);
            }
        });
        AdminMenuBar.add(LaporanMenu);

        AccountMenu.setText("Account");
        AccountMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AccountMenuMouseClicked(evt);
            }
        });
        AdminMenuBar.add(AccountMenu);

        setJMenuBar(AdminMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AccountMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountMenuMouseClicked
        // TODO add your handling code here:
        new Account(this, true).setVisible(true);
    }//GEN-LAST:event_AccountMenuMouseClicked

    private void AddUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddUserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AddUserMouseClicked

    private void AddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserActionPerformed
        // TODO add your handling code here:
        new Registrasi(this, true).setVisible(true);
    }//GEN-LAST:event_AddUserActionPerformed

    private void ManageUserMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageUserMenuMouseClicked
        // TODO add your handling code here:
        new ManageUser(this, true).setVisible(true);
    }//GEN-LAST:event_ManageUserMenuMouseClicked

    private void ManageUserMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageUserMenuActionPerformed
        // TODO add your handling code here:
        new ManageUser(this, true).setVisible(true);
    }//GEN-LAST:event_ManageUserMenuActionPerformed

    private void MenuResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuResActionPerformed
        // TODO add your handling code here:
        new Menu(this, true).setVisible(true);
    }//GEN-LAST:event_MenuResActionPerformed

    private void MenuResMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuResMouseClicked
        // TODO add your handling code here:
        new Menu(this, true).setVisible(true);
    }//GEN-LAST:event_MenuResMouseClicked

    private void OrderMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderMenuMouseClicked
        // TODO add your handling code here:
        new OrderMenu(this, true).setVisible(true);
    }//GEN-LAST:event_OrderMenuMouseClicked

    private void TransaksiMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransaksiMenuMouseClicked
        // TODO add your handling code here:
        new Transaksi(this, true).setVisible(true);
    }//GEN-LAST:event_TransaksiMenuMouseClicked

    private void LaporanMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LaporanMenuMouseClicked
        try {
            String namafile= "src/kasir/Laporan.jasper"; 
            File report = new File(namafile);
            JasperReport jreprt;
            jreprt = (JasperReport) JRLoader.loadObject(report);
            JasperPrint jprintt = JasperFillManager.fillReport(jreprt,null, Database.getCon());
            JasperViewer.viewReport(jprintt,false);
        } catch (JRException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LaporanMenuMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Admin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AccountMenu;
    private javax.swing.JMenuItem AddUser;
    private javax.swing.JMenuBar AdminMenuBar;
    private javax.swing.JMenu LaporanMenu;
    private javax.swing.JMenuItem ManageUserMenu;
    private javax.swing.JMenu MenuRes;
    private javax.swing.JMenu OrderMenu;
    private javax.swing.JMenu TransaksiMenu;
    private javax.swing.JMenu UserMenu;
    private javax.swing.JMenu jMenu1;
    // End of variables declaration//GEN-END:variables
}
