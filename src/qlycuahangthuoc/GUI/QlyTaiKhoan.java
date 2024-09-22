
package qlycuahangthuoc.GUI;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import qlycuahangthuoc.BUS.QlyTaiKhoan_Bus;
import qlycuahangthuoc.DTO.TaiKhoan;

/**
 *
 * @author vanqu
 */
public class QlyTaiKhoan extends javax.swing.JFrame {

    QlyTaiKhoan_Bus taiKhoan_Bus = new QlyTaiKhoan_Bus();
    public QlyTaiKhoan() {
        initComponents();
        setLocationRelativeTo(null);
        taiKhoan_Bus.loadDataTable(tbTaiKhoan);
        taiKhoan_Bus.loadcboxMaNV(cboxMaNV);
        
        // Thêm ListSelectionListener vào JTable để lang nghe su kien khi dong duoc chon
        tbTaiKhoan.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Kiểm tra xem có hàng nào được chọn không
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tbTaiKhoan.getSelectedRow();
                    if (selectedRow != -1) { // Nếu có hàng được chọn
                        // Lấy thông tin từ hàng được chọn và hiển thị lên các ô JTextField tương ứng
                        String username = tbTaiKhoan.getValueAt(selectedRow, 0).toString();
                        String pass = tbTaiKhoan.getValueAt(selectedRow, 1).toString();
                        String idNV = tbTaiKhoan.getValueAt(selectedRow, 2).toString();
                        String idTK = tbTaiKhoan.getValueAt(selectedRow, 3).toString();
                        int loaitk = Integer.parseInt(tbTaiKhoan.getValueAt(selectedRow, 4).toString());

                        txtUsername.setText(username);
                        txtPass.setText(pass);
                        txtidTK.setText(idTK);
                        cboxMaNV.setSelectedItem(idNV);
                        if (loaitk == 1) {
                            rdLoaiTK1.setSelected(true);
                        } else {
                            rdLoaiTK2.setSelected(true);
                        }
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTaiKhoan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnXem = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        CboxTim = new javax.swing.JComboBox<>();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cboxMaNV = new javax.swing.JComboBox<>();
        txtidTK = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        rdLoaiTK1 = new javax.swing.JRadioButton();
        rdLoaiTK2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "UserName", "Pass", "id NV", "id TaiKhoan", "Loại TK"
            }
        ));
        jScrollPane1.setViewportView(tbTaiKhoan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(822, 280));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 20));

        btnXem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/showall.png"))); // NOI18N
        btnXem.setText("Xem");
        btnXem.setPreferredSize(new java.awt.Dimension(88, 31));
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });
        jPanel5.add(btnXem);

        jPanel3.add(jPanel5);

        jPanel6.setPreferredSize(new java.awt.Dimension(320, 70));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 20));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel6.add(btnThem);

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel6.add(btnSua);

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel6.add(btnXoa);

        jPanel3.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 15, 20));

        CboxTim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "idTaiKhoan", "Username", "idNhanVien" }));
        CboxTim.setPreferredSize(new java.awt.Dimension(96, 31));
        jPanel7.add(CboxTim);

        txtTim.setPreferredSize(new java.awt.Dimension(120, 31));
        txtTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimActionPerformed(evt);
            }
        });
        jPanel7.add(txtTim);

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/Search.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });
        jPanel7.add(btnTim);

        jPanel3.add(jPanel7);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý tài khoản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(822, 200));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jPanel8.setPreferredSize(new java.awt.Dimension(280, 280));

        jLabel2.setText("Username");

        jLabel3.setText("Pass");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(txtPass))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel8);

        jPanel9.setPreferredSize(new java.awt.Dimension(280, 280));

        jLabel5.setText("id NV");

        jLabel1.setText("id TaiKhoan");

        cboxMaNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboxMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidTK, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboxMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidTK, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel9);

        jLabel4.setText("Loại TK");

        buttonGroup1.add(rdLoaiTK1);
        rdLoaiTK1.setText("1 (Admin)");

        buttonGroup1.add(rdLoaiTK2);
        rdLoaiTK2.setText("2 (NV)");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addGap(164, 164, 164))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(rdLoaiTK1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdLoaiTK2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdLoaiTK1)
                    .addComponent(rdLoaiTK2))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel10);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbTaiKhoan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một tài khoản để xóa!");
            return;
        }

        String idTK = tbTaiKhoan.getValueAt(selectedRow, 3).toString();
        int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa tài khoản này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            boolean deletedSuccessfully = taiKhoan_Bus.deleteTaiKhoan(idTK);
            if (deletedSuccessfully) {
                JOptionPane.showMessageDialog(this, "Xóa tài khoản thành công!");
                taiKhoan_Bus.loadDataTable(tbTaiKhoan);
            } else {
                JOptionPane.showMessageDialog(this, "Xóa tài khoản thất bại!");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String username = txtUsername.getText();
        String pass = txtPass.getText();
        String idNV = cboxMaNV.getSelectedItem().toString();
        String idTK = txtidTK.getText();
        int loaitk = rdLoaiTK1.isSelected() ? 1 : 2;

        // Kiểm tra xem các trường dữ liệu có trống không
        if (username.isEmpty() || pass.isEmpty() || idNV.isEmpty() || idTK.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
            return; // Không thêm tài khoản nếu có trường dữ liệu trống
        }

        // Kiểm tra sự tồn tại của username, idTK và idNV trước khi thêm
        if (taiKhoan_Bus.isUsernameExists(username)) {
            JOptionPane.showMessageDialog(this, "Username đã tồn tại!");
            return; // Không thêm tài khoản nếu username đã tồn tại
        }

        if (taiKhoan_Bus.isIdTKExists(idTK)) {
            JOptionPane.showMessageDialog(this, "id TaiKhoan đã tồn tại!");
            return; // Không thêm tài khoản nếu idTK đã tồn tại
        }

        if (taiKhoan_Bus.isIdNVExists(idNV)) {
            JOptionPane.showMessageDialog(this, "id NV đã tồn tại!");
            return; // Không thêm tài khoản nếu idNV đã tồn tại
        }

        TaiKhoan taiKhoan = new TaiKhoan(username, pass, idNV, idTK, loaitk);

        boolean addedSuccessfully = taiKhoan_Bus.addTaiKhoan(taiKhoan);

        if (addedSuccessfully) {
            JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công!");
            taiKhoan_Bus.loadDataTable(tbTaiKhoan);
        } else {
            JOptionPane.showMessageDialog(this, "Thêm tài khoản thất bại!");
        }
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        // Lấy dòng được chọn trong bảng
        int selectedRow = tbTaiKhoan.getSelectedRow();
        // Kiểm tra xem có dòng nào được chọn không
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một tài khoản để sửa!");
            return;
        }

        // Lấy thông tin của tài khoản được chọn
        String username = txtUsername.getText();
        String pass = txtPass.getText();
        String idNV = cboxMaNV.getSelectedItem().toString();
        String idTK = txtidTK.getText();
        int loaitk = rdLoaiTK1.isSelected() ? 1 : 2;

        // Kiểm tra xem các trường dữ liệu có trống không
        if (username.isEmpty() || pass.isEmpty() || idNV.isEmpty() || idTK.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
            return; // Không thêm tài khoản nếu có trường dữ liệu trống
        }

        // Tạo một đối tượng Tài Khoản mới với thông tin đã chỉnh sửa
        TaiKhoan taiKhoan = new TaiKhoan(username, pass, idNV, idTK, loaitk);

        // Thực hiện cập nhật thông tin của tài khoản
        boolean updatedSuccessfully = taiKhoan_Bus.updateTaiKhoan(taiKhoan);

        // Hiển thị thông báo tùy thuộc vào kết quả của việc cập nhật
        if (updatedSuccessfully) {
            JOptionPane.showMessageDialog(this, "Cập nhật tài khoản thành công!");
            taiKhoan_Bus.loadDataTable(tbTaiKhoan); // Tải lại dữ liệu lên bảng
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật tài khoản thất bại!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        // TODO add your handling code here:
        taiKhoan_Bus.loadDataTable(tbTaiKhoan);
    }//GEN-LAST:event_btnXemActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        // Lấy từ khóa tìm kiếm và tùy chọn tìm kiếm từ các trường tương ứng
        String searchText = txtTim.getText();
        String searchOption = CboxTim.getSelectedItem().toString();

        // Kiểm tra xem từ khóa tìm kiếm có rỗng không
        if (searchText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa tìm kiếm!");
            return;
        }

        // Thực hiện tìm kiếm và cập nhật dữ liệu lên bảng
        boolean result = taiKhoan_Bus.searchTaiKhoanByOption(tbTaiKhoan, searchText, searchOption);
        if (!result) {
            JOptionPane.showMessageDialog(this, "Lựa chọn tìm kiếm không hợp lệ!");
        }
    }//GEN-LAST:event_btnTimActionPerformed

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
            java.util.logging.Logger.getLogger(QlyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QlyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QlyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QlyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QlyTaiKhoan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CboxTim;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboxMaNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdLoaiTK1;
    private javax.swing.JRadioButton rdLoaiTK2;
    private javax.swing.JTable tbTaiKhoan;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtidTK;
    // End of variables declaration//GEN-END:variables
}
