package com.example.demo.service;


import com.example.demo.dto.QuyetdinhkyluatDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QuyetdinhkyluatService {
    List<QuyetdinhkyluatDTO> getAll();                // Lấy danh sách tất cả quyết định kỷ luật
    QuyetdinhkyluatDTO getById(Long id);             // Lấy quyết định kỷ luật theo ID
    QuyetdinhkyluatDTO create(QuyetdinhkyluatDTO dto); // Tạo mới quyết định kỷ luật
    QuyetdinhkyluatDTO update(Long id, QuyetdinhkyluatDTO dto); // Cập nhật quyết định kỷ luật
    void delete(Long id);

    public Page<QuyetdinhkyluatDTO> getAllPage(int pageNo, int pageSize);
}
