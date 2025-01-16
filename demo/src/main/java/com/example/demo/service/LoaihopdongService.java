package com.example.demo.service;


import com.example.demo.dto.DantocDTO;
import com.example.demo.dto.LoaihopdongDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LoaihopdongService {
    List<LoaihopdongDTO> getAll();                   // Lấy tất cả tôn giáo
    Page<LoaihopdongDTO> getAllPage(int pageNo, int pageSize);
    LoaihopdongDTO getById(Long id);                // Lấy tôn giáo theo ID
    LoaihopdongDTO create(LoaihopdongDTO loaihopdongDTO);   // Tạo mới tôn giáo
    LoaihopdongDTO update(Long id, LoaihopdongDTO loaihopdongDTO); // Cập nhật tôn giáo
    void delete(Long id);                       // Xóa tôn giáo
}
