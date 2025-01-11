package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "quequan")
public class Quequan implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tenQueQuan;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "can_bo_id", nullable = false)
	private Canbo canbo; // Liên kết với Canbo


}
