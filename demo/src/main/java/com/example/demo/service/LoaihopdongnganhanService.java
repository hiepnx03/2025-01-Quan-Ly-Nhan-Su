package com.example.demo.service;


import com.example.demo.dto.LoaihopdongnganhanDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LoaihopdongnganhanService {
    List<LoaihopdongnganhanDTO> getAll();
    Page<LoaihopdongnganhanDTO> getAllPage(int pageNo, int pageSize);
    LoaihopdongnganhanDTO getById(Long id);
    LoaihopdongnganhanDTO create(LoaihopdongnganhanDTO loaihopdongnganhanDTO);
    LoaihopdongnganhanDTO update(Long id, LoaihopdongnganhanDTO loaihopdongnganhanDTO);
    void delete(Long id);
}
