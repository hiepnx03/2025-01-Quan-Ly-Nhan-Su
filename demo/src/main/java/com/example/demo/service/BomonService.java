package com.example.demo.service;


import com.example.demo.dto.BomonDTO;

import java.util.List;

public interface BomonService {
    List<BomonDTO> getAll();                     // Lấy tất cả bộ môn
    BomonDTO getById(Long id);                  // Lấy bộ môn theo ID
    BomonDTO create(Long donvichucnangId, BomonDTO bomonDTO);         // Tạo mới bộ môn
    BomonDTO update(Long donvichucnangId, Long bomonId, BomonDTO bomonDTO);     // Cập nhật bộ môn
    void delete(Long id);


}
