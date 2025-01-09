package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

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
}
