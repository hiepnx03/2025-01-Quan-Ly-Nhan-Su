package com.example.demo.controller;

import com.example.demo.dto.BacluongDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.BacluongService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/bacluong")
@AllArgsConstructor
public class BacluongController {
    private final BacluongService bacluongService;

    @GetMapping("/show")
    public ResponseEntity<ResponseObject> getAll() {
        List<BacluongDTO> bacluongDTOList = bacluongService.getAll();
        return ResponseEntity.ok(new ResponseObject("200", "Addresses retrieved successfully", bacluongDTOList));
    }
}
