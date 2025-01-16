package com.example.demo.service;

import com.example.demo.dto.HopdongcanboDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HopdongcanboService {
    public List<HopdongcanboDTO> getAll();
    public Page<HopdongcanboDTO> getAllPage(int pageNo, int pageSize);
    public HopdongcanboDTO getById(Long id);
    public HopdongcanboDTO create(HopdongcanboDTO hopdongcanboDTO);
    public HopdongcanboDTO update(Long id, HopdongcanboDTO hopdongcanboDTO);
    public void delete(Long id);
}
