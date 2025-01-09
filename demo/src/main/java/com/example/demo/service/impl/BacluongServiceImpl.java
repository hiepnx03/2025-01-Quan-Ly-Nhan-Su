package com.example.demo.service.impl;


import com.example.demo.converter.BacluongConverter;
import com.example.demo.dto.BacluongDTO;
import com.example.demo.entity.Bacluong;
import com.example.demo.repository.BacluongRepository;
import com.example.demo.service.BacluongService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BacluongServiceImpl implements BacluongService {
    private final BacluongRepository bacluongRepository;
    private final BacluongConverter bacluongConverter;

    @Override
    public List<BacluongDTO> getAll() {
        List<Bacluong> bacluongList = bacluongRepository.findAll();
        return bacluongList.stream().map(bacluongConverter::toDTO)
                .collect(Collectors.toList());
    }
}
