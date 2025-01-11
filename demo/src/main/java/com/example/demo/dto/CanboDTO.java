package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CanboDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String soHieu;
	private String imageUrl;
	private String ten;
	private String tenGoiKhac;
	private String gioiTinh;
	private String noiSinh;
	private String soCmnd;
	private String noiCapCmnd;
	private String noiDKHoKhauThuongTru;
	private String noiOHienNay;
	private String ngheNghieidhiTuyenDung;
	private String coQuanTuyenDung;
	private String congViecDuocGiao;
	private String chucDanh;
	private String trinhDoGiaoDucPt;
	private String trinhDoChuyenMon;
	private String hocVi;
	private String hocHam;
	private String lyLuanChinhTri;
	private String quanLyNhaNuoc;
	private String ngoaiNgu;
	private String tinHoc;
	private String thamGiaToChucCtxh;
	private String nhomMau;
	private String soBaoHiemXh;
	private String laThuongBinh;
	private String laConGiaDinhChinhSach;
	private String nhanXet;
	private String quanHamCaoNhat;
	private String danhHieuPhongTang;
	private String khenThuong;
	private String kyLuat;
	private String tinhTrangSucKhoe;

	private Integer soTruongCongTac;

	private double chieuCao;
	private double canNang;
	private double phuCapChucVu;
	private double phuCaidhac;

	private Integer version = 0;
	private Boolean enabled;


	private Date ngayNhapNgu;
	private Date ngayXuatNgu;
	private Date ngayVeHuu;
	private Date ngayThoiViec;
	private Date ngayNhanHocVi;
	private Date ngayHuong;
	private Date ngayTuyenDung;
	private Date ngaySinh;
	private Date ngayCapCmnd;
	private Date ngayNhanHocHam;
	private Date ngayVaoDcsvnDuBi;
	private Date ngayVaoDcsvnChinhThuc;


	// 1-n canbo - quequan
	private List<QuequanDTO> quequanDTOS;


	// n-1 canbo - tongiao
	private TongiaoDTO tongiaoDTO;
	// n-1 canbo - chucvu
	private ChucvuDTO chucvuDTO;

	// n-1 canbo - donvichucnang
	private DonvichucnangDTO donvichucnangDTO;

	// n-1 canbo - bomon
	private BomonDTO bomonDTO;
	// n-1 canbo - dantoc
	private DantocDTO dantocDTO;
	// n-1 canbo - ngachcongchubng
	private NgachcongchucDTO ngachcongchucDTO;
	// n-1 canbo - bacluong
	private BacluongDTO bacluongDTO;
}
