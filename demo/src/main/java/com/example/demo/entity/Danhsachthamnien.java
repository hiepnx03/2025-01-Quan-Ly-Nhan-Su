package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "danhsachthamnien")
public class Danhsachthamnien implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer soThangBiGiamTru;
	private String ghiChuThoiDiemTang;
	private String ghiChuKhongPhuCapTn;

	private float phuCapChucVu;
	private float vuotKhung;
	private float tongHeSoLuong;
	private float phuCapGiangVien;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;

	@Temporal(TemporalType.DATE)
	private Date mocTinhPhuCapTn;
	@Temporal(TemporalType.DATE)
	private Date thoiDiemTangPhuCapTn;
	@Temporal(TemporalType.DATE)
	private Date tuNgay;
	@Temporal(TemporalType.DATE)
	private Date denNgay;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "don_vi_chuc_nang_id", referencedColumnName = "id")
	private Donvichucnang donvichucnang;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "can_bo_id", referencedColumnName = "id")
	private Canbo canbo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bac_luong_id", referencedColumnName = "id")
	private Bacluong bacluong;
}
