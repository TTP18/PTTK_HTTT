package qlycuahangthuoc.GUI;




import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import qlycuahangthuoc.BUS.QlyKhachHang_Bus;
import qlycuahangthuoc.DTO.KhachHang;

public class QlyKhachHang extends javax.swing.JFrame {

    QlyKhachHang_Bus qlyKhachHang_Bus = new QlyKhachHang_Bus();
    public QlyKhachHang() {
        initComponents();this.setLocationRelativeTo(null);
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
        List<KhachHang> listKhachHang = qlyKhachHang_Bus.getListKhachHangFromData();
        DefaultTableModel model = (DefaultTableModel) Tableresult.getModel();
        model.setRowCount(0);
        
        for(KhachHang KH : listKhachHang){
            Object [] row = {KH.getMakh(),KH.getTenkh(),KH.getNgaysinh(),KH.getDiaChi(),KH.getSdt()};
            model.addRow(row);
        }
    }
     
      public void loadDataToTextBoxes() {
        int selectedRow = Tableresult.getSelectedRow();
        if (selectedRow != -1) { // Kiểm tra xem có hàng nào được chọn không
            // Lấy dữ liệu từ bảng
            Object maKH = Tableresult.getValueAt(selectedRow, 0);
            Object tenKH = Tableresult.getValueAt(selectedRow, 1);
            Object ngaysinh = Tableresult.getValueAt(selectedRow, 2);
            Object diachi = Tableresult.getValueAt(selectedRow, 3);
            Object sdt = Tableresult.getValueAt(selectedRow, 4);

            // Đặt dữ liệu lên các ô văn bản
            txtMakh.setText(maKH != null ? maKH.toString() : "");
            txtTenkh.setText(tenKH != null ? tenKH.toString() : "");
            if (ngaysinh instanceof Date) {
                cboxNgaySinh.setDate((Date) ngaysinh);
            } else {
                cboxNgaySinh.setDate(null); // Tránh gây ra lỗi khi không phải là ngày
            }
            txtDiaChi.setText(diachi != null ? diachi.toString() : "");
            txtSdt.setText(sdt != null ? sdt.toString() : "");
        } 
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMakh = new javax.swing.JTextField();
        txtTenkh = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnrefesh = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        txtTim1 = new javax.swing.JTextField();
        cbxTim1 = new javax.swing.JComboBox<>();
        cboxNgaySinh = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tableresult = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lý Khách Hàng");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Mã Khách Hàng :");

        jLabel4.setText("Tên Khách Hàng :");

        jLabel6.setText("Ngày Sinh :");

        jLabel7.setText("Địa Chỉ :");

        jLabel8.setText("Số Điện Thoại :");

        txtMakh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMakhFocusLost(evt);
            }
        });

        txtTenkh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenkhFocusLost(evt);
            }
        });

        txtDiaChi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiaChiFocusLost(evt);
            }
        });

        txtSdt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSdtFocusLost(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnrefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/Refresh.png"))); // NOI18N
        btnrefesh.setText("Refesh");
        btnrefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefeshActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/Search.png"))); // NOI18N
        btnTim.setText("Tìm Kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        txtTim1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTim1CaretUpdate(evt);
            }
        });

        cbxTim1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã KH", "Tên KH" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(20, 20, 20)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(btnXoa))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTim1)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnrefesh))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cbxTim1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnrefesh))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTim)
                    .addComponent(txtTim1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTim1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTenkh, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                        .addComponent(txtMakh)
                        .addComponent(txtDiaChi)
                        .addComponent(txtSdt))
                    .addComponent(cboxNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cboxNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tableresult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Ngày Sinh", "Địa Chỉ", "Số Điện Thoại"
            }
        ));
        jScrollPane1.setViewportView(Tableresult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(431, 431, 431))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        String loaiTimKiem = (String) cbxTim1.getSelectedItem();
        String duLieu = txtTim1.getText().trim(); // Loại bỏ khoảng trắng ở đầu và cuối dữ liệu

        // Kiểm tra dữ liệu tìm kiếm trống
        if (duLieu.isEmpty()) {
            // Hiển thị lại toàn bộ danh sách khách hàng
            loadDatatoTable(Tableresult);
            return;
        }

        // Thực hiện tìm kiếm
        List<KhachHang> resultList = qlyKhachHang_Bus.searchKhachHang(loaiTimKiem, duLieu);

        // Cập nhật bảng với kết quả tìm kiếm
        DefaultTableModel model = (DefaultTableModel) Tableresult.getModel();
        model.setRowCount(0); // Xóa dữ liệu hiện tại trong bảng

        for (KhachHang kh : resultList) {
            Object[] row = {kh.getMakh(), kh.getTenkh(), kh.getNgaysinh(), kh.getDiaChi(), kh.getSdt()};
            model.addRow(row);
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String maKH = txtMakh.getText();
        String tenKH = txtTenkh.getText();
        Date ngaysinh = cboxNgaySinh.getDate();
        String diachi = txtDiaChi.getText();
        String sdt = txtSdt.getText();

        // Kiểm tra tính hợp lệ của dữ liệu
        // Kiểm tra rỗng
        if ( maKH.isEmpty() || tenKH.isEmpty() || diachi.isEmpty() || sdt.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
            return; // Dừng việc thực hiện chức năng nếu có trường dữ liệu trống
        }
        
        // Kiểm tra trùng mã hóa đơn
        if (qlyKhachHang_Bus.isMaKHExists(maKH)) {
            JOptionPane.showMessageDialog(null, "Mã hóa đơn đã tồn tại!");
            return; // Dừng việc thực hiện chức năng nếu mã hóa đơn đã tồn tại
        }

        KhachHang kh = new KhachHang(maKH, tenKH, diachi, sdt, ngaysinh);
        // Gọi phương thức thêm hóa đơn từ lớp QlyHoaDon_Bus
        boolean result = qlyKhachHang_Bus.addKhachHang(kh);

        // Kiểm tra kết quả và cập nhật giao diện nếu cần
        if (result) {
            // Nếu thêm thành công, cập nhật bảng
            loadDatatoTable(Tableresult);
            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(null, "Thêm KH thành công!");
        } else {
            // Nếu thêm không thành công, hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(null, "Thêm KH không thành công!");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String maKH = txtMakh.getText();
        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa KH này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // Gọi phương thức xóa hóa đơn từ lớp QlyHoaDon_Bus
            boolean result = qlyKhachHang_Bus.deleteKhachHang(maKH);

            // Kiểm tra kết quả và cập nhật giao diện nếu cần
            if (result) {
                // Nếu xóa thành công, cập nhật bảng
                loadDatatoTable(Tableresult);
                // Hiển thị thông báo thành công
                JOptionPane.showMessageDialog(null, "Xóa KH thành công!");
            } else {
                // Nếu xóa không thành công, hiển thị thông báo lỗi
                JOptionPane.showMessageDialog(null, "Xóa KH không thành công!");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        String maKH = txtMakh.getText();
        String tenKH = txtTenkh.getText();
        Date ngaysinh = cboxNgaySinh.getDate();
        String diachi = txtDiaChi.getText();
        String sdt = txtSdt.getText();
        if ( maKH.isEmpty() || tenKH.isEmpty() || diachi.isEmpty() || sdt.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
            return; // Dừng việc thực hiện chức năng nếu có trường dữ liệu trống
        }
        
         KhachHang kh = new KhachHang(maKH, tenKH, diachi, sdt, ngaysinh);
        // Gọi phương thức thêm hóa đơn từ lớp QlyHoaDon_Bus
        boolean result = qlyKhachHang_Bus.updateKhachHang(kh);

        // Kiểm tra kết quả và cập nhật giao diện nếu cần
        if (result) {
            // Nếu thêm thành công, cập nhật bảng
            loadDatatoTable(Tableresult);
            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(null, "Sửa KH thành công!");
        } else {
            // Nếu thêm không thành công, hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(null, "Sửa KH không thành công!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnrefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefeshActionPerformed
        txtMakh.setText("");
        txtTenkh.setText("");
        cboxNgaySinh.setDate(null);
        txtDiaChi.setText("");
        txtSdt.setText("");                    
        loadDatatoTable(Tableresult);
    }//GEN-LAST:event_btnrefeshActionPerformed

    private void txtMakhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMakhFocusLost
        String id = txtMakh.getText();
        String reg = "^(KH)\\d{3}$";
        if(id.length()>0){
            if(!id.matches(reg)){
                JOptionPane.showMessageDialog(this, "Sai định dạng , Nhập lại mã khách hàng");    
                txtMakh.requestFocus();
                }
            }
    }//GEN-LAST:event_txtMakhFocusLost

    private void txtSdtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSdtFocusLost
        String Pnumber = txtSdt.getText();
        String reg = "^09\\d{8}$";
        if(Pnumber.length()>0){
            if(!Pnumber.matches(reg)){
                JOptionPane.showMessageDialog(this, "Sai định dạng , Nhập lại số điện thoại");
                txtSdt.requestFocus();
            }
        }
    }//GEN-LAST:event_txtSdtFocusLost

    private void txtTenkhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenkhFocusLost
          String reg = "^[\\p{L}][\\p{L}\\s]*[\\p{L}]$";
          String name = txtTenkh.getText();
          if (name.length() > 0) {
            if (!name.matches(reg)) {
                JOptionPane.showMessageDialog(this, "Sai định dạng, Nhập lại tên khách hàng ");
                // Đưa con trỏ tới ô nhập liệu ngày tháng năm
                txtTenkh.requestFocus();
            }
        }
    }//GEN-LAST:event_txtTenkhFocusLost

    private void txtDiaChiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiFocusLost
        String reg = "^[\\p{L} ]+$";
        String name = txtDiaChi.getText();
          if (name.length() > 0) {
            if (!name.matches(reg)) {
                JOptionPane.showMessageDialog(this, "Sai định dạng, Nhập lại địa chỉ khách hàng ");
                // Đưa con trỏ tới ô nhập liệu ngày tháng năm
                txtDiaChi.requestFocus();
            }
        }
    }//GEN-LAST:event_txtDiaChiFocusLost

    private void txtTim1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTim1CaretUpdate
        if (txtTim1.getText().isEmpty()) {
           
            loadDatatoTable(Tableresult);
        }
    }//GEN-LAST:event_txtTim1CaretUpdate

    
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
            java.util.logging.Logger.getLogger(QlyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QlyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QlyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QlyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QlyKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tableresult;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnrefesh;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser cboxNgaySinh;
    private javax.swing.JComboBox<String> cbxTim1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMakh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenkh;
    private javax.swing.JTextField txtTim1;
    // End of variables declaration//GEN-END:variables

   
}
