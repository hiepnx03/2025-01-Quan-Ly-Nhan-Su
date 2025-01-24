package com.example.demo.service;


import com.example.demo.dto.NgachcongchucDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NgachcongchucService {
    List<NgachcongchucDTO> getAll();

    Page<NgachcongchucDTO> getAllPage(int pageNo, int pageSize);

    NgachcongchucDTO getById(Long id);

    NgachcongchucDTO create(NgachcongchucDTO dto);

    NgachcongchucDTO update(Long id, NgachcongchucDTO dto);

    void delete(Long id);

    Page<NgachcongchucDTO> searchByMaNgachOrSoNamNangBacLuongOrTenNgach(String keyword, int pageNo, int pageSize);

}
