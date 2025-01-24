package com.example.demo.controller;

import com.example.demo.constants.PageableConstant;
import com.example.demo.dto.TongiaoDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.TongiaoService;
import com.example.demo.constants.ErrorVm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tongiao")
@AllArgsConstructor
public class TongiaoController {

    private final TongiaoService tongiaoService;

    @Operation(summary = "Get all tôn giáo", description = "Lấy danh sách tất cả các tôn giáo từ hệ thống")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<TongiaoDTO> result = tongiaoService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "Danh sách tôn giáo", result));
    }

    @GetMapping("/page")
    @Operation(summary = "Get all tôn giáo", description = "Lấy danh sách tất cả các tôn giáo từ hệ thống")
    @ApiResponse(responseCode = "200", description = "Success")
    public ResponseEntity<Page<TongiaoDTO>> getAllPage(
            @RequestParam(value = "pageNo", defaultValue = PageableConstant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = PageableConstant.DEFAULT_PAGE_SIZE, required = false) int pageSize
    ) {
        Page<TongiaoDTO> tongiaoDTOPage = tongiaoService.getAllPage(pageNo, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(tongiaoDTOPage);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))})
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        TongiaoDTO result = tongiaoService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "Chi tiết tôn giáo", result));
    }

    // 🔍 API tìm kiếm tôn giáo (có hỗ trợ phân trang)
    @GetMapping("/search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))})
    public ResponseEntity<ResponseObject> searchTonGiao(
            @RequestParam String tenTonGiao,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {

        Page<TongiaoDTO> results = tongiaoService.searchByTenTonGiao(tenTonGiao, pageNo, pageSize);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("200", "Danh sách tôn giáo tìm kiếm", results.getContent()));
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = TongiaoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<ResponseObject> create(@RequestBody TongiaoDTO tongiaoDTO) {
        TongiaoDTO created = tongiaoService.create(tongiaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("201", "Tạo mới tôn giáo thành công", created));
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Updated"),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<ResponseObject> update(@PathVariable Long id, @RequestBody TongiaoDTO tongiaoDTO) {
        TongiaoDTO updated = tongiaoService.update(id, tongiaoDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseObject("202", "Cập nhật tôn giáo thành công", updated));
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))})
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        tongiaoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseObject("204", "Xóa tôn giáo thành công", null));
    }
}
