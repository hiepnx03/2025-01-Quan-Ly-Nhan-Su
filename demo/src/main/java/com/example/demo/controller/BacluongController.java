package com.example.demo.controller;

import com.example.demo.dto.BacluongDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.BacluongService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bacluong")
@AllArgsConstructor
public class BacluongController {
    private final BacluongService bacluongService;

    @Operation(summary = "Get all  bậc môn", description = "Lấy danh sách bậc môn từ hệ thống")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping("/show")
    public ResponseEntity<ResponseObject> getAll() {
        List<BacluongDTO> bacluongDTOList = bacluongService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "Addresses retrieved successfully", bacluongDTOList));
    }
}
