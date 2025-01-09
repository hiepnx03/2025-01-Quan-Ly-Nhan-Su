package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "hopdongnganhan")
public class Hopdongnganhan implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tenHopDong;
	private String tenNhanVien;

	@Temporal(TemporalType.DATE)
	private Date tuNgay;
	@Temporal(TemporalType.DATE)
	private Date denNgay;
	@Temporal(TemporalType.DATE)
	private Date ngayKy;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;
}