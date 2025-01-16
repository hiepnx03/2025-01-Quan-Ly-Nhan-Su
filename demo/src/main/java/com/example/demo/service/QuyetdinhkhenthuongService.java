package com.example.demo.service;


import com.example.demo.dto.QuyetdinhkhenthuongDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QuyetdinhkhenthuongService {
    List<QuyetdinhkhenthuongDTO> getAll();

    Page<QuyetdinhkhenthuongDTO> getAllPage(int pageNo, int pageSize);

    QuyetdinhkhenthuongDTO getById(Long id);

    QuyetdinhkhenthuongDTO create(QuyetdinhkhenthuongDTO dto);

    QuyetdinhkhenthuongDTO update(Long id, QuyetdinhkhenthuongDTO dto);

    void delete(Long id);
}
