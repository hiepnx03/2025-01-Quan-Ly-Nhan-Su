package com.example.demo.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class DonvichucnangDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String maDonVi;
    private String tenDonVi;
    private Integer version = 0;
	
    private Set<BomonDTO> bomonDTOS = new HashSet<>();
    private Set<CanboDTO> canboDTOS = new HashSet<>();

}
