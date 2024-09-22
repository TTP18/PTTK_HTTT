package GUI;


import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import BUS.BUSChiTietPhieuNhap;
import BUS.BUSPhieuNhap;
import BUS.BUSncc;
import BUS.BUSThuoc;
import DTO.ChiTietPhieuNhap;
import DTO.NhaCungCap;
import DTO.PhieuNhap;
import DTO.Thuoc;



public class QLNhapHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField jtextSearch;
	private JPanel contentPane;
	private JTextField jtextMaPhieuNhap;
	private JTextField txtAdmin;
	private JTable tableThuoc;
	private JTextField jtextSoLuong;
	private JTable tableThuocPhieuNhap;
	private JComboBox comboBox;
	private JLabel jlableTongTien;
	
	public JButton jbuttonNhapHang;
	public JButton jbuttonUpdate;

	private static DefaultTableModel modelThuoc;
	private static DefaultTableModel modeNhap;
	int selectedIndex;
	BUSPhieuNhap buspn = new BUSPhieuNhap();
	BUSThuoc busThuoc = new BUSThuoc();
	BUSChiTietPhieuNhap busctpn = new BUSChiTietPhieuNhap();
	private ArrayList<PhieuNhap> phieuNhap;
	private ArrayList<ChiTietPhieuNhap> listChiTietPhieuNhap;
	private ArrayList<Thuoc> thuoc;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLNhapHang frame = new QLNhapHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public QLNhapHang() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1010, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel jpanelTimKiem = new JPanel();
		jpanelTimKiem.setBounds(10, 28, 489, 62);
		jpanelTimKiem.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(jpanelTimKiem);
		jpanelTimKiem.setLayout(null);

		JButton jbuttonRefresh = new JButton("Làm mới");
		jbuttonRefresh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonRefresh.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Button-Reload-icon.png"));
		jbuttonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefresh(e);
			}
		});
		jbuttonRefresh.setBounds(368, 8, 111, 36);
		jpanelTimKiem.add(jbuttonRefresh);

		jtextSearch = new JTextField();
		jtextSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextSearch.setBounds(10, 9, 262, 36);
		jpanelTimKiem.add(jtextSearch);
		jtextSearch.setColumns(10);

		JButton jbuttomSearch = new JButton("");
		jbuttomSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFindActionPerformed(e);
			}
		});
		jbuttomSearch.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\search-icon (1).png"));
		jbuttomSearch.setBounds(282, 8, 76, 36);
		jpanelTimKiem.add(jbuttomSearch);

		JLabel jlableSreach = new JLabel("Tìm Kiếm");
		jlableSreach.setBounds(10, 0, 76, 36);
		contentPane.add(jlableSreach);
		jlableSreach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlableSreach.setLabelFor(jpanelTimKiem);

		JLabel jlableMa = new JLabel("Mã Phiếu Nhập");
		jlableMa.setBounds(532, 14, 84, 22);
		jlableMa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(jlableMa);

		JLabel jlabelMaNCC = new JLabel("Mã nhà cung cấp");
		jlabelMaNCC.setBounds(532, 46, 99, 22);
		jlabelMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(jlabelMaNCC);

		txtAdmin = new JTextField();
		txtAdmin.setBounds(641, 79, 246, 24);
		txtAdmin.setText("Admin");
		txtAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(txtAdmin);
		txtAdmin.setColumns(10);

		jtextMaPhieuNhap = new JTextField();
		jtextMaPhieuNhap.setBounds(641, 8, 246, 25);
		jtextMaPhieuNhap.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(jtextMaPhieuNhap);
		jtextMaPhieuNhap.setColumns(10);
		jtextMaPhieuNhap.setText(buspn.showMa());
		jtextMaPhieuNhap.setEnabled(false);

		JLabel jlableNguoiNhap = new JLabel("Người nhập");
		jlableNguoiNhap.setBounds(532, 78, 84, 22);
		jlableNguoiNhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(jlableNguoiNhap);

		comboBox = new JComboBox<>();
		comboBox.setBounds(641, 46, 246, 23);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 101, 489, 330);
		contentPane.add(scrollPane);

		tableThuoc = new JTable();
		scrollPane.setViewportView(tableThuoc);
		tableThuoc.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "Mã thuốc", "Tên thuốc", "Giá", "Số lượng ", "Hạn sử dụng" }));

		JLabel jlableSoLuong = new JLabel("Số lượng");
		jlableSoLuong.setBounds(69, 464, 63, 23);
		jlableSoLuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(jlableSoLuong);

		jtextSoLuong = new JTextField();
		jtextSoLuong.setBounds(148, 464, 61, 27);
		jtextSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtextSoLuong.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(jtextSoLuong);
		jtextSoLuong.setColumns(10);
		jtextSoLuong.setText("1");

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBounds(219, 462, 99, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Button-Add-icon.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnNewButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(555, 128, 394, 289);
		contentPane.add(scrollPane_1);

		tableThuocPhieuNhap = new JTable();
		scrollPane_1.setViewportView(tableThuocPhieuNhap);
		tableThuocPhieuNhap.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "Mã thuốc", "Tên thuốc", "Số lượng", "Đơn giá", "Thành tiền" }));

		JButton jbuttonSuaSoLuong = new JButton("Sữa số lượng");
		jbuttonSuaSoLuong.setBounds(605, 427, 152, 27);
		jbuttonSuaSoLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSuaSoLuong(e);
			}
		});
		jbuttonSuaSoLuong.setIcon(new ImageIcon("/icon/Edit.png"));
		jbuttonSuaSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(jbuttonSuaSoLuong);

		JButton jbuttonXoaSoLuong = new JButton("Xóa số lượng");
		jbuttonXoaSoLuong.setBounds(767, 427, 152, 27);
		jbuttonXoaSoLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoaChiTiet(e);
			}
		});
		jbuttonXoaSoLuong.setIcon(new ImageIcon("/icon/Delete.png"));
		jbuttonXoaSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(jbuttonXoaSoLuong);

		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		String formattedTongTien = decimalFormat.format(tinhTongTien());
		jlableTongTien = new JLabel("Tổng tiền:" + formattedTongTien + "Đ");
		jlableTongTien.setBounds(482, 485, 218, 22);
		jlableTongTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(jlableTongTien);

		jbuttonNhapHang = new JButton("Nhập hàng");
		jbuttonNhapHang.setBounds(823, 483, 146, 35);
		jbuttonNhapHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNhapHang(e);
			}
		});
		
		jbuttonNhapHang.setForeground(Color.RED);
		jbuttonNhapHang.setBackground(Color.BLACK);
		jbuttonNhapHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(jbuttonNhapHang);
		
		jbuttonUpdate = new JButton("Lưu thay đổi");
		jbuttonUpdate.setBackground(new Color(0, 255, 128));
		jbuttonUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jbuttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdatePhieuNhap(e);
			}
		});
		
		jbuttonUpdate.setVisible(false);
		jbuttonUpdate.setBounds(710, 483, 140, 35);
		contentPane.add(jbuttonUpdate);
		
		tableThuocPhieuNhap.getColumnModel().getColumn(0).setPreferredWidth(65);
		tableThuocPhieuNhap.getColumnModel().getColumn(1).setPreferredWidth(186);
		tableThuocPhieuNhap.getColumnModel().getColumn(2).setPreferredWidth(60);
		tableThuocPhieuNhap.getColumnModel().getColumn(3).setPreferredWidth(65);
		tableThuocPhieuNhap.getColumnModel().getColumn(4).setPreferredWidth(75);

		tableThuoc.getColumnModel().getColumn(0).setPreferredWidth(56);
		tableThuoc.getColumnModel().getColumn(1).setPreferredWidth(210);
		tableThuoc.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableThuoc.getColumnModel().getColumn(3).setPreferredWidth(75);

		modelThuoc = (DefaultTableModel) tableThuoc.getModel();
		showTableThuoc();

		modeNhap = (DefaultTableModel) tableThuocPhieuNhap.getModel();
		showTableNhap(modeNhap);
		showNcc();
		tinhTongTien();
	}

	public void showTableThuoc() {
		clearTableThuoc();
		thuoc = busThuoc.getListTh();
		for (Thuoc t : thuoc) {
			modelThuoc.addRow(
					new Object[] { t.getMaThuoc(), t.getTenThuoc(), t.getGiaBan(), t.getSoLuong(), t.getHanSuDung() });
		}
	}

	public void showTableNhap(DefaultTableModel modeNhap) {
		// Lấy mã phiếu nhập từ jtextMaPhieuNhap
		String maPhieuNhap = jtextMaPhieuNhap.getText();

		// Lấy danh sách chi tiết phiếu nhập dựa trên mã phiếu nhập
		listChiTietPhieuNhap = busctpn.getListChiTietPhieuNhap(maPhieuNhap);

		// Xóa dữ liệu hiện tại của tableThuocPhieuNhap
		clearTableThuocPhieuNhap();

		// Thêm dữ liệu từ danh sách chi tiết phiếu nhập vào tableThuocPhieuNhap
		for (ChiTietPhieuNhap ctpn : listChiTietPhieuNhap) {
			String maThuoc = ctpn.getMaThuoc();
			String tenThuoc = busctpn.getTenThuoc(maThuoc);
			String giaThuoc = busThuoc.getGiaThuoc(maThuoc);
			modeNhap.addRow(new Object[] { maThuoc, tenThuoc, ctpn.getSoLuong(), // Lấy tên thuốc từ mã thuốc
					tenThuoc, ctpn.getThanhTien() });
		}
		tableThuocPhieuNhap.setModel(modeNhap);
	}

	public void clearTableThuocPhieuNhap() {
		DefaultTableModel model = (DefaultTableModel) tableThuocPhieuNhap.getModel();
		model.setRowCount(0); // Xóa hết các dòng trên JTable
	}

	public void showNcc() {
		BUSncc busNCC = new BUSncc();
		ArrayList<NhaCungCap> listNCC = busNCC.getListNCC();
		for (NhaCungCap ncc : listNCC) {
			comboBox.addItem(ncc.getTenNCC());
		}
	}

	public void clearTableThuoc() {
		DefaultTableModel model = (DefaultTableModel) tableThuoc.getModel();
		model.setRowCount(0); // Xóa hết các dòng trên JTable
	}

	public void btnFindActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFindActionPerformed
		String Name = jtextSearch.getText();
		if (Name.length() > 0) {
			thuoc = busThuoc.findbyName(Name);
			modelThuoc.setRowCount(0);
			for (Thuoc t : thuoc) {
				modelThuoc.addRow(
						new Object[] { t.getMaThuoc(), t.getTenThuoc(), t.getGiaBan(), t.getSoLuong(), t.getHanSuDung() });

			}
		}
	}

	public void btnRefresh(ActionEvent e) {
		jtextSearch.setText("");
		showTableThuoc();
		showTableNhap(modeNhap);
	}

	public void btnThem(ActionEvent e) {
		int selectedRow = tableThuoc.getSelectedRow();

		// Kiểm tra nếu không có hàng nào được chọn
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn thuốc cần nhập.");
			return;
		}
		String maThuoc = (String) tableThuoc.getValueAt(selectedRow, 0); // Mã thuốc
		String tenThuoc = (String) tableThuoc.getValueAt(selectedRow, 1); // Tên thuốc
		float donGia = (int) tableThuoc.getValueAt(selectedRow, 2); // Đơn giá
		// int soLuongTon =(int) tableThuoc.getValueAt(selectedRow, 3);

		String soLuongNhapStr = jtextSoLuong.getText().trim();

		if (soLuongNhapStr.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng.");
			return;
		}

		int soLuongNhap;
		try {
			soLuongNhap = Integer.parseInt(soLuongNhapStr);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Số lượng nhập không hợp lệ.");
			return;
		}

		// Kiểm tra số lượng nhập có vượt quá số lượng tồn kho không
		if (soLuongNhap <= 0) {
			JOptionPane.showMessageDialog(null, "Số lượng nhập phải lớn hơn 0.");
			return;
		}

		ChiTietPhieuNhap chiTietPhieuNhap = new ChiTietPhieuNhap();
		chiTietPhieuNhap.setMaPhieuNhap(jtextMaPhieuNhap.getText());
		chiTietPhieuNhap.setMaThuoc(maThuoc);
		chiTietPhieuNhap.setSoLuong(soLuongNhap);
		chiTietPhieuNhap.setThanhTien(donGia * soLuongNhap);
		JOptionPane.showMessageDialog(this, busctpn.addChiTietPhieuNhap(chiTietPhieuNhap));
		//busThuoc.updateSoLuong(maThuoc, soLuongNhap);
		jtextSoLuong.setText("1");
		showTableNhap(modeNhap);
		showTableThuoc();
		updateTongTienLabel();

	}

	public void btnXoaChiTiet(ActionEvent e) {
		selectedIndex = tableThuocPhieuNhap.getSelectedRow();
		if (selectedIndex >= 0) {
			String maThuoc = tableThuocPhieuNhap.getValueAt(selectedIndex, 0).toString();
			int soluong = (int) tableThuocPhieuNhap.getValueAt(selectedIndex, 2);

			ChiTietPhieuNhap ctpn = listChiTietPhieuNhap.get(selectedIndex);

			// Hiển thị hộp thoại xác nhận xóa
			int confirmResult = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Xác nhận xóa",
					JOptionPane.YES_NO_OPTION);

			if (confirmResult == JOptionPane.YES_OPTION) {
				// Nếu người dùng chọn YES_OPTION

				// Xóa thành công, cập nhật lại bảng và số lượng
				//busThuoc.updateSoLuong(maThuoc, -soluong);
				JOptionPane.showMessageDialog(this, busctpn.deleteChiTietPhieuNhap(ctpn));
				showTableNhap(modeNhap);
				showTableThuoc();
				updateTongTienLabel();

			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void btnSuaSoLuong(ActionEvent e) {
		// Lấy mã thuốc từ tableThuocPhieuNhap (chỉ ví dụ, bạn cần cập nhật logic lấy mã
		// thuốc ở đây)
		selectedIndex = tableThuocPhieuNhap.getSelectedRow();
		if (selectedIndex == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để sửa số lượng.", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		String maPhieuNhap =  jtextMaPhieuNhap.getText();
		String maThuoc = tableThuocPhieuNhap.getValueAt(selectedIndex, 0).toString();
		int soluong = (int) tableThuocPhieuNhap.getValueAt(selectedIndex, 2);
		// Lấy mã thuốc từ cột 0 (ví dụ)

		// Hiển thị hộp thoại để nhập số lượng mới
		String input = JOptionPane.showInputDialog(null, "Nhập số lượng mới:", "Sửa số lượng",
				JOptionPane.PLAIN_MESSAGE);
		
		int a = Integer.parseInt(input);
		
		if (input != null && !input.isEmpty() && a > 0  ) {
			try {
				int soLuongMoi = Integer.parseInt(input);
				int soLuongCapNhat = soLuongMoi - soluong;
//	            for (ChiTietPhieuNhap ctpn : listChiTietPhieuNhap) {
//	                if (ctpn.getMaThuoc().equals(maThuoc)) {
//	                    // Tìm thấy đối tượng ChiTietPhieuNhap tương ứng, cập nhật số lượng
//	                    ctpn.setSoLuong(soLuongMoi);
//	                    break;
//	                }
//	            }
				busctpn.updateSoLuongChiTiet(maThuoc, soLuongMoi);
				//busThuoc.updateSoLuong(maThuoc, soLuongCapNhat);
				//busctpn.updateThanhTien(maPhieuNhap);
				tinhTongTien();

				//Cập nhật lại dữ liệu trên bảng sau khi sửa số lượng
				showTableNhap(modeNhap);
				showTableThuoc();
				updateTongTienLabel();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên hợp lệ.", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập số lượng mới.", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public float tinhTongTien() {
		float tongTien = 0;

		String maPhieuNhap = jtextMaPhieuNhap.getText();
		listChiTietPhieuNhap = busctpn.getListChiTietPhieuNhap(maPhieuNhap);
		for (ChiTietPhieuNhap ctpn : listChiTietPhieuNhap) {
			tongTien += ctpn.getThanhTien();
		}
		return tongTien;
	}

	private void updateTongTienLabel() {
		// Tính toán tổng tiền mới
		float tongTienMoi = tinhTongTien();

		// Định dạng số và cập nhật label jlableTongTien
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		String formattedTongTien = decimalFormat.format(tongTienMoi);
		jlableTongTien.setText("Tổng tiền: " + formattedTongTien + " Đ");
	}

	public int tinhTongSoLuong() {
		int tongSoLuong = 0;

		String maPhieuNhap = jtextMaPhieuNhap.getText();
		listChiTietPhieuNhap = busctpn.getListChiTietPhieuNhap(maPhieuNhap);
		for (ChiTietPhieuNhap ctpn : listChiTietPhieuNhap) {
			tongSoLuong += ctpn.getSoLuong();
		}
		return tongSoLuong;
	}

	public void btnNhapHang(ActionEvent e) {
		// Lấy thông tin từ giao diện
		String maPhieuNhap = jtextMaPhieuNhap.getText();
		String nguoiNhap = txtAdmin.getText();

		// Lấy đối tượng Nhà Cung Cấp đã chọn từ JComboBox
		String tenNCC = (String) comboBox.getSelectedItem();
	    String maNCC = null;
	    BUSncc busNCC = new BUSncc();

	    // Tìm mã nhà cung cấp từ tên nhà cung cấp
	    for (NhaCungCap ncc : busNCC.getListNCC()) {
	        if (ncc.getTenNCC().equals(tenNCC)) {
	            maNCC = ncc.getMaNCC();
	            break;
	        }
	    }

		// Kiểm tra nếu nhà cung cấp đã được chọn
		if (maNCC == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà cung cấp.", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		// Lấy mã nhà cung cấp từ đối tượng Nhà Cung Cấp
		

		// Lấy ngày giờ hiện tại
		LocalDate currentDate = LocalDate.now();
		java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);


		// Tạo đối tượng PhiieuNhap mới
		PhieuNhap phieuNhap = new PhieuNhap();
		phieuNhap.setMaPhieuNhap(maPhieuNhap);
		phieuNhap.setMaNCC(maNCC);
		phieuNhap.setNgayLap(sqlDate);
		// Thiết lập ngày giờ nhập hàng

		// Gọi đối tượng BUSPhieuNhap để thêm phiếu nhập vào cơ sở dữ liệu

		// Nếu thêm thành công, thông báo và làm mới giao diện
		JOptionPane.showMessageDialog(this, buspn.addPhieuNhap(phieuNhap));
		// Làm mới giao diện để chuẩn bị cho phiếu nhập tiếp theo
		// Ví dụ:
		jtextMaPhieuNhap.setText(buspn.showMa()); // Lấy mã phiếu nhập mới
		showTableNhap(modeNhap); // Hiển thị lại bảng chi tiết phiếu nhập
		showTableThuoc(); // Hiển thị lại bảng thuốc
		updateTongTienLabel(); // Cập nhật lại tổng tiền

	}

	public void setMaPhieuNhap(String maPhieuNhap) {
	    // Lấy thông tin phiếu nhập từ mã phiếu nhập và hiển thị lên giao diện QLNhapHang
	    jtextMaPhieuNhap.setText(maPhieuNhap); // Hiển thị mã phiếu nhập lên text field
	    showTableNhap(modeNhap); // Hiển thị lại bảng chi tiết phiếu nhập tương ứng
	    // Các bước khác để hiển thị thông tin chi tiết phiếu nhập và các chức năng chỉnh sửa
	}
	
	public void setButton()
	{
		jbuttonUpdate.setVisible(true);
	    jbuttonNhapHang.setVisible(false);
	}
	
	public void editPhieuNhap(String maPhieuNhap) {
	    // Hiển thị giao diện QLNhapHang để chỉnh sửa phiếu nhập
	    QLNhapHang qlNhapHang = new QLNhapHang(); // Tạo một đối tượng QLNhapHang mới
	    
	    qlNhapHang.setVisible(true); // Hiển thị giao diện QLNhapHang

	    // Truyền mã phiếu nhập cần chỉnh sửa vào giao diện QLNhapHang
	    qlNhapHang.setMaPhieuNhap(maPhieuNhap);
	    qlNhapHang.setButton();
	    setDefaultCloseOperation(qlNhapHang.DO_NOTHING_ON_CLOSE);
	}
	
	public void btnUpdatePhieuNhap(ActionEvent e) {
		// Lấy thông tin từ giao diện
		String maPhieuNhap = jtextMaPhieuNhap.getText();
		String nguoiNhap = txtAdmin.getText();

		// Lấy đối tượng Nhà Cung Cấp đã chọn từ JComboBox
		String tenNCC = (String) comboBox.getSelectedItem();
		String maNCC = null;
		BUSncc busNCC = new BUSncc();

		// Tìm mã nhà cung cấp từ tên nhà cung cấp
		for (NhaCungCap ncc : busNCC.getListNCC()) {
			if (ncc.getTenNCC().equals(tenNCC)) {
				maNCC = ncc.getMaNCC();
				break;
			}
		}

		// Kiểm tra nếu nhà cung cấp đã được chọn
		if (maNCC == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà cung cấp.", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		// Lấy mã nhà cung cấp từ đối tượng Nhà Cung Cấp

		// Lấy ngày giờ hiện tại
		LocalDate currentDate = LocalDate.now();
		java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);

		// Tạo đối tượng PhiieuNhap mới
		PhieuNhap phieuNhap = new PhieuNhap();
		phieuNhap.setMaPhieuNhap(maPhieuNhap);
		phieuNhap.setMaNCC(maNCC);
		//phieuNhap.setSoLuong(tinhTongSoLuong());
		phieuNhap.setNgayLap(sqlDate);
		//phieuNhap.setTongTien(tinhTongTien());
		// Thiết lập ngày giờ nhập hàng

		// Gọi đối tượng BUSPhieuNhap để thêm phiếu nhập vào cơ sở dữ liệu

		// Nếu thêm thành công, thông báo và làm mới giao diện
		JOptionPane.showMessageDialog(this, buspn.updatePhieuNhap(phieuNhap));
		
	}
	
	
}
