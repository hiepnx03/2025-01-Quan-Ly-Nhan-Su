package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "quatrinhluong")
public class Quatrinhluong implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String lyDoLenLuongSom;
	private String ghiChu;

	@Temporal(TemporalType.DATE)
	private Date thoiGianTinhHuong;
	private Integer phanTranPhuCap;
	@Temporal(TemporalType.DATE)
	private Date thoiGianTangLuong;
	@Temporal(TemporalType.DATE)
	private Date thoiGianChamLenLuong;
	private String lyDoChamLenLuong;
	@Temporal(TemporalType.DATE)
	private Date thoiGianLenLuongSom;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "don_vi_chuc_nang_id",referencedColumnName = "id")
	private Donvichucnang donvichucnang;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "can_bo_id",referencedColumnName = "id")
	private Canbo canbo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ngach_cong_chuc_id", referencedColumnName = "id")
	private Ngachcongchuc ngachcongchuc;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bac_luong_id",referencedColumnName = "id")
	private Bacluong bacluong;

}
