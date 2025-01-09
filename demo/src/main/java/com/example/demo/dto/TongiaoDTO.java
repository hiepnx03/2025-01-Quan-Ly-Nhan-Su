package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TongiaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String tenTonGiao;

	private Integer version = 0;
}
