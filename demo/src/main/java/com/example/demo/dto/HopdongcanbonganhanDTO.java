package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class HopdongcanbonganhanDTO {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String maHopDong;
    private String tenHopDong;
    private String chucVu;
    private String trichYeuNoiDung;
    private String fileHD;

    private Date ngayKy;
    private Date tuNgay;
    private Date denNgay;

    private Integer version = 0;

    //	N-1 hopdongcanbonganhan-donvichucnang
    private DonvichucnangDTO donvichucnangDTO;
    //	N-1 hopdongcanbonganhan-loaihopdong
    private LoaihopdongnganhanDTO loaihopdongnganhanDTO;
    //	N-1 hopdongcanbonganhan-canbo
    private CanboDTO canboDTO;
}
