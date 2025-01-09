package com.example.demo.converter;

import com.example.demo.dto.NgachcongchucDTO;
import com.example.demo.entity.Ngachcongchuc;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NgachcongchucConverter  {
    private final ModelMapper modelMapper;

    public NgachcongchucConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public NgachcongchucDTO toDTO (Ngachcongchuc ngachcongchuc) {
        return modelMapper.map(ngachcongchuc, NgachcongchucDTO.class);
    }
    public Ngachcongchuc toEntity (NgachcongchucDTO ngachcongchucDTO) {
        return modelMapper.map(ngachcongchucDTO, Ngachcongchuc.class);
    }
}
