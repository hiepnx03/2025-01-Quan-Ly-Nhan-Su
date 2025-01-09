package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "kekhaitaisan")
public class Kekhaitaisan implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "don_vi_chuc_nang_id",referencedColumnName = "id")
	private Donvichucnang donvichucnang;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "can_bo_id", referencedColumnName = "id")
	private Canbo canbo;
	@Temporal(TemporalType.DATE)
	private Date ngayKeKhai;
	private String fileKeKhai;
	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;

}
