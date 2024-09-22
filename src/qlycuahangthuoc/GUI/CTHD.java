/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlycuahangthuoc.GUI;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import qlycuahangthuoc.BUS.CTHD_Bus;
import qlycuahangthuoc.DTO.CTHD_DTO;

/**
 *
 * @author vanqu
 */
public class CTHD extends javax.swing.JFrame {

    CTHD_Bus cthdb = new CTHD_Bus();
    
    public CTHD(String maHD) {
        initComponents();
        cthdb.loadCboxMaThuoc(cboxMaThuoc);
        cthdb.loadcboxMaHD(cboxMaHD);
        cboxMaHD.setSelectedItem(maHD);

        // Nếu mã hóa đơn không null
        if (maHD != null) {
            // Lấy dữ liệu mới từ cơ sở dữ liệu theo mã hóa đơn và cập nhật bảng
            List<CTHD_DTO> listCTHD = cthdb.getListCTHDByMaHD(maHD);
            DefaultTableModel model = (DefaultTableModel) tbCTHD.getModel();
            for (CTHD_DTO cthd : listCTHD) {
                Object[] row = {cthd.getMahd(), cthd.getMathuoc(), cthd.getSoluong(), cthd.getThanhtien()};
                model.addRow(row);
            }
        }
        
        tbCTHD.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = tbCTHD.getSelectedRow();
                if (selectedRow != -1) {
                    // Lấy dữ liệu từ dòng được chọn
                    String maHD = (String) tbCTHD.getValueAt(selectedRow, 0);
                    String maThuoc = (String) tbCTHD.getValueAt(selectedRow, 1);
                    int soLuong = (int) tbCTHD.getValueAt(selectedRow, 2);
                    BigDecimal thanhTien = (BigDecimal) tbCTHD.getValueAt(selectedRow, 3);

                    // Hiển thị dữ liệu lên các ô text hoặc combo box khác
                    cboxMaHD.setSelectedItem(maHD);
                    cboxMaThuoc.setSelectedItem(maThuoc);
                    txtSoLuong.setText(String.valueOf(soLuong));
                    txtThanhTien.setText(String.valueOf(thanhTien));
                }
            }
        }
    });

        
//        loadDatatoTable(tbCTHD);
        setLocationRelativeTo(null);
    }

    
    public static void startGUI(String maHD) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CTHD(maHD).setVisible(true);
            }
        });
    }
    
    public void loadDatatoTable(JTable table){
        List<CTHD_DTO> listCTHD = cthdb.getListCTHD();
        DefaultTableModel model = (DefaultTableModel) tbCTHD.getModel();
        model.setRowCount(0);
        for(CTHD_DTO cthd : listCTHD){
            Object [] row = {cthd.getMahd(),cthd.getMathuoc(),cthd.getSoluong(),cthd.getThanhtien()};
            model.addRow(row);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCTHD = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnXem = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        cboxTim = new javax.swing.JComboBox<>();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboxMaHD = new javax.swing.JComboBox<>();
        cboxMaThuoc = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã HD", "Mã thuốc", "Số lượng", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(tbCTHD);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(843, 300));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setPreferredSize(new java.awt.Dimension(150, 100));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 25));

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

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 25));

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

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 15, 25));

        cboxTim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã HD", "Mã thuốc" }));
        cboxTim.setPreferredSize(new java.awt.Dimension(100, 31));
        jPanel7.add(cboxTim);

        txtTim.setPreferredSize(new java.awt.Dimension(150, 31));
        txtTim.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimCaretUpdate(evt);
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 102, 255))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(886, 220));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Mã HD");

        jLabel2.setText("Mã Thuốc");

        cboxMaHD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboxMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMaHDActionPerformed(evt);
            }
        });

        cboxMaThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboxMaThuoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxMaThuocItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboxMaThuoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboxMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel8);

        jLabel3.setText("Số lượng");

        jLabel4.setText("Thành tiền");

        txtSoLuong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoLuongFocusLost(evt);
            }
        });

        jButton1.setText("Tính");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtThanhTien)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel9);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel10);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbCTHD.getSelectedRow();
        if (selectedRow != -1) {
            String maHD = (String) tbCTHD.getValueAt(selectedRow, 0);
            String maThuoc = (String) tbCTHD.getValueAt(selectedRow, 1);

            // Gọi phương thức xóa từ lớp CTHD_Bus
            if (cthdb.xoaCTHD(maHD, maThuoc)) {
                // Nếu xóa thành công, xóa dòng tương ứng trong bảng hiển thị
                DefaultTableModel model = (DefaultTableModel) tbCTHD.getModel();
                model.removeRow(selectedRow);
            } else {
                // Hiển thị thông báo lỗi nếu không xóa được
                JOptionPane.showMessageDialog(this, "Xóa không thành công!");
            }
        } else {
            // Hiển thị thông báo nếu không có dòng nào được chọn
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa!");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void cboxMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMaHDActionPerformed
        // TODO add your handling code here:
        // Xóa dữ liệu cũ trong bảng
        DefaultTableModel model = (DefaultTableModel) tbCTHD.getModel();
        model.setRowCount(0);
        
        // Lấy mã hóa đơn được chọn
        String maHD = (String) cboxMaHD.getSelectedItem();
        
        // Nếu mã hóa đơn không null
        if (maHD != null) {
            // Lấy dữ liệu mới từ cơ sở dữ liệu theo mã hóa đơn và cập nhật bảng
            List<CTHD_DTO> listCTHD = cthdb.getListCTHDByMaHD(maHD);
            for (CTHD_DTO cthd : listCTHD) {
                Object[] row = {cthd.getMahd(), cthd.getMathuoc(), cthd.getSoluong(), cthd.getThanhtien()};
                model.addRow(row);
            }
        }
    }//GEN-LAST:event_cboxMaHDActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String maHD = (String) cboxMaHD.getSelectedItem();
        String maThuoc = (String) cboxMaThuoc.getSelectedItem();
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        BigDecimal thanhTien = new BigDecimal(txtThanhTien.getText());

        // Tạo một đối tượng CTHD_DTO với dữ liệu vừa lấy được
        CTHD_DTO cthd = new CTHD_DTO(maHD, maThuoc, soLuong, thanhTien);

        // Gọi phương thức thêm mới từ lớp CTHD_Bus
        if (cthdb.themCTHD(cthd)) {
            // Nếu thêm thành công, cập nhật lại bảng hiển thị
            DefaultTableModel model = (DefaultTableModel) tbCTHD.getModel();
            model.addRow(new Object[]{maHD, maThuoc, soLuong, thanhTien});
        } else {
            // Hiển thị thông báo lỗi nếu không thêm được
            JOptionPane.showMessageDialog(this, "Thêm không thành công!");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        // Lấy dữ liệu từ các ô nhập
        String maHD = (String) cboxMaHD.getSelectedItem();
        String maThuoc = (String) cboxMaThuoc.getSelectedItem();
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        BigDecimal thanhTien = new BigDecimal(txtThanhTien.getText());

        // Tạo một đối tượng CTHD_DTO với dữ liệu vừa lấy được
        CTHD_DTO cthd = new CTHD_DTO(maHD, maThuoc, soLuong, thanhTien);

        // Gọi phương thức cập nhật từ lớp CTHD_Bus
        if (cthdb.suaCTHD(cthd)) {
            // Nếu cập nhật thành công, cập nhật lại dòng tương ứng trong bảng hiển thị
            int selectedRow = tbCTHD.getSelectedRow();
            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) tbCTHD.getModel();
                model.setValueAt(maHD, selectedRow, 0);
                model.setValueAt(maThuoc, selectedRow, 1);
                model.setValueAt(soLuong, selectedRow, 2);
                model.setValueAt(thanhTien, selectedRow, 3);
            }

            // Load lại dữ liệu từ cơ sở dữ liệu vào bảng
            loadDatatoTable(tbCTHD);
        } else {
            // Hiển thị thông báo lỗi nếu không cập nhật được
            JOptionPane.showMessageDialog(this, "Cập nhật không thành công!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        // TODO add your handling code here:
        loadDatatoTable(tbCTHD);
    }//GEN-LAST:event_btnXemActionPerformed

    private void cboxMaThuocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxMaThuocItemStateChanged
        // TODO add your handling code here:
        // Lấy mã thuốc được chọn
        String maThuoc = (String) cboxMaThuoc.getSelectedItem();
        
        // Nếu mã thuốc không rỗng
        if (maThuoc != null) {
            // Thực hiện truy vấn hoặc tìm giá tiền từ CSDL hoặc danh sách dữ liệu
            BigDecimal giaTien = cthdb.layGiaTien(maThuoc);
            
            // Cập nhật giá tiền vào txtThanhTien
            txtThanhTien.setText(String.valueOf(giaTien));
        }
    }//GEN-LAST:event_cboxMaThuocItemStateChanged

    private void txtSoLuongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoLuongFocusLost
        // TODO add your handling code here:
        // Kiểm tra xem số lượng có được nhập không rỗng
        if (!txtSoLuong.getText().isEmpty()) {
            // Lấy số lượng từ txtSoLuong
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            
            // Kiểm tra xem giá tiền có được nhập không rỗng
            if (!txtThanhTien.getText().isEmpty()) {
                // Lấy giá tiền từ txtThanhTien
                BigDecimal giaTien = new BigDecimal(txtThanhTien.getText());
                
                // Tính toán tổng thành tiền và cập nhật vào txtThanhTien
                BigDecimal thanhTien = giaTien.multiply(BigDecimal.valueOf(soLuong));
                txtThanhTien.setText(String.valueOf(thanhTien));
            }
        }
    }//GEN-LAST:event_txtSoLuongFocusLost

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        // Lấy giá trị được chọn từ combobox và dữ liệu được nhập từ textbox
        String timTheo = (String) cboxTim.getSelectedItem();
        String tuKhoa = txtTim.getText();

        // Kiểm tra xem người dùng đã chọn tiêu chí tìm kiếm và nhập từ khoá chưa
        if (timTheo != null && !tuKhoa.isEmpty()) {
            // Tạo một danh sách để lưu kết quả tìm kiếm
            List<CTHD_DTO> resultList = new ArrayList<>();

            // Kiểm tra theo tiêu chí tìm kiếm và thêm vào danh sách kết quả
            if (timTheo.equals("Mã HD")) {
                resultList = cthdb.timKiemCTHDTheoMaHD(tuKhoa);
            } else if (timTheo.equals("Mã thuốc")) {
                resultList = cthdb.timKiemCTHDTheoMaThuoc(tuKhoa);
            }

            // Kiểm tra xem danh sách kết quả có dữ liệu không
            if (!resultList.isEmpty()) {
                // Xóa dữ liệu cũ trong bảng
                DefaultTableModel model = (DefaultTableModel) tbCTHD.getModel();
                model.setRowCount(0);

                // Thêm dữ liệu từ danh sách kết quả vào bảng
                for (CTHD_DTO cthd : resultList) {
                    Object[] row = {cthd.getMahd(), cthd.getMathuoc(), cthd.getSoluong(), cthd.getThanhtien()};
                    model.addRow(row);
                }
            } else {
                // Hiển thị thông báo nếu không tìm thấy kết quả
                JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả phù hợp!");
            }
        } else {
            // Hiển thị thông báo nếu không chọn tiêu chí tìm kiếm hoặc không nhập từ khóa
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tiêu chí tìm kiếm và nhập từ khóa!");
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void txtTimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimCaretUpdate
        // TODO add your handling code here:
        if (txtTim.getText().isEmpty()) {
            loadDatatoTable(tbCTHD);
        }
    }//GEN-LAST:event_txtTimCaretUpdate

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
            java.util.logging.Logger.getLogger(CTHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CTHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CTHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CTHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                startGUI(args[0]);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboxMaHD;
    private javax.swing.JComboBox<String> cboxMaThuoc;
    private javax.swing.JComboBox<String> cboxTim;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JTable tbCTHD;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
