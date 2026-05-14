package BUS;

import DAL.HoaDonDAL;
import DTO.DTOs.ResultDTO;
import DTO.entity.HoaDon;
import DTO.enums.TrangThaiHoaDon;

import java.util.ArrayList;
import java.util.List;

public class HoaDonBUS {

    private HoaDonDAL dal = new HoaDonDAL();

    // 1. GET ALL
    public ResultDTO getAll() {
        List<HoaDon> list = dal.getAll();
        return new ResultDTO(true, "Lấy danh sách thành công", list);
    }

    // 2. GET BY ID
    public ResultDTO getById(String maHoaDon) {
        if (maHoaDon == null || maHoaDon.trim().isEmpty())
            return new ResultDTO(false, "Mã hóa đơn không hợp lệ");

        HoaDon hd = dal.getById(maHoaDon);
        if (hd == null)
            return new ResultDTO(false, "Không tìm thấy hóa đơn");

        return new ResultDTO(true, "Tìm thấy hóa đơn", hd);
    }

    // 3. GET BY MA HOP DONG
    public ResultDTO getByMaHopDong(int maHopDong) {
        if (maHopDong <= 0)
            return new ResultDTO(false, "Mã hợp đồng không hợp lệ");

        List<HoaDon> list = dal.getByMaHopDong(maHopDong);
        return new ResultDTO(true, "Lấy danh sách thành công", list);
    }

    
    // 4. INSERT
    public ResultDTO insert(HoaDon hd) {
        if (hd == null)
            return new ResultDTO(false, "Hóa đơn không hợp lệ");
        if (hd.getMaHoaDon() == null || hd.getMaHoaDon().trim().isEmpty())
            return new ResultDTO(false, "Mã hóa đơn không được rỗng");
        if (hd.getMaHopDong() <= 0)
            return new ResultDTO(false, "Mã hợp đồng không hợp lệ");
        if (hd.getChiSoDienMoi() < hd.getChiSoDienCu())
            return new ResultDTO(false, "Chỉ số điện mới phải >= chỉ số cũ");
        if (hd.getChiSoNuocMoi() < hd.getChiSoNuocCu())
            return new ResultDTO(false, "Chỉ số nước mới phải >= chỉ số cũ");
        if (hd.getTienPhong() < 0)
            return new ResultDTO(false, "Tiền phòng không hợp lệ");
        if (hd.getTienDV() < 0)
            return new ResultDTO(false, "Tiền dịch vụ không hợp lệ");
        if (hd.getNgayLap() == null)
            return new ResultDTO(false, "Ngày lập không được rỗng");
        if (hd.getTrangThai() == null)
            return new ResultDTO(false, "Trạng thái không được rỗng");
        if (dal.checkTonTai(hd.getMaHoaDon()))
            return new ResultDTO(false, "Mã hóa đơn đã tồn tại");

        dal.insert(hd);
        return new ResultDTO(true, "Thêm hóa đơn thành công");
    }

    
    // 5. UPDATE
    public ResultDTO update(HoaDon hd) {
        if (hd == null)
            return new ResultDTO(false, "Hóa đơn không hợp lệ");
        if (hd.getMaHoaDon() == null || hd.getMaHoaDon().trim().isEmpty())
            return new ResultDTO(false, "Mã hóa đơn không được rỗng");
        if (hd.getMaHopDong() <= 0)
            return new ResultDTO(false, "Mã hợp đồng không hợp lệ");
        if (hd.getChiSoDienMoi() < hd.getChiSoDienCu())
            return new ResultDTO(false, "Chỉ số điện mới phải >= chỉ số cũ");
        if (hd.getChiSoNuocMoi() < hd.getChiSoNuocCu())
            return new ResultDTO(false, "Chỉ số nước mới phải >= chỉ số cũ");
        if (hd.getTienPhong() < 0)
            return new ResultDTO(false, "Tiền phòng không hợp lệ");
        if (hd.getTienDV() < 0)
            return new ResultDTO(false, "Tiền dịch vụ không hợp lệ");
        if (hd.getNgayLap() == null)
            return new ResultDTO(false, "Ngày lập không được rỗng");
        if (hd.getTrangThai() == null)
            return new ResultDTO(false, "Trạng thái không được rỗng");
        if (!dal.checkTonTai(hd.getMaHoaDon()))
            return new ResultDTO(false, "Hóa đơn không tồn tại");

        dal.update(hd);
        return new ResultDTO(true, "Cập nhật hóa đơn thành công");
    }

    
    // 6. DELETE
    public ResultDTO delete(String maHoaDon) {
        if (maHoaDon == null || maHoaDon.trim().isEmpty())
            return new ResultDTO(false, "Mã hóa đơn không hợp lệ");
        if (!dal.checkTonTai(maHoaDon))
            return new ResultDTO(false, "Hóa đơn không tồn tại");

        dal.delete(maHoaDon);
        return new ResultDTO(true, "Xóa hóa đơn thành công");
    }

    
    // 7. DELETE BY MA HOP DONG
    public ResultDTO deleteByMaHopDong(int maHopDong) {
        if (maHopDong <= 0)
            return new ResultDTO(false, "Mã hợp đồng không hợp lệ");

        dal.deleteByMaHopDong(maHopDong);
        return new ResultDTO(true, "Xóa hóa đơn theo hợp đồng thành công");
    }

    
    // 8. THANH TOAN
    public ResultDTO thanhToan(String maHoaDon) {
        if (maHoaDon == null || maHoaDon.trim().isEmpty())
            return new ResultDTO(false, "Mã hóa đơn không hợp lệ");

        HoaDon hd = dal.getById(maHoaDon);
        if (hd == null)
            return new ResultDTO(false, "Hóa đơn không tồn tại");
        if (hd.getTrangThai() == TrangThaiHoaDon.DaNop)
            return new ResultDTO(false, "Hóa đơn đã được thanh toán");

        hd.setTrangThai(TrangThaiHoaDon.DaNop);
        dal.update(hd);
        return new ResultDTO(true, "Thanh toán thành công");
    }

    
    // ========================
    // THỐNG KÊ DOANH THU
    // ========================

    public ResultDTO doanhThu(int maHopDong, Integer thang, Integer quy, Integer nam) {
        List<HoaDon> list = layDanhSach(maHopDong);
        double tong = 0;
        for (HoaDon hd : list) {
            if (hd.getTrangThai() != TrangThaiHoaDon.DaNop) continue;
            if (!locThoiGian(hd, thang, quy, nam)) continue;
            tong += hd.getTongTien();
        }
        return new ResultDTO(true, "Doanh thu", tong);
    }

    public ResultDTO getDanhSachDoanhThu(int maHopDong, Integer thang, Integer quy, Integer nam) {
        List<HoaDon> list = layDanhSach(maHopDong);
        List<HoaDon> ketQua = new ArrayList<>();
        for (HoaDon hd : list)
            if (locThoiGian(hd, thang, quy, nam))
                ketQua.add(hd);
        return new ResultDTO(true, "Danh sách hóa đơn", ketQua);
    }

    
    // ========================
    // CÔNG NỢ
    // ========================

    public ResultDTO getDSCongNo(int maHopDong, Integer thang, Integer quy, Integer nam) {
        List<HoaDon> list = layDanhSach(maHopDong);
        List<HoaDon> chuaNop = new ArrayList<>();
        for (HoaDon hd : list)
            if (hd.getTrangThai() == TrangThaiHoaDon.ChuaNop && locThoiGian(hd, thang, quy, nam))
                chuaNop.add(hd);
        return new ResultDTO(true, "Danh sách công nợ", chuaNop);
    }

    public ResultDTO tongCongNo(int maHopDong, Integer thang, Integer quy, Integer nam) {
        List<HoaDon> list = (List<HoaDon>) getDSCongNo(maHopDong, thang, quy, nam).getData();
        double tong = 0;
        for (HoaDon hd : list)
            tong += hd.getTongTien();
        return new ResultDTO(true, "Tổng công nợ", tong);
    }

    public int soNgayQuaHan(HoaDon hd) {
        long diff = java.time.LocalDate.now().toEpochDay() - hd.getNgayLap().toLocalDate().toEpochDay();
        return diff > 0 ? (int) diff : 0;
    }

    
    // ========================
    // HELPER
    // ========================

    private boolean locThoiGian(HoaDon hd, Integer thang, Integer quy, Integer nam) {
        if (nam != null && getNam(hd) != nam) return false;
        if (quy != null) {
            int thangBat = (quy - 1) * 3 + 1;
            int thangKet = thangBat + 2;
            if (getThang(hd) < thangBat || getThang(hd) > thangKet) return false;
        }
        if (thang != null && getThang(hd) != thang) return false;
        return true;
    }

    private List<HoaDon> layDanhSach(int maHopDong) {
        return maHopDong > 0 ? dal.getByMaHopDong(maHopDong) : dal.getAll();
    }

    private int getThang(HoaDon hd) {
        return hd.getNgayLap().toLocalDate().getMonthValue();
    }

    private int getNam(HoaDon hd) {
        return hd.getNgayLap().toLocalDate().getYear();
    }
}
