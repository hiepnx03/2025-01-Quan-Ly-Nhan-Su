package com.example.demo.service.impl;


import com.example.demo.converter.CanboConverter;
import com.example.demo.dto.CanboDTO;
import com.example.demo.entity.Canbo;
import com.example.demo.repository.*;
import com.example.demo.service.CanboService;
import com.example.demo.service.DonvichucnangService;
import com.example.demo.service.NgachcongchucService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CanboServiceImpl implements CanboService {
    private final CanboRepository canBoRepository;
    private final DonvichucnangRepository donViChucNangRepository;
    private final BomonRepository boMonRepository;
    private final BacluongRepository bacLuongRepository;
    private final ChucvuRepository chucVuRepository;
    private final DantocRepository danTocRepository;
    private final TongiaoRepository tonGiaoRepository;
    private final NgachcongchucRepository ngachCongChucRepository;
    private final QuequanRepository queQuanRepository;
    private final DonvichucnangService donViChucNangService;
    private final NgachcongchucService ngachCongChucService;
    private final CanboConverter canboConverter;

    @Override
    public List<CanboDTO> getAll() {
        List<Canbo> canBoList = canBoRepository.findAll();

        return canBoList.stream()
                .map(canboConverter::toDTO)
                .collect(Collectors.toList());
    }
}
