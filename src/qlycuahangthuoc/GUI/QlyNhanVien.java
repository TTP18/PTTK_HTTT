package qlycuahangthuoc.GUI;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import qlycuahangthuoc.BUS.QlyNhanVien_Bus;
import qlycuahangthuoc.DTO.NhanVien;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Mai
 */
public class QlyNhanVien extends javax.swing.JFrame {

    QlyNhanVien_Bus nvBus = new QlyNhanVien_Bus();
    public QlyNhanVien() {
        initComponents();
        this.setLocationRelativeTo(null);
        setLocationRelativeTo(null);
        loadDatatoTable(Tableresult);
        Tableresult.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting()) {
                // Gọi phương thức loadDataToTextBoxes() khi có sự thay đổi lựa chọn trong bảng
                loadDataToTextBoxes();
            }
        }
    });

    }
    
    
    public void loadDatatoTable(JTable table){
        List<NhanVien> listNhanVien = nvBus.getListNhanVienFromData();
        DefaultTableModel model = (DefaultTableModel) Tableresult.getModel();
        model.setRowCount(0);
        
        for(NhanVien nv : listNhanVien){
            Object [] row = {nv.getMaNV(),nv.getHoten(),nv.getNgaySinh(),nv.getDiaChi(),nv.getSdt(), nv.getCmnd()};
            model.addRow(row);
        }
    }

    
    public void loadDataToTextBoxes() {
        int selectedRow = Tableresult.getSelectedRow();
        if (selectedRow != -1) { // Kiểm tra xem có hàng nào được chọn không
            // Lấy dữ liệu từ bảng
            Object maNV = Tableresult.getValueAt(selectedRow, 0);
            Object tenNV = Tableresult.getValueAt(selectedRow, 1);
            Object ngaysinh = Tableresult.getValueAt(selectedRow, 2);
            Object diachi = Tableresult.getValueAt(selectedRow, 3);
            Object sdt = Tableresult.getValueAt(selectedRow, 4);
            Object cmnd = Tableresult.getValueAt(selectedRow, 5);

            // Đặt dữ liệu lên các ô văn bản và JDateChooser
            txtMaNV.setText(maNV != null ? maNV.toString() : "");
            txtTenNV.setText(tenNV != null ? tenNV.toString() : "");
            txtDiaChi.setText(diachi != null ? diachi.toString() : "");
            txtCMND.setText(cmnd != null ? cmnd.toString() : "");
            txtSDT.setText(sdt != null ? sdt.toString() : "");

            // Xử lý dữ liệu ngày sinh
            if (ngaysinh instanceof Date) {
                cboxNgaySinh.setDate((Date) ngaysinh);
            } else {
                cboxNgaySinh.setDate(null); // Đặt giá trị null nếu dữ liệu không hợp lệ
            }
        }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tableresult = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        cboxNgaySinh = new com.toedter.calendar.JDateChooser();
        CboxTim = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý nhân viên");

        jLabel2.setText("Mã NV");

        jLabel3.setText("Ngày sinh");

        jLabel4.setText("Số ĐT");

        jLabel5.setText("Họ tên NV");

        jLabel6.setText("Địa chỉ");

        jLabel7.setText("CMND");

        Tableresult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Họ Tên NV", "Ngày sinh", "Địa chỉ", "Số ĐT", "CMND"
            }
        ));
        jScrollPane1.setViewportView(Tableresult);

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        jLabel8.setText("Danh sách nhân viên");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtTim.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimCaretUpdate(evt);
            }
        });

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        CboxTim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã NV", "Tên NV" }));

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 693, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboxNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(btnThem)
                        .addGap(78, 78, 78)
                        .addComponent(btnSua)
                        .addGap(78, 78, 78)
                        .addComponent(btnXoa)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnRefresh)))
                .addContainerGap(301, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CboxTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboxNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnRefresh))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CboxTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTim))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String maNV = txtMaNV.getText();
        String tenNV = txtTenNV.getText();
        Date ngaysinh = cboxNgaySinh.getDate();
        String diachi = txtSDT.getText();
        String sdt = txtDiaChi.getText();
        String cmnd = txtCMND.getText();

        // Kiểm tra tính hợp lệ của dữ liệu
        // Kiểm tra rỗng
        if ( maNV.isEmpty() || tenNV.isEmpty() || diachi.isEmpty() || sdt.isEmpty() || cmnd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
            return; // Dừng việc thực hiện chức năng nếu có trường dữ liệu trống
        }
        
        // Kiểm tra trùng mã 
        if (nvBus.isMaNVExists(maNV)) {
            JOptionPane.showMessageDialog(null, "Mã NV đã tồn tại!");
            return; // Dừng việc thực hiện chức năng nếu mã hóa đơn đã tồn tại
        }
        
        
        String regmanv = "^(NV)\\d{3}$";
        if(maNV.length()>0){
            if(!maNV.matches(regmanv)){
                JOptionPane.showMessageDialog(this, "Sai định dạng , Nhập lại mã nhân viên");    
                txtMaNV.requestFocus();
                return;
            }
        }

        //Kiem tra sdt
        String Pnumber = txtSDT.getText();
        String reg = "^09\\d{8}$";
        if(Pnumber.length()>0){
            if(!Pnumber.matches(reg)){
                JOptionPane.showMessageDialog(this, "Sai định dạng , Nhập lại số điện thoại");
                txtSDT.requestFocus();
                return;
            }
        }
        
        //Kiem tra CMND
        if(nvBus.isCMNDExist(cmnd)){
            JOptionPane.showMessageDialog(null, "CMND đã tồn tại !");
            return;
        }
        
        String regcmnd = "^[0-9]{9}$"; // Biểu thức chính quy để so khớp với 9 chữ số
        if (cmnd.length() > 0) {
            if (!cmnd.matches(regcmnd)) {
                JOptionPane.showMessageDialog(this, "Sai định dạng, vui lòng nhập lại số CMND gồm 9 chữ số.");
                txtCMND.setText(""); // Xóa nội dung CMND không hợp lệ
                txtCMND.requestFocus(); // Trỏ lại ô nhập liệu CMND
                return;
            }
        }

        NhanVien nv = new NhanVien(maNV, tenNV, diachi, sdt, cmnd, ngaysinh);
        // Gọi phương thức thêm hóa đơn từ lớp QlyHoaDon_Bus
        boolean result = nvBus.addNhanVien(nv);

        // Kiểm tra kết quả và cập nhật giao diện nếu cần
        if (result) {
            // Nếu thêm thành công, cập nhật bảng
            loadDatatoTable(Tableresult);
            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(null, "Thêm nhan vien thành công!");
        } else {
            // Nếu thêm không thành công, hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(null, "Thêm nhan vien không thành công!");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        String maNV = txtMaNV.getText();
        String tenNV = txtTenNV.getText();
        Date ngaysinh = cboxNgaySinh.getDate();
        String diachi = txtDiaChi.getText();
        String sdt = txtSDT.getText();
        String cmnd = txtCMND.getText();
        if ( maNV.isEmpty() || tenNV.isEmpty() || diachi.isEmpty() || sdt.isEmpty() || cmnd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
            return; // Dừng việc thực hiện chức năng nếu có trường dữ liệu trống
        }
        NhanVien nv = new NhanVien(maNV, tenNV, diachi, sdt, cmnd, ngaysinh);
        // Gọi phương thức thêm hóa đơn từ lớp QlyHoaDon_Bus
        boolean result = nvBus.updateNhanVien(nv);

        // Kiểm tra kết quả và cập nhật giao diện nếu cần
        if (result) {
            // Nếu thêm thành công, cập nhật bảng
            loadDatatoTable(Tableresult);
            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(null, "Sửa nhan vien thành công!");
        } else {
            // Nếu thêm không thành công, hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(null, "Sửa nhan vien không thành công!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String maNV = txtMaNV.getText();
        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa NV này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // Gọi phương thức xóa hóa đơn từ lớp QlyHoaDon_Bus
            boolean result = nvBus.deleteNhanVien(maNV);

            // Kiểm tra kết quả và cập nhật giao diện nếu cần
            if (result) {
                // Nếu xóa thành công, cập nhật bảng
                loadDatatoTable(Tableresult);
                // Hiển thị thông báo thành công
                JOptionPane.showMessageDialog(null, "Xóa NV thành công!");
            } else {
                // Nếu xóa không thành công, hiển thị thông báo lỗi
                JOptionPane.showMessageDialog(null, "Xóa NV không thành công!");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String loaiTimKiem = (String) CboxTim.getSelectedItem();
        String duLieu = txtTim.getText().trim(); // Loại bỏ khoảng trắng ở đầu và cuối dữ liệu

        // Kiểm tra dữ liệu tìm kiếm trống
        if (duLieu.isEmpty()) {
            // Hiển thị lại toàn bộ danh sách khách hàng
            loadDatatoTable(Tableresult);
            return;
        }

        // Thực hiện tìm kiếm
        List<NhanVien> resultList = nvBus.searchNhanVien(loaiTimKiem, duLieu);

        // Cập nhật bảng với kết quả tìm kiếm
        DefaultTableModel model = (DefaultTableModel) Tableresult.getModel();
        model.setRowCount(0); // Xóa dữ liệu hiện tại trong bảng

        for (NhanVien nv : resultList) {
            Object[] row = {nv.getMaNV(), nv.getHoten(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSdt(), nv.getCmnd()};
            model.addRow(row);
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        txtMaNV.setText("");
        txtTenNV.setText("");
        cboxNgaySinh.setDate(null);
        txtSDT.setText("");
        txtDiaChi.setText("");    
        txtCMND.setText("");
        loadDatatoTable(Tableresult);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtTimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimCaretUpdate
        // TODO add your handling code here:
        if (txtTim.getText().isEmpty()) {
           
            loadDatatoTable(Tableresult);
        }
    }//GEN-LAST:event_txtTimCaretUpdate


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
            java.util.logging.Logger.getLogger(QlyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QlyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QlyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QlyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QlyNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CboxTim;
    private javax.swing.JTable Tableresult;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private com.toedter.calendar.JDateChooser cboxNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
