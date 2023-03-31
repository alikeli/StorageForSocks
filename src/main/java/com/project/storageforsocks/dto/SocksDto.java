package com.project.storageforsocks.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SocksDto {
    private Integer id;

    @NotNull(message = "color should be fill in")
    private String color;
    @Min(value = 0,message = "cotton part should be >=0")
    @Max(value = 100,message = "cotton part should be <=100")
    private Integer cottonPart;

    @Min(value = 0,message = "amount should be >=0")
    private Integer amount;
}
