package com.example.demo.service;


import com.example.demo.dto.LoaiquyetdinhDTO;

import java.util.List;

public interface LoaiquyetdinhService {
    List<LoaiquyetdinhDTO> getAll();                     // Lấy danh sách tất cả loại quyết định
    LoaiquyetdinhDTO getById(Long id);                  // Lấy loại quyết định theo ID
    LoaiquyetdinhDTO create(LoaiquyetdinhDTO dto);      // Tạo mới loại quyết định
    LoaiquyetdinhDTO update(Long id, LoaiquyetdinhDTO dto); // Cập nhật loại quyết định
    void delete(Long id);
}
