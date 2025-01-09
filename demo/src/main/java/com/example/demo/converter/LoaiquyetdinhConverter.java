package com.example.demo.converter;

import com.example.demo.dto.LoaiquyetdinhDTO;
import com.example.demo.entity.Loaiquyetdinh;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LoaiquyetdinhConverter {
    private final ModelMapper modelMapper;

    public LoaiquyetdinhConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public LoaiquyetdinhDTO toDTO(Loaiquyetdinh loaiquyetdinh) {
        return modelMapper.map(loaiquyetdinh, LoaiquyetdinhDTO.class);
    }

    public Loaiquyetdinh toEntity(LoaiquyetdinhDTO loaiquyetdinhDTO) {
        return modelMapper.map(loaiquyetdinhDTO, Loaiquyetdinh.class);
    }
}
