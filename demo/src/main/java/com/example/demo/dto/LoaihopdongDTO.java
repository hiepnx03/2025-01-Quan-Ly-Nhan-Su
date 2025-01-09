package com.example.demo.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoaihopdongDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String tenLoaiHopDong;

	private Integer version = 0;
}
