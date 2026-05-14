package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import BUS.*;
import DTO.DTOs.*;
import DTO.entity.*;
import security.*;
import javax.swing.JPasswordField;
import java.awt.Font;


public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPass;
	
	
	private TaiKhoanBUS busTK = new TaiKhoanBUS();
	public void setUsername(String username) {

		txtUsername.setText(username);

	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		
		// Sự kiện bấm nút Đăng nhập
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText().trim();
				String pass = new String(txtPass.getPassword());
				if(username.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Nhập lại username");
					txtUsername.requestFocus();
					return;
				}
				if(pass.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Nhập lại mật khẩu");
					txtPass.requestFocus();
					return;
				}
				

				ResultDTO dto = busTK.dangNhap(username,pass);
				
				if(!dto.isSuccess()) {
					JOptionPane.showMessageDialog(null,dto.getMessage());
					return;
				}
				
				TaiKhoan tk = (TaiKhoan)dto.getData();
				Auth.login(tk); 				// Auth-> chuyển user Tk cho Sessiom->  Lưu user cho toàn app dùng . Vì khái báo: Session.userHienTai = tk;
				if(tk.getRole() == 0) {

					new FormChuTro().setVisible(true);

				}
				else {
					new FormKhach().setVisible(true);
				}
				dispose();
			}
		});
		
		btnDangNhap.setBackground(new Color(240, 240, 240));
		btnDangNhap.setBounds(123, 189, 84, 20);
		contentPane.add(btnDangNhap);
		
		JButton btnDangKy = new JButton("Đăng ký");
		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangKy dK = new DangKy(Login.this);
				dK.setVisible(true);
			}
		});
		btnDangKy.setBackground(UIManager.getColor("Button.background"));
		btnDangKy.setBounds(245, 189, 84, 20);
		contentPane.add(btnDangKy);
		
		txtUsername = new JTextField();
		txtUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtUsername.setBounds(123, 97, 206, 18);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setBounds(42, 100, 75, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setBounds(42, 143, 75, 15);
		contentPane.add(lblMtKhu);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME TO EASY RENT");
		lblNewLabel_1.setForeground(new Color(0, 128, 192));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(123, 30, 206, 36);
		contentPane.add(lblNewLabel_1);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(123, 141, 206, 18);
		contentPane.add(txtPass);

	}
}
