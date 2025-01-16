package com.example.demo.service;


import com.example.demo.dto.DanhsachthamnienDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DanhsachthamnienService {
    List<DanhsachthamnienDTO> getAll();

    Page<DanhsachthamnienDTO> getAllPage(int pageNo, int pageSize);

    DanhsachthamnienDTO getById(Long id);

    DanhsachthamnienDTO create(DanhsachthamnienDTO danhsachthamnienDTO);

    DanhsachthamnienDTO update(Long id, DanhsachthamnienDTO danhsachthamnienDTO);

    void delete(Long id);
}
