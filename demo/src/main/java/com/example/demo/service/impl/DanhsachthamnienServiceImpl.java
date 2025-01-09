package com.example.demo.service.impl;


import com.example.demo.converter.DanhsachthamnienConverter;
import com.example.demo.dto.DanhsachthamnienDTO;
import com.example.demo.entity.Danhsachthamnien;
import com.example.demo.repository.DanhsachthamnienRepository;
import com.example.demo.service.DanhsachthamnienService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DanhsachthamnienServiceImpl implements DanhsachthamnienService {
    private final DanhsachthamnienRepository danhsachthamnienRepository;
    private final DanhsachthamnienConverter danhsachthamnienConverter;

    @Override
    public List<DanhsachthamnienDTO> getAll() {
        List<Danhsachthamnien> danhsachthamnienList= danhsachthamnienRepository.findAll();
        return danhsachthamnienList.stream().map(danhsachthamnienConverter::toDTO).collect(Collectors.toList());
    }
}
