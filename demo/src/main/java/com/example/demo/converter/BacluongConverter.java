package com.example.demo.converter;

import com.example.demo.dto.BacluongDTO;
import com.example.demo.dto.NgachcongchucDTO;
import com.example.demo.entity.Bacluong;
import com.example.demo.entity.Ngachcongchuc;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BacluongConverter {
    private final ModelMapper modelMapper;

    public BacluongConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BacluongDTO toDTO(Bacluong bacluong) {
        BacluongDTO bacluongDTO = modelMapper.map(bacluong, BacluongDTO.class);


        //	N-1 bacluong - ngachcongchuc
        if (bacluong.getNgachcongchuc() != null) {
            NgachcongchucDTO ngachcongchucDTO = new NgachcongchucDTO();

            ngachcongchucDTO.setId(bacluong.getNgachcongchuc().getId());
            ngachcongchucDTO.setMaNgach(bacluong.getNgachcongchuc().getMaNgach());
            ngachcongchucDTO.setTenNgach(bacluong.getNgachcongchuc().getTenNgach());
            ngachcongchucDTO.setSoNamNangBacLuong(bacluong.getNgachcongchuc().getSoNamNangBacLuong());
            ngachcongchucDTO.setVersion(bacluong.getNgachcongchuc().getVersion());

            bacluongDTO.setNgachcongchucDTO(ngachcongchucDTO);
        }



        return bacluongDTO;
    }

    public Bacluong toEntity(BacluongDTO bacluongDTO) {
        Bacluong bacluong = modelMapper.map(bacluongDTO, Bacluong.class);


//        // Chuyển đổi Tôn giáo DTO sang Entity
//        //	N-1 bacluong - ngachcongchuc
//        if (bacluongDTO.getNgachcongchucDTO() != null) {
//            bacluong.getNgachcongchuc().setId(bacluongDTO.getNgachcongchucDTO().getId());
//        }


        // N-1: Ánh xạ NgachcongchucDTO sang Ngachcongchuc entity
        if (bacluongDTO.getNgachcongchucDTO() != null) {
            if (bacluong.getNgachcongchuc() == null) {
                bacluong.setNgachcongchuc(new Ngachcongchuc());
            }
            bacluong.getNgachcongchuc().setId(bacluongDTO.getNgachcongchucDTO().getId());
        }

        return bacluong;
    }
}


