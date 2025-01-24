-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table quanlynhansu.bacluong: ~15 rows (approximately)
INSERT INTO `bacluong` (`he_so_luong`, `ma_bac_luong`, `phu_cap_vuot_khung`, `id`, `ngach_cong_chuc_id`)
VALUES (6.2, 1, 0, 1, 1),
       (6.56, 2, 0, 2, 1),
       (6.92, 3, 0.5, 3, 1),
       (4.4, 1, 0, 4, 2),
       (4.74, 2, 0.3, 5, 2),
       (5.08, 3, 0.6, 6, 2),
       (2.34, 1, 0, 7, 3),
       (2.67, 2, 0.2, 8, 3),
       (3, 3, 0.4, 9, 3),
       (1.86, 1, 0, 10, 4),
       (2.1, 2, 0.2, 11, 4),
       (2.34, 3, 0.4, 12, 4),
       (1.5, 1, 0, 13, 5),
       (1.7, 2, 0.1, 14, 5),
       (1.9, 3, 0.2, 15, 5);

-- Dumping data for table quanlynhansu.bomon: ~16 rows (approximately)
INSERT INTO `bomon` (`don_vi_chuc_nang_id`, `id`, `ten_bo_mon`)
VALUES (1, 1, 'An toàn thông tin'),
       (1, 2, 'Công nghệ phần mềm'),
       (1, 3, 'Hệ thống thông tin'),
       (1, 4, 'Khoa học dữ liệu'),
       (1, 5, 'Kỹ thuật máy tính'),
       (1, 6, 'Trí tuệ nhân tạo'),
       (2, 7, 'Kế toán'),
       (2, 8, 'Quản trị kinh doanh'),
       (2, 9, 'Tài chính - Ngân hàng'),
       (3, 10, 'Cơ khí chế tạo'),
       (3, 11, 'Cơ điện tử'),
       (3, 12, 'Điện tử viễn thông'),
       (3, 13, 'Tự động hóa'),
       (4, 14, 'Tiếng Anh'),
       (4, 15, 'Tiếng Nhật'),
       (4, 16, 'Tiếng Trung');

-- Dumping data for table quanlynhansu.canbo: ~1 rows (approximately)
INSERT INTO `canbo` (`can_nang`, `chieu_cao`, `enabled`, `ngay_cap_cmnd`, `ngay_huong`, `ngay_nhan_hoc_ham`,
                     `ngay_nhan_hoc_vi`, `ngay_nhap_ngu`, `ngay_sinh`, `ngay_thoi_viec`, `ngay_tuyen_dung`,
                     `ngay_vao_dcsvn_chinh_thuc`, `ngay_vao_dcsvn_du_bi`, `ngay_ve_huu`, `ngay_xuat_ngu`, `phu_caidhac`,
                     `phu_cap_chuc_vu`, `so_truong_cong_tac`, `version`, `bac_luong_id`, `bo_mon_id`, `chuc_vu_id`,
                     `dan_toc_id`, `don_vi_chuc_nang_id`, `id`, `ngach_cong_chuc_id`, `ton_giao_id`, `chuc_danh`,
                     `co_quan_tuyen_dung`, `cong_viec_duoc_giao`, `danh_hieu_phong_tang`, `gioi_tinh`, `hoc_ham`,
                     `hoc_vi`, `image_url`, `khen_thuong`, `ky_luat`, `la_con_gia_dinh_chinh_sach`, `la_thuong_binh`,
                     `ly_luan_chinh_tri`, `nghe_nghieidhi_tuyen_dung`, `ngoai_ngu`, `nhan_xet`, `nhom_mau`,
                     `noi_cap_cmnd`, `noi_sinh`, `noidkho_khau_thuong_tru`, `noiohien_nay`, `quan_ham_cao_nhat`,
                     `quan_ly_nha_nuoc`, `so_bao_hiem_xh`, `so_cmnd`, `so_hieu`, `ten`, `ten_goi_khac`,
                     `tham_gia_to_chuc_ctxh`, `tin_hoc`, `tinh_trang_suc_khoe`, `trinh_do_chuyen_mon`,
                     `trinh_do_giao_duc_pt`)
VALUES (65, 170, b'1', '2000-01-01', '2025-06-01', '2022-01-01', '2020-01-01', '2010-06-01', '1985-01-01', NULL,
        '2025-01-24', '2014-01-01', '2012-01-01', '2030-01-01', '2015-06-01', 0.2, 0.5, 5, 1, 1, 1, 23, 48, 10, 1, 2, 7,
        'Trưởng phòng', 'Đại học Quốc gia', 'Giảng viên', 'Chiến sĩ thi đua cấp Bộ', 'Nam', 'Phó giáo sư', 'Thạc sĩ',
        'https://example.com/image.jpg', 'Bằng khen Thủ tướng', 'Không', 'Có', 'Không', 'Cao cấp', 'Kỹ sư phần mềm',
        'Tiếng Anh', 'Nhiệt tình, trách nhiệm', 'O', 'Hà Nội', 'Hà Nội', 'Số 1, Đường ABC, Hà Nội',
        'Số 10, Đường XYZ, Hà Nội', 'Đại tá', 'Chuyên viên', '012345678901', '0123456789', 'CB001', 'Nguyen Van A',
        'Van A', 'Hội Chữ thập đỏ', 'Chứng chỉ B', 'Tốt', 'Thạc sĩ', '12/12');

-- Dumping data for table quanlynhansu.chucvu: ~31 rows (approximately)
INSERT INTO `chucvu` (`version`, `id`, `ten_chuc_vu`)
VALUES (1, 1, 'Giám đốc nhân sự (CHRO - Chief Human Resources Officer)'),
       (1, 2, 'Phó giám đốc nhân sự'),
       (1, 3, 'Trưởng phòng nhân sự'),
       (1, 4, 'Phó phòng nhân sự'),
       (1, 5, 'Chuyên viên tuyển dụng'),
       (1, 6, 'Chuyên viên đào tạo và phát triển nhân sự'),
       (1, 7, 'Chuyên viên phúc lợi và đãi ngộ'),
       (1, 8, 'Chuyên viên quản lý hiệu suất'),
       (1, 9, 'Chuyên viên quản lý hồ sơ nhân sự'),
       (1, 10, 'Chuyên viên quản lý tiền lương'),
       (1, 11, 'Chuyên viên quan hệ lao động'),
       (1, 12, 'Nhân viên hành chính nhân sự'),
       (1, 13, 'Nhân viên quản lý hồ sơ nhân viên'),
       (1, 14, 'Nhân viên tính lương'),
       (1, 15, 'Trưởng khoa'),
       (1, 16, 'Phó trưởng khoa'),
       (1, 17, 'Trưởng bộ môn'),
       (1, 18, 'Phó trưởng bộ môn'),
       (1, 19, 'Giảng viên chính'),
       (1, 20, 'Giảng viên'),
       (1, 21, 'Trợ giảng'),
       (1, 22, 'Nghiên cứu viên'),
       (1, 23, 'Chuyên viên đào tạo'),
       (1, 24, 'Chuyên viên phát triển chương trình đào tạo'),
       (1, 25, 'Chuyên viên tư vấn đào tạo'),
       (1, 26, 'Trưởng bộ phận đào tạo'),
       (1, 27, 'Phó bộ phận đào tạo'),
       (1, 28, 'Quản lý chương trình đào tạo nội bộ'),
       (1, 29, 'Chuyên viên đào tạo nội bộ'),
       (1, 30, 'Huấn luyện viên doanh nghiệp'),
       (1, 31, 'Chuyên viên phát triển tổ chức');

-- Dumping data for table quanlynhansu.danhsachkhoangon: ~0 rows (approximately)
INSERT INTO `danhsachkhoangon` (`ngay_ky_hop_dong`, `version`, `don_vi_chuc_nang_id`, `id`, `dia_chi`, `ho_ten_can_bo`,
                                `so_cmnd`, `so_dien_thoai`)
VALUES ('2025-01-24', 1, 1, 1, 'Hà Nội', 'Nguyễn Văn A', '012345678', '0987654321'),
       ('2025-01-24', 1, 7, 2, 'TP. Hồ Chí Minh', 'Phạm Thị D', '012345682', '0987654325'),
       ('2025-01-24', 1, 10, 3, 'Đà Nẵng', 'Trần Thị H', '012345685', '0987654328');

-- Dumping data for table quanlynhansu.danhsachkiemnhiem: ~1 rows (approximately)
INSERT INTO `danhsachkiemnhiem` (`den_ngay`, `tu_ngay`, `version`, `can_bo_id`, `don_vi_chuc_nang_id`, `id`,
                                 `chuc_vu_kiem_nhiem`)
VALUES ('2024-01-01', '2023-01-01', 1, 1, 1, 1, 'Trưởng phòng Nhân sự');

-- Dumping data for table quanlynhansu.danhsachthamnien: ~0 rows (approximately)
INSERT INTO `danhsachthamnien` (`den_ngay`, `moc_tinh_phu_cap_tn`, `phu_cap_chuc_vu`, `phu_cap_giang_vien`,
                                `so_thang_bi_giam_tru`, `thoi_diem_tang_phu_cap_tn`, `tong_he_so_luong`, `tu_ngay`,
                                `version`, `vuot_khung`, `bac_luong_id`, `can_bo_id`, `don_vi_chuc_nang_id`, `id`,
                                `ghi_chu_khong_phu_cap_tn`, `ghi_chu_thoi_diem_tang`)
VALUES ('2024-01-01', '2023-06-01', 0.5, 0.3, 0, '2023-12-01', 5, '2023-01-01', 1, 0.2, 1, 1, 1, 1, NULL,
        'Tăng theo quy định');

-- Dumping data for table quanlynhansu.dantoc: ~53 rows (approximately)
INSERT INTO `dantoc` (`version`, `id`, `ten_dan_toc`)
VALUES (1, 1, 'Kinh'),
       (1, 2, 'Tày'),
       (1, 3, 'Thái'),
       (1, 4, 'Mường'),
       (1, 5, 'Khmer'),
       (1, 6, 'H’Mông'),
       (1, 7, 'Nùng'),
       (1, 8, 'Dao'),
       (1, 9, 'Gia Rai'),
       (1, 10, 'Ngái'),
       (1, 11, 'Ê Đê'),
       (1, 12, 'Ba Na'),
       (1, 13, 'Xơ Đăng'),
       (1, 14, 'Sán Chay'),
       (1, 15, 'Cơ Ho'),
       (1, 16, 'Chăm'),
       (1, 17, 'Sán Dìu'),
       (1, 18, 'Hrê'),
       (1, 19, 'Mnông'),
       (1, 20, 'Ra Glai'),
       (1, 21, 'Xtiêng'),
       (1, 22, 'Bru - Vân Kiều'),
       (1, 23, 'Thổ'),
       (1, 24, 'Giáy'),
       (1, 25, 'Cơ Tu'),
       (1, 26, 'Gié - Triêng'),
       (1, 27, 'Mạ'),
       (1, 28, 'Khơ Mú'),
       (1, 29, 'Co'),
       (1, 30, 'Tà Ôi'),
       (1, 31, 'Chơ Ro'),
       (1, 32, 'Kháng'),
       (1, 33, 'Xinh Mun'),
       (1, 34, 'Hà Nhì'),
       (1, 35, 'Chu Ru'),
       (1, 36, 'Lào'),
       (1, 37, 'La Chí'),
       (1, 38, 'La Ha'),
       (1, 39, 'Phù Lá'),
       (1, 40, 'La Hủ'),
       (1, 41, 'Lự'),
       (1, 42, 'Lô Lô'),
       (1, 43, 'Chứt'),
       (1, 44, 'Mảng'),
       (1, 45, 'Pà Thẻn'),
       (1, 46, 'Co Lao'),
       (1, 47, 'Cống'),
       (1, 48, 'Bố Y'),
       (1, 49, 'Si La'),
       (1, 50, 'Pu Péo'),
       (1, 51, 'Brâu'),
       (1, 52, 'Ơ Đu'),
       (1, 53, 'Rơ Măm');

-- Dumping data for table quanlynhansu.donvichucnang: ~0 rows (approximately)
INSERT INTO `donvichucnang` (`version`, `id`, `ma_don_vi`, `ten_don_vi`)
VALUES (1, 1, 'BLD', 'Ban lãnh đạo'),
       (1, 2, 'HĐQT', 'Hội đồng quản trị'),
       (1, 3, 'HCNS', 'Phòng Hành chính - Nhân sự'),
       (1, 4, 'NS', 'Phòng Nhân sự'),
       (1, 5, 'TD', 'Phòng Tuyển dụng'),
       (1, 6, 'DTPT', 'Phòng Đào tạo và Phát triển'),
       (1, 7, 'KT', 'Phòng Kế toán'),
       (1, 8, 'TC', 'Phòng Tài chính'),
       (1, 9, 'KD', 'Phòng Kinh doanh'),
       (1, 10, 'BH', 'Phòng Bán hàng'),
       (1, 11, 'MKT', 'Phòng Marketing'),
       (1, 12, 'CSKH', 'Phòng Chăm sóc khách hàng'),
       (1, 13, 'SX', 'Phòng Sản xuất'),
       (1, 14, 'VH', 'Phòng Vận hành'),
       (1, 15, 'QLCL', 'Phòng Quản lý chất lượng'),
       (1, 16, 'KCS', 'Phòng Kiểm tra chất lượng'),
       (1, 17, 'CNTT', 'Phòng Công nghệ Thông tin'),
       (1, 18, 'KT', 'Phòng Kỹ thuật'),
       (1, 19, 'R&D', 'Phòng Nghiên cứu và Phát triển (R&D)'),
       (1, 20, 'PL', 'Phòng Pháp lý'),
       (1, 21, 'KTNB', 'Phòng Kiểm toán nội bộ'),
       (1, 22, 'HC', 'Phòng Hậu cần'),
       (1, 23, 'KHO', 'Phòng Kho vận'),
       (1, 24, 'VCH', 'Phòng Vận chuyển');

-- Dumping data for table quanlynhansu.hopdongcanbo: ~0 rows (approximately)
INSERT INTO `hopdongcanbo` (`den_ngay`, `ngay_ky`, `tu_ngay`, `version`, `can_bo_id`, `don_vi_chuc_nang_id`, `id`,
                            `loai_hop_dong_id`, `chuc_vu`, `filehd`, `ma_hop_dong`, `ten_hop_dong`,
                            `trich_yeu_noi_dung`)
VALUES (NULL, '2023-01-10', '2023-01-01', 1, 1, 1, 1, 1, 'Nhân viên kinh doanh', 'hd_001.pdf', 'HD-001',
        'Hợp đồng lao động chính thức', 'Hợp đồng lao động dài hạn với nhân viên');

-- Dumping data for table quanlynhansu.hopdongcanbonganhan: ~1 rows (approximately)
INSERT INTO `hopdongcanbonganhan` (`den_ngay`, `ngay_ky`, `tu_ngay`, `version`, `can_bo_id`, `don_vi_chuc_nang_id`,
                                   `id`, `loai_hop_dong_nganhan_id`, `chuc_vu`, `filehd`, `ma_hop_dong`, `ten_hop_dong`,
                                   `trich_yeu_noi_dung`)
VALUES ('2023-04-01', '2023-01-10', '2023-01-01', 1, 1, 1, 1, 1, 'Nhân viên bán hàng', 'hdnh_001.pdf', 'HĐNH-001',
        'Hợp đồng thời vụ', 'Hợp đồng thời vụ 3 tháng');

-- Dumping data for table quanlynhansu.kekhaitaisan: ~0 rows (approximately)
INSERT INTO `kekhaitaisan` (`ngay_ke_khai`, `version`, `can_bo_id`, `don_vi_chuc_nang_id`, `id`, `file_ke_khai`)
VALUES ('2023-01-10', 1, 1, 1, 1, 'file_2023_01.pdf');

-- Dumping data for table quanlynhansu.loaihopdong: ~12 rows (approximately)
INSERT INTO `loaihopdong` (`version`, `id`, `ten_loai_hop_dong`)
VALUES (1, 1, 'Hợp đồng lao động không xác định thời hạn'),
       (1, 2, 'Hợp đồng lao động xác định thời hạn'),
       (1, 3, 'Hợp đồng lao động thời vụ'),
       (1, 4, 'Hợp đồng thử việc'),
       (1, 5, 'Hợp đồng cộng tác viên'),
       (1, 6, 'Hợp đồng khoán việc'),
       (1, 7, 'Hợp đồng thực tập'),
       (1, 8, 'Hợp đồng đào tạo nghề'),
       (1, 9, 'Hợp đồng lao động bán thời gian'),
       (1, 10, 'Hợp đồng hợp tác kinh doanh (BCC)'),
       (1, 11, 'Hợp đồng thuê khoán nhân công'),
       (1, 12, 'Hợp đồng dịch vụ lao động');

-- Dumping data for table quanlynhansu.loaihopdongnganhan: ~0 rows (approximately)
INSERT INTO `loaihopdongnganhan` (`version`, `id`, `ten_loai_hop_dong`)
VALUES (1, 1, 'Hợp đồng lao động thời vụ'),
       (1, 2, 'Hợp đồng lao động dưới 3 tháng'),
       (1, 3, 'Hợp đồng lao động từ 3 - 6 tháng'),
       (1, 4, 'Hợp đồng lao động từ 6 - 12 tháng'),
       (1, 5, 'Hợp đồng khoán việc'),
       (1, 6, 'Hợp đồng thuê khoán nhân công'),
       (1, 7, 'Hợp đồng lao động bán thời gian'),
       (1, 8, 'Hợp đồng thử việc'),
       (1, 9, 'Hợp đồng thực tập'),
       (1, 10, 'Hợp đồng cộng tác viên'),
       (1, 11, 'Hợp đồng đào tạo nghề'),
       (1, 12, 'Hợp đồng thời vụ theo dự án');

-- Dumping data for table quanlynhansu.loaiquyetdinh: ~0 rows (approximately)
INSERT INTO `loaiquyetdinh` (`version`, `id`, `ten_loai_quyet_dinh`)
VALUES (1, 1, 'Quyết định bổ nhiệm'),
       (1, 2, 'Quyết định miễn nhiệm'),
       (1, 3, 'Quyết định điều động'),
       (1, 4, 'Quyết định luân chuyển'),
       (1, 5, 'Quyết định khen thưởng'),
       (1, 6, 'Quyết định kỷ luật'),
       (1, 7, 'Quyết định nâng lương'),
       (1, 8, 'Quyết định chấm dứt hợp đồng'),
       (1, 9, 'Quyết định thành lập phòng ban'),
       (1, 10, 'Quyết định giải thể phòng ban'),
       (1, 11, 'Quyết định sửa đổi cơ cấu tổ chức'),
       (1, 12, 'Quyết định quy chế làm việc'),
       (1, 13, 'Quyết định phê duyệt ngân sách'),
       (1, 14, 'Quyết định chi thưởng'),
       (1, 15, 'Quyết định hỗ trợ tài chính'),
       (1, 16, 'Quyết định ban hành quy chế'),
       (1, 17, 'Quyết định thay đổi nội quy lao động'),
       (1, 18, 'Quyết định sửa đổi chính sách công ty'),
       (1, 19, 'Quyết định cử đi học tập, bồi dưỡng'),
       (1, 20, 'Quyết định hỗ trợ đào tạo'),
       (1, 21, 'Quyết định thanh lý tài sản'),
       (1, 22, 'Quyết định phân công nhiệm vụ'),
       (1, 23, 'Quyết định bổ sung nhân sự');

-- Dumping data for table quanlynhansu.ngachcongchuc: ~26 rows (approximately)
INSERT INTO `ngachcongchuc` (`so_nam_nang_bac_luong`, `version`, `id`, `ma_ngach`, `ten_ngach`)
VALUES (3, 1, 1, 'A1-01', 'Chuyên viên cao cấp'),
       (3, 1, 2, 'A1-02', 'Thanh tra viên cao cấp'),
       (3, 1, 3, 'A1-03', 'Giảng viên cao cấp'),
       (3, 1, 4, 'A2-01', 'Chuyên viên chính'),
       (3, 1, 5, 'A2-02', 'Thanh tra viên chính'),
       (3, 1, 6, 'A2-03', 'Giảng viên chính'),
       (3, 1, 7, 'A3-01', 'Chuyên viên'),
       (3, 1, 8, 'A3-02', 'Thanh tra viên'),
       (3, 1, 9, 'A3-03', 'Giảng viên'),
       (2, 1, 10, 'B1-01', 'Cán sự'),
       (2, 1, 11, 'B1-02', 'Kế toán viên trung cấp'),
       (2, 1, 12, 'B1-03', 'Thư ký nghiệp vụ'),
       (2, 1, 13, 'C1-01', 'Nhân viên hành chính'),
       (2, 1, 14, 'C1-02', 'Nhân viên văn thư'),
       (2, 1, 15, 'C1-03', 'Nhân viên kế toán'),
       (3, 1, 16, 'GD-01', 'Giáo viên THPT hạng I'),
       (3, 1, 17, 'GD-02', 'Giáo viên THPT hạng II'),
       (3, 1, 18, 'GD-03', 'Giáo viên THCS hạng I'),
       (3, 1, 19, 'GD-04', 'Giáo viên THCS hạng II'),
       (3, 1, 20, 'GD-05', 'Giáo viên Tiểu học hạng I'),
       (3, 1, 21, 'GD-06', 'Giáo viên Tiểu học hạng II'),
       (3, 1, 22, 'YT-01', 'Bác sĩ chính'),
       (3, 1, 23, 'YT-02', 'Bác sĩ'),
       (2, 1, 24, 'YT-03', 'Y sĩ'),
       (2, 1, 25, 'YT-04', 'Điều dưỡng viên'),
       (2, 1, 26, 'YT-05', 'Kỹ thuật viên y tế');

-- Dumping data for table quanlynhansu.password_history: ~0 rows (approximately)

-- Dumping data for table quanlynhansu.quatrinhluong: ~1 rows (approximately)
INSERT INTO `quatrinhluong` (`phan_tran_phu_cap`, `thoi_gian_cham_len_luong`, `thoi_gian_len_luong_som`,
                             `thoi_gian_tang_luong`, `thoi_gian_tinh_huong`, `version`, `bac_luong_id`, `can_bo_id`,
                             `don_vi_chuc_nang_id`, `id`, `ngach_cong_chuc_id`, `ghi_chu`, `ly_do_cham_len_luong`,
                             `ly_do_len_luong_som`)
VALUES (10, '2023-01-01', NULL, '2024-01-01', '2023-12-01', 1, 1, 1, 1, 1, 1, 'Tăng lương theo định kỳ', NULL, NULL);

-- Dumping data for table quanlynhansu.quequan: ~0 rows (approximately)
INSERT INTO `quequan` (`can_bo_id`, `id`, `ten_que_quan`)
VALUES (1, 1, 'Hà Nội');

-- Dumping data for table quanlynhansu.quyetdinh: ~1 rows (approximately)
INSERT INTO `quyetdinh` (`den_ngay`, `ngay_ky`, `tu_ngay`, `version`, `can_bo_id`, `don_vi_chuc_nang_id`, `id`,
                         `loai_quyet_dinh_id`, `file_ky`, `nguoi_ky`, `noi_dung_quyet_dinh`, `so_quyet_dinh`,
                         `ten_quyet_dinh`)
VALUES (NULL, '2023-01-10', '2023-01-01', 1, 1, 1, 1, 1, 'qd_001.pdf', 'Trần Thị B',
        'Bổ nhiệm ông Nguyễn Văn A làm trưởng \r\nphòng Kinh doanh', 'QD-001', 'Bổ nhiệm trưởng phòng');

-- Dumping data for table quanlynhansu.quyetdinhkhenthuong: ~1 rows (approximately)
INSERT INTO `quyetdinhkhenthuong` (`ngay_ky`, `version`, `can_bo_id`, `don_vi_chuc_nang_id`, `id`, `file_ky`,
                                   `nguoi_ky`, `noi_dung_quyet_dinh`, `so_quyet_dinh`, `ten_quyet_dinh`)
VALUES ('2023-01-15', 1, 1, 1, 1, 'qd_001.pdf', 'Nguyễn Văn A', 'Khen thưởng vì có thành tích xuất sắc trong năm 2023',
        'QD-001', 'Khen thưởng cá nhân xuất sắc');

-- Dumping data for table quanlynhansu.quyetdinhkyluat: ~1 rows (approximately)
INSERT INTO `quyetdinhkyluat` (`den_ngay`, `ngay_ky`, `tu_ngay`, `version`, `can_bo_id`, `don_vi_chuc_nang_id`, `id`,
                               `file_ky`, `nguoi_ky`, `noi_dung_quyet_dinh`, `so_quyet_dinh`, `ten_quyet_dinh`)
VALUES ('2023-06-01', '2023-01-10', '2023-01-01', 1, 1, 1, 1, 'qd_kl_001.pdf', 'Nguyễn Văn A',
        'Vi phạm nội quy công ty trong giờ làm việc', 'QD-KL-001', 'Cảnh cáo vi phạm nội quy');

-- Dumping data for table quanlynhansu.roles: ~0 rows (approximately)
INSERT INTO `roles` (`id`, `name`)
VALUES (1, 'CLIENT'),
       (2, 'ADMIN'),
       (3, 'MANAGER');

-- Dumping data for table quanlynhansu.tongiao: ~13 rows (approximately)
INSERT INTO `tongiao` (`version`, `id`, `ten_ton_giao`)
VALUES (1, 1, 'Phật giáo'),
       (1, 2, 'Công giáo'),
       (1, 3, 'Tin lành'),
       (1, 4, 'Hòa Hảo'),
       (1, 5, 'Cao Đài'),
       (1, 6, 'Hồi giáo'),
       (1, 7, 'Bà La Môn'),
       (1, 8, 'Tịnh độ cư sĩ Phật hội Việt Nam'),
       (1, 9, 'Bửu Sơn Kỳ Hương'),
       (1, 10, 'Minh Sư Đạo'),
       (1, 11, 'Minh Lý Đạo'),
       (1, 12, 'Tôn giáo khác'),
       (1, 13, 'Không tôn giáo');

-- Dumping data for table quanlynhansu.users: ~2 rows (approximately)
INSERT INTO `users` (`enabled`, `failed_attempt`, `status`, `created_at`, `expiry_date`, `id`,
                     `last_failed_attempt_time`, `last_login_time`, `lock_time`, `update_at`, `first_name`, `last_name`,
                     `user_name`, `verification_code`, `email`, `refresh_token`, `created_by`, `password`, `phone`,
                     `token`, `update_by`)
VALUES (b'1', 0, 1, '2025-01-24 05:02:10.000000', '2025-01-24 05:02:09.000000', 1, NULL, '2025-01-24 05:02:01.000000',
        '2025-01-24 05:01:56.000000', '2025-01-24 05:09:00.763000', 'ADMIN', 'ADMIN', 'ADMIN', NULL, 'ADMIN@gmail.com',
        'e9068da4-6b51-4d9f-ac43-1fa1569ee3d6', NULL, '$2a$12$t6HhKFMZV5xDmqd1rvFj.eo1qgZ3R7p7HnlByUjIMOKrqiZG3I7uq',
        NULL, NULL, NULL),
       (b'1', 0, 1, '2025-01-24 05:02:10.000000', '2025-01-24 05:02:09.000000', 2, NULL, '2025-01-24 05:02:01.000000',
        '2025-01-24 05:01:56.000000', '2025-01-24 05:09:00.763000', 'CLIENT', 'CLIENT', 'CLIENT', NULL,
        'CLIENT@gmail.com', '', NULL, '$2a$12$0MbYBrbO8o3h99R7bizIiOsCRq93lKiBiGa4VxFpDdXeiblVsNWtC', NULL, NULL, NULL);

-- Dumping data for table quanlynhansu.user_roles: ~2 rows (approximately)
INSERT INTO `user_roles` (`role_id`, `user_id`)
VALUES (2, 1),
       (1, 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
