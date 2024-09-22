package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.BUSncc;
import DTO.NhaCungCap;

//import BUS.BUSncc;
//import DTO.NhaCungCap;


import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class QLNCC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtextTimKiem;
	private JTextField jtextMa;
	private JTextField jtextTen;
	private JTextField jtextSDT;
	private JTextField jtextDiaChi;
	private JTable table;
	
	private static DefaultTableModel model ;
	int selectedIndex ;
	BUSncc busncc = new BUSncc();
	private ArrayList<NhaCungCap> ncc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLNCC frame = new QLNCC();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public QLNCC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jpanelTimKiem = new JPanel();
		jpanelTimKiem.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpanelTimKiem.setBounds(423, 10, 551, 77);
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
		jbuttonRefresh.setBounds(430, 29, 111, 36);
		jpanelTimKiem.add(jbuttonRefresh);
		
		jtextTimKiem = new JTextField();
		jtextTimKiem.setBounds(10, 31, 301, 36);
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
				btnFindNCC(e);
			}
		});
		jbuttomSearch.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\search-icon (1).png"));
		jbuttomSearch.setBounds(328, 31, 92, 36);
		jpanelTimKiem.add(jbuttomSearch);
		
		JPanel jpanelChucNang = new JPanel();
		jpanelChucNang.setBackground(new Color(0, 0, 0));
		jpanelChucNang.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpanelChucNang.setBounds(30, 10, 368, 77);
		contentPane.add(jpanelChucNang);
		jpanelChucNang.setLayout(null);
		
		JButton jbuttomAdd = new JButton("");
		jbuttomAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddNcc(e);
			}
		});
		jbuttomAdd.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Button-Add-icon.png"));
		jbuttomAdd.setBounds(10, 10, 86, 57);
		jpanelChucNang.add(jbuttomAdd);
		
		JButton jbuttomDetele = new JButton("");
		jbuttomDetele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoa(e);
			}
		});
		jbuttomDetele.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\user-trash-full-icon.png"));
		jbuttomDetele.setBounds(133, 10, 86, 57);
		jpanelChucNang.add(jbuttomDetele);
		
		JButton jbuttomSua = new JButton("");
		jbuttomSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSuaNCC(e);
			}
		});
		jbuttomSua.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\settings-icon.png"));
		jbuttomSua.setBounds(254, 10, 92, 57);
		jpanelChucNang.add(jbuttomSua);
		
		JPanel jpanelInput = new JPanel();
		jpanelInput.setBackground(new Color(128, 255, 255));
		jpanelInput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpanelInput.setBounds(76, 111, 867, 94);
		contentPane.add(jpanelInput);
		jpanelInput.setLayout(null);
		
		JLabel jlabelMaNCC = new JLabel("Mã Nhà Cung Cấp");
		jlabelMaNCC.setHorizontalAlignment(SwingConstants.LEFT);
		jlabelMaNCC.setBackground(Color.WHITE);
		jlabelMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlabelMaNCC.setForeground(Color.BLACK);
		jlabelMaNCC.setBounds(31, 10, 105, 32);
		jpanelInput.add(jlabelMaNCC);
		
		jtextMa = new JTextField();
		jtextMa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!checkMaNCC(jtextMa.getText()))
				{
					JOptionPane.showMessageDialog(jtextMa, "Sai định dạng "); 
					//jtextMa.requestFocus();
				}
			}
		});
		jtextMa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextMa.setBounds(158, 12, 254, 32);
		jpanelInput.add(jtextMa);
		jtextMa.setColumns(10);
		
		JLabel jlableTenNCC = new JLabel("Tên Nhà Cung Cấp:");
		jlableTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlableTenNCC.setBounds(31, 52, 105, 32);
		jpanelInput.add(jlableTenNCC);
		
		jtextTen = new JTextField();
		jtextTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextTen.setBounds(158, 54, 254, 32);
		jpanelInput.add(jtextTen);
		jtextTen.setColumns(10);
		
		JLabel jlableSDT = new JLabel("Số điện thoại:");
		jlableSDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlableSDT.setBounds(444, 10, 95, 32);
		jpanelInput.add(jlableSDT);
		
		jtextSDT = new JTextField();
		jtextSDT.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!checkSDT(jtextSDT.getText()))
				{
					JOptionPane.showMessageDialog(jtextSDT, "Sai định dạng "); 
					jtextSDT.requestFocus();
				}
			}
		});
		jtextSDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextSDT.setBounds(549, 10, 205, 32);
		jpanelInput.add(jtextSDT);
		jtextSDT.setColumns(10);
		
		JLabel jlableDiaChi = new JLabel("Địa chỉ:");
		jlableDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlableDiaChi.setBounds(444, 52, 55, 32);
		jpanelInput.add(jlableDiaChi);
		
		jtextDiaChi = new JTextField();
		jtextDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextDiaChi.setBounds(509, 52, 245, 27);
		jpanelInput.add(jtextDiaChi);
		jtextDiaChi.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(53, 233, 918, 318);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
			new String[] {
				"Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ"
			}
		) 
		
		);
		table.getColumnModel().getColumn(0).setPreferredWidth(87);
		table.getColumnModel().getColumn(1).setPreferredWidth(187);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(91);
		table.getColumnModel().getColumn(3).setPreferredWidth(179);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jTableMouseClicked(e);
			}
		});
		model = (DefaultTableModel) table.getModel();
		showTable();
		
	}
	
	public void showTable()
	{
		 clearTable();
		 ncc = busncc.getListNCC();
		 for(NhaCungCap ncc : ncc)
		 {
			 model.addRow(new Object[]{
					 ncc.getMaNCC(),ncc.getTenNCC(),ncc.getPhoneNumber(),ncc.getAddress() });
		 }
		 
	}
	
	public void clearTable() {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0); // Xóa hết các dòng trên JTable
	}
	
	public void btnAddNcc(ActionEvent evt)
	{
		try {
			if (jtextMa.getText().isEmpty() || jtextTen.getText().isEmpty() || jtextDiaChi.getText().isEmpty() || jtextSDT.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Vui lòng nhập đủ thông tin");
			}
			else
			{
					NhaCungCap ncc = new NhaCungCap();
					ncc.setMaNCC(jtextMa.getText());
					ncc.setTenNCC(jtextTen.getText());
					ncc.setPhoneNumber(jtextSDT.getText());
					ncc.setAddress(jtextDiaChi.getText());
					JOptionPane.showMessageDialog(this, busncc.addNCC(ncc));
					showTable();
			}	
		}catch (Exception  ex) {
			JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ"); 
			ex.printStackTrace();
		}
	}
	
	public void btnXoa(ActionEvent evt)
	{
		selectedIndex=table.getSelectedRow();
		if(selectedIndex>=0){
			NhaCungCap nc = ncc.get(selectedIndex);
			JOptionPane.showConfirmDialog(this , "Bạn có muốn xóa không");
	        JOptionPane.showMessageDialog(this, busncc.deleteNCC(nc));
	        showTable();
		}
	}
	
	private void jTableMouseClicked (MouseEvent evt) {
		selectedIndex=table.getSelectedRow();
		if (selectedIndex>=0){
			jtextMa.setText(model.getValueAt(selectedIndex, 0).toString());
			jtextTen.setText(model.getValueAt(selectedIndex, 1).toString());
			jtextSDT.setText(model.getValueAt(selectedIndex, 2).toString());
			jtextDiaChi.setText(model.getValueAt(selectedIndex, 3).toString());
			jtextMa.setEnabled(false);
		}
	}
	
	public void btnSuaNCC(ActionEvent evt) {
	    try {
	    	  String maNCC = jtextMa.getText();
	          String tenNCC = jtextTen.getText();
	          String sdt = jtextSDT.getText();
	          String diaChi = jtextDiaChi.getText();
	        if (jtextMa.getText().isEmpty() || jtextTen.getText().isEmpty() || jtextDiaChi.getText().isEmpty() || jtextSDT.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
	        } else {
	        	
	        	NhaCungCap nccToUpdate = new NhaCungCap();
	            nccToUpdate.setMaNCC(maNCC); // Giữ nguyên mã nhà cung cấp
	            nccToUpdate.setTenNCC(tenNCC);
	            nccToUpdate.setPhoneNumber(sdt);
	            nccToUpdate.setAddress(diaChi);

	            // Gọi phương thức cập nhật từ BUS và nhận kết quả thông báo
	            String message = busncc.updateNCC(nccToUpdate);

	            // Hiển thị thông báo kết quả sau khi cập nhật
	            JOptionPane.showMessageDialog(this, message);

	            // Sau khi cập nhật thành công, làm mới bảng và reset trạng thái các trường nhập
	            showTable();
	            resetFields();
	        }
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ");
	        ex.printStackTrace();
	    }
	}
	
	public boolean checkMaNCC(String ma) {
	    String id = ma.trim();
	    String check = "^(NCC)\\d{3}$";
	    return id.matches(check);
	}
	
	public boolean checkSDT(String sdt)
	{
		String phone = sdt.trim();
	    String check = "^(0)\\d{9}$";
	    return phone.matches(check);
	}
	
	public void btnFindNCC(ActionEvent evt)
	{
		clearTable();
		try
		{
			if(!jtextTimKiem.getText().isEmpty())
			{	
				ArrayList<NhaCungCap> rs = new ArrayList<NhaCungCap>();
				rs = busncc.findNCCByNameOrId(jtextTimKiem.getText());
				for(NhaCungCap ncc : rs)
				 {
					 model.addRow(new Object[]{
							 ncc.getMaNCC(),ncc.getTenNCC(),ncc.getPhoneNumber(),ncc.getAddress() });
				 }
			}
			else
			{
				showTable();
			}
		}catch (Exception  ex) {
			JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ"); 
			ex.printStackTrace();
		}
	}
	
	public void btnRefresh(ActionEvent evt)
	{
		jtextMa.setText("");
		jtextTen.setText("");
		jtextSDT.setText("");
		jtextDiaChi.setText("");
		jtextTimKiem.setText("");
		showTable();
		jtextMa.setEnabled(true);
	}
	
	public void resetFields() {
	    jtextMa.setText("");
	    jtextTen.setText("");
	    jtextSDT.setText("");
	    jtextDiaChi.setText("");

	    // Sau khi cập nhật xong, vô hiệu hóa lại trường MaNCC để người dùng không thể chỉnh sửa nữa
	    jtextMa.setEnabled(true);
	}
	
}
