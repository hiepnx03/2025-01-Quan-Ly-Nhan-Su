package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "quyetdinh")
public class Quyetdinh implements Serializable {
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
	@Temporal(TemporalType.DATE)
	private Date tuNgay;
	@Temporal(TemporalType.DATE)
	private Date denNgay;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "don_vi_chuc_nang_id", foreignKey = @ForeignKey(name = "donViChucNangQd_id"))
	private Donvichucnang donvichucnang;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "can_bo_id", foreignKey = @ForeignKey(name = "canBoQd_id"))
	private Canbo canbo;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loai_quyet_dinh_id", foreignKey = @ForeignKey(name = "loaiQuyetDinhQd_id"))
	private Loaiquyetdinh loaiquyetdinh;
}
