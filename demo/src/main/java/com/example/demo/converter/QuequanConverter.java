package com.example.demo.converter;

import com.example.demo.dto.QuequanDTO;
import com.example.demo.entity.Quequan;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class QuequanConverter {
    private final ModelMapper modelMapper;

    public QuequanConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuequanDTO toDTO(Quequan quequan) {
        return modelMapper.map(quequan, QuequanDTO.class);
    }
    public Quequan toEntity(QuequanDTO quequanDTO) {
        return modelMapper.map(quequanDTO, Quequan.class);
    }
}
