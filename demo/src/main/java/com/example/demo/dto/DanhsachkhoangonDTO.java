package com.example.demo.dto;

import com.example.demo.entity.Donvichucnang;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DanhsachkhoangonDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;

	private String hoTenCanBo;
	private String soDienThoai;
	private String soCmnd;
	private String diaChi;

	private Integer version = 0;

	private Date ngayKyHopDong;

	private DonvichucnangDTO donvichucnangDTO;
}
