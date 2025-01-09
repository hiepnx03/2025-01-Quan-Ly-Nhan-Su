package com.example.demo.converter;


import com.example.demo.dto.CanboDTO;
import com.example.demo.entity.Canbo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CanboConverter  {
    private final ModelMapper modelMapper;

    public CanboConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CanboDTO toDTO(Canbo canbo) {
        return modelMapper.map(canbo, CanboDTO.class);
    }

    public Canbo toEntity(CanboDTO canboDTO) {
        return modelMapper.map(canboDTO, Canbo.class);
    }
}
