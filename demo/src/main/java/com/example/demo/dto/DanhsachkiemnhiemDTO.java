package com.example.demo.dto;

import com.example.demo.entity.Canbo;
import com.example.demo.entity.Donvichucnang;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class DanhsachkiemnhiemDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String chucVuKiemNhiem;

	private Date tuNgay;
	private Date denNgay;

	private Integer version = 0;

	private CanboDTO canboDTO;

	private DonvichucnangDTO donvichucnangDTO;
}
