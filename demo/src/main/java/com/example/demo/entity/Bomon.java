package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "bomon")
public class Bomon implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tenBoMon;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "don_vi_chuc_nang_id", nullable = false) // Foreign key column name
	private Donvichucnang donvichucnang;
}
