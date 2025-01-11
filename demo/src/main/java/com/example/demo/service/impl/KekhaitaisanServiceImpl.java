package com.example.demo.service.impl;

import com.example.demo.converter.KekhaitaisanConverter;
import com.example.demo.dto.KekhaitaisanDTO;
import com.example.demo.entity.Kekhaitaisan;
import com.example.demo.repository.KekhaitaisanRepository;
import com.example.demo.service.KekhaitaisanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KekhaitaisanServiceImpl implements KekhaitaisanService {

    private final KekhaitaisanRepository kekhaitaisanRepository;
    private final KekhaitaisanConverter kekhaitaisanConverter;

    @Override
    public List<KekhaitaisanDTO> getAll() {
        List<Kekhaitaisan> kekhaitaisanList = kekhaitaisanRepository.findAll();
        return kekhaitaisanList.stream().map(kekhaitaisanConverter::toDTO).collect(Collectors.toList());
    }
}
