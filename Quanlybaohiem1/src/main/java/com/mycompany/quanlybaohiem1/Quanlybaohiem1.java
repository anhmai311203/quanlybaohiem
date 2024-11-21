/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.quanlybaohiem1;

import DAO.Dbconnection;
import DAO.UserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import view.Dangki;
import view.Quanlybaohiem;
import view.menu;

/**
 *
 * @author MT
 */
public class Quanlybaohiem1 extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public Quanlybaohiem1() {
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

        tendn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txttendn = new javax.swing.JTextField();
        txtmatkhau = new javax.swing.JPasswordField();
        btndangnhap = new javax.swing.JButton();
        lblDangKy = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tendn.setText("Tên đăng nhập:");
        getContentPane().add(tendn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        jLabel2.setText("Mật khẩu:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 82, -1));
        getContentPane().add(txttendn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 143, -1));
        getContentPane().add(txtmatkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 143, -1));

        btndangnhap.setText("Đăng Nhập");
        getContentPane().add(btndangnhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        lblDangKy.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        lblDangKy.setForeground(new java.awt.Color(51, 0, 255));
        lblDangKy.setText("chưa có tài khoản hãy đăng kí");
        lblDangKy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangKyMouseClicked(evt);
            }
        });
        getContentPane().add(lblDangKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 180, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Đăng Nhập");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 80, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bảo hiểm - TenMienNgon_com.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblDangKyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangKyMouseClicked
        // TODO add your handling code here:
         Dangki dangkiForm = new Dangki(); // Tạo đối tượng form đăng ký
    dangkiForm.setVisible(true);      // Hiển thị form đăng ký
    this.dispose();       
    }//GEN-LAST:event_lblDangKyMouseClicked

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
            java.util.logging.Logger.getLogger(Quanlybaohiem1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quanlybaohiem1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quanlybaohiem1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quanlybaohiem1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quanlybaohiem1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndangnhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblDangKy;
    private javax.swing.JLabel tendn;
    private javax.swing.JPasswordField txtmatkhau;
    private javax.swing.JTextField txttendn;
    // End of variables declaration//GEN-END:variables
}
