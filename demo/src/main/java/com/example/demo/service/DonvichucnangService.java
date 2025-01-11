package com.example.demo.service;

import com.example.demo.dto.DonvichucnangDTO;

import java.util.List;

public interface DonvichucnangService {
    List<DonvichucnangDTO> getAll();                    // Lấy tất cả đơn vị chức năng
    DonvichucnangDTO getById(Long id);                 // Lấy đơn vị chức năng theo ID
    DonvichucnangDTO create(DonvichucnangDTO dto);     // Tạo mới đơn vị chức năng
    DonvichucnangDTO update(Long id, DonvichucnangDTO dto); // Cập nhật đơn vị chức năng
    void delete(Long id);
}
