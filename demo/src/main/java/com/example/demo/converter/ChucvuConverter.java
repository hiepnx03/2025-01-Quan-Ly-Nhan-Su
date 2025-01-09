package com.example.demo.converter;


import com.example.demo.dto.ChucvuDTO;
import com.example.demo.entity.Chucvu;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ChucvuConverter  {
    private final ModelMapper modelMapper;

    public ChucvuConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ChucvuDTO toDTO(Chucvu chucvu) {
        return modelMapper.map(chucvu, ChucvuDTO.class);
    }
    public Chucvu toEntity(ChucvuDTO chucvuDTO) {
        return modelMapper.map(chucvuDTO, Chucvu.class);
    }
}
