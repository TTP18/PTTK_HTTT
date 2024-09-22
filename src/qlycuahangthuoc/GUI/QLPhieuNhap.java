package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.Label;
import java.awt.Choice;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import BUS.BUSPhieuNhap;
import BUS.BUSncc;
import DTO.ChiTietPhieuNhap;
import DTO.NhaCungCap;
import DTO.PhieuNhap;

import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;

public class QLPhieuNhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtextTimKiem;

	int selectedIndex;
	private JTable tablePhieuNhap;
	private static DefaultTableModel modePhieuNhap;
	private ArrayList<PhieuNhap> listPhieuNhap;
	BUSPhieuNhap buspn = new BUSPhieuNhap();
	BUSncc busncc = new BUSncc();
	//QLNhapHang qlNhapHang = new QLNhapHang();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLPhieuNhap frame = new QLPhieuNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLPhieuNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1168, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel jpanelChucNang = new JPanel();
		jpanelChucNang.setBounds(30, 10, 413, 77);
		jpanelChucNang.setForeground(new Color(192, 192, 192));
		jpanelChucNang.setBackground(new Color(255, 255, 255));
		jpanelChucNang.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(jpanelChucNang);
		jpanelChucNang.setLayout(null);

		JButton jbuttomAdd = new JButton("");
		jbuttomAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoaChiTiet(e);
			}
		});
		jbuttomAdd.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\user-trash-full-icon.png"));
		jbuttomAdd.setBounds(10, 10, 86, 57);
		jpanelChucNang.add(jbuttomAdd);

		JButton jbuttonSua = new JButton("");
		jbuttonSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSuaPhieuNhap(e);
			}
		});
		jbuttonSua.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\settings-icon.png"));
		jbuttonSua.setBounds(145, 10, 86, 57);
		jpanelChucNang.add(jbuttonSua);

		JButton jbuttonChiTiet = new JButton("");
		jbuttonChiTiet.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Eye-icon.png"));
		jbuttonChiTiet.setVerticalAlignment(SwingConstants.TOP);
		jbuttonChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//showChiTiet(e);
			}
		});
		jbuttonChiTiet.setBounds(281, 10, 97, 57);
		jpanelChucNang.add(jbuttonChiTiet);

		JPanel jpanelTimKiem = new JPanel();
		jpanelTimKiem.setBounds(497, 10, 612, 77);
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
		jbuttonRefresh.setBounds(491, 29, 111, 36);
		jpanelTimKiem.add(jbuttonRefresh);

		jtextTimKiem = new JTextField();
		jtextTimKiem.setBounds(10, 31, 369, 36);
		jpanelTimKiem.add(jtextTimKiem);
		jtextTimKiem.setColumns(10);

		JLabel jlableSreach = new JLabel("Tìm Kiếm");
		jlableSreach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlableSreach.setLabelFor(jpanelTimKiem);
		jlableSreach.setBounds(26, 0, 76, 36);
		jpanelTimKiem.add(jlableSreach);

		JButton jbuttomSearch = new JButton("");
		jbuttomSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findPhieuNhap(e);
			}
		});
		jbuttomSearch.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\search-icon (1).png"));
		jbuttomSearch.setBounds(389, 29, 92, 36);
		jpanelTimKiem.add(jbuttomSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 180, 1079, 460);
		contentPane.add(scrollPane);

		tablePhieuNhap = new JTable();
		scrollPane.setViewportView(tablePhieuNhap);
		tablePhieuNhap.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "M\u00E3 Phi\u1EBFu Nh\u1EADp", "T\u00EAn nh\u00E0 cung c\u1EA5p", "S\u1ED1 l\u01B0\u1EE3ng",
				"Ng\u00E0y l\u1EADp", "Tổng tiền" }));
		tablePhieuNhap.getColumnModel().getColumn(0).setPreferredWidth(92);
		tablePhieuNhap.getColumnModel().getColumn(1).setPreferredWidth(222);
		tablePhieuNhap.getColumnModel().getColumn(2).setPreferredWidth(64);
		tablePhieuNhap.getColumnModel().getColumn(3).setPreferredWidth(82);
		tablePhieuNhap.getColumnModel().getColumn(4).setPreferredWidth(82);

		modePhieuNhap = (DefaultTableModel) tablePhieuNhap.getModel();
		showTablePhieuNhap();

	}

	public void showTablePhieuNhap() {
		clearTablePhieuNhap();
		listPhieuNhap = buspn.getListPhieuNhap();

		for (PhieuNhap pn : listPhieuNhap) {
			String maNCC = pn.getMaNCC();
			String tenNCC = busncc.getTenNCC(maNCC);
			modePhieuNhap.addRow(
					new Object[] { pn.getMaPhieuNhap(), tenNCC, pn.getMaNV(), pn.getNgayLap() });
		}

	}

	public void clearTablePhieuNhap() {
		DefaultTableModel model = (DefaultTableModel) tablePhieuNhap.getModel();
		model.setRowCount(0); // Xóa hết các dòng trên JTable
	}

	public void btnXoaChiTiet(ActionEvent e) {
		selectedIndex = tablePhieuNhap.getSelectedRow();
		if (selectedIndex != -1) {

			PhieuNhap pn = listPhieuNhap.get(selectedIndex);
			// Hiển thị hộp thoại xác nhận xóa
			int confirmResult = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Xác nhận xóa",
					JOptionPane.YES_NO_OPTION);

			if (confirmResult == JOptionPane.YES_OPTION) {
				// Nếu người dùng chọn YES_OPTION

				// Xóa thành công, cập nhật lại bảng và số lượng
				JOptionPane.showMessageDialog(this, buspn.deletePhieuNhap(pn));
				showTablePhieuNhap();

			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void findPhieuNhap(ActionEvent e) {
		clearTablePhieuNhap();
		try {
			if (!jtextTimKiem.getText().isEmpty()) {
				ArrayList<PhieuNhap> rs = new ArrayList<PhieuNhap>();
				rs = buspn.findPhieuNhap(jtextTimKiem.getText());
				for (PhieuNhap pn : rs) {
					String maNCC = pn.getMaNCC();
					String tenNCC = busncc.getTenNCC(maNCC);
					modePhieuNhap.addRow(new Object[] {

							pn.getMaPhieuNhap(), tenNCC, pn.getMaNV(), pn.getNgayLap() });
				}
			} else {
				showTablePhieuNhap();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ");
			ex.printStackTrace();
		}
	}

	public void btnRefresh(ActionEvent e) {
		jtextTimKiem.setText("");
		showTablePhieuNhap();
		showTablePhieuNhap();
	}

	public void btnSuaPhieuNhap(ActionEvent e) {
		selectedIndex = tablePhieuNhap.getSelectedRow();
		if (selectedIndex != -1) {
			String maPhieuNhap = tablePhieuNhap.getValueAt(selectedIndex, 0).toString();
			//qlNhapHang.editPhieuNhap(maPhieuNhap);
			
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sữa.", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	
//	public void showChiTiet(ActionEvent e)
//	{
//		selectedIndex = tablePhieuNhap.getSelectedRow();
//		if (selectedIndex != -1) {
//			String maPhieuNhap = tablePhieuNhap.getValueAt(selectedIndex, 0).toString();
//			String tenNCC = tablePhieuNhap.getValueAt(selectedIndex, 1).toString();
//			int soLuong =  (int) tablePhieuNhap.getValueAt(selectedIndex, 2);
//			Date ngayLap =  (Date) tablePhieuNhap.getValueAt(selectedIndex, 3);
//			XemChiTietPhieuNhap ct = new XemChiTietPhieuNhap(maPhieuNhap,tenNCC,soLuong,(java.sql.Date) ngayLap);
//			ct.setVisible(true);
//		
//		} else {
//			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xem chi tiết.", "Thông báo",
//					JOptionPane.WARNING_MESSAGE);
//		}
//	}
}
