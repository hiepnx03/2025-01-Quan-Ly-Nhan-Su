package com.example.demo.converter;

import com.example.demo.dto.TongiaoDTO;
import com.example.demo.entity.Tongiao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TongiaoConverter  {
    private final ModelMapper modelMapper;

    public TongiaoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TongiaoDTO toDTO (Tongiao tongiao) {
        return modelMapper.map(tongiao, TongiaoDTO.class);
    }
    public Tongiao toEntity (TongiaoDTO dto) {
        return modelMapper.map(dto, Tongiao.class);
    }
}
