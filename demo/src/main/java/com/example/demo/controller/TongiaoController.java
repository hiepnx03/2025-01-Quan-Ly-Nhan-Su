package com.example.demo.controller;

import com.example.demo.dto.TongiaoDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.TongiaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/tongiao")
@AllArgsConstructor
public class TongiaoController {

    private final TongiaoService tongiaoService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<TongiaoDTO> result = tongiaoService.getAll();
        return ResponseEntity.ok(new ResponseObject("200", "Danh sách tôn giáo", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        TongiaoDTO result = tongiaoService.getById(id);
        return ResponseEntity.ok(new ResponseObject("200", "Chi tiết tôn giáo", result));
    }

    @PostMapping
    public ResponseEntity<ResponseObject> create(@RequestBody TongiaoDTO tongiaoDTO) {
        TongiaoDTO created = tongiaoService.create(tongiaoDTO);
        return ResponseEntity.ok(new ResponseObject("200", "Tạo mới tôn giáo thành công", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> update(@PathVariable Long id, @RequestBody TongiaoDTO tongiaoDTO) {
        TongiaoDTO updated = tongiaoService.update(id, tongiaoDTO);
        return ResponseEntity.ok(new ResponseObject("200", "Cập nhật tôn giáo thành công", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        tongiaoService.delete(id);
        return ResponseEntity.ok(new ResponseObject("200", "Xóa tôn giáo thành công", null));
    }
}
