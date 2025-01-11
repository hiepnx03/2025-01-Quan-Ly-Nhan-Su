package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "chucvu")
public class Chucvu implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tenChucVu;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;

	@OneToMany(mappedBy = "chucvu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Canbo> canbos; // Danh sách cán bộ thuộc tôn giáo này
}
