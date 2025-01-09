package com.example.demo.dto;

import com.example.demo.entity.Bacluong;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class NgachcongchucDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;

	private String maNgach;
	private String tenNgach;
	private Integer soNamNangBacLuong;

	private Integer version = 0;

	private Set<BacluongDTO> bacluongDTOS = new HashSet<>();
}
