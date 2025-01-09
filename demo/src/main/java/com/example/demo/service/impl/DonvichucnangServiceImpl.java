package com.example.demo.service.impl;

import com.example.demo.converter.DonvichucnangConverter;
import com.example.demo.dto.DonvichucnangDTO;
import com.example.demo.entity.Donvichucnang;
import com.example.demo.repository.DonvichucnangRepository;
import com.example.demo.service.DonvichucnangService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DonvichucnangServiceImpl implements DonvichucnangService {
    private final DonvichucnangRepository donvichucnangRepository;
    private final DonvichucnangConverter donvichucnangConverter;

    @Override
    public List<DonvichucnangDTO> getAll() {
        List<Donvichucnang> donvichucnangList = donvichucnangRepository.findAll();
        return donvichucnangList.stream().map(donvichucnangConverter::toDTO).collect(Collectors.toList());
    }
}
