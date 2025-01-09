package com.example.demo.service.impl;

import com.example.demo.converter.HopdongcanboConverter;
import com.example.demo.dto.HopdongcanboDTO;
import com.example.demo.entity.Hopdongcanbo;
import com.example.demo.repository.HopdongcanboRepository;
import com.example.demo.service.HopdongcanboService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HopdongcanboServiceImpl implements HopdongcanboService {
    private final HopdongcanboRepository hopdongcanboRepository;
    private final HopdongcanboConverter hopdongcanboConverter;
    @Override
    public List<HopdongcanboDTO> getAll() {
        List<Hopdongcanbo> hopdongcanboList = hopdongcanboRepository.findAll();
        return hopdongcanboList.stream().map(hopdongcanboConverter::toDTO).collect(Collectors.toList());
    }
}
