package com.example.demo.service;


import com.example.demo.dto.ChucvuDTO;

import java.util.ArrayList;
import java.util.List;

public interface ChucvuService {

    public List<ChucvuDTO> getAll();

    void delete(Long id, Integer version);

    public ChucvuDTO getById(Long id);

    ChucvuDTO update(ChucvuDTO chucvuDTO);

    ChucvuDTO insert(ChucvuDTO chucvuDTO);
}
