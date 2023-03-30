package com.project.storageforsocks.mapper;

import com.project.storageforsocks.dto.SocksDto;
import com.project.storageforsocks.entity.Socks;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SocksMapper {

    SocksMapper INSTANCE = Mappers.getMapper(SocksMapper.class );
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "color", source = "color")
    @Mapping(target = "cottonPart", source = "cottonPart")
    @Mapping(target = "amount", source = "amount")
    Socks toEntity(SocksDto socksDto);
    @Mapping(target = "color", source = "color")
    @Mapping(target = "cottonPart", source = "cottonPart")
    @Mapping(target = "amount", source = "amount")
    SocksDto toDto(Socks socks);
}

