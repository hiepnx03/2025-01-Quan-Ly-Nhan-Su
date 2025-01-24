package com.example.demo.controller;

import com.example.demo.constants.PageableConstant;
import com.example.demo.dto.HopdongcanboDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.HopdongcanboService;
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
@RequestMapping("/api/hopdongcanbo")
@AllArgsConstructor
public class HopdongcanboController {

    private final HopdongcanboService hopdongcanboService;

    @Operation(summary = "Get all hợp đồng cán bộ", description = "Lấy danh sách tất cả các hợp đồng cán bộ từ hệ thống")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<HopdongcanboDTO> result = hopdongcanboService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "Danh sách hợp đồng cán bộ", result));
    }

    @GetMapping("/page")
    @Operation(summary = "Get all hợp đồng cán bộ (phân trang)", description = "Lấy danh sách tất cả các hợp đồng cán bộ từ hệ thống với phân trang")
    @ApiResponse(responseCode = "200", description = "Success")
    public ResponseEntity<Page<HopdongcanboDTO>> getAllPage(
            @RequestParam(value = "pageNo", defaultValue = PageableConstant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = PageableConstant.DEFAULT_PAGE_SIZE, required = false) int pageSize
    ) {
        Page<HopdongcanboDTO> hopdongcanboDTOPage = hopdongcanboService.getAllPage(pageNo, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(hopdongcanboDTOPage);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))}
    )
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        HopdongcanboDTO result = hopdongcanboService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "Chi tiết hợp đồng cán bộ", result));
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = HopdongcanboDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<ResponseObject> create(@RequestBody HopdongcanboDTO hopdongcanboDTO) {
        HopdongcanboDTO created = hopdongcanboService.create(hopdongcanboDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("201", "Tạo mới hợp đồng cán bộ thành công", created));
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Updated"),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<ResponseObject> update(@PathVariable Long id, @RequestBody HopdongcanboDTO hopdongcanboDTO) {
        HopdongcanboDTO updated = hopdongcanboService.update(id, hopdongcanboDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseObject("202", "Cập nhật hợp đồng cán bộ thành công", updated));
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))})
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        hopdongcanboService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseObject("204", "Xóa hợp đồng cán bộ thành công", null));
    }
}
