package com.example.demo.service;


import com.example.demo.dto.DanhsachkiemnhiemDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DanhsachkiemnhiemService {
    List<DanhsachkiemnhiemDTO> getAll();

    Page<DanhsachkiemnhiemDTO> getAllPage(int pageNo, int pageSize);

    DanhsachkiemnhiemDTO getById(Long id);

    DanhsachkiemnhiemDTO create(DanhsachkiemnhiemDTO dto);

    DanhsachkiemnhiemDTO update(Long id, DanhsachkiemnhiemDTO dto);

    void delete(Long id);
}
