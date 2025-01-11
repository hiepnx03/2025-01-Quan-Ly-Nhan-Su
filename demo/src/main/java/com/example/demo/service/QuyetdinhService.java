package com.example.demo.service;


import com.example.demo.dto.QuyetdinhDTO;

import java.util.List;

public interface QuyetdinhService {
    List<QuyetdinhDTO> getAll();                // Lấy danh sách tất cả quyết định
    QuyetdinhDTO getById(Long id);             // Lấy quyết định theo ID
    QuyetdinhDTO create(QuyetdinhDTO dto);     // Tạo mới quyết định
    QuyetdinhDTO update(Long id, QuyetdinhDTO dto); // Cập nhật quyết định
    void delete(Long id);                      // Xóa quyết định
}
