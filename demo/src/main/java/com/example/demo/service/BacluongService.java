package com.example.demo.service;


import com.example.demo.dto.BacluongDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BacluongService {
    public Page<BacluongDTO> getAllPage(int pageNo, int pageSize);
    public List<BacluongDTO> getAll();
}
