package com.example.demo.converter;

import com.example.demo.dto.KekhaitaisanDTO;
import com.example.demo.entity.Kekhaitaisan;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class KekhaitaisanConverter {
    private final ModelMapper modelMapper;

    public KekhaitaisanConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public KekhaitaisanDTO toDTO (Kekhaitaisan kekhaitaisan){
        return modelMapper.map(kekhaitaisan, KekhaitaisanDTO.class);
    }

    public Kekhaitaisan toEntity(KekhaitaisanDTO kekhaitaisanDTO){
        return modelMapper.map(kekhaitaisanDTO , Kekhaitaisan.class);
    }

}
