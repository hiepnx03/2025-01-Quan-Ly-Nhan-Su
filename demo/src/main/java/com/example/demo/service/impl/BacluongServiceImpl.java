package com.example.demo.service.impl;


import com.example.demo.converter.BacluongConverter;
import com.example.demo.dto.BacluongDTO;
import com.example.demo.entity.Bacluong;
import com.example.demo.repository.BacluongRepository;
import com.example.demo.service.BacluongService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BacluongServiceImpl implements BacluongService {
    private final BacluongRepository bacluongRepository;
    private final BacluongConverter bacluongConverter;

    @Override
    public Page<BacluongDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of (pageNo,pageSize);
        Page<Bacluong> bacluongPage= bacluongRepository.findAllPage(pageable);
        Page<BacluongDTO> bacluongDTOPage = bacluongPage.map(bacluongConverter::toDTO);
        return bacluongDTOPage;
    }

    @Override
    public List<BacluongDTO> getAll() {
        List<Bacluong> bacluongList = bacluongRepository.findAll();
        return bacluongList.stream().map(bacluongConverter::toDTO)
                .collect(Collectors.toList());
    }
}
