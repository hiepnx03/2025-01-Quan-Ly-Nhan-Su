package com.example.demo.service;


import com.example.demo.dto.TongiaoDTO;
import com.example.demo.entity.Tongiao;

import java.util.List;

public interface TongiaoService {
    List<TongiaoDTO> getAll();                   // Lấy tất cả tôn giáo
    TongiaoDTO getById(Long id);                // Lấy tôn giáo theo ID
    TongiaoDTO create(TongiaoDTO tongiaoDTO);   // Tạo mới tôn giáo
    TongiaoDTO update(Long id, TongiaoDTO dto); // Cập nhật tôn giáo
    void delete(Long id);                       // Xóa tôn giáo
}
