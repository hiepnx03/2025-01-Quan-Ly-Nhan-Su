package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class DantocDTO implements Serializable {
	private static final long serialVersionUID = -654521177995353456L;
	private Long id;
	private String tenDanToc;

	private Integer version = 0;
}
