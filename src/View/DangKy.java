package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import BUS.TaiKhoanBUS;
import DTO.DTOs.*;

public class DangKy extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPass;
	private TaiKhoanBUS bustk = new TaiKhoanBUS();
	
	private Login loginForm;
	public DangKy(Login loginForm) {
		this();
		this.loginForm = loginForm;
		
		
	}

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DangKy() {
		setTitle("Form DangKy");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // tắt đăng ký thì tắt đăng ký, o tắt cả App
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng ký tài khoản");
		lblNewLabel.setBounds(133, 27, 184, 27);
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(76, 97, 74, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(76, 145, 74, 27);
		contentPane.add(lblNewLabel_1_1);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(150, 102, 184, 18);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(150, 150, 184, 18);
		contentPane.add(txtPass);
		
		JButton btnDangKy = new JButton("Đăng ký");
		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText().trim();
				String pass =txtPass.getText().trim();
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
				

				ResultDTO dto = bustk.dangKy(username, pass);
				if(!dto.isSuccess()) {
					JOptionPane.showMessageDialog(null,dto.getMessage());
					return;
				}
				loginForm.setUsername(username);

				loginForm.setVisible(true);
				dispose();
				
			}
		});
		btnDangKy.setForeground(new Color(0, 128, 192));
		btnDangKy.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnDangKy.setBounds(179, 209, 96, 27);
		contentPane.add(btnDangKy);

	}

}
