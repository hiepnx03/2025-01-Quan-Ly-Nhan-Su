package com.example.demo.controller.admin;

import com.example.demo.dto.response.ResponseObject;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import com.example.demo.dto.QuyetdinhDTO;
import com.example.demo.service.QuyetdinhService;


@RestController
@RequestMapping("/admin/quyetdinh")
@AllArgsConstructor
public class QuyetdinhController {

    private final QuyetdinhService quyetdinhService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<QuyetdinhDTO> list = quyetdinhService.getAll();
        return ResponseEntity.ok(new ResponseObject("200", "Danh sách quyết định", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        QuyetdinhDTO quyetdinh = quyetdinhService.getById(id);
        return ResponseEntity.ok(new ResponseObject("200", "Chi tiết quyết định", quyetdinh));
    }

    @PostMapping
    public ResponseEntity<ResponseObject> create(@RequestBody QuyetdinhDTO dto) {
        QuyetdinhDTO created = quyetdinhService.create(dto);
        return ResponseEntity.ok(new ResponseObject("200", "Tạo mới quyết định thành công", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> update(@PathVariable Long id, @RequestBody QuyetdinhDTO dto) {
        QuyetdinhDTO updated = quyetdinhService.update(id, dto);
        return ResponseEntity.ok(new ResponseObject("200", "Cập nhật quyết định thành công", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        quyetdinhService.delete(id);
        return ResponseEntity.ok(new ResponseObject("200", "Xóa quyết định thành công", null));
    }
}
