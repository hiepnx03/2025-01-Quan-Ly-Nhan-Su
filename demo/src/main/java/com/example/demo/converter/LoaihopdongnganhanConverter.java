package com.example.demo.converter;

import com.example.demo.dto.LoaihopdongDTO;
import com.example.demo.dto.LoaihopdongnganhanDTO;
import com.example.demo.entity.Loaihopdong;
import com.example.demo.entity.Loaihopdongnganhan;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LoaihopdongnganhanConverter {
    private final ModelMapper modelMapper;

    public LoaihopdongnganhanConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public LoaihopdongnganhanDTO toDTO(Loaihopdongnganhan loaihopdongnganhan) {
        return modelMapper.map(loaihopdongnganhan, LoaihopdongnganhanDTO.class);
    }

    public Loaihopdongnganhan toEntity(LoaihopdongnganhanDTO loaihopdongnganhanDTO) {
        return modelMapper.map(loaihopdongnganhanDTO, Loaihopdongnganhan.class);
    }
}
