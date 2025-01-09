package com.example.demo.converter;


import com.example.demo.dto.BomonDTO;
import com.example.demo.entity.Bomon;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BomonConverter {
    private final ModelMapper modelMapper;

    public BomonConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public BomonDTO toDTO(Bomon bomon) {
        return modelMapper.map(bomon, BomonDTO.class);
    }
    public Bomon toEntity(BomonDTO bomonDTO) {
        return modelMapper.map(bomonDTO, Bomon.class);
    }
}
