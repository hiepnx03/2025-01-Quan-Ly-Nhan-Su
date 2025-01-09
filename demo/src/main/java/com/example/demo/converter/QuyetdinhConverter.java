package com.example.demo.converter;

import com.example.demo.dto.QuyetdinhDTO;
import com.example.demo.entity.Quyetdinh;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class QuyetdinhConverter {
    private final ModelMapper modelMapper;

    public QuyetdinhConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuyetdinhDTO toDTO(Quyetdinh quyetdinh) {
        return modelMapper.map(quyetdinh, QuyetdinhDTO.class);
    }
    public Quyetdinh toEntity(QuyetdinhDTO quyetdinhDTO) {
        return modelMapper.map(quyetdinhDTO, Quyetdinh.class);
    }
}
