package com.example.demo.service.impl;


import com.example.demo.controller.admin.ChucvuController;
import com.example.demo.converter.ChucvuConverter;
import com.example.demo.dto.ChucvuDTO;
import com.example.demo.entity.Chucvu;
import com.example.demo.repository.ChucvuRepository;
import com.example.demo.service.ChucvuService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ChucvuServiceImpl implements ChucvuService {
    private final ChucvuRepository chucvuRepository;
    private final ChucvuConverter chucvuConverter;

    public ChucvuServiceImpl(ChucvuRepository chucvuRepository, ChucvuConverter chucvuConverter) {
        this.chucvuRepository = chucvuRepository;
        this.chucvuConverter = chucvuConverter;
    }

    @Override
    public List<ChucvuDTO> getAll() {
        List<Chucvu> chucvuList = chucvuRepository.findAll();
        return chucvuList.stream()
                .map(chucvuConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id, Integer version) {

    }

    @Override
    public ChucvuDTO getById(Long id) {
        return null;
    }

    @Override
    public ChucvuDTO update(ChucvuDTO chucvuDTO) {
        return null;
    }

    @Override
    public ChucvuDTO insert(ChucvuDTO chucvuDTO) {
        return null;
    }
}
