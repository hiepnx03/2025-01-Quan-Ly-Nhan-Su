package com.example.demo.dto;

import com.example.demo.entity.Bacluong;
import com.example.demo.entity.Canbo;
import com.example.demo.entity.Donvichucnang;
import com.example.demo.entity.Ngachcongchuc;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class QuatrinhluongDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String lyDoLenLuongSom;
	private String ghiChu;

	private Date thoiGianTinhHuong;
	private Integer phanTranPhuCap;
	private Date thoiGianTangLuong;
	private Date thoiGianChamLenLuong;
	private String lyDoChamLenLuong;
	private Date thoiGianLenLuongSom;

	private Integer version = 0;

	private DonvichucnangDTO donvichucnangDTO;

	private CanboDTO canboDTO;

	private NgachcongchucDTO ngachcongchucDTO;

	private BacluongDTO bacluongDTO;

}
