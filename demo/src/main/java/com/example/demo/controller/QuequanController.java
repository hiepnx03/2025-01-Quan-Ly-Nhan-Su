package com.example.demo.controller;

import com.example.demo.dto.DantocDTO;
import com.example.demo.dto.QuequanDTO;
import com.example.demo.service.QuequanService;
import com.example.demo.viewmodel.ErrorVm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quequan")
@AllArgsConstructor
public class QuequanController  {
    private final QuequanService quequanService;


    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping("{canboId}/quequan")
    public ResponseEntity<List<QuequanDTO>> getAllByCanboId(@PathVariable Long canboId) {
        List<QuequanDTO> quequans = quequanService.getAllByCanboId(canboId);
        return ResponseEntity.status(HttpStatus.OK).body(quequans);
    }

    @PostMapping("{canboId}/quequan")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = QuequanDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<QuequanDTO> create(@PathVariable Long canboId, @RequestBody QuequanDTO quequanDTO) {
        QuequanDTO savedQuequan = quequanService.create(canboId, quequanDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedQuequan);
    }

    @PutMapping("{canboId}/quequan/{quequanId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Updated"),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<QuequanDTO> update(
            @PathVariable Long canboId,
            @PathVariable Long quequanId,
            @RequestBody QuequanDTO quequanDTO) {
        QuequanDTO updatedQuequan = quequanService.update(canboId, quequanId, quequanDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedQuequan);
    }

    @DeleteMapping("{canboId}/quequan/{quequanId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))})
    public ResponseEntity<Void> delete(@PathVariable Long canboId, @PathVariable Long quequanId) {
        quequanService.delete(canboId, quequanId);
        return ResponseEntity.noContent().build();
    }

}
