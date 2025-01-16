package com.example.demo.dto;

import com.example.demo.entity.Ngachcongchuc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class BacluongDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer maBacLuong;
	private double heSoLuong;
	private double phuCapVuotKhung;

	//	N-1 bacluong - ngachcongchuc
	private NgachcongchucDTO ngachcongchucDTO;



}
