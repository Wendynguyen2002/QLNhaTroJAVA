package View;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import BUS.*;
import DTO.DTOs.*;

public class Khach_DangKyThue extends JFrame {
	
	private String maPhong;

    private JPanel PanelChung;
    private JScrollPane scrollPane;
    private JPanel panel0, panel1, panel2, panel3;

    private JTextField txtTenTK;
    private JTextField txtPass;
    private JTextField txtCCCD;
    private JTextField txtTen;
    private JTextField txtNgaySinh;
    private JTextField txtQue;
    private JTextField txtNgheNghiep;
    private JTextField txtTienCoc;

    private ButtonGroup groupAcc;
    private ButtonGroup groupGender;
    
    public Khach_DangKyThue() {
        this(null);
    }

    public Khach_DangKyThue(String maPhong) {
        this.maPhong = maPhong;
        initComponents();
    }

    public void initComponents() {
    	
    	
    	
    	

        setTitle("Đăng ký thuê phòng");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);

        // ================= ROOT =================
        PanelChung = new JPanel();
        PanelChung.setLayout(null);
        PanelChung.setPreferredSize(new Dimension(430, 650));

        scrollPane = new JScrollPane(PanelChung);
        setContentPane(scrollPane);
        
        

        // ======================================================
        // ================= PANEL 0 (GIỮ NGUYÊN 100%) ==========
        // ======================================================
        JPanel panel0 = new JPanel();
        panel0.setBounds(10, 10, 414, 149);
        panel0.setLayout(null);
        PanelChung.add(panel0);

        JLabel lblNewLabel = new JLabel("Form đăng ký thuê");
        lblNewLabel.setForeground(new Color(0, 128, 192));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(105, 0, 178, 26);
        panel0.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Phòng");
        lblNewLabel_1.setBounds(10, 46, 58, 12);
        panel0.add(lblNewLabel_1);

        JLabel lblNewLabel2 = new JLabel("Tên nhà trọ");
        lblNewLabel2.setBounds(10, 68, 68, 12);
        panel0.add(lblNewLabel2);

        JLabel lblNewLabel3 = new JLabel("Địa chỉ");
        lblNewLabel3.setBounds(10, 90, 44, 12);
        panel0.add(lblNewLabel3);

        JLabel lblNewLabel4 = new JLabel("Diện tích");
        lblNewLabel4.setBounds(10, 112, 58, 12);
        panel0.add(lblNewLabel4);

        JLabel lblNewLabel5 = new JLabel("Thông tin khác");
        lblNewLabel5.setBounds(10, 134, 79, 12);
        panel0.add(lblNewLabel5);

        JLabel lblNewLabe7 = new JLabel("SĐT chủ trọ");
        lblNewLabe7.setBounds(204, 112, 79, 12);
        panel0.add(lblNewLabe7);

        JLabel lbThongtin = new JLabel("");
        lbThongtin.setBounds(95, 134, 309, 12);
        panel0.add(lbThongtin);

        JLabel lbDTich = new JLabel("");
        lbDTich.setBounds(78, 112, 68, 12);
        panel0.add(lbDTich);

        JLabel lbDChi = new JLabel("");
        lbDChi.setBounds(73, 90, 298, 12);
        panel0.add(lbDChi);

        JLabel lbTenNhaTro = new JLabel("");
        lbTenNhaTro.setBounds(78, 68, 210, 12);
        panel0.add(lbTenNhaTro);

        JLabel lbPhong = new JLabel("");
        lbPhong.setBounds(78, 46, 135, 12);
        panel0.add(lbPhong);

        JLabel lblNewLabel6 = new JLabel("m^2");
        lblNewLabel6.setBounds(150, 112, 27, 12);
        panel0.add(lblNewLabel6);

        JLabel lbSDT = new JLabel("");
        lbSDT.setBounds(269, 112, 135, 12);
        panel0.add(lbSDT);
        
        
        // Điền thông tin phòng đang chọn
        
        lbPhong.setText(maPhong);

        // ======================================================
        // ================= PANEL 1 ============================
        // ======================================================
        JPanel panel1 = new JPanel();
        panel1.setBounds(10, 167, 414, 129);
        panel1.setLayout(null);
        PanelChung.add(panel1);

        JLabel lblNewLabe9 = new JLabel("Tên tài khoản");
        lblNewLabe9.setBounds(10, 44, 79, 12);
        panel1.add(lblNewLabe9);

        JLabel lblNewLabel10 = new JLabel("Mật khẩu");
        lblNewLabel10.setBounds(10, 74, 79, 12);
        panel1.add(lblNewLabel10);

        txtTenTK = new JTextField();
        txtTenTK.setBounds(87, 41, 173, 18);
        panel1.add(txtTenTK);

        txtPass = new JTextField();
        txtPass.setBounds(87, 71, 173, 18);
        panel1.add(txtPass);

        //======KHI CLICK YES / NO
        JRadioButton radianYes = new JRadioButton("Có");
        radianYes.setBounds(95, 6, 51, 20);
        panel1.add(radianYes);

        
        
        
        JRadioButton radianNo = new JRadioButton("Không");
        radianNo.setBounds(148, 6, 79, 20);
        panel1.add(radianNo);
        groupAcc = new ButtonGroup();
        groupAcc.add(radianYes);
        groupAcc.add(radianNo);
        radianYes.setSelected(true);
        
        radianYes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		txtTenTK.setEnabled(true);
        	    txtPass.setEnabled(true);
 	
        	}
        });
        
        
        
        radianNo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(Khach_DangKyThue.this,
        		        "Chuyển sang form đăng ký tài khoản...");

        		new DangKy().setVisible(true);
        		Khach_DangKyThue.this.dispose();
        	}
        });
        

        

        JButton btnOK1 = new JButton("OK");
        btnOK1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (radianYes.isSelected()) {

        		    String user = txtTenTK.getText();
        		    String pass = txtPass.getText();

        		    TaiKhoanBUS tk = new TaiKhoanBUS();

        		    boolean ok = tk.dangNhap(user, pass).isSuccess();

        		    if (ok) {
        		        panel2.setVisible(true);
        		    } else {
        		        JOptionPane.showMessageDialog(Khach_DangKyThue.this, "Sai tài khoản!");
        		    }

        		} else {
        		    panel2.setVisible(true);
        		}
        		
        	}
        });
        btnOK1.setBounds(266, 99, 64, 20);
        panel1.add(btnOK1);

        JButton btnHu1 = new JButton("Huỷ");
        btnHu1.setBounds(340, 99, 64, 20);
        panel1.add(btnHu1);

       
        
        // ======================================================
        // ================= PANEL 2 (CCCD) =====================
        // ======================================================
        JPanel panel2 = new JPanel();
        panel2.setBounds(10, 306, 414, 68);
        panel2.setLayout(null);
        PanelChung.add(panel2);

        JLabel lblNewLabel11 = new JLabel("Nhập CCCD");
        lblNewLabel11.setBounds(10, 10, 79, 12);
        panel2.add(lblNewLabel11);

        txtCCCD = new JTextField();
        txtCCCD.setBounds(87, 7, 173, 18);
        panel2.add(txtCCCD);

        JButton btnOK2 = new JButton("OK");
        btnOK2.setBounds(266, 38, 64, 20);
        panel2.add(btnOK2);

        JButton btnHu2 = new JButton("Huỷ");
        btnHu2.setBounds(340, 38, 64, 20);
        panel2.add(btnHu2);

        // ======================================================
        // ================= PANEL 3 ============================
        // ======================================================
        JPanel panel3 = new JPanel();
        panel3.setBounds(10, 384, 414, 206);
        panel3.setLayout(null);
        PanelChung.add(panel3);

        JLabel lblNewLabel12 = new JLabel("Họ tên");
        lblNewLabel12.setBounds(10, 20, 59, 12);
        panel3.add(lblNewLabel12);

        JLabel lblNewLabel13 = new JLabel("Ngày sinh");
        lblNewLabel13.setBounds(10, 42, 59, 12);
        panel3.add(lblNewLabel13);

        JLabel lblNewLabe14 = new JLabel("Quê quán");
        lblNewLabe14.setBounds(10, 101, 59, 12);
        panel3.add(lblNewLabe14);

        JLabel lb15 = new JLabel("Nghề nghiệp");
        lb15.setBounds(10, 123, 76, 12);
        panel3.add(lb15);

        JLabel lb16 = new JLabel("Số tiền đặt cọc");
        lb16.setBounds(10, 145, 76, 12);
        panel3.add(lb16);

        txtTen = new JTextField();
        txtTen.setBounds(85, 17, 173, 18);
        panel3.add(txtTen);

        txtNgaySinh = new JTextField();
        txtNgaySinh.setBounds(85, 39, 173, 18);
        panel3.add(txtNgaySinh);

        txtQue = new JTextField();
        txtQue.setBounds(85, 98, 173, 18);
        panel3.add(txtQue);

        txtNgheNghiep = new JTextField();
        txtNgheNghiep.setBounds(85, 120, 173, 18);
        panel3.add(txtNgheNghiep);

        txtTienCoc = new JTextField();
        txtTienCoc.setBounds(85, 145, 173, 18);
        panel3.add(txtTienCoc);

        // GIỚI TÍNH
        JRadioButton rNam = new JRadioButton("Nam");
        rNam.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        rNam.setBounds(85, 72, 59, 20);
        panel3.add(rNam);

        JRadioButton rNu = new JRadioButton("Nữ");
        rNu.setBounds(146, 72, 47, 20);
        panel3.add(rNu);

        JRadioButton rKhac = new JRadioButton("Khác");
        rKhac.setBounds(203, 72, 55, 20);
        panel3.add(rKhac);

        groupGender = new ButtonGroup();
        groupGender.add(rNam);
        groupGender.add(rNu);
        groupGender.add(rKhac);

        JButton btnXacNhanNop = new JButton("Xác nhận nộp");
        btnXacNhanNop.setBounds(288, 161, 116, 35);
        panel3.add(btnXacNhanNop);

        
        panel0.setVisible(true);
        panel1.setVisible(true);
        panel2.setVisible(false);
        panel3.setVisible(false);
     // lock input ban đầu
        txtTenTK.setEnabled(false);
        txtPass.setEnabled(false);
        
        JLabel lblCTi = new JLabel("Đã có tài khoản");
        lblCTi.setBounds(10, 10, 79, 12);
        panel1.add(lblCTi);

        // ======================================================
        // ================= LOGIC CCCD =========================
        // ======================================================
        btnOK2.addActionListener(e -> {

            String cccd = txtCCCD.getText().trim();

            if (cccd.isEmpty()) {
                JOptionPane.showMessageDialog(Khach_DangKyThue.this, "Nhập CCCD!");
                return;
            }

            Khach k = KhachBUS.findByCCCD(cccd);

            if (k == null) {
                JOptionPane.showMessageDialog(Khach_DangKyThue.this, "CCCD không tồn tại!");
                return;
            }

            txtTen.setText(k.getHoTen());
            txtNgaySinh.setText(k.getNgaySinh());
            txtQue.setText(k.getQueQuan());
            txtNgheNghiep.setText(k.getNgheNghiep());

            panel3.setVisible(true);
        });

        // ======================================================
        // ================= XÁC NHẬN ===========================
        // ======================================================
        btnXacNhanNop.addActionListener(e -> {

            String ten = txtTen.getText();
            String cccd = txtCCCD.getText();
            String tienCoc = txtTienCoc.getText();

            boolean ok = HopDongBUS.taoHopDong(ten, cccd, tienCoc); // Tái form tạo hợp đồng THÁI 

            if (ok) {
                JOptionPane.showMessageDialog(this, "Nộp thành công!");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi khi tạo hợp đồng!");
            }
        });

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    // fake DB
    static class Khach {
        String ten, ngaySinh, que, nghe;

        Khach(String t, String ns, String q, String n) {
            ten = t;
            ngaySinh = ns;
            que = q;
            nghe = n;
        }
    }

    private Khach fakeFind(String cccd) {
        if (cccd.equals("123")) {
            return new Khach("Nguyễn A", "2000-01-01", "Đà Nẵng", "IT");
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Khach_DangKyThue().setVisible(true));
    }
}