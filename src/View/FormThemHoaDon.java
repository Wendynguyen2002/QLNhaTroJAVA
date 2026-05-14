package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class FormThemHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormThemHoaDon frame = new FormThemHoaDon();
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
	public FormThemHoaDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb1 = new JLabel("Tiền phòng");
		lb1.setBounds(25, 118, 67, 13);
		contentPane.add(lb1);
		
		JLabel lb2 = new JLabel("Mã phòng");
		lb2.setBounds(25, 64, 45, 13);
		contentPane.add(lb2);
		
		JLabel lb3 = new JLabel("Mã hợp đồng");
		lb3.setBounds(25, 87, 67, 13);
		contentPane.add(lb3);
		
		JLabel lb4 = new JLabel("Tiền điện");
		lb4.setBounds(25, 141, 67, 13);
		contentPane.add(lb4);
		
		JLabel lb5 = new JLabel("Tiền nước");
		lb5.setBounds(25, 164, 67, 13);
		contentPane.add(lb5);
		
		JLabel lb6 = new JLabel("Tiền dịch vụ");
		lb6.setBounds(25, 187, 67, 13);
		contentPane.add(lb6);
		
		JLabel lb7 = new JLabel("Chỉ số điện");
		lb7.setBounds(162, 141, 67, 13);
		contentPane.add(lb7);
		
		JLabel lb8 = new JLabel("Chỉ số nước");
		lb8.setBounds(162, 164, 67, 13);
		contentPane.add(lb8);
		
		JLabel lb9 = new JLabel("Tổng tiền");
		lb9.setFont(new Font("Tahoma", Font.BOLD, 10));
		lb9.setBounds(25, 210, 67, 13);
		contentPane.add(lb9);
		
		JLabel lb10 = new JLabel("TẠO HOÁ ĐƠN");
		lb10.setForeground(new Color(0, 128, 192));
		lb10.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lb10.setHorizontalAlignment(SwingConstants.CENTER);
		lb10.setBounds(127, 10, 160, 41);
		contentPane.add(lb10);
		
		JLabel lb12 = new JLabel("Đơn giá");
		lb12.setBounds(309, 139, 67, 13);
		contentPane.add(lb12);
		
		JLabel lb11 = new JLabel("Đơn giá");
		lb11.setBounds(309, 162, 67, 13);
		contentPane.add(lb11);
		
		textField = new JTextField();
		textField.setBounds(99, 61, 141, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(99, 84, 141, 18);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(83, 115, 73, 18);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(83, 141, 73, 18);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(83, 164, 73, 18);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(83, 187, 73, 18);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(83, 207, 73, 18);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(226, 136, 73, 18);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(226, 159, 73, 18);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(353, 136, 73, 18);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(353, 159, 73, 18);
		contentPane.add(textField_10);

	}

}
