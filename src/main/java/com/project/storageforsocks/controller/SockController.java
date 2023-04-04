package com.project.storageforsocks.controller;

import com.project.storageforsocks.dto.SocksDto;
import com.project.storageforsocks.entity.OperationEnum;
import com.project.storageforsocks.service.SocksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@Validated
@RequestMapping("/socks")
public class SockController {
    private final SocksService socksService;

    public SockController(SocksService socksService) {
        this.socksService = socksService;
    }


    @Operation(summary = "add Socks",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Socks Added"),
                    @ApiResponse(responseCode = "400", description = "Incorrect format"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")}
    )
    @PostMapping(path = "/income")
    public ResponseEntity<SocksDto> addSocks(@RequestBody @Valid  SocksDto socksDto) {
        socksService.addSocks(socksDto);
        return ResponseEntity.ok().build();

    }

    @Operation(summary = " socks delete",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Socks was outcome successful"),
                    @ApiResponse(responseCode = "400", description = "Incorrect format"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")}


    )
    @PostMapping("/outcome")
    public ResponseEntity<SocksDto> outcomeSocks(@RequestBody @Valid SocksDto socksDto) {
        socksService.removeSocks(socksDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "get socks",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Got quantity of socks",
                            content = @Content(
                                    schema = @Schema(implementation = Integer.class))),
                    @ApiResponse(responseCode = "400", description = "Incorrect format"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")}


    )
    @GetMapping
    public ResponseEntity<Integer> getAmountOfSocks(@RequestParam String color,
                                                    @RequestParam Integer cottonPart,
                                                    @RequestParam OperationEnum operation) {
        return ResponseEntity.ok(socksService.getAmountOfSocks(color, cottonPart, operation));
    }


}

