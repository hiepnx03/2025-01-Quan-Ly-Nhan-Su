package com.example.demo.service.impl;


import com.example.demo.converter.DantocConverter;
import com.example.demo.dto.DantocDTO;
import com.example.demo.entity.Dantoc;
import com.example.demo.repository.DantocRepository;
import com.example.demo.service.DantocService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DantocServiceImpl implements DantocService {

    private final DantocRepository dantocRepository;
    private final DantocConverter dantocConverter;
    @Override
    public List<DantocDTO> getAll() {
        List<Dantoc> dantocList = dantocRepository.findAll();
        return dantocList.stream().map(dantocConverter::toDTO).collect(Collectors.toList());
    }
}
