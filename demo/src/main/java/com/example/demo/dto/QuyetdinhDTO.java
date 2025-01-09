package com.example.demo.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class QuyetdinhDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String soQuyetDinh;
	private String tenQuyetDinh;
	private String noiDungQuyetDinh;
	private String nguoiKy;
	private String fileKy;

	private Date ngayKy;
	private Date tuNgay;
	private Date denNgay;

	private Integer version = 0;

	private DonvichucnangDTO donvichucnangDTO;
	private CanboDTO canboDTO;
	private LoaiquyetdinhDTO loaiquyetdinhDTO;
}
