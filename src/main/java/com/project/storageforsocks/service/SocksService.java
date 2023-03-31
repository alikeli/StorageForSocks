package com.project.storageforsocks.service;

import com.project.storageforsocks.dto.SocksDto;
import com.project.storageforsocks.entity.Operation;
import com.project.storageforsocks.entity.Socks;
import com.project.storageforsocks.exception.SocksNotFoundException;
import com.project.storageforsocks.mapper.SocksMapper;
import com.project.storageforsocks.repository.SocksRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@Transactional

public class SocksService {

    private final SocksRepository socksRepository;

    private final SocksMapper socksMapper;

    public SocksService(SocksRepository socksRepository, SocksMapper socksMapper) {
        this.socksRepository = socksRepository;
        this.socksMapper = socksMapper;
    }


    /**
     * Add socks to DB.
     * If DB contains entry with the same color and cotton part, then its amount will be increased amount.
     *
     * @param socksDto {@link SocksDto} instance from user's request.
     */

    public SocksDto addSocks(SocksDto socksDto) {
        log.debug("method addSocks had been started");
        Socks socksInStorage = socksRepository.findByColorAndCottonPart(socksDto.getColor(),
                socksDto.getCottonPart());
        if (socksInStorage == null) {
            log.warn("Socks added");
            return socksMapper.toDto(socksRepository.save(socksMapper.toEntity(socksDto)));
        }
        socksInStorage.setAmount(socksInStorage.getAmount() + socksDto.getAmount());
        log.info("Socks update");
        return socksMapper.toDto(socksRepository.save(socksInStorage));
    }

    /**
     * Remove the required amount of socks from DB.
     *
     * @param socksDto {@link Socks} instance from user's request.
     * @throws SocksNotFoundException if socks are not present
     */

    public void removeSocks(SocksDto socksDto) {
        log.debug("method removeSocks had been started");
        Socks socks = socksRepository.findByColorAndCottonPart(socksDto.getColor(), socksDto.getCottonPart());
        if (socks == null || socks.getAmount() < socksDto.getAmount()) {
            log.warn("Socks not found");
            throw new SocksNotFoundException();
        }
        socks.setAmount(socks.getAmount() - socksDto.getAmount());
        socksRepository.save(socks);
    }


    /**
     * Get the number of socks available in stock based on color,
     * cotton part and comparison operators.
     *
     * @param color      name of the color
     * @param operation  comparison operator
     * @param cottonPart desired amount of cotton
     * @return numbers of socks matching the required params or nothing
     */

    public Integer getAmountOfSocks(String color, int cottonPart, Operation operation) {
        log.debug("method getAmountOfSocks had been started");
        List<Socks> socks = new ArrayList<>();

        switch (operation) {
            case EQUAL -> socks = socksRepository.findAllByColorAndCottonPartEquals(color, cottonPart);
            case LESSTHAN -> socks = socksRepository.findAllByColorAndCottonPartLessThan(color, cottonPart);
            case MORETHAN -> socks = socksRepository.findAllByColorAndCottonPartGreaterThan(color, cottonPart);

        }
        log.debug("method getAmountOfSocks had been ended");
        return socks.stream().map(Socks::getAmount).reduce(0, Integer::sum);
    }


}
