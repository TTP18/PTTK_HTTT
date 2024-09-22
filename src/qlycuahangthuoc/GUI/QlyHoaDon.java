
package qlycuahangthuoc.GUI;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import qlycuahangthuoc.BUS.QlyHoaDon_Bus;
import qlycuahangthuoc.DTO.HoaDon;

/**
 *
 * @author vanqu
 */
public class QlyHoaDon extends javax.swing.JFrame {

    QlyHoaDon_Bus qlyHoaDon_Bus = new QlyHoaDon_Bus();
    
    public QlyHoaDon() {
        initComponents();
        setLocationRelativeTo(null);
        loadDatatoTable(tbHoaDon);
        qlyHoaDon_Bus.loadcboxMaKH(cboxMaKH);
        qlyHoaDon_Bus.loadcboxMaNV(cboxMaNV);
        tbHoaDon.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting()) {
                // Gọi phương thức loadDataToTextBoxes() khi có sự thay đổi lựa chọn trong bảng
                loadDataToTextBoxes();
            }
        }
    });

    }
    
    public void loadDatatoTable(JTable table){
        List<HoaDon> listHoaDon = qlyHoaDon_Bus.getListHoaDonFromData();
        DefaultTableModel model = (DefaultTableModel) tbHoaDon.getModel();
        model.setRowCount(0);
        
        for(HoaDon HD : listHoaDon){
            Object [] row = {HD.getMahd(),HD.getMakh(),HD.getHotenKH(),HD.getManv(),HD.getHotenNV(),HD.getNgaylap()};
            model.addRow(row);
        }
    }
    
    public void loadDataToTextBoxes() {
        // Lấy hàng được chọn từ bảng
        int selectedRow = tbHoaDon.getSelectedRow();
        if (selectedRow != -1) { // Kiểm tra xem có hàng nào được chọn không
            // Lấy dữ liệu từ bảng
            Object maHD = tbHoaDon.getValueAt(selectedRow, 0);
            Object maKH = tbHoaDon.getValueAt(selectedRow, 1);
            Object tenKH = tbHoaDon.getValueAt(selectedRow, 2);
            Object maNV = tbHoaDon.getValueAt(selectedRow, 3);
            Object tenNV = tbHoaDon.getValueAt(selectedRow, 4);
            Date ngayLap = (Date) tbHoaDon.getValueAt(selectedRow, 5);

            // Đặt dữ liệu lên các ô văn bản
            txtMaHD.setText(maHD.toString());
            txtTenKH.setText(tenKH.toString());
            txtTenNV.setText(tenNV.toString());

            // Đặt mã KH và mã NV cho các combobox tương ứng
            cboxMaKH.setSelectedItem(maKH.toString());
            cboxMaNV.setSelectedItem(maNV.toString());

            // Đặt ngày lên JDateChooser
            jDateChooser1.setDate(ngayLap);
        } else {
            // Nếu không có hàng nào được chọn, bạn có thể xử lý tương ứng ở đây
        }
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
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
        txtMaHD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        cboxMaKH = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        cboxMaNV = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Mã KH", "Tên KH", "Mã NV", "Tên NV", "Ngày Lập"
            }
        ));
        jScrollPane1.setViewportView(tbHoaDon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(876, 300));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 20));

        btnXem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlycuahangthuoc/icon/showall.png"))); // NOI18N
        btnXem.setText("Xem chi tiết");
        btnXem.setPreferredSize(new java.awt.Dimension(150, 31));
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });
        jPanel5.add(btnXem);

        jPanel3.add(jPanel5);

        jPanel6.setPreferredSize(new java.awt.Dimension(300, 70));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 20));

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

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 20));

        cboxTim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã hóa đơn", "Mã khách hàng", "Mã nhân viên" }));
        cboxTim.setPreferredSize(new java.awt.Dimension(120, 31));
        jPanel7.add(cboxTim);

        txtTim.setPreferredSize(new java.awt.Dimension(120, 31));
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(876, 230));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Mã HD");

        jLabel6.setText("Ngày Lập");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel8);

        jLabel2.setText("Mã KH");

        jLabel4.setText("Tên KH");

        cboxMaKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboxMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMaKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboxMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(cboxMaKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel9);

        jLabel3.setText("Mã NV");

        jLabel5.setText("Tên NV");

        cboxMaNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboxMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMaNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboxMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel10);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboxMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMaKHActionPerformed
        // TODO add your handling code here:
        // Lấy mã KH được chọn
        String maKH = (String) cboxMaKH.getSelectedItem();
        
        // Load tên KH tương ứng lên ô văn bản
        String tenKH = qlyHoaDon_Bus.getTenKHByMaKH(maKH); // Thay thế bằng phương thức tương ứng của bạn
        txtTenKH.setText(tenKH);
    }//GEN-LAST:event_cboxMaKHActionPerformed

    private void cboxMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMaNVActionPerformed
        // TODO add your handling code here:
        // Lấy mã NV được chọn
        String maNV = (String) cboxMaNV.getSelectedItem();
        
        // Load tên NV tương ứng lên ô văn bản
        String tenNV = qlyHoaDon_Bus.getTenNVByMaNV(maNV); // Thay thế bằng phương thức tương ứng của bạn
        txtTenNV.setText(tenNV);
    }//GEN-LAST:event_cboxMaNVActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        // Lấy dữ liệu từ các ô văn bản và combobox
        String maHD = txtMaHD.getText();
        String maKH = (String) cboxMaKH.getSelectedItem();
        String tenKH = txtTenKH.getText();
        String maNV = (String) cboxMaNV.getSelectedItem();
        String tenNV = txtTenNV.getText();
        Date ngayLap = jDateChooser1.getDate();

        // Kiểm tra tính hợp lệ của dữ liệu
        // Kiểm tra rỗng
        if (maHD.isEmpty() || maKH.isEmpty() || tenKH.isEmpty() || maNV.isEmpty() || tenNV.isEmpty() || ngayLap == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
            return; // Dừng việc thực hiện chức năng nếu có trường dữ liệu trống
        }
        
        // Kiểm tra trùng mã hóa đơn
        if (qlyHoaDon_Bus.isMaHoaDonExists(maHD)) {
            JOptionPane.showMessageDialog(null, "Mã hóa đơn đã tồn tại!");
            return; // Dừng việc thực hiện chức năng nếu mã hóa đơn đã tồn tại
        }
        
        // Kiểm tra ngày lập hóa đơn có phải là ngày hiện tại không
        Date currentDate = new Date();
        if (ngayLap.after(currentDate)) {
            JOptionPane.showMessageDialog(null, "Ngày lập hóa đơn không hợp lệ!");
            return; // Dừng việc thực hiện chức năng nếu ngày lập hóa đơn không hợp lệ
        }

        HoaDon hd = new HoaDon(maHD, maKH, tenKH, maNV, tenNV, ngayLap);
        // Gọi phương thức thêm hóa đơn từ lớp QlyHoaDon_Bus
        boolean result = qlyHoaDon_Bus.addHoaDon(hd);

        // Kiểm tra kết quả và cập nhật giao diện nếu cần
        if (result) {
            // Nếu thêm thành công, cập nhật bảng
            loadDatatoTable(tbHoaDon);
            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(null, "Thêm hóa đơn thành công!");
        } else {
            // Nếu thêm không thành công, hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(null, "Thêm hóa đơn không thành công!");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        // Lấy dữ liệu từ các ô văn bản và combobox
        String maHD = txtMaHD.getText();
        String maKH = (String) cboxMaKH.getSelectedItem();
        String tenKH = txtTenKH.getText();
        String maNV = (String) cboxMaNV.getSelectedItem();
        String tenNV = txtTenNV.getText();
        Date ngayLap = jDateChooser1.getDate();

        // Kiểm tra tính hợp lệ của dữ liệu
        // Kiểm tra rỗng
        if (maHD.isEmpty() || maKH.isEmpty() || tenKH.isEmpty() || maNV.isEmpty() || tenNV.isEmpty() || ngayLap == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
            return; // Dừng việc thực hiện chức năng nếu có trường dữ liệu trống
        }
        
//        // Kiểm tra trùng mã hóa đơn
//        if (qlyHoaDon_Bus.isMaHoaDonExists(maHD)) {
//            JOptionPane.showMessageDialog(null, "Mã hóa đơn đã tồn tại!");
//            return; // Dừng việc thực hiện chức năng nếu mã hóa đơn đã tồn tại
//        }
        
        // Kiểm tra ngày lập hóa đơn có phải là ngày hiện tại không
        Date currentDate = new Date();
        if (ngayLap.after(currentDate)) {
            JOptionPane.showMessageDialog(null, "Ngày lập hóa đơn không hợp lệ!");
            return; // Dừng việc thực hiện chức năng nếu ngày lập hóa đơn không hợp lệ
        }

        HoaDon hd = new HoaDon(maHD, maKH, tenKH, maNV, tenNV, ngayLap);
        // Gọi phương thức sửa hóa đơn từ lớp QlyHoaDon_Bus
        boolean result = qlyHoaDon_Bus.updateHoaDon(hd);

        // Kiểm tra kết quả và cập nhật giao diện nếu cần
        if (result) {
            // Nếu sửa thành công, cập nhật bảng
            loadDatatoTable(tbHoaDon);
            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(null, "Sửa hóa đơn thành công!");
        } else {
            // Nếu sửa không thành công, hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(null, "Sửa hóa đơn không thành công!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        // Lấy mã hóa đơn từ ô văn bản
        String maHD = txtMaHD.getText();

        // Hiển thị hộp thoại xác nhận xóa
        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa hóa đơn này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        
        if (dialogResult == JOptionPane.YES_OPTION) {
            // Gọi phương thức xóa hóa đơn từ lớp QlyHoaDon_Bus
            boolean result = qlyHoaDon_Bus.deleteHoaDon(maHD);

            // Kiểm tra kết quả và cập nhật giao diện nếu cần
            if (result) {
                // Nếu xóa thành công, cập nhật bảng
                loadDatatoTable(tbHoaDon);
                // Hiển thị thông báo thành công
                JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công!");
            } else {
                // Nếu xóa không thành công, hiển thị thông báo lỗi
                JOptionPane.showMessageDialog(null, "Xóa hóa đơn không thành công!");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        // Lấy loại tìm kiếm và dữ liệu nhập vào
        String loaiTimKiem = (String) cboxTim.getSelectedItem();
        String duLieu = txtTim.getText();

        // Gọi phương thức tìm kiếm hóa đơn từ lớp QlyHoaDon_Bus
        List<HoaDon> resultList = qlyHoaDon_Bus.searchHoaDon(loaiTimKiem, duLieu);

        // Cập nhật bảng dữ liệu với kết quả tìm kiếm
        DefaultTableModel model = (DefaultTableModel) tbHoaDon.getModel();
        model.setRowCount(0); // Xóa dữ liệu hiện tại trong bảng

        for (HoaDon hd : resultList) {
            Object[] row = {hd.getMahd(), hd.getMakh(), hd.getHotenKH(), hd.getManv(), hd.getHotenNV(), hd.getNgaylap()};
            model.addRow(row);
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void txtTimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimCaretUpdate
        // TODO add your handling code here:
        // Kiểm tra xem nội dung của txtTim có rỗng không
        if (txtTim.getText().isEmpty()) {
            // Nếu rỗng, gọi phương thức loadDatatoTable để tải dữ liệu vào bảng tbHoaDon
            loadDatatoTable(tbHoaDon);
        }
    }//GEN-LAST:event_txtTimCaretUpdate

    private void hienThiFormChiTietHoaDon(String maHD) {
        // Viết code để hiển thị form chi tiết hóa đơn với mã hóa đơn được chọn
        // Ví dụ:
        CTHD cthd = new CTHD(maHD);
        cthd.setVisible(true);
    }

    
    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        // TODO add your handling code here:
        // Lấy hàng được chọn từ bảng
        int selectedRow = tbHoaDon.getSelectedRow();
        if (selectedRow != -1) { // Kiểm tra xem có hàng nào được chọn không
            // Lấy mã hóa đơn từ dòng được chọn
            String maHD = tbHoaDon.getValueAt(selectedRow, 0).toString();
            // Hiển thị form chi tiết hóa đơn tương ứng với mã hóa đơn
            hienThiFormChiTietHoaDon(maHD);
        } else {
            // Nếu không có hàng nào được chọn, bạn có thể xử lý tương ứng ở đây
        }
    }//GEN-LAST:event_btnXemActionPerformed

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
            java.util.logging.Logger.getLogger(QlyHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QlyHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QlyHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QlyHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QlyHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboxMaKH;
    private javax.swing.JComboBox<String> cboxMaNV;
    private javax.swing.JComboBox<String> cboxTim;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
