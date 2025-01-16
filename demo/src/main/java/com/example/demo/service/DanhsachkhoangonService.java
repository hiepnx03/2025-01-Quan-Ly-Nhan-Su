package com.example.demo.service;


import com.example.demo.dto.DanhsachkhoangonDTO;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface DanhsachkhoangonService {
    List<DanhsachkhoangonDTO> getAll();

    Page<DanhsachkhoangonDTO> getAllPage(int pageNo, int pageSize);

    DanhsachkhoangonDTO getById(Long id);

    DanhsachkhoangonDTO create(DanhsachkhoangonDTO dto);

    DanhsachkhoangonDTO update(Long id, DanhsachkhoangonDTO dto);

    void delete(Long id);


}
