package com.example.demo.controller;

import com.example.demo.dto.DantocDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.DantocService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dantoc")
@AllArgsConstructor
public class DantocController{
    private final DantocService dantocService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<DantocDTO> dantocs = dantocService.getAll();
        return ResponseEntity.ok(new ResponseObject("200", "Danh sách dân tộc", dantocs));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        DantocDTO dantoc = dantocService.getById(id);
        return ResponseEntity.ok(new ResponseObject("200", "Chi tiết dân tộc", dantoc));
    }

    @PostMapping
    public ResponseEntity<ResponseObject> create(@RequestBody DantocDTO dantocDTO) {
        DantocDTO createdDantoc = dantocService.create(dantocDTO);
        return ResponseEntity.ok(new ResponseObject("200", "Tạo mới dân tộc thành công", createdDantoc));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> update(@PathVariable Long id, @RequestBody DantocDTO dantocDTO) {
        DantocDTO updatedDantoc = dantocService.update(id, dantocDTO);
        return ResponseEntity.ok(new ResponseObject("200", "Cập nhật dân tộc thành công", updatedDantoc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        dantocService.delete(id);
        return ResponseEntity.ok(new ResponseObject("200", "Xóa dân tộc thành công", null));
    }
}
