package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "hopdongcanbo")
public class Hopdongcanbo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String maHopDong;
	private String tenHopDong;
	private String chucVu;
	private String trichYeuNoiDung;
	private String fileHD;

	@Temporal(TemporalType.DATE)
	private Date ngayKy;
	@Temporal(TemporalType.DATE)
	private Date tuNgay;
	@Temporal(TemporalType.DATE)
	private Date denNgay;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "don_vi_chuc_nang_id",referencedColumnName = "id")
	private Donvichucnang donvichucnang;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "can_bo_id", referencedColumnName = "id")
	private Canbo canbo;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loai_hop_dong_id",referencedColumnName = "id")
	private Loaihopdong loaihopdong;
}
