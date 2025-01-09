package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DanhsachthamnienDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer soThangBiGiamTru;
	private String ghiChuThoiDiemTang;
	private String ghiChuKhongPhuCapTn;

	private float phuCapChucVu;
	private float vuotKhung;
	private float tongHeSoLuong;
	private float phuCapGiangVien;

	private Integer version = 0;

	private Date mocTinhPhuCapTn;
	private Date thoiDiemTangPhuCapTn;
	private Date tuNgay;
	private Date denNgay;

	private DonvichucnangDTO donvichucnangDTO;
	private CanboDTO canboDTO;
	private BacluongDTO bacluongDTO;
}
