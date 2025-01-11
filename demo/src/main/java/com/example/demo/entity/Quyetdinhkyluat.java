package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "quyetdinhkyluat")
public class Quyetdinhkyluat implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String soQuyetDinh;
	private String tenQuyetDinh;
	private String noiDungQuyetDinh;
	private String nguoiKy;
	private String fileKy;

	@Temporal(TemporalType.DATE)
	private Date tuNgay;
	@Temporal(TemporalType.DATE)
	private Date denNgay;
	@Temporal(TemporalType.DATE)
	private Date ngayKy;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "don_vi_chuc_nang_id",referencedColumnName = "id")
	private Donvichucnang donvichucnang;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "can_bo_id",referencedColumnName = "id")
	private Canbo canbo;
}
