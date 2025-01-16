package com.example.demo.service;


import com.example.demo.dto.BacluongDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BacluongService {
    List<BacluongDTO> getAll();

    Page<BacluongDTO> getAllPage(int pageNo, int pageSize);

    BacluongDTO getById(Long id);

    BacluongDTO create(BacluongDTO dto);

    BacluongDTO update(Long id, BacluongDTO dto);

    void delete(Long id);
}
