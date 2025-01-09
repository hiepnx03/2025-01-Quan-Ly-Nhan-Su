package com.example.demo.converter;


import com.example.demo.dto.HopdongcanboDTO;
import com.example.demo.entity.Hopdongcanbo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HopdongcanboConverter  {
    private final ModelMapper modelMapper;

    public HopdongcanboConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public HopdongcanboDTO toDTO(Hopdongcanbo hopdongcanbo) {
        return modelMapper.map(hopdongcanbo, HopdongcanboDTO.class);
    }

    public Hopdongcanbo toEntity(HopdongcanboDTO hopdongcanboDTO) {
        return modelMapper.map(hopdongcanboDTO, Hopdongcanbo.class);
    }
}
