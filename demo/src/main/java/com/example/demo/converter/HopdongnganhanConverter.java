package com.example.demo.converter;

import com.example.demo.dto.HopdongnganhanDTO;
import com.example.demo.entity.Hopdongnganhan;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HopdongnganhanConverter {
    private final ModelMapper modelMapper;

    public HopdongnganhanConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public HopdongnganhanDTO toDTO(Hopdongnganhan hopdongnganhan) {
        return modelMapper.map(hopdongnganhan, HopdongnganhanDTO.class);
    }

    public Hopdongnganhan toEntity(HopdongnganhanDTO hopdongnganhanDTO) {
        return modelMapper.map(hopdongnganhanDTO, Hopdongnganhan.class);
    }

}