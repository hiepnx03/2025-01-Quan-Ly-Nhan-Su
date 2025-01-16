package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "loaihopdongnganhan")
public class Loaihopdongnganhan implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tenLoaiHopDong;
	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;


	@OneToMany(mappedBy = "loaihopdongnganhan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Hopdongcanbonganhan> hopdongcanbonganhan;
}
