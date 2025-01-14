package com.example.demo.service;


import com.example.demo.dto.QuyetdinhDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QuyetdinhService {
    List<QuyetdinhDTO> getAll();                // Lấy danh sách tất cả quyết định
    public Page<QuyetdinhDTO> getAllPage(int pageNo, int pageSize);
    QuyetdinhDTO getById(Long id);             // Lấy quyết định theo ID
    QuyetdinhDTO create(QuyetdinhDTO dto);     // Tạo mới quyết định
    QuyetdinhDTO update(Long id, QuyetdinhDTO dto); // Cập nhật quyết định

    void delete(Long id);                      // Xóa quyết định
}
