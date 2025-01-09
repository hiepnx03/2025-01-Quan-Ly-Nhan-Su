package com.example.demo.converter;

import com.example.demo.dto.QuyetdinhkhenthuongDTO;
import com.example.demo.entity.Quyetdinhkhenthuong;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class QuyetdinhkhenthuongConverter  {
    private final ModelMapper modelMapper;

    public QuyetdinhkhenthuongConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuyetdinhkhenthuongDTO toDTO (Quyetdinhkhenthuong quyetdinhkhenthuong) {
        return modelMapper.map(quyetdinhkhenthuong, QuyetdinhkhenthuongDTO.class);
    }

    public Quyetdinhkhenthuong toEntity (QuyetdinhkhenthuongDTO quyetdinhkhenthuongDTO) {
        return modelMapper.map(quyetdinhkhenthuongDTO,Quyetdinhkhenthuong.class);
    }
}
