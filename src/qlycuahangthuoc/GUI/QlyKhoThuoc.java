package qlycuahangthuoc.GUI;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import qlycuahangthuoc.BUS.QlyKhoThuoc_Bus;
import qlycuahangthuoc.DTO.KhoThuoc;

public class QlyKhoThuoc extends javax.swing.JFrame {

    QlyKhoThuoc_Bus qlyKhoThuoc_Bus = new QlyKhoThuoc_Bus();
    
    public QlyKhoThuoc() {
        initComponents();
        setLocationRelativeTo(null);
        qlyKhoThuoc_Bus.loadTableData(tbKho);
        
        // Thêm ListSelectionListener vào JTable
        tbKho.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    // Xử lý sự kiện khi một dòng được chọn
                    int selectedRow = tbKho.getSelectedRow();
                    if (selectedRow != -1) {
                        // Lấy dữ liệu từ dòng được chọn và hiển thị lên các ô nhập liệu và JDateChooser
                        String makho = tbKho.getValueAt(selectedRow, 0).toString();
                        String maThuoc = tbKho.getValueAt(selectedRow, 1).toString();
                        String tenThuoc = tbKho.getValueAt(selectedRow, 2).toString();
                        String giaBan = tbKho.getValueAt(selectedRow, 3).toString();
                        String soLuong = tbKho.getValueAt(selectedRow, 4).toString();
                        Date hanSuDung = (Date) tbKho.getValueAt(selectedRow, 5);

                        txtMaKho.setText(makho);
                        txtMaThuoc.setText(maThuoc);
                        txtTenThuoc.setText(tenThuoc);
                        txtGiaBan.setText(giaBan);
                        txtSoLuong.setText(soLuong);
                        JdateHSD.setDate(hanSuDung);
                    }
                }
            }
        });
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        cboxTim = new javax.swing.JComboBox<>();
        btnTim = new javax.swing.JButton();
        pn2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaThuoc = new javax.swing.JTextField();
        txtTenThuoc = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtMaKho = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        pn3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        GiaDateStart = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        GiaDateFinish = new javax.swing.JTextField();
        btnLoc = new javax.swing.JButton();
        HSDDateStart = new com.toedter.calendar.JDateChooser();
        HSDDateFinish = new com.toedter.calendar.JDateChooser();
        JdateHSD = new com.toedter.calendar.JDateChooser();
        pnThuoc = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKho = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý kho thuốc");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel18.setText("tìm kiếm theo");

        txtTim.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimCaretUpdate(evt);
            }
        });

        cboxTim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã kho", "Mã thuốc" }));

        btnTim.setText("search");
        btnTim.setPreferredSize(new java.awt.Dimension(73, 25));
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn1Layout = new javax.swing.GroupLayout(pn1);
        pn1.setLayout(pn1Layout);
        pn1Layout.setHorizontalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn1Layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboxTim, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn1Layout.setVerticalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("Thông tin loại thuốc");

        jLabel4.setText("Tên thuốc");

        jLabel5.setText("Mã thuốc");

        jLabel6.setText("Giá bán");

        jLabel8.setText("mã thuốc");

        jLabel9.setText("HSD");

        jLabel10.setText("Mã kho");

        jLabel11.setText("Số lượng");

        btnThem.setBackground(new java.awt.Color(102, 255, 51));
        btnThem.setText("Thêm");
        btnThem.setPreferredSize(new java.awt.Dimension(73, 23));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 0, 0));
        btnXoa.setText("Xóa");
        btnXoa.setPreferredSize(new java.awt.Dimension(73, 23));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(204, 255, 204));
        btnSua.setText("Sửa");
        btnSua.setPreferredSize(new java.awt.Dimension(73, 23));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        pn3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Lọc thuốc");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel12.setText("hạn sử dụng:");

        jLabel13.setText("từ:");

        jLabel14.setText("đến:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel15.setText("giá bán");

        jLabel16.setText("từ:");

        jLabel17.setText("đến");

        btnLoc.setBackground(new java.awt.Color(0, 102, 255));
        btnLoc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLoc.setText("Lọc");
        btnLoc.setPreferredSize(new java.awt.Dimension(73, 23));
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn3Layout = new javax.swing.GroupLayout(pn3);
        pn3.setLayout(pn3Layout);
        pn3Layout.setHorizontalGroup(
            pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn3Layout.createSequentialGroup()
                        .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn3Layout.createSequentialGroup()
                        .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pn3Layout.createSequentialGroup()
                                .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GiaDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pn3Layout.createSequentialGroup()
                                .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(HSDDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 70, Short.MAX_VALUE)
                                .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GiaDateFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(HSDDateFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(47, Short.MAX_VALUE))))
        );
        pn3Layout.setVerticalGroup(
            pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HSDDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HSDDateFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GiaDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GiaDateFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout pn2Layout = new javax.swing.GroupLayout(pn2);
        pn2.setLayout(pn2Layout);
        pn2Layout.setHorizontalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn2Layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jLabel8))
                    .addGroup(pn2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(pn2Layout.createSequentialGroup()
                                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9))
                                .addGap(36, 36, 36)
                                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                        .addComponent(txtTenThuoc, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(txtMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JdateHSD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addComponent(jLabel10)
                                .addGap(13, 13, 13)
                                .addComponent(txtMaKho)))))
                .addGap(18, 18, 18)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn2Layout.setVerticalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtMaKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pn2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(15, 15, 15)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JdateHSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pn3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tbKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã kho", "Mã thuốc", "Tên thuốc", "Giá bán", "Số lượng", "HSD"
            }
        ));
        jScrollPane1.setViewportView(tbKho);

        javax.swing.GroupLayout pnThuocLayout = new javax.swing.GroupLayout(pnThuoc);
        pnThuoc.setLayout(pnThuocLayout);
        pnThuocLayout.setHorizontalGroup(
            pnThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1093, Short.MAX_VALUE))
        );
        pnThuocLayout.setVerticalGroup(
            pnThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
            .addGroup(pnThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnThuocLayout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(pn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Phương thức kiểm tra dữ liệu nhập
    private boolean kiemTraDuLieuNhap() {
        String makho = txtMaKho.getText();
        String maThuoc = txtMaThuoc.getText();
        String tenThuoc = txtTenThuoc.getText();
        String giaBanStr = txtGiaBan.getText();
        String soLuongStr = txtSoLuong.getText();
        Date hanSuDung = JdateHSD.getDate();

        // Kiểm tra xem các trường nhập liệu có bị bỏ trống không
        if (makho.trim().isEmpty() || maThuoc.trim().isEmpty() || tenThuoc.trim().isEmpty() || giaBanStr.trim().isEmpty() || soLuongStr.trim().isEmpty() || hanSuDung == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
            return false;
        }
        
        // Kiểm tra xem giá bán và số lượng có đúng định dạng số không
        try {
            BigDecimal giaBan = new BigDecimal(giaBanStr);
            int soLuong = Integer.parseInt(soLuongStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá bán và số lượng phải là số.");
            return false;
        }

        return true;
    }
    
    //hienThiKetQuaTimKiem(danhSachThuoc)
    
    public boolean hienThiKetQuaTimKiem( List<KhoThuoc> danhSachThuoc, JTable table){
        
        if (danhSachThuoc.isEmpty()) {
            return false;
        }
        else{
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for(KhoThuoc kt : danhSachThuoc){
                Object [] row = {kt.getMaKho(),kt.getMaThuoc(),kt.getTenThuoc(),kt.getGiaBan(),kt.getSoluong(),kt.getHSD()};
                model.addRow(row);
            }
            return true;
        }
    }

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        // Kiểm tra các trường nhập liệu
        if (kiemTraDuLieuNhap()) {
            // Lấy thông tin từ các trường nhập liệu
            String makho = txtMaKho.getText();
            String maThuoc = txtMaThuoc.getText();
            String tenThuoc = txtTenThuoc.getText();
            BigDecimal giaBan = new BigDecimal(txtGiaBan.getText());
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            Date hanSuDung = JdateHSD.getDate();

            // Gọi phương thức sửa thuốc từ lớp QlyKhoThuoc_Bus

            KhoThuoc khoThuoc = new KhoThuoc(makho, maThuoc, tenThuoc, giaBan, soLuong, hanSuDung);

            boolean result = qlyKhoThuoc_Bus.suaThuoc(khoThuoc);

            if (result) {
                JOptionPane.showMessageDialog(this, "Sửa thuốc thành công.");
                // Sau khi sửa thành công, cập nhật lại bảng
                qlyKhoThuoc_Bus.loadTableData(tbKho);
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thuốc thất bại.");
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        // Kiểm tra các trường nhập liệu
        if (kiemTraDuLieuNhap()) {
            String makho = txtMaKho.getText();
            String maThuoc = txtMaThuoc.getText();
            String tenThuoc = txtTenThuoc.getText();
            BigDecimal giaBan = new BigDecimal(txtGiaBan.getText());
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            Date hanSuDung = JdateHSD.getDate();

            // Kiểm tra xem mã kho đã tồn tại hay chưa
            if (!qlyKhoThuoc_Bus.kiemTraMaKhoTonTai(makho)) {
                // Mã kho không tồn tại, tiến hành thêm mới thuốc
                KhoThuoc khoThuoc = new KhoThuoc(makho, maThuoc, tenThuoc, giaBan, soLuong, hanSuDung);

                boolean result = qlyKhoThuoc_Bus.themThuoc(khoThuoc);

                if (result) {
                    JOptionPane.showMessageDialog(this, "Thêm thuốc thành công.");
                    // Sau khi thêm thành công, cập nhật lại bảng
                    qlyKhoThuoc_Bus.loadTableData(tbKho);
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thuốc thất bại.");
                }
            } else {
                // Mã kho đã tồn tại, hiển thị thông báo
                JOptionPane.showMessageDialog(this, "Mã kho đã tồn tại. Vui lòng chọn mã kho khác.");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
        // Lấy ngày bắt đầu và kết thúc từ các trường ngày
        Date dateHSDstart = HSDDateStart.getDate();
        Date dateHSDfinish = HSDDateFinish.getDate();

        // Lấy giá bắt đầu và kết thúc từ các trường giá
        BigDecimal giaBanStart = new BigDecimal(GiaDateStart.getText());
        BigDecimal giaBanFinish = new BigDecimal(GiaDateFinish.getText());   

        // Thực hiện lọc dữ liệu dựa trên các điều kiện
        List<KhoThuoc> danhSachThuoc = qlyKhoThuoc_Bus.locThuocTheoDieuKien(dateHSDstart, dateHSDfinish, giaBanStart, giaBanFinish);

        // Kiểm tra xem danh sách thuốc có dữ liệu hay không
        if (!danhSachThuoc.isEmpty()) {
            // Cập nhật dữ liệu lên bảng
            hienThiKetQuaTimKiem(danhSachThuoc, tbKho);
        } else {
            // Hiển thị thông báo nếu không tìm thấy dữ liệu
            JOptionPane.showMessageDialog(this, "Không tìm thấy thuốc theo điều kiện đã chọn.");
        }
        
        
    }//GEN-LAST:event_btnLocActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        // Kiểm tra dữ liệu trước khi xóa
        String maThuoc = txtMaThuoc.getText();

        // Kiểm tra xem mã thuốc có được nhập không
        if (maThuoc.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuốc cần xóa.");
            return;
        }

        // Gọi phương thức xóa thuốc từ lớp QlyKhoThuoc_Bus
        boolean result = qlyKhoThuoc_Bus.xoaThuoc(maThuoc);

        if (result) {
            JOptionPane.showMessageDialog(this, "Xóa thuốc thành công.");
            // Sau khi xóa thành công, cập nhật lại bảng
            qlyKhoThuoc_Bus.loadTableData(tbKho);
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thuốc thất bại.");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        // Lấy thông tin từ ô nhập liệu
        String keyword = txtTim.getText(); // Từ khóa tìm kiếm
        String searchBy = (String) cboxTim.getSelectedItem(); // Lựa chọn tìm kiếm

        // Kiểm tra lựa chọn tìm kiếm và thực hiện tìm kiếm tương ứng
        if (searchBy.equals("Mã kho")) {
            // Tìm theo mã kho
            List<KhoThuoc> danhSachThuoc = qlyKhoThuoc_Bus.timThuocTheoMaKho(keyword);
            if (!danhSachThuoc.isEmpty()) {
                // Hiển thị kết quả tìm kiếm
                hienThiKetQuaTimKiem(danhSachThuoc,tbKho);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy thuốc trong kho có mã " + keyword);
            }
        } else if (searchBy.equals("Mã thuốc")) {
            // Tìm theo mã thuốc
            List<KhoThuoc> danhSachThuoc = qlyKhoThuoc_Bus.timThuocTheoMa(keyword);
            if (!danhSachThuoc.isEmpty()) {
                // Hiển thị kết quả tìm kiếm
                hienThiKetQuaTimKiem(danhSachThuoc,tbKho);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy thuốc có mã " + keyword);
            }
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void txtTimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimCaretUpdate
        // TODO add your handling code here:
        if (txtTim.getText().equals("")) {
            qlyKhoThuoc_Bus.loadTableData(tbKho);
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
            java.util.logging.Logger.getLogger(QlyKhoThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QlyKhoThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QlyKhoThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QlyKhoThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QlyKhoThuoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField GiaDateFinish;
    private javax.swing.JTextField GiaDateStart;
    private com.toedter.calendar.JDateChooser HSDDateFinish;
    private com.toedter.calendar.JDateChooser HSDDateStart;
    private com.toedter.calendar.JDateChooser JdateHSD;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboxTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pn2;
    private javax.swing.JPanel pn3;
    private javax.swing.JPanel pnThuoc;
    private javax.swing.JTable tbKho;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaKho;
    private javax.swing.JTextField txtMaThuoc;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenThuoc;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
