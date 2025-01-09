package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "quyetdinhkhenthuong")
public class Quyetdinhkhenthuong implements Serializable {
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
	private Date ngayKy;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "donViChucNangQdkt_id", foreignKey = @ForeignKey(name = "donViChucNangQdkt_id"))
	private Donvichucnang donvichucnang;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "canBoQdkt_id", foreignKey = @ForeignKey(name = "canBoQdkt_id"))
	private Canbo canbo;
}
