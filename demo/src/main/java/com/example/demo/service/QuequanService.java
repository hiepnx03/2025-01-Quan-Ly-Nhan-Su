package com.example.demo.service;


import com.example.demo.dto.QuequanDTO;

import java.util.List;

public interface QuequanService {
    public List<QuequanDTO> getAll();

    List<QuequanDTO> getAllByCanboId(Long canboId); // Lấy tất cả quê quán của một cán bộ
    QuequanDTO create(Long canboId, QuequanDTO quequanDTO); // Tạo quê quán cho cán bộ
    QuequanDTO update(Long canboId, Long quequanId, QuequanDTO quequanDTO); // Cập nhật quê quán
    void delete(Long canboId, Long quequanId); // Xóa quê quán của cán bộ
}
