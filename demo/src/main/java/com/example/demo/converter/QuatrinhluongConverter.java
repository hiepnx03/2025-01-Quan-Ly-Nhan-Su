package com.example.demo.converter;

import com.example.demo.dto.QuatrinhluongDTO;
import com.example.demo.entity.Quatrinhluong;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class QuatrinhluongConverter {
    private final ModelMapper modelMapper;

    public QuatrinhluongConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuatrinhluongDTO toDTO(Quatrinhluong quatrinhluong) {
        return modelMapper.map(quatrinhluong, QuatrinhluongDTO.class);
    }

    public Quatrinhluong toEntity(QuatrinhluongDTO quatrinhluongDTO) {
        return modelMapper.map(quatrinhluongDTO, Quatrinhluong.class);
    }

}
