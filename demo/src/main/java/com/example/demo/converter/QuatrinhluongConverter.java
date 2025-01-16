package com.example.demo.converter;

import com.example.demo.dto.BacluongDTO;
import com.example.demo.dto.DonvichucnangDTO;
import com.example.demo.dto.NgachcongchucDTO;
import com.example.demo.dto.QuatrinhluongDTO;
import com.example.demo.entity.Bacluong;
import com.example.demo.entity.Donvichucnang;
import com.example.demo.entity.Ngachcongchuc;
import com.example.demo.entity.Quatrinhluong;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class QuatrinhluongConverter {
    private final ModelMapper modelMapper;

    public QuatrinhluongConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuatrinhluongDTO toDTO(Quatrinhluong quatrinhluong) {
        QuatrinhluongDTO quatrinhluongDTO = modelMapper.map(quatrinhluong, QuatrinhluongDTO.class);

        if (quatrinhluong.getDonvichucnang() != null) {
            DonvichucnangDTO donvichucnangDTO = new DonvichucnangDTO();

            donvichucnangDTO.setId(quatrinhluong.getDonvichucnang().getId());
            donvichucnangDTO.setMaDonVi(quatrinhluong.getDonvichucnang().getMaDonVi());
            donvichucnangDTO.setTenDonVi(quatrinhluong.getDonvichucnang().getTenDonVi());
            donvichucnangDTO.setVersion(quatrinhluong.getDonvichucnang().getVersion());

            quatrinhluongDTO.setDonvichucnangDTO(donvichucnangDTO);
        }


        if (quatrinhluong.getNgachcongchuc() != null) {
            NgachcongchucDTO ngachcongchucDTO = new NgachcongchucDTO();

            ngachcongchucDTO.setId(quatrinhluong.getNgachcongchuc().getId());
            ngachcongchucDTO.setMaNgach(quatrinhluong.getNgachcongchuc().getMaNgach());
            ngachcongchucDTO.setTenNgach(quatrinhluong.getNgachcongchuc().getTenNgach());
            ngachcongchucDTO.setSoNamNangBacLuong(quatrinhluong.getNgachcongchuc().getSoNamNangBacLuong());
            ngachcongchucDTO.setVersion(quatrinhluong.getNgachcongchuc().getVersion());

            quatrinhluongDTO.setNgachcongchucDTO(ngachcongchucDTO);
        }

        if (quatrinhluong.getBacluong() != null) {
            BacluongDTO bacluongDTO = new BacluongDTO();

            bacluongDTO.setId(quatrinhluong.getBacluong().getId());
            bacluongDTO.setMaBacLuong(quatrinhluong.getBacluong().getMaBacLuong());
            bacluongDTO.setHeSoLuong(quatrinhluong.getBacluong().getHeSoLuong());
            bacluongDTO.setPhuCapVuotKhung(quatrinhluong.getBacluong().getPhuCapVuotKhung());

            quatrinhluongDTO.setBacluongDTO(bacluongDTO);
        }




        return quatrinhluongDTO;
    }

    public Quatrinhluong toEntity(QuatrinhluongDTO quatrinhluongDTO) {
        Quatrinhluong quatrinhluong = modelMapper.map(quatrinhluongDTO, Quatrinhluong.class);


        // Bỏ qua việc gán lại donvichucnang nếu đã được thiết lập từ trước
        if (quatrinhluong.getDonvichucnang() == null && quatrinhluongDTO.getDonvichucnangDTO() != null) {
            Donvichucnang donvichucnang = new Donvichucnang();
            donvichucnang.setId(quatrinhluongDTO.getDonvichucnangDTO().getId());
            quatrinhluong.setDonvichucnang(donvichucnang);
        }

        // Bỏ qua việc gán lại Bacluong nếu đã được thiết lập từ trước
        if (quatrinhluong.getBacluong() == null && quatrinhluongDTO.getBacluongDTO() != null) {
            Bacluong bacluong = new Bacluong();
            bacluong.setId(quatrinhluongDTO.getBacluongDTO().getId());
            quatrinhluong.setBacluong(bacluong);
        }

        // Bỏ qua việc gán lại ngachcongchuc nếu đã được thiết lập từ trước
        if (quatrinhluong.getNgachcongchuc() == null && quatrinhluongDTO.getNgachcongchucDTO() != null) {
            Ngachcongchuc ngachcongchuc = new Ngachcongchuc();
            ngachcongchuc.setId(quatrinhluongDTO.getNgachcongchucDTO().getId());
            quatrinhluong.setNgachcongchuc(ngachcongchuc);
        }


        return quatrinhluong;
    }

}
