package com.example.demo.dto;

import com.example.demo.entity.Canbo;
import com.example.demo.entity.Donvichucnang;
import com.example.demo.entity.Loaihopdong;
import jakarta.persistence.*;
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

	private DonvichucnangDTO donvichucnangDTO;
	private CanboDTO canboDTO;
	private LoaihopdongDTO loaihopdongDTO;
}
