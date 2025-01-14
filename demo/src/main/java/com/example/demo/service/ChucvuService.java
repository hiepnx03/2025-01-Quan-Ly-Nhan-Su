package com.example.demo.service;


import com.example.demo.dto.ChucvuDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChucvuService {

    List<ChucvuDTO> getAll();
    public Page<ChucvuDTO> getAllPage(int pageNo, int pageSize);
    ChucvuDTO getById(Long id);
    ChucvuDTO create(ChucvuDTO chucvuDTO);
    ChucvuDTO update(Long id, ChucvuDTO chucvuDTO);
    void delete(Long id);
}
