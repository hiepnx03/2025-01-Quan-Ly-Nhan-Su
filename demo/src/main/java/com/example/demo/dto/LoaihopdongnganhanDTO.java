package com.example.demo.dto;

import lombok.Data;

@Data
public class LoaihopdongnganhanDTO {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String tenLoaiHopDong;

    private Integer version = 0;
}
