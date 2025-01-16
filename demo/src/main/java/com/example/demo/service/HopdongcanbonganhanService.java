package com.example.demo.service;

import com.example.demo.dto.HopdongcanboDTO;
import com.example.demo.dto.HopdongcanbonganhanDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HopdongcanbonganhanService {
    public List<HopdongcanbonganhanDTO> getAll();
    public Page<HopdongcanbonganhanDTO> getAllPage(int pageNo, int pageSize);
    public HopdongcanbonganhanDTO getById(Long id);
    public HopdongcanbonganhanDTO create(HopdongcanbonganhanDTO hopdongcanbonganhanDTO);
    public HopdongcanbonganhanDTO update(Long id, HopdongcanbonganhanDTO hopdongcanbonganhanDTO);
    public void delete(Long id);
}
