package com.project.storageforsocks.mapper;

import com.project.storageforsocks.dto.SocksDto;
import com.project.storageforsocks.entity.Socks;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SocksMapper {

    @Mapping(target = "color", source = "color")
    @Mapping(target = "cottonPart", source = "cottonPart")
    SocksDto toDto(Socks socks);
    @Mapping(target = "color", source = "color")
    @Mapping(target = "cottonPart", source = "cottonPart")
    Socks toEntity(SocksDto socksStockDto);
}

