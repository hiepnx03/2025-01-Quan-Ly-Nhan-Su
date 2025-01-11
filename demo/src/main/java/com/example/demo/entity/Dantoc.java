package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "dantoc")
public class Dantoc implements Serializable {
	private static final long serialVersionUID = -654521177995353456L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tenDanToc;
	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version = 0;


	@OneToMany(mappedBy = "dantoc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Canbo> canbos; // Danh sách cán bộ thuộc tôn giáo này
}
