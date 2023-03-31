package com.project.storageforsocks.mapper;

import com.project.storageforsocks.dto.SocksDto;
import com.project.storageforsocks.entity.Socks;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SocksMapper {

    @Mapping(target = "id", ignore = true)
    Socks toEntity(SocksDto socksDto);

    SocksDto toDto(Socks socks);
}

