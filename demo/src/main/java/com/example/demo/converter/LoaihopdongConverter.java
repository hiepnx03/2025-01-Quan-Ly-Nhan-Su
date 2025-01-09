package com.example.demo.converter;

import com.example.demo.dto.LoaihopdongDTO;
import com.example.demo.entity.Loaihopdong;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LoaihopdongConverter  {
    private final ModelMapper modelMapper;

    public LoaihopdongConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public LoaihopdongDTO toDTO(Loaihopdong loaihopdong) {
        return modelMapper.map(loaihopdong, LoaihopdongDTO.class);
    }

    public Loaihopdong toEntity(LoaihopdongDTO loaihopdongDTO) {
        return modelMapper.map(loaihopdongDTO, Loaihopdong.class);
    }
}
