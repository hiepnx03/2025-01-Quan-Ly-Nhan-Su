package com.example.demo.service;


import com.example.demo.dto.DantocDTO;

import java.util.List;

public interface DantocService {
    List<DantocDTO> getAll();                   // Lấy tất cả tôn giáo
    DantocDTO getById(Long id);                // Lấy tôn giáo theo ID
    DantocDTO create(DantocDTO dantocDTO);   // Tạo mới tôn giáo
    DantocDTO update(Long id, DantocDTO dantocDTO); // Cập nhật tôn giáo
    void delete(Long id);                       // Xóa tôn giáo
}
