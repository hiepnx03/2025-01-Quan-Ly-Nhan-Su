package com.example.demo.converter;


import com.example.demo.dto.BomonDTO;
import com.example.demo.dto.DonvichucnangDTO;
import com.example.demo.dto.TongiaoDTO;
import com.example.demo.entity.Bomon;
import com.example.demo.entity.Donvichucnang;
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
        BomonDTO bomonDTO = modelMapper.map(bomon, BomonDTO.class);
        return bomonDTO;
    }
    public Bomon toEntity(BomonDTO bomonDTO) {
        Bomon bomon = modelMapper.map(bomonDTO, Bomon.class);
        return bomon;
    }
}
