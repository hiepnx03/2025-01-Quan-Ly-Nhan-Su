package com.example.demo.service;

import com.example.demo.dto.DonvichucnangDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DonvichucnangService {
    List<DonvichucnangDTO> getAll();
    public Page<DonvichucnangDTO> getAllPage (int pageNo, int pageSize);
    DonvichucnangDTO getById(Long id);                 // Lấy đơn vị chức năng theo ID
    DonvichucnangDTO create(DonvichucnangDTO dto);     // Tạo mới đơn vị chức năng
    DonvichucnangDTO update(Long id, DonvichucnangDTO dto); // Cập nhật đơn vị chức năng
    void delete(Long id);

    Page<DonvichucnangDTO> searchByTenOrMaDonVi(String keyword, int pageNo, int pageSize);

}
