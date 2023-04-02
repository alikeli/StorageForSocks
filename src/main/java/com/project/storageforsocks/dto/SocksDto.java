package com.project.storageforsocks.dto;


import lombok.Data;

import javax.validation.constraints.*;

@Data
public class SocksDto {
    @NotBlank
    private String color;
    @Min(value = 0, message = "should be > 0")
    @Max(value = 100, message = "should be <100")
    private int cottonPart;
    @Min(value = 1, message = "min 1 ")
    private int quantity;


}
