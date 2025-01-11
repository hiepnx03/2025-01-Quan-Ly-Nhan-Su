package com.example.demo.controller;

import com.example.demo.dto.QuequanDTO;
import com.example.demo.service.QuequanService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quequan")
@AllArgsConstructor
public class QuequanController  {
    private final QuequanService quequanService;

    @GetMapping("{canboId}/quequan")
    public ResponseEntity<List<QuequanDTO>> getAllByCanboId(@PathVariable Long canboId) {
        List<QuequanDTO> quequans = quequanService.getAllByCanboId(canboId);
        return ResponseEntity.ok(quequans);
    }

    @PostMapping("{canboId}/quequan")
    public ResponseEntity<QuequanDTO> create(@PathVariable Long canboId, @RequestBody QuequanDTO quequanDTO) {
        QuequanDTO savedQuequan = quequanService.create(canboId, quequanDTO);
        return ResponseEntity.ok(savedQuequan);
    }

    @PutMapping("{canboId}/quequan/{quequanId}")
    public ResponseEntity<QuequanDTO> update(
            @PathVariable Long canboId,
            @PathVariable Long quequanId,
            @RequestBody QuequanDTO quequanDTO) {
        QuequanDTO updatedQuequan = quequanService.update(canboId, quequanId, quequanDTO);
        return ResponseEntity.ok(updatedQuequan);
    }

    @DeleteMapping("{canboId}/quequan/{quequanId}")
    public ResponseEntity<Void> delete(@PathVariable Long canboId, @PathVariable Long quequanId) {
        quequanService.delete(canboId, quequanId);
        return ResponseEntity.noContent().build();
    }

}
