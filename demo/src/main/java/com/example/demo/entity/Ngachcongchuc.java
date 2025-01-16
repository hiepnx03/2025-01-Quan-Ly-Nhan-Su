package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "ngachcongchuc")
public class Ngachcongchuc implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String maNgach;
	private String tenNgach;
	private Integer soNamNangBacLuong;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;

	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "ngachcongchuc", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Bacluong> bacLuongs ;
}
