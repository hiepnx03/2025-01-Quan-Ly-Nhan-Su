package com.example.demo.service.impl;


import com.example.demo.converter.HopdongnganhanConverter;
import com.example.demo.dto.HopdongnganhanDTO;
import com.example.demo.entity.Hopdongnganhan;
import com.example.demo.repository.HopdongnganhanRepository;
import com.example.demo.service.HopdongnganhanService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HopdongnganhanServiceImpl implements HopdongnganhanService {

    private final HopdongnganhanRepository hopdonganhanRepository;
    private final HopdongnganhanConverter hopdongnganhanConverter;
    @Override
    public List<HopdongnganhanDTO> getAll() {
        List<Hopdongnganhan> hopdongnganhanList = hopdonganhanRepository.findAll();
        return hopdongnganhanList.stream().map(hopdongnganhanConverter::toDTO).collect(Collectors.toList());
    }
}