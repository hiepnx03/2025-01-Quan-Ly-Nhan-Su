package com.example.demo.service;


import com.example.demo.dto.TongiaoDTO;
import com.example.demo.entity.Tongiao;

import java.util.List;

public interface TongiaoService {
    List<TongiaoDTO> getAll();
    void delete(Long id, Integer version);
    public TongiaoDTO getById(Long id);
    TongiaoDTO update(TongiaoDTO tongiaoDTO);
    TongiaoDTO insert(TongiaoDTO tongiaoDTO);
}
