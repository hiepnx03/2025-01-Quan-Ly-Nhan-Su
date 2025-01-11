package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "canbo")
public class Canbo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private Boolean enabled = true;
	private double chieuCao;
	private double canNang;
	private double phuCapChucVu;
	private double phuCaidhac;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;

	@Temporal(TemporalType.DATE)
	private Date ngayNhapNgu;
	@Temporal(TemporalType.DATE)
	private Date ngayXuatNgu;
	@Temporal(TemporalType.DATE)
	private Date ngayVeHuu;
	@Temporal(TemporalType.DATE)
	private Date ngayThoiViec;
	@Temporal(TemporalType.DATE)
	private Date ngayNhanHocVi;
	@Temporal(TemporalType.DATE)
	private Date ngayHuong;
	@Temporal(TemporalType.DATE)
	private Date ngayTuyenDung;
	@Temporal(TemporalType.DATE)
	private Date ngaySinh;
	@Temporal(TemporalType.DATE)
	private Date ngayCapCmnd;
	@Temporal(TemporalType.DATE)
	private Date ngayNhanHocHam;
	@Temporal(TemporalType.DATE)
	private Date ngayVaoDcsvnDuBi;
	@Temporal(TemporalType.DATE)
	private Date ngayVaoDcsvnChinhThuc;

	@OneToMany(mappedBy = "canbo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Quequan> quequans; // Danh sách quê quán của cán bộ

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dan_toc_id",nullable = true)
	private Dantoc dantoc;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ton_giao_id",nullable = true)
	private Tongiao tongiao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chuc_vu_id",nullable = true)
	private Chucvu chucvu;


	@OneToMany(mappedBy = "canbo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Quyetdinhkyluat> quyetdinhkyluats;



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "don_vi_chuc_nang_id",nullable = true)
	private Donvichucnang donvichucnang;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bo_mon_id",nullable = true)
	private Bomon bomon;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ngach_cong_chuc_id",nullable = true)
	private Ngachcongchuc ngachcongchuc;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "bac_luong_id",nullable = true)
	private Bacluong bacluong;
}
