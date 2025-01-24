package com.example.demo.service;


import com.example.demo.dto.DantocDTO;
import com.example.demo.dto.LoaihopdongDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LoaihopdongService {
    List<LoaihopdongDTO> getAll();
    Page<LoaihopdongDTO> getAllPage(int pageNo, int pageSize);
    LoaihopdongDTO getById(Long id);
    LoaihopdongDTO create(LoaihopdongDTO loaihopdongDTO);
    LoaihopdongDTO update(Long id, LoaihopdongDTO loaihopdongDTO);
    void delete(Long id);


    Page<LoaihopdongDTO> searchByTenLoaiHopDong(String tenLoaiHopDong, int pageNo, int pageSize);

}
