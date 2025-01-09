package com.example.demo.converter;

import com.example.demo.dto.QuyetdinhkyluatDTO;
import com.example.demo.entity.Quyetdinhkyluat;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class QuyetdinhkyluatConverter  {

    private final ModelMapper modelMapper;

    public QuyetdinhkyluatConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuyetdinhkyluatDTO toDTO (Quyetdinhkyluat quyetdinhkyluat) {
        return modelMapper.map(quyetdinhkyluat, QuyetdinhkyluatDTO.class);
    }

    public Quyetdinhkyluat toEntity (QuyetdinhkyluatDTO quyetdinhkyluatDTO) {
        return modelMapper.map(quyetdinhkyluatDTO, Quyetdinhkyluat.class);
    }
}

