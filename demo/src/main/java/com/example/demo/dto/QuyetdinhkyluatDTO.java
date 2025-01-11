package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class QuyetdinhkyluatDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;                      // ID của quyết định kỷ luật
	private String soQuyetDinh;           // Số quyết định
	private String tenQuyetDinh;          // Tên quyết định
	private String noiDungQuyetDinh;      // Nội dung quyết định
	private String nguoiKy;               // Người ký quyết định
	private String fileKy;                // Tệp ký đính kèm

	private Date tuNgay;                  // Thời gian hiệu lực từ ngày
	private Date denNgay;                 // Thời gian hiệu lực đến ngày
	private Date ngayKy;                  // Ngày ký quyết định

	private Integer version = 0;          // Phiên bản dùng để kiểm tra xung đột dữ liệu

	private DonvichucnangDTO donvichucnangDTO; // Đơn vị chức năng liên quan đến quyết định
	private CanboDTO canboDTO;                // Cán bộ liên quan đến quyết định
}
