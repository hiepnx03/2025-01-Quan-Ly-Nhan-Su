package com.example.demo.dto;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class HopdongnganhanDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String tenHopDong;
	private String tenNhanVien;

	private Date tuNgay;
	private Date denNgay;
	private Date ngayKy;

	private Integer version = 0;
}