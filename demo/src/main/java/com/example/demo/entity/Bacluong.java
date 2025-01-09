package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "bacluong")
public class Bacluong implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer maBacLuong;
	private double heSoLuong;
	private double phuCapVuotKhung;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ngach_cong_chuc_id") // Ensure this matches the actual foreign key column
	private Ngachcongchuc ngachcongchuc;


}
