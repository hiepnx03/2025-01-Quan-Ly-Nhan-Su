package com.example.demo.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class DonvichucnangDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String maDonVi;
    private String tenDonVi;
    private Integer version = 0;

    // 1-n donvichucnang - bomon
    private List<BomonDTO> bomonDTOS ;

    // 1-n donvichucnang - canbo
    private List<CanboDTO> canboDTOS ;

}
