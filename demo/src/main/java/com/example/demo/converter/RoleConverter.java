package com.example.demo.converter;

import com.example.demo.dto.RoleDTO;
import com.example.demo.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {
    private final ModelMapper modelMapper;

    public RoleConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RoleDTO convertToDto(Role entity) {
        return modelMapper.map(entity, RoleDTO.class);
    }

    public Role convertToEntity(RoleDTO dto) {
        return modelMapper.map(dto, Role.class);
    }
}
