package com.example.demo.dto;

import com.example.demo.entity.Canbo;
import com.example.demo.entity.Donvichucnang;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class QuyetdinhkhenthuongDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String soQuyetDinh;
	private String tenQuyetDinh;
	private String noiDungQuyetDinh;
	private String nguoiKy;
	private String fileKy;

	private Date ngayKy;

	private Integer version = 0;

	private DonvichucnangDTO donvichucnangDTO;
	private CanboDTO canboDTO;
}
