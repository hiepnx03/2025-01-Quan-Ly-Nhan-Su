package com.example.demo.service.impl;


import com.example.demo.converter.DanhsachkhoangonConverter;
import com.example.demo.converter.DanhsachkiemnhiemConverter;
import com.example.demo.dto.DanhsachkiemnhiemDTO;
import com.example.demo.entity.Danhsachkiemnhiem;
import com.example.demo.repository.DanhsachkiemnhiemRepository;
import com.example.demo.service.DanhsachkiemnhiemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DanhsachkiemnhiemServiceImpl implements DanhsachkiemnhiemService {
    private final DanhsachkiemnhiemRepository danhsachkiemnhiemRepository;
    private final DanhsachkiemnhiemConverter danhsachkiemnhiemConverter;


//    @Override
//    public List<DanhsachkiemnhiemDTO> getAll() {
//        List<Danhsachkiemnhiem> danhsachkiemnhiemList = danhsachkiemnhiemRepository.findAll();
//        return danhsachkiemnhiemList.stream().map(danhsachkiemnhiemConverter::toDTO).collect(Collectors.toList());
//    }
}
