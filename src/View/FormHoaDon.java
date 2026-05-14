package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class FormHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormHoaDon frame = new FormHoaDon();
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
	public FormHoaDon() {
		setTitle("FormQLHoaDon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 63, 416, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBounds(20, 272, 84, 30);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setBounds(120, 274, 84, 28);
		contentPane.add(btnSa);
		
		JButton btnXo = new JButton("Xoá");
		btnXo.setBounds(217, 274, 84, 28);
		contentPane.add(btnXo);
		
		JButton btnShow = new JButton("Show");
		btnShow.setBounds(317, 274, 84, 28);
		contentPane.add(btnShow);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(274, 33, 84, 20);
		contentPane.add(btnSearch);
		
		textField = new JTextField();
		textField.setBounds(10, 35, 110, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(138, 34, 110, 18);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Mã phòng");
		lblNewLabel.setBounds(10, 13, 84, 12);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnhTrngHo = new JLabel("Tình trạng Hoá đơn");
		lblTnhTrngHo.setBounds(141, 13, 107, 12);
		contentPane.add(lblTnhTrngHo);

	}
}
