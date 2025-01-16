package com.example.demo.service;

import com.example.demo.dto.KekhaitaisanDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KekhaitaisanService {
    List<KekhaitaisanDTO> getAll();

    Page<KekhaitaisanDTO> getAllPage(int pageNo, int pageSize);

    KekhaitaisanDTO getById(Long id);

    KekhaitaisanDTO create(KekhaitaisanDTO kekhaitaisanDTO);

    KekhaitaisanDTO update(Long id, KekhaitaisanDTO kekhaitaisanDTO);

    void delete(Long id);
}
