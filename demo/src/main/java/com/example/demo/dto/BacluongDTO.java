package com.example.demo.dto;

import com.example.demo.entity.Ngachcongchuc;
import lombok.Data;

import java.io.Serializable;

@Data
public class BacluongDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer maBacLuong;
	private double heSoLuong;
	private double phuCapVuotKhung;

	private Ngachcongchuc ngachcongchuc;


}
