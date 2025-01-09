package com.example.demo.converter;

import com.example.demo.dto.BacluongDTO;
import com.example.demo.entity.Bacluong;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BacluongConverter  {
    private final ModelMapper modelMapper;

    public BacluongConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BacluongDTO toDTO(Bacluong bacluong) {
        return modelMapper.map(bacluong, BacluongDTO.class);
    }

    public Bacluong toEntity(BacluongDTO bacluongDTO) {
        return modelMapper.map(bacluongDTO, Bacluong.class);
    }
}
