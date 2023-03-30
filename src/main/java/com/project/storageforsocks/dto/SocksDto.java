package com.project.storageforsocks.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SocksDto {
    private Integer id;
    @Size(min = 2,max = 30)
    @NotBlank(message = "color should be fill in")
    private String color;
    @Min(value = 0,message = "cotton part should be >=0")
    @Max(value = 100,message = "cotton part should be <=100")
    private Integer cottonPart;
    @NotBlank(message = "amount should be fill in")
    @Min(value = 0,message = "amount should be >=0")
    private Integer amount;
}
