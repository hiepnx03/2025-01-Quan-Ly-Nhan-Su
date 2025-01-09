package com.example.demo.service.impl;


import com.example.demo.converter.DanhsachkhoangonConverter;
import com.example.demo.dto.DanhsachkhoangonDTO;
import com.example.demo.entity.Danhsachkhoangon;
import com.example.demo.repository.DanhsachkhoangonRepository;
import com.example.demo.service.DanhsachkhoangonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DanhsachkhoangonServiceImpl implements DanhsachkhoangonService {
    private final DanhsachkhoangonRepository danhsachkhoangonRepository;
    private final DanhsachkhoangonConverter danhsachkhoangonConverter;

    @Override
    public List<DanhsachkhoangonDTO> getAll() {
        List<Danhsachkhoangon> danhsachkhoangonList = danhsachkhoangonRepository.findAll();
        return danhsachkhoangonList.stream().map(danhsachkhoangonConverter::toDTO).collect(Collectors.toList());
    }
}
