package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HopdongcanboDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String maHopDong;
	private String tenHopDong;
	private String chucVu;
	private String trichYeuNoiDung;
	private String fileHD;

	private Date ngayKy;
	private Date tuNgay;
	private Date denNgay;

	private Integer version = 0;

//	N-1 hopdongcanbo-donvichucnang
	private DonvichucnangDTO donvichucnangDTO;
//	N-1 hopdongcanbo-loaihopdong
	private LoaihopdongDTO loaihopdongDTO;
//	N-1 hopdongcanbo-canbo
	private CanboDTO canboDTO;
}
