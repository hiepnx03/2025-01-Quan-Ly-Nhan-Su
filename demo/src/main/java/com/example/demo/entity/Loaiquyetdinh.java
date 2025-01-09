package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "loaiquyetdinh")
public class Loaiquyetdinh implements Serializable {
	private static final long serialVersionUID = -9214791584187680657L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tenLoaiQuyetDinh;
	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;
}
