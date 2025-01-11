package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.ChucvuDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.ChucvuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin/chucvu")
@AllArgsConstructor
public class ChucvuController {

    private final ChucvuService chucvuService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<ChucvuDTO> result = chucvuService.getAll();
        return ResponseEntity.ok(new ResponseObject("200", "Danh sách chức vụ", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        ChucvuDTO result = chucvuService.getById(id);
        return ResponseEntity.ok(new ResponseObject("200", "Chi tiết chức vụ", result));
    }

    @PostMapping
    public ResponseEntity<ResponseObject> create(@RequestBody ChucvuDTO dto) {
        ChucvuDTO created = chucvuService.create(dto);
        return ResponseEntity.ok(new ResponseObject("200", "Tạo mới chức vụ thành công", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> update(@PathVariable Long id, @RequestBody ChucvuDTO dto) {
        ChucvuDTO updated = chucvuService.update(id, dto);
        return ResponseEntity.ok(new ResponseObject("200", "Cập nhật chức vụ thành công", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        chucvuService.delete(id);
        return ResponseEntity.ok(new ResponseObject("200", "Xóa chức vụ thành công", null));
    }
}
