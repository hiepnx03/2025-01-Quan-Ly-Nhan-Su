package com.example.demo.service;


import com.example.demo.dto.ChucvuDTO;

import java.util.List;

public interface ChucvuService {

    List<ChucvuDTO> getAll();
    ChucvuDTO getById(Long id);
    ChucvuDTO create(ChucvuDTO chucvuDTO);
    ChucvuDTO update(Long id, ChucvuDTO chucvuDTO);
    void delete(Long id);
}
