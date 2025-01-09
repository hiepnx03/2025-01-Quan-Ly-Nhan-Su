package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "danhsachkhoangon")
public class Danhsachkhoangon implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String hoTenCanBo;
	private String soDienThoai;
	private String soCmnd;
	private String diaChi;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;

	@Temporal(TemporalType.DATE)
	private Date ngayKyHopDong;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "don_vi_chuc_nang_id", referencedColumnName = "id")
	private Donvichucnang donvichucnang;
}
