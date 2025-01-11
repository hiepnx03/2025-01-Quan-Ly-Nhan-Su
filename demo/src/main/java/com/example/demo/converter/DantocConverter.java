package com.example.demo.converter;


import com.example.demo.dto.DantocDTO;
import com.example.demo.entity.Dantoc;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DantocConverter  {
    private final ModelMapper modelMapper;

    public DantocConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DantocDTO toDTO(Dantoc dantoc) {
        return modelMapper.map(dantoc, DantocDTO.class);
    }

    public Dantoc toEntity(DantocDTO dantocDTO) {
        return modelMapper.map(dantocDTO, Dantoc.class);
    }
}
