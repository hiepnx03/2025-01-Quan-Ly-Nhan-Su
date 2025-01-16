package com.example.demo.service;


import com.example.demo.dto.QuatrinhluongDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QuatrinhluongService {
    List<QuatrinhluongDTO> getAll();

    Page<QuatrinhluongDTO> getAllPage(int pageNo, int pageSize);

    QuatrinhluongDTO getById(Long id);

    QuatrinhluongDTO create(QuatrinhluongDTO dto);

    QuatrinhluongDTO update(Long id, QuatrinhluongDTO dto);

    void delete(Long id);

}
