package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "loaihopdong")
public class Loaihopdong implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tenLoaiHopDong;
	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;
}
