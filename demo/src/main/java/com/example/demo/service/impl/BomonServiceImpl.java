package com.example.demo.service.impl;


import com.example.demo.converter.BomonConverter;
import com.example.demo.dto.BomonDTO;
import com.example.demo.entity.Bomon;
import com.example.demo.repository.BomonRepository;
import com.example.demo.service.BomonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BomonServiceImpl implements BomonService {
    private final BomonRepository bomonRepository;
    private final BomonConverter bomonConverter;

    @Override
    public List<BomonDTO> getAll() {
        List<Bomon> bomonList = bomonRepository.findAll();
        return bomonList.stream()
                .map(bomonConverter::toDTO)
                .collect(Collectors.toList());
    }
}
