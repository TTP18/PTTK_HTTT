package qlycuahangthuoc.GUI;

import GUI.QLNhapHang;
import java.awt.CardLayout;
import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ColorModel;


public class mainform extends javax.swing.JFrame {
    
    public mainform() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnDoanhthu = new javax.swing.JButton();
        btnKhoThuoc = new javax.swing.JButton();
        btnNhanvien = new javax.swing.JButton();
        btnTaikhoan = new javax.swing.JButton();
        btnKhachhang = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        btnPhieuNhap = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/BgroundCHThuoc.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1247, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(799, 120));

        btnDoanhthu.setBackground(new java.awt.Color(0, 102, 204));
        btnDoanhthu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDoanhthu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/Bar chart.png"))); // NOI18N
        btnDoanhthu.setText("Doanh Thu");
        buttonGroup1.add(btnDoanhthu);
        btnDoanhthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoanhthuActionPerformed(evt);
            }
        });

        btnKhoThuoc.setBackground(new java.awt.Color(0, 102, 204));
        btnKhoThuoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKhoThuoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/Documents.png"))); // NOI18N
        btnKhoThuoc.setText("Kho Thuốc");
        buttonGroup1.add(btnKhoThuoc);
        btnKhoThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoThuocActionPerformed(evt);
            }
        });

        btnNhanvien.setBackground(new java.awt.Color(0, 102, 204));
        btnNhanvien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhanvien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/User.png"))); // NOI18N
        btnNhanvien.setText("Nhân Viên");
        buttonGroup1.add(btnNhanvien);
        btnNhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanvienActionPerformed(evt);
            }
        });

        btnTaikhoan.setBackground(new java.awt.Color(0, 102, 204));
        btnTaikhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTaikhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/Open door.png"))); // NOI18N
        btnTaikhoan.setText("Tài Khoản");
        buttonGroup1.add(btnTaikhoan);
        btnTaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaikhoanActionPerformed(evt);
            }
        });

        btnKhachhang.setBackground(new java.awt.Color(0, 102, 204));
        btnKhachhang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/Users.png"))); // NOI18N
        btnKhachhang.setText("Khách Hàng");
        buttonGroup1.add(btnKhachhang);
        btnKhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachhangActionPerformed(evt);
            }
        });

        btnHoaDon.setBackground(new java.awt.Color(0, 102, 204));
        btnHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/List.png"))); // NOI18N
        btnHoaDon.setText("Hóa Đơn");
        buttonGroup1.add(btnHoaDon);
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });

        btnPhieuNhap.setBackground(new java.awt.Color(0, 102, 204));
        btnPhieuNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/Add to basket.png"))); // NOI18N
        btnPhieuNhap.setText("Nhập Hàng");
        buttonGroup1.add(btnPhieuNhap);
        btnPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhieuNhapActionPerformed(evt);
            }
        });

        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/dangxuat_icon.png"))); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        buttonGroup1.add(btnDangXuat);
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnDoanhthu)
                .addGap(15, 15, 15)
                .addComponent(btnKhachhang)
                .addGap(15, 15, 15)
                .addComponent(btnKhoThuoc)
                .addGap(15, 15, 15)
                .addComponent(btnNhanvien)
                .addGap(15, 15, 15)
                .addComponent(btnTaikhoan)
                .addGap(15, 15, 15)
                .addComponent(btnHoaDon)
                .addGap(15, 15, 15)
                .addComponent(btnPhieuNhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btnDangXuat)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhoThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    private void btnKhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachhangActionPerformed
        // TODO add your handling code here:
        QlyKhachHang qlkh = new QlyKhachHang();
        qlkh.setVisible(true);
    }//GEN-LAST:event_btnKhachhangActionPerformed

    private void btnNhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanvienActionPerformed
        // TODO add your handling code here:
        QlyNhanVien qlnv = new QlyNhanVien();
        qlnv.setVisible(true);
    }//GEN-LAST:event_btnNhanvienActionPerformed
   
            
    private void btnKhoThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoThuocActionPerformed
        // TODO add your handling code here:
        QlyKhoThuoc qlkt = new QlyKhoThuoc();
        qlkt.setVisible(true);
    }//GEN-LAST:event_btnKhoThuocActionPerformed

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        // TODO add your handling code here:
        QlyHoaDon qlyHoaDon = new QlyHoaDon();
        qlyHoaDon.setVisible(true);
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnTaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaikhoanActionPerformed
        // TODO add your handling code here:
        QlyTaiKhoan qltk = new QlyTaiKhoan();
        qltk.setVisible(true);
    }//GEN-LAST:event_btnTaikhoanActionPerformed

    private void btnDoanhthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanhthuActionPerformed
        // TODO add your handling code here:
        QlyThuChi qltc = new QlyThuChi();
        qltc.setVisible(true);
    }//GEN-LAST:event_btnDoanhthuActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        Login lg = new Login();
        lg.setVisible(true);
        lg.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhieuNhapActionPerformed
        // TODO add your handling code here:
        QLNhapHang qlnh = new QLNhapHang();
        qlnh.setVisible(true);
        
    }//GEN-LAST:event_btnPhieuNhapActionPerformed

        
    
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
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDoanhthu;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnKhachhang;
    private javax.swing.JButton btnKhoThuoc;
    private javax.swing.JButton btnNhanvien;
    private javax.swing.JButton btnPhieuNhap;
    private javax.swing.JButton btnTaikhoan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
