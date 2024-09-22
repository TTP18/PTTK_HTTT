package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Date;

import javax.swing.JTree;
import javax.swing.JList;

public class XemChiTietPhieuNhap extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	private static DefaultTableModel modelChiTiet;
	QLNhapHang qlNhapHang = new QLNhapHang();
	private String maPhieuNhap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			/*
			 * XemChiTietPhieuNhap dialog = new XemChiTietPhieuNhap("PN08","adc","ưa","Ư");
			 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 * dialog.setVisible(true);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public XemChiTietPhieuNhap(String maPhieuNhap,String tenNCC, int soluong, Date  ngayLap) {
		
		setBounds(100, 100, 955, 700);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 941, 515);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 941, 66);
			panel.setBackground(new Color(0, 204, 51));
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Chi Tiết Phiếu Nhập");
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(267, 0, 361, 64);
				panel.add(lblNewLabel);
			}
		}
		
		JLabel lblNewLabel_1 = new JLabel("Mã Phiếu:");
		lblNewLabel_1.setBounds(10, 100, 68, 32);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		contentPanel.add(lblNewLabel_1);
		
		JLabel jlableMaPhieu = new JLabel("");
		jlableMaPhieu.setBounds(112, 100, 68, 32);
		jlableMaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlableMaPhieu.setText(maPhieuNhap);
		contentPanel.add(jlableMaPhieu);
		
		JLabel lblNewLabel_2 = new JLabel("Nhà cung cấp:");
		lblNewLabel_2.setBounds(10, 153, 102, 32);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_2);
		
		JLabel jlabelTenNCC = new JLabel("New label");
		jlabelTenNCC.setBounds(137, 153, 230, 32);
		jlabelTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlabelTenNCC.setText(tenNCC);
		contentPanel.add(jlabelTenNCC);
		
		JLabel lblNewLabel_4 = new JLabel("Số lượng:");
		lblNewLabel_4.setBounds(553, 100, 84, 32);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_4);
		
		JLabel jlableSoLuong = new JLabel("New label");
		jlableSoLuong.setBounds(662, 100, 107, 32);
		jlableSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlableSoLuong.setText(String.valueOf(soluong));
		contentPanel.add(jlableSoLuong);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày lập:");
		lblNewLabel_6.setBounds(553, 153, 90, 32);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_6);
		
		JLabel jlableNgayLap = new JLabel("New label");
		jlableNgayLap.setBounds(662, 159, 84, 25);
		jlableNgayLap.setText(ngayLap.toString());
		contentPanel.add(jlableNgayLap);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 217, 921, 250);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"M\u00E3 thu\u1ED1c", "T\u00EAn thu\u1ED1c", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(69);
		table.getColumnModel().getColumn(1).setPreferredWidth(219);
		table.getColumnModel().getColumn(2).setPreferredWidth(67);
		table.getColumnModel().getColumn(3).setPreferredWidth(55);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		modelChiTiet = (DefaultTableModel) table.getModel();
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 515, 941, 31);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			buttonPane.setVisible(false);
		}
		showChiTiet(maPhieuNhap);
		
		
	}
	public void showChiTiet(String maPhieuNhap)
	{
			
		qlNhapHang.setMaPhieuNhap(maPhieuNhap);
		qlNhapHang.showTableNhap(modelChiTiet);
	}
}
