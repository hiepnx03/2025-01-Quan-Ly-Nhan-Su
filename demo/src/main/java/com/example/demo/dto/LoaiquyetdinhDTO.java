package com.example.demo.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoaiquyetdinhDTO implements Serializable {
	private static final long serialVersionUID = -9214791584187680657L;
	private Long id;
	private String tenLoaiQuyetDinh;

	private Integer version = 0;
}
