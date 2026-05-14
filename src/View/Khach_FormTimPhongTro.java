package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class Khach_FormTimPhongTro extends JFrame {

    private JTable tableHienThi;
    private JScrollPane scrollChuaTable;

    private JTextField txtGiaMin, txtGiaMax;
    private JTextField txtDTMin, txtDTMax;

    private JComboBox<String> cmbTinh;
    private JComboBox<String> cmbPhuong;
    private JButton btnShowall;
    private JButton btnDangKy;

    public Khach_FormTimPhongTro() {

        setTitle("Trang chủ - Easy Rent");
        setSize(760, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel PanelChinh = new JPanel(null);
        setContentPane(PanelChinh);

        JLabel title = new JLabel("WELCOME TO EASY RENT");
        title.setForeground(new Color(0, 128, 192));
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setBounds(270, 10, 300, 30);
        PanelChinh.add(title);

        // ================= TABLE =================
        tableHienThi = new JTable();
        tableHienThi.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã phòng", "Giá", "Trạng thái"}
        ));
        tableHienThi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollChuaTable = new JScrollPane(tableHienThi);
        scrollChuaTable.setBounds(150, 60, 570, 190);
        PanelChinh.add(scrollChuaTable);

        // ================= FILTER =================
        cmbTinh = new JComboBox<>(new String[]{"All", "Đà Nẵng", "Huế"});
        cmbTinh.setBounds(20, 285, 90, 25);
        PanelChinh.add(cmbTinh);

        cmbPhuong = new JComboBox<>(new String[]{"All", "Hải Châu", "Ngũ Hành Sơn"});
        cmbPhuong.setBounds(120, 285, 90, 25);
        PanelChinh.add(cmbPhuong);

        txtGiaMin = new JTextField();
        txtGiaMin.setBounds(220, 285, 80, 25);
        PanelChinh.add(txtGiaMin);

        txtGiaMax = new JTextField();
        txtGiaMax.setBounds(320, 285, 80, 25);
        PanelChinh.add(txtGiaMax);

        txtDTMin = new JTextField();
        txtDTMin.setBounds(420, 285, 80, 25);
        PanelChinh.add(txtDTMin);

        txtDTMax = new JTextField();
        txtDTMax.setBounds(520, 285, 80, 25);
        PanelChinh.add(txtDTMax);

        // ================= BUTTON =================
        JButton btnSearch = new JButton("Tìm kiếm");
        btnSearch.setBounds(610, 285, 120, 25);
        PanelChinh.add(btnSearch);

        btnDangKy = new JButton("Đăng ký thuê");
        btnDangKy.setBounds(10, 60, 130, 40);
        btnDangKy.setEnabled(false);
        PanelChinh.add(btnDangKy);

        btnShowall = new JButton("ShowAll");
        btnShowall.setBounds(10, 110, 130, 40);
        PanelChinh.add(btnShowall);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.setBounds(10, 160, 130, 40);
        PanelChinh.add(btnThoat);

        // ================= SHOW ALL =================
        btnShowall.addActionListener(e -> {
            List<PhongTro> list = PhongTroBUS.search(null, null, null, null, null, null);
            if (list == null) list = new ArrayList<>();
            loadTable(list);
        });

        // ================= SEARCH =================
        btnSearch.addActionListener(e -> {

            String tinh = normalize(cmbTinh.getSelectedItem());
            String phuong = normalize(cmbPhuong.getSelectedItem());

            Integer giaMin = parseInt(txtGiaMin.getText());
            Integer giaMax = parseInt(txtGiaMax.getText());
            Integer dtMin = parseInt(txtDTMin.getText());
            Integer dtMax = parseInt(txtDTMax.getText());

            List<PhongTro> list = PhongTroBUS.search(
                    tinh, phuong, giaMin, giaMax, dtMin, dtMax
            );

            if (list == null) list = new ArrayList<>();

            loadTable(list);
        });

        // ================= TABLE SELECT =================
        tableHienThi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableHienThi.getSelectedRow();
                btnDangKy.setEnabled(row != -1);
            }
        });

        // ================= OPEN REGISTER =================
        btnDangKy.addActionListener(e -> {

            int row = tableHienThi.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Chọn phòng trước!");
                return;
            }

            String maPhong = tableHienThi.getValueAt(row, 0).toString();

            new Khach_DangKyThue(maPhong).setVisible(true);
        });

        btnThoat.addActionListener(e -> dispose());
    }

    // ================= LOAD TABLE =================
    private void loadTable(List<PhongTro> list) {

        DefaultTableModel model = (DefaultTableModel) tableHienThi.getModel();
        model.setRowCount(0);

        for (PhongTro p : list) {
            model.addRow(new Object[]{
                    p.getMaPhong(),
                    p.getGia(),
                    p.getTrangThai()
            });
        }
    }

    // ================= HELPERS =================
    private String normalize(Object obj) {
        if (obj == null) return null;
        String v = obj.toString();
        return v.equals("All") ? null : v;
    }

    private Integer parseInt(String text) {
        try {
            if (text == null || text.trim().isEmpty()) return null;
            return Integer.parseInt(text.trim());
        } catch (Exception e) {
            return null;
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new Khach_FormTimPhongTro().setVisible(true)
        );
    }
}