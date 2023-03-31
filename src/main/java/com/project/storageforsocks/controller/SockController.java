package com.project.storageforsocks.controller;

import com.project.storageforsocks.dto.SocksDto;
import com.project.storageforsocks.service.SocksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/socks")
public class SockController {
    private final SocksService socksService;

    public SockController(SocksService socksService) {
        this.socksService = socksService;
    }

    @Operation(summary = "add socks", tags = "socks",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Socks Added",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SocksDto.class))),
                    @ApiResponse(responseCode = "400", description = "Query parameters not found or incorrect format"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")}
    )
    @PostMapping("/income")
    public ResponseEntity<SocksDto> addSocks(@RequestBody @Valid SocksDto socksDto) {
        socksService.addSocks(socksDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = " socks delete", tags = "socks",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Outcome of socks was successful",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SocksDto.class))),
                    @ApiResponse(responseCode = "400", description = "Query parameters not found or incorrect format"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")}


    )
    @PostMapping("/outcome")
    public ResponseEntity<SocksDto> outcomeSocks(@RequestBody @Valid SocksDto socksDto) {
        socksService.removeSocks(socksDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "get socks", tags = "socks",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Got quantity of socks",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SocksDto.class))),
                    @ApiResponse(responseCode = "400", description = "Query parameters not found or incorrect format"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")}


    )
    @GetMapping
    public ResponseEntity<Integer> getAmountOfSocks(@RequestParam String color,
                                                    @RequestParam int cottonPart,
                                                    @RequestParam com.project.storageforsocks.entity.Operation operation) {
        return ResponseEntity.ok(socksService.getAmountOfSocks(color,cottonPart, operation));
    }


}

